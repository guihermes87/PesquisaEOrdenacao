import java.util.List;
import java.util.ArrayList;

import model.Utilidades;
import view.Visao;

/*
Construir um programa que popule 2 listas: uma com números aleatórios e outra com números sequenciais... temporizando cada rotina
*/
/**
 * CONTROLLER: coordena o Model (Utilidades) e a View (Visao).
 */
public class ExemploMedicaoTempo {
    public static void main(String[] args) {
        long tempoInicio, tempoFim;
        List<Integer> listaAleatoria = new ArrayList<>();
        List<Integer> listaSequencial = new ArrayList<>();

        tempoInicio = System.nanoTime();
        // rotina1 - popular uma lista com 100000 aleatorios na faixa 100 a 100000
        Utilidades.popularLista(listaAleatoria, 100000, 100, 100000, true);
        // Visao.exibrLista(listaAleatoria, "Lista aleatoria");
        tempoFim = System.nanoTime();
        Visao.exibirTempo(1, (tempoFim - tempoInicio)/1000000);

        tempoInicio = System.nanoTime();
        // rotina2 - popular uma lista com 100000 de forma crescente 0 na posição 0, 1 na posição 1, e assim por diante
        Utilidades.popularLista(listaSequencial, 100000, 1, 100000, false);
        // Visao.exibrLista(listaSequencial, "Lista sequencial");
        tempoFim = System.nanoTime();
        Visao.exibirTempo(2, (tempoFim - tempoInicio)/1000000);
    }
}
