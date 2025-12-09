import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class PagCartaoCredito extends PagamentoBase {

    private String ncartaocredito;
    private String nome;
    private LocalDate dvalidade;
    private int cvv;

    // Construtor
    public PagCartaoCredito(String ncartaocredito, String nome, LocalDate dvalidade, int cvv,
                            int idTransacao, double valor, String dataHora) {
        super(idTransacao, valor, dataHora);
        this.ncartaocredito = ncartaocredito;
        this.nome = nome;
        this.dvalidade = dvalidade;
        this.cvv = cvv;

        // Valida número do cartão
        if (!cartaoCreditoValido(ncartaocredito)) {
            throw new IllegalArgumentException("Número inválido, deve ter 16 dígitos");
        }

        // Valida CVV
        if (!cvvValido(cvv)) {
            throw new IllegalArgumentException("CVV inválido, deve ter 3 a 4 dígitos");
        }

        // Valida se o cartão está vencido
        if (isCartaoVencido(dvalidade)) {
            throw new IllegalArgumentException("Data Inválida: cartão vencido");
        }
    }

    // Verifica se cartão está vencido
    private boolean isCartaoVencido(LocalDate validade) {
        if (validade != null) {
            LocalDate hoje = LocalDate.now();
            return validade.isBefore(hoje);
        }
        return false;
    }

    // Valida número do cartão
    private boolean cartaoCreditoValido(String numero) {
        return numero != null && numero.matches("\\d{16}");
    }

    // Valida CVV
    private boolean cvvValido(int cvv) {
        return cvv >= 100 && cvv <= 9999;
    }

    // Converte string MM/yy para LocalDate
    public static LocalDate converterValidade(String datavalidade) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
            LocalDate validade = LocalDate.parse("01/" + datavalidade, DateTimeFormatter.ofPattern("dd/MM/yy"));
            return validade.with(TemporalAdjusters.lastDayOfMonth());
        } catch (DateTimeException e) {
            throw new IllegalArgumentException("Formato de Data inválido, use MM/yy");
        }
    }

    // Getters e Setters
    public String getNcartaocredito() {
        return ncartaocredito;
    }

    public void setNcartaocredito(String ncartaocredito) {
        this.ncartaocredito = ncartaocredito;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDvalidade() {
        return dvalidade;
    }

    public void setDvalidade(LocalDate dvalidade) {
        this.dvalidade = dvalidade;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    // Processa pagamento
    @Override
    public boolean processarPagamento() {
        if (isCartaoVencido(dvalidade)) {
            System.out.println("Pagamento recusado, cartão vencido");
            return false;
        }
        System.out.println("Cartão aprovado");
        return true;
    }
}
