/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Discente
 */
public class PagPayPal extends PagamentoBase{
    
    
    String email;

    public PagPayPal(String email, int idTransacao, double valor, String dataHora) {
        super(idTransacao, valor, dataHora);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
   @Override
    public boolean processarPagamento() {
    
    try{
     
     System.out.println("Conectando ao PayPal");
     Thread.sleep(2000);
     
    }
    catch(InterruptedException e){
        
    System.out.println("Erro na simulação da conexão");    
    return false;
    }
    
    boolean aprovado = email != null && email.contains("@") && getValor() > 0;
    
    if(aprovado){
        
    System.out.println("Pagamento PayPal aprovado");
        
    }
    else{
        
    System.out.println("Pagamento PayPal recusado");
        
    }
    return aprovado;
}
}