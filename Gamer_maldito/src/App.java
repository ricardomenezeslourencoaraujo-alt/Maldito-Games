import dao.ProdutoDAO;
import dao.ProdutoDAOImpl;
import modelo.Produto;
import java.util.List;

public class App {
    public static void main(String[] args) {

    	ProdutoDAO dao = new ProdutoDAOImpl();

        //Produto p1 = new Produto(0, "Notebook", "Dell Inspiron 15", 3500.00, 10, "Informática");
        //Produto p2 = new Produto(0, "Mouse", "Mouse óptico USB", 89.90, 50, "Periféricos");
        //Produto p3 = new Produto(0, "Teclado", "Teclado mecânico RGB", 320.00, 30, "Periféricos");
        //Produto p4 = new Produto(0, "Monitor", "Monitor 24' Full HD", 1200.00, 15, "Monitores");
        //Produto p5 = new Produto(0, "Headset", "Headset gamer 7.1", 450.00, 20, "Áudio");

        //dao.criar(p1);
        //dao.criar(p2);
        //dao.criar(p3);
        //dao.criar(p4);
        //dao.criar(p5);

  
    	//List<Produto> todosProdutos = dao.listar();

        
    	 Produto produtoEncontrado = dao.buscarPorId(12);

        // Atualizar
    	//if (produtoEncontrado != null) {
    	//produtoEncontrado.setPreco(79.90);
    	//produtoEncontrado.setQuantidadeEstoque(45);
    	//dao.atualizar(produtoEncontrado);
    	//}

        
    	//dao.deletar();
    	//List<Produto> listaAposRemocao = dao.listar();

        
    }
}