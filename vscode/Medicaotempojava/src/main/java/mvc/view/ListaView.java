package mvc.view;

import java.util.List;

/**
 * VIEW: única camada que fala com o usuário (System.out).
 * Não contém lógica de negócio — só recebe dados prontos e exibe.
 */
public class ListaView {

    public void exibirLista(List<Integer> lista, String frase) {
        System.out.println(frase);
        for (Integer item : lista) {
            System.out.println(item);
        }
        System.out.println("--------------------------");
        System.out.println("Total de registros: " + lista.size());
    }

    public void exibirTempo(String rotina, long tempoMs) {
        System.out.println("Tempo (ms) " + rotina + ": " + tempoMs);
    }
}
