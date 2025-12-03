import java.util.ArrayList;
import java.util.List;



public class ProcessadorPagamentos {
    
    
    List<MetodoPagamento> pagamentos;
    
    
    
    public void processarTodosPagamentos(){
    
    this.pagamentos = new ArrayList<>();
    
    };
    
    public void adicionarPagamento(MetodoPagamento pagamento){
    
        pagamentos.add(pagamento);
    
    }
    public void gerarRelatorio(){};
    
    public void pagamentosPedentes(){};
    
    public void transacaoSucesso(){};
    
    public void transacaoFalha(){};
    
    public void valorTotal(){};
}
