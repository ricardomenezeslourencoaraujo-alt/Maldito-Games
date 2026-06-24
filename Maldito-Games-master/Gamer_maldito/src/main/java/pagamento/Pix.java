package pagamento;
public class Pix implements FormaPagamento {
    @Override
    public void pagar() {
        System.out.println("Pagando com Pix...");
    }
}
