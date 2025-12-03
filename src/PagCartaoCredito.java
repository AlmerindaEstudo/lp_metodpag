
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.Month.*;
import java.time.temporal.TemporalAdjusters;




public class PagCartaoCredito extends PagamentoBase{
    
    String ncartaocredito;
    String nome;
    LocalDate dvalidade;
    int cvv;

    public PagCartaoCredito(String ncartaocredito, String nome, LocalDate dvalidade, int cvv, int idTransacao, double valor, String dataHora) {
        super(idTransacao, valor, dataHora);
        this.ncartaocredito = ncartaocredito;
        this.nome = nome;
        this.dvalidade = dvalidade;
        this.cvv = cvv;
        
        if(!cartaoCreditoValido(ncartaocredito)){
        
        throw new IllegalArgumentException("Número inválido,deve ter 16 dígitos ");
        }
        
        if(!CvvValido(cvv)){
        
         throw new IllegalArgumentException("Número inválido,deve ter 3 á 4 dígitos ");
        
        }
        
        if(CartaoVencido(dvalidade)){
        
        
        throw new IllegalArgumentException("Data Inválida");
        
        }
        
        
    }

    private boolean cartaoCreditoValido(String numero){
    
    return numero != null && numero.matches("\\d{16}");
    
    }
    private boolean  CvvValido(int cvv){
    
    return cvv >= 100 && cvv<=9999;
    
    }
    
    private boolean CartaoVencido(LocalDate validade){
    
    if(dvalidade != null){
    
    LocalDate hoje = LocalDate.now();
    
    return dvalidade.isBefore(hoje);
    
    }
    
    return false;
    }
    
    private LocalDate DvalidadeFutura(String datavalidade){
    
        try{
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        LocalDate validade =  LocalDate.parse("01"+ datavalidade, formatter);
        
        return validade.with(TemporalAdjusters.lastDayOfMonth());
        }
    
       catch(DateTimeException e){
       
       throw new IllegalArgumentException("Formato de Data inválido,use MM/AA");
       
       }
    }
            
            
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
    
    @Override
    public boolean processarPagamento() {
    
    }

    
}
