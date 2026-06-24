package modelo;
import java.util.LinkedList;
import java.util.List;

public class Venda {
    private int idVenda;
    private String data;
    private double valorTotal;
    private int idCliente;
    private String statusPagamento;
    private List<Pagamento> pagamento;
    
    public Venda(int idVenda, String data, double valorTotal, int idCliente, String statusPagamento) {
        this.idVenda = idVenda;
        this.data = data;
        this.valorTotal = valorTotal;
        this.idCliente = idCliente;
        this.statusPagamento = statusPagamento;
        this.pagamento = new LinkedList<Pagamento>();
    
    }
    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(String statusPagamento) {
        this.statusPagamento = statusPagamento;
    }
    
    public void addPagamento(Pagamento pagamento) {
        this.pagamento.add(pagamento);
    }
    
    public List<Pagamento> getPagamento () {
    	return pagamento;
    }
}