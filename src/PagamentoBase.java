public abstract class PagamentoBase implements MetodoPagamento {

    //Qualquer classe que implemente MetodoPagamento precisa obrigatoriamente implementar o método processarPagamento().
    private int idTransacao;
    private double valor;
    private String dataHora;

    // Construtor
    public PagamentoBase(int idTransacao, double valor, String dataHora) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.dataHora = dataHora;
    }

    // Getters e Setters
    public int getIdTransacao() {
        return idTransacao;
    }

    public void setIdTransacao(int idTransacao) {
        this.idTransacao = idTransacao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    // Métodos opcionais que podem ser sobrescritos nas subclasses
    public void registrarTransacao() {
        // Implementação padrão (pode ser sobrescrita)
    }

    public void getDetalhes() {
        // Implementação padrão (pode ser sobrescrita)
    }

    public void validarPagamento() {
        // Implementação padrão (pode ser sobrescrita)
    }

    // Método abstrato obrigatório para processamento de pagamento
    @Override
    public abstract boolean processarPagamento();
}
