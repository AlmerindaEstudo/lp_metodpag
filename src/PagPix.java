import java.util.Random;

public class PagPix extends PagamentoBase {

    private long cpf;
    private String email;
    private long telefone;
    private String chave;

    // Construtor
    public PagPix(long cpf, String email, long telefone, String chave, int idTransacao, double valor, String dataHora) {
        super(idTransacao, valor, dataHora);
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.chave = chave;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }

   

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    // Detecta o tipo de chave
    private String detectarTipoChave() {
        if (chave.matches("\\d{11}")) {
            return "CPF";
        } else if (chave.contains("@")) {
            return "Email";
        } else if (chave.matches("\\d{10,11}")) {
            return "Telefone";
        } else {
            return "Aleatoria";
        }
    }

    // Valida a chave Pix de acordo com o tipo detectado
    private boolean validarChave() {
        String tipo = detectarTipoChave();

        switch (tipo) {
            case "CPF":
                return chave.matches("\\d{11}");
            case "Email":
                return chave.contains("@");
            case "Telefone":
                return chave.matches("\\d{10,11}");
            case "Aleatoria":
                return chave != null && !chave.isEmpty();
            default:
                return false;
        }
    }

    // Gera um QR Code simulado
    private String gerarQrCode() {
        Random random = new Random();
        int codigo = random.nextInt(9000000) + 1000000; // 7 dígitos
        return "QRPIX | Valor: R$" + getValor() + " | Chave: " + chave + " | Código: " + codigo;
    }

    // Processa o pagamento Pix
    @Override
    public boolean processarPagamento() {
        System.out.println("Detectando o tipo de chave...");
        String tipoDetectado = detectarTipoChave();
        System.out.println("Tipo identificado: " + tipoDetectado);

        System.out.println("Validando chave Pix...");
        if (!validarChave() || getValor() <= 0) {
            System.out.println("Erro: chave inválida ou valor zero");
            return false;
        }

        System.out.println("Gerando QR Code...");
        String qr = gerarQrCode();
        System.out.println("QR Code gerado:");
        System.out.println(qr);

        return true;
    }
}
