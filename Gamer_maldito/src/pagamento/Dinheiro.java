package pagamento;
public class Dinheiro implements FormaPagamento {
    @Override
    public void pagar() {
        System.out.println("Pagando com Dinheiro...");
    }
}
