package view;

import java.util.List;

/**
 * VIEW: toda a exibição em tela fica aqui.
 */
public class Visao {
    /**
     * método de classe que exibe conteúdo de uma lista de inteiros
     * @param lista
     * @param frase - para exibir no início do método
     */
    public static void exibrLista(List<Integer> lista, String frase) {
        System.out.println(frase);
        for (Object item : lista) {
            System.out.println(item);
        }
        System.out.println("--------------------------");
        System.out.println("Total de registros: " + lista.size());
    }

    /**
     * exibe o tempo gasto por uma rotina
     * @param rotina - número da rotina
     * @param tempoMs - tempo em milissegundos
     */
    public static void exibirTempo(int rotina, long tempoMs) {
        System.out.println("Tempo (ms) rotina " + rotina + ": " + tempoMs);
    }
}
