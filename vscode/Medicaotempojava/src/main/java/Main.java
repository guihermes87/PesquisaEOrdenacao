import mvc.controller.MedicaoController;

/**
 * Ponto de entrada: só cria o Controller e dispara as rotinas.
 */
public class Main {
    public static void main(String[] args) {
        
        MedicaoController controller = new MedicaoController();

        // rotina 1 - 100000 números aleatórios na faixa 100 a 100000
        controller.executarMedicao("rotina 1", 100000, 100, 100000, true);

        // rotina 2 - 100000 números sequenciais
        controller.executarMedicao("rotina 2", 100000, 1, 100000, false);
    }
}
