package mvc.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * MODEL: guarda os dados e contém a lógica de negócio
 * (popular a lista). Não imprime nada na tela.
 */
public class ListaNumeros {
    
    private final List<Integer> numeros = new ArrayList<>();

    public void popular(long quantidade, int inicio, int fim, boolean aleatorio) {
        Random gerador = new Random();

        if (aleatorio) {
            for (long i = 0; i < quantidade; i++) {
                numeros.add(gerador.nextInt(inicio, fim));
            }
        } else {
            for (long i = inicio; i < inicio + quantidade; i++) {
                numeros.add((int) i);
            }
        }
    }

    public List<Integer> getNumeros() {
        return numeros;
    }

    public int getTotal() {
        return numeros.size();
    }
}
