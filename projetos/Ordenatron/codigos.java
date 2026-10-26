import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Util {

    public static boolean carregarArquivoEmLista(String nomeArquivo, ArrayList<Integer> lista) {
        try {
            FileReader procurador;
            procurador = new FileReader(nomeArquivo);
            BufferedReader leitor = new BufferedReader(procurador);
            String linha;
            do {
                linha = leitor.readLine();
                if (linha != null) {
                    lista.add(Integer.parseInt(linha));
                }                
            } while (linha != null);
            leitor.close();
            return true;
        } catch (Exception e) {
            //System.out.println("Erro " + e.getMessage());
            return false;
        }
    }

    public static void exibirLista(ArrayList<Integer> lista) {
        for (Integer item : lista) {
            System.out.println(item);
        }
    }
}

import java.util.ArrayList;

public class Ordenacao {
    public static boolean contido(int numero, ArrayList<Integer> lista) {
        long qtdComparacoes = 0;
        for (Integer item : lista) {
            qtdComparacoes++;
            if (item == numero) {
                return true;
            }
        }
        return false;
    }


    public static boolean pesquisaBinaria(int numero, ArrayList<Integer> lista) {
        int ini = 0;
        int fim = lista.size()-1;
        int meio;
        long qtdComparacoes = 0;
        do {
            meio = (int)(ini+fim)/2;

            qtdComparacoes++;
            if (numero == lista.get(meio)) {
                return true;
            }
            if (numero < lista.get(meio)) {
                fim = meio - 1;                
            } else {
                ini = meio + 1;
            }
        } while (ini <= fim);
        System.out.println("Qauntidade de comparaçoes: " + qtdComparacoes);

        return false;
    }


    public static ArrayList bolha(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i;
        do {
            houveTroca = false;
            for (i = 0; i < lista.size() - 1; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + 1)) {
                    houveTroca = true;
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + 1));
                    lista.set(i + 1, aux);
                    qtdTrocas++;
                }
            }
        } while (houveTroca);
        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);
        return metricas;
    }

    public static ArrayList selecao(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int i, j, posMenor, aux;
        posMenor = 0;

        for (i = 0; i < lista.size(); i++) {
            posMenor = i;
            for (j = i + 1; j < lista.size(); j++) {
                qtdComparacoes++;
                if (lista.get(j) < lista.get(posMenor)) {
                    posMenor = j;
                }
            }
            if (posMenor != i) {
                aux = lista.get(i);
                lista.set(i, lista.get(posMenor));
                lista.set(posMenor, aux);
                qtdTrocas++;
            }
        }

        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);
        return metricas;
    }

    public static ArrayList insercao(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int i, j, aux;

        for (i = 1; i < lista.size(); i++) {
            aux = lista.get(i);
            for (j = i - 1; j > 0 && aux < lista.get(j); j--, qtdComparacoes++) {
                qtdTrocas++;
                lista.set(j + 1, lista.get(j));
            }
            lista.set(j + 1, aux);
        }
        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);
        return metricas;
    }

    public static ArrayList pente(ArrayList<Integer> lista) {
        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i;
        int distancia = lista.size();
        do {
            distancia = (int) (distancia / 1.3);
            if (distancia <= 0) {
                distancia = 1;
            }
            houveTroca = false;
            for (i = 0; i + distancia < lista.size(); i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + distancia)) {
                    houveTroca = true;
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, aux);
                    qtdTrocas++;
                }
            }
        } while (distancia > 1 || houveTroca);
        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);
        return metricas;
    }
}


import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {
    public static void main(String a[]) {
        ArrayList<Integer> lista = new ArrayList<>();
        Util.carregarArquivoEmLista("numeros.txt", lista);
        Ordenacao.pente(lista);
        Util.exibirLista(lista);
        System.out.println("Total de elementos na lista: " + lista.size());

        int numeroPesquisa = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro para pesquisar: "));
        JOptionPane.showMessageDialog(null,"Resultado: " + lista.contains(numeroPesquisa) + "  " + Ordenacao.pesquisaBinaria(numeroPesquisa, lista));

    }
}
	