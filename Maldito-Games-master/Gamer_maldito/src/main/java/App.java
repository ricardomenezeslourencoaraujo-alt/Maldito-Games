import dao.*;
import modelo.*;
import pagamento.*;

import java.util.List;

public class App {
    public static void main(String[] args) {

        // 1. Testar o polimorfismo com pagamento (Aula 05)
        System.out.println("=== TESTE DE PAGAMENTO (Polimorfismo) ===");
        FormaPagamento pag1 = new Cartao();
        FormaPagamento pag2 = new Pix();
        FormaPagamento pag3 = new Dinheiro();
        pag1.pagar();
        pag2.pagar();
        pag3.pagar();

        // 2. Testar DAO de Produto (CRUD)
        System.out.println("\n=== TESTE PRODUTO DAO ===");
        ProdutoDAO produtoDAO = new ProdutoDAOImpl();

        // Inserir
        Produto p1 = new Produto(0, "Teclado Mecânico", "Switch azul", 299.99, 20, "Periféricos");
        produtoDAO.criar(p1);
        System.out.println("Produto inserido!");

        // Listar todos
        List<Produto> produtos = produtoDAO.listar();
        System.out.println("Lista de produtos:");
        for (Produto p : produtos) {
            System.out.println(p);
        }

        // Buscar por ID (pegando o último inserido)
        int idProduto = produtos.get(produtos.size() - 1).getIdProduto();
        Produto encontrado = produtoDAO.buscarPorId(idProduto);
        System.out.println("Produto buscado: " + encontrado);

        // Atualizar
        encontrado.setPreco(199.99);
        produtoDAO.atualizar(encontrado);
        System.out.println("Produto atualizado!");

        // 3. Testar DAO de Cliente
        System.out.println("\n=== TESTE CLIENTE DAO ===");
        ClienteDAO clienteDAO = new ClienteDAOImpl();

        Cliente cliente = new Cliente(0, "Ana Souza", "333.333.333-33", "(11) 98888-3333", "ana@email.com", "Rua C, 789");
        clienteDAO.criar(cliente);
        System.out.println("Cliente inserido!");

        List<Cliente> clientes = clienteDAO.listar();
        System.out.println("Clientes cadastrados:");
        for (Cliente c : clientes) {
            System.out.println(c.getIdCliente() + " - " + c.getNome());
        }

        // 4. Testar Venda com Itens (Aula 06 e 03)
        System.out.println("\n=== TESTE VENDA + ITENS ===");
        VendaDAO vendaDAO = new VendaDAOImpl();
        ItemVendaDAO itemDAO = new ItemVendaDAOImpl();

        // Criar uma venda
        Venda venda = new Venda(0, java.time.LocalDate.now().toString(), 0.0, clientes.get(0).getIdCliente(), "PENDENTE");
        vendaDAO.criar(venda);
        System.out.println("Venda criada com ID: " + venda.getIdVenda()); // OBS: o ID não é preenchido automaticamente na classe! Vamos buscar a última.
        
        // Buscar a última venda para pegar o ID real
        List<Venda> vendas = vendaDAO.listar();
        Venda vendaReal = vendas.get(vendas.size() - 1);
        System.out.println("Última venda ID: " + vendaReal.getIdVenda());

        // Adicionar itens
        Produto prod1 = produtos.get(0); // primeiro produto
        Produto prod2 = produtos.get(1); // segundo produto

        ItemVenda item1 = new ItemVenda(0, vendaReal.getIdVenda(), prod1.getIdProduto(), 2, prod1.getPreco() * 2);
        ItemVenda item2 = new ItemVenda(0, vendaReal.getIdVenda(), prod2.getIdProduto(), 1, prod2.getPreco());
        itemDAO.criar(item1);
        itemDAO.criar(item2);
        System.out.println("Itens adicionados!");

        // Atualizar valor total da venda
        double total = item1.getSubtotal() + item2.getSubtotal();
        vendaReal.setValorTotal(total);
        vendaReal.setStatusPagamento("PAGO");
        vendaDAO.atualizar(vendaReal);
        System.out.println("Venda atualizada com total: R$ " + total);

        // Listar itens da venda
        List<ItemVenda> itens = itemDAO.listarPorVenda(vendaReal.getIdVenda());
        System.out.println("Itens da venda " + vendaReal.getIdVenda() + ":");
        for (ItemVenda item : itens) {
            System.out.println("  Produto ID: " + item.getIdProduto() + " | Qtd: " + item.getQuantidade() + " | Subtotal: R$ " + item.getSubtotal());
        }

        // 5. Testar Pagamento
        System.out.println("\n=== TESTE PAGAMENTO ===");
        PagamentoDAO pagamentoDAO = new PagamentoDAOImpl();
        Pagamento pagamento = new Pagamento(0, vendaReal.getIdVenda(), "CARTAO", total, java.time.LocalDate.now().toString());
        pagamentoDAO.criar(pagamento);
        System.out.println("Pagamento registrado!");

        List<Pagamento> pagamentos = pagamentoDAO.listarPorVenda(vendaReal.getIdVenda());
        for (Pagamento pg : pagamentos) {
            System.out.println("Pagamento ID: " + pg.getIdPagamento() + " | Forma: " + pg.getFormaPagamento() + " | Valor: R$ " + pg.getValorPago());
        }

        // 6. Fechar conexão (boa prática)
        DBConnection.getInstance().fecharConexao();
        System.out.println("\n=== FIM ===");
    }
}