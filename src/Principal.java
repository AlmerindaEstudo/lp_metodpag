import java.time.LocalDate;

public class Principal {

    public static void main(String[] args) {

        // Criando o processador de pagamentos
        ProcessadorPagamentos processador = new ProcessadorPagamentos();

        // ======= Pagamento com Cartão de Crédito (válido) =======
        try {
            PagCartaoCredito cartao = new PagCartaoCredito(
                    "1234567812345678", // 16 dígitos
                    "João da Silva",
                    LocalDate.now().plusYears(2), // validade futura
                    123, // CVV válido
                    1, // idTransacao
                    1500.00, // valor
                    "2025-12-09 10:00"
            );
            processador.adicionarPagamento(cartao);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar PagCartaoCredito: " + e.getMessage());
        }

        // ======= Pagamento com PayPal (válido) =======
        PagPayPal paypal = new PagPayPal(
                "joao.silva@email.com",
                2, // idTransacao
                750.00, // valor
                "2025-12-09 11:00"
        );
        processador.adicionarPagamento(paypal);

        // ======= Pagamento Pix (válido com CPF) =======
        PagPix pixCpf = new PagPix(
                12345678901L, // cpf como long
                null,
                0L,
                "12345678901", // chave CPF
                3, // idTransacao
                500.00, // valor
                "2025-12-09 12:00"
        );
        processador.adicionarPagamento(pixCpf);

        // ======= Pagamento Pix (válido com Email) =======
        PagPix pixEmail = new PagPix(
                0L,
                "cliente@email.com",
                0L,
                "cliente@email.com", // chave Email
                4, // idTransacao
                300.00, // valor
                "2025-12-09 12:30"
        );
        processador.adicionarPagamento(pixEmail);

        // ======= Pagamento Pix (válido com Telefone) =======
        PagPix pixTel = new PagPix(
                0L,
                null,
                11987654321L, // telefone como long
                "11987654321", // chave Telefone
                5, // idTransacao
                200.00, // valor
                "2025-12-09 13:00"
        );
        processador.adicionarPagamento(pixTel);

        // ======= Processando todos os pagamentos =======
        processador.processarTodosPagamentos();
    }
}
