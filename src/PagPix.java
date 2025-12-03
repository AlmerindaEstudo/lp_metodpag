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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }
    
    
    
}
