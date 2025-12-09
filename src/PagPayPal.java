public class PagPayPal extends PagamentoBase {

    private String email;

    // Construtor
    public PagPayPal(String email, int idTransacao, double valor, String dataHora) {
        super(idTransacao, valor, dataHora);
        this.email = email;
    }

    // Getter e Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Processamento do pagamento PayPal
    @Override
    public boolean processarPagamento() {
        try {
            System.out.println("Conectando ao PayPal...");
            Thread.sleep(2000); // simula delay da conexão
        } catch (InterruptedException e) {
            System.out.println("Erro na simulação da conexão");
            return false;
        }

        // Validação simples: e-mail válido e valor maior que 0
        boolean aprovado = email != null && email.contains("@") && getValor() > 0;

        if (aprovado) {
            System.out.println("Pagamento PayPal aprovado");
        } else {
            System.out.println("Pagamento PayPal recusado");
        }

        return aprovado;
    }
}
