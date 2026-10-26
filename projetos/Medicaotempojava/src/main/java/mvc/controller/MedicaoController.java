package mvc.controller;

import mvc.model.ListaNumeros;
import mvc.model.MedidorTempo;
import mvc.view.ListaView;

/**
 * CONTROLLER: coordena Model e View.
 * Pede ao Model para fazer o trabalho e à View para exibir o resultado.
 */
public class MedicaoController {
    private final ListaView view = new ListaView();

    public void executarMedicao(String nomeRotina, long quantidade,
                                int inicio, int fim, boolean aleatorio) {
        ListaNumeros lista = new ListaNumeros();
        MedidorTempo medidor = new MedidorTempo();

        medidor.iniciar();
        lista.popular(quantidade, inicio, fim, aleatorio);
        medidor.parar();

        view.exibirTempo(nomeRotina, medidor.getTempoMs());
        // view.exibirLista(lista.getNumeros(), "Lista " + nomeRotina);
    }
}
