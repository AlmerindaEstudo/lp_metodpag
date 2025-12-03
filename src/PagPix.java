
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Discente
 */
public class PagPix extends PagamentoBase {
    
    int cpf;
    String email;
    int telefone;
    String chave;

    public PagPix(int cpf, String email, int telefone, String chave, int idTransacao, double valor, String dataHora) {
        super(idTransacao, valor, dataHora);
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.chave = chave;
    }
    
    
    
    public int getCpf() {
        return cpf;
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

    public int getTelefone() {
        return telefone;
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
    
    private String detectarTipoChave(){
    
    String tipo;
    
    if(chave.matches("\\d{11}")){
    
    return "CPF";
    
    }
    
    if(chave.contains("@")){
    
    return "Email";
    
    }
    
    if(chave.matches("\\d{10,11}")){
    
    return "Telefone";
    }
    
    return "Aleatoria";
    }
    
    
    
    private boolean validarChave(){
    
    switch(chave){
    
        case "CPF":
            
        return chave.matches("\\d{11}");
    
        case "Email" :
    
        return chave.contains("@");
    
        case "Telefone":
        
        return chave.matches("\\d{10,11}");
        
        default :
            
        return false;
    }
}
    private String qerarQrCode(){
    
    Random random = new Random();
    
    int codigo = random.nextInt(9000000) + 100000;
    
    return "QRPIX | Valor : R$" + getValor() + "| Chave " + chave + "| Código " + codigo;
    
    
    }
    
    @Override
    
    public boolean processarPagamento(){
    
    System.out.println("Detectando o tipo de chave ");
    String tipoDetectado = detectarTipoChave();
    System.out.println("Tipo Identificado "+tipoDetectado);
    
    
    System.out.println("Valindo Chave Pix ...");
    if(!validarChave()){
    System.out.println("Erro ao detectar a Chave");
    return false;
    }
    }
}