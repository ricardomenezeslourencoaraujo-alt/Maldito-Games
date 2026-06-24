package pagamento;
public class Cartao implements FormaPagamento {
    @Override
    public void pagar() {
        System.out.println("Pagando com Cartão...");
    }
}
