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
    
}
