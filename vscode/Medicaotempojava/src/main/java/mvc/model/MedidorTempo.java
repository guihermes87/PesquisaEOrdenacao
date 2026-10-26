package mvc.model;

/**
 * MODEL: lógica de medição de tempo, sem nenhuma saída na tela.
 */
public class MedidorTempo {
    private long inicio;
    private long fim;

    public void iniciar() {
        inicio = System.nanoTime();
    }

    public void parar() {
        fim = System.nanoTime();
    }

    public long getTempoMs() {
        return (fim - inicio) / 1_000_000;
    }
}
