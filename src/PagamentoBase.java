
public abstract class PagamentoBase {
    
    private int idTransacao;
    private double valor;
    private String dataHora;

    public PagamentoBase(int idTransacao, double valor, String dataHora) {
        this.idTransacao = idTransacao;
        this.valor = valor;
        this.dataHora = dataHora;
    }
    
    
    
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
    
    public void registrarTransacao(){}
    
    public void getDetalhes(){};
    
    public void validarPagamento(){};
    
}
