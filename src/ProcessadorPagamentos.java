import java.util.ArrayList;
import java.util.List;

public class ProcessadorPagamentos {

    private List<MetodoPagamento> pagamentos;

    // Construtor
    public ProcessadorPagamentos() {
        this.pagamentos = new ArrayList<>();
    }

    // Adiciona um pagamento à lista
    public void adicionarPagamento(MetodoPagamento pagamento) {
        pagamentos.add(pagamento);
    }

    // Processa todos os pagamentos da lista
    public void processarTodosPagamentos() {
        int totalProcessados = 0;
        int totalSucesso = 0;
        int totalFalha = 0;
        double valorTotalProcessado = 0.0;

        for (MetodoPagamento pagamento : pagamentos) {
            totalProcessados++;

            try {
                boolean sucesso = pagamento.processarPagamento();

                if (sucesso) {
                    totalSucesso++;

                    if (pagamento instanceof PagamentoBase) {
                        valorTotalProcessado += ((PagamentoBase) pagamento).getValor();
                    }

                    System.out.println("Pagamento " + totalProcessados + ": Sucesso");
                } else {
                    totalFalha++;
                    System.out.println("Pagamento " + totalProcessados + ": Falhou");
                }

            } catch (Exception e) {
                totalFalha++;
                System.out.println("Pagamento " + totalProcessados + ": ERRO -> " + e.getMessage());
            }

            System.out.println("----------------------------------");
        }

        gerarRelatorio(totalProcessados, totalSucesso, totalFalha, valorTotalProcessado);
    }

    // Gera relatório consolidado
    private void gerarRelatorio(int total, int sucesso, int falhas, double valorProcessado) {
        System.out.println("======= RELATÓRIO DE PAGAMENTOS =======");
        System.out.println("Total de transações processadas: " + total);
        System.out.println("Total de transações com sucesso: " + sucesso);
        System.out.println("Total de transações com falhas: " + falhas);
        System.out.printf("Valor total processado com sucesso: R$ %.2f%n", valorProcessado);
        System.out.println("======================================");
    }
}
