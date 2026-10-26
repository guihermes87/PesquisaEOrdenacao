package pesquisaeordenacao2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Ordena uma lista de pessoas pela ordem natural definida em Pessoa.compareTo().
 *
 * @author hermes
 */
public class Principal {

    public static void main(String[] args) {

        List<Pessoa> lista = new ArrayList<>();

        lista.add(new Pessoa("Gabriel", 19));
        lista.add(new Pessoa("Alex", 52));
        lista.add(new Pessoa("Gabriel", 20));
        lista.add(new Pessoa("Alex", 51));

        System.out.println("Antes:  " + lista);

        Collections.sort(lista);

        System.out.println("Depois: " + lista);
    }
}
