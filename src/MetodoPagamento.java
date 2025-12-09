
public interface  MetodoPagamento {
    
    
    boolean processarPagamento();

   
   //Qualquer classe que implemente MetodoPagamento precisa obrigatoriamente implementar o método processarPagamento().
   
    //Interfaces permitem que você trate objetos diferentes de maneira uniforme.
    
    //Por exemplo, no ProcessadorPagamentos você pode ter:
    /* List<MetodoPagamento> pagamentos = new ArrayList<>();
    pagamentos.add(new PagCartaoCredito(...));
    pagamentos.add(new PagPayPal(...));
    pagamentos.add(new PagPix(...));
*/
}
