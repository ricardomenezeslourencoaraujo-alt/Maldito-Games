package modelo;
import java.util.LinkedList;
import java.util.List;

public class ItemVenda {
    private int idItemVenda;
    private int idVenda;
    private int idProduto;
    private int quantidade;
    private double subtotal;
    private List <Venda> venda;       
    private List <Produto> produto;
    public ItemVenda(int idItemVenda, int idVenda, int idProduto, int quantidade, double subtotal) {
        
    	this.idItemVenda = idItemVenda;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.subtotal = subtotal;
        this.venda = new LinkedList <Venda>();
        this.produto = new LinkedList <Produto>();
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    public void addVenda(Venda v) {
        venda.add(v);
    }
    public void addProduto(Produto p) {
        produto.add(p);
    }
}