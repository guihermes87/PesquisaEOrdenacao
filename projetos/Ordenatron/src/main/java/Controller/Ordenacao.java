

package Controller;

import java.lang.reflect.Array;

import View.Arraylist;

import java.util.ArrayList;
import java.util.HashSet;

public class Ordenacao {
    
    

public static ArrayList<Float> bolha(ArrayList<Integer> lista) {
    ArrayList<Float> metricas = new ArrayList<>();
    long qtdComparacoes = 0;
    long qtdTrocas = 0;
    int aux;
    boolean houveTroca;
    
    int n = lista.size();
    
    do {
        houveTroca = false;
        for (int i = 0; i < n - 1; i++) {
            qtdComparacoes++;
            if (lista.get(i) > lista.get(i + 1)) {
                houveTroca = true;
                aux = lista.get(i);
                lista.set(i, lista.get(i + 1));
                lista.set(i + 1, aux);
                qtdTrocas++;
            }
        }
        // Otimização opcional: a cada passada, o maior elemento já vai para o final,
        // então podemos reduzir o espaço de busca decrementando 'n'.
        n--; 
    } while (houveTroca);

    metricas.add((float)qtdComparacoes);
    metricas.add((float)qtdTrocas);
    
    return metricas;
}

    
    public static ArrayList<Float>pente(ArrayList<Integer> lista) {
        
        ArrayList<Float> metricas = new ArrayList<>();
        
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux;
        boolean houveTroca;
        int i;
        int distancia = lista.size();
        
        do {
            
            distancia = (int)(distancia/1.3);
            if(distancia <=0) {
            distancia = 1;
                    }
            houveTroca = false;
            for (i = 0; i < lista.size() - 1; i++) {
                qtdComparacoes++;
                if (lista.get(i) > lista.get(i + distancia)) {
                    houveTroca = true;
                    aux = lista.get(i);
                    lista.set(i, lista.get(i + distancia));
                    lista.set(i + distancia, aux);
                    qtdTrocas++;
                }
            }
        } while (houveTroca);
        
        metricas.add((float)qtdComparacoes);
        metricas.add((float)qtdTrocas);
        return metricas;
    }


    public static ArrayList<Float> selecao(ArrayList<Integer> lista) {

        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int i, j, posMenor, aux;

        for (i = 0; i < lista.size() - 1; i++) {
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



    public static ArrayList<Float> insercao(ArrayList<Integer> lista) {

        ArrayList<Float> metricas = new ArrayList<>();
        long qtdComparacoes = 0;
        long qtdTrocas = 0;
        int aux, j;

        for (int i = 1; i < lista.size(); i++) {
            aux = lista.get(i);
            j = i - 1;
            while (j >= 0) {
                qtdComparacoes++;
                if (aux < lista.get(j)) {
                    lista.set(j + 1, lista.get(j));
                    qtdTrocas++;
                    j--;
                } else {
                    break;
                }
            }
            lista.set(j + 1, aux);
        }

        metricas.add((float) qtdComparacoes);
        metricas.add((float) qtdTrocas);
        return metricas;
    }

    
 public static ArrayList<Float> shell(ArrayList<Integer> lista) {

    ArrayList<Float> metricas = new ArrayList<>();
    long qtdComparacoes = 0;
    long qtdTrocas = 0;
    int n = lista.size();
    int i, j, tmp;
    int distancia = 1;
    int referenciaTamanho = 3;

    do {
        distancia = referenciaTamanho * distancia + 1;
    } while (distancia < n);

    do {
        distancia = distancia / referenciaTamanho;

        for (i = distancia; i < n; i++) {
            tmp = lista.get(i);
            for (j = i - distancia; j >= 0; j -= distancia) {
                qtdComparacoes++;
                if (tmp < lista.get(j)) {
                    lista.set(j + distancia, lista.get(j));
                    qtdTrocas++;
                } else {
                    break;
                }
            }
            lista.set(j + distancia, tmp);
        }
    } while (distancia > 1);

    metricas.add((float) qtdComparacoes);
    metricas.add((float) qtdTrocas);
    return metricas;
}

//    public static Arraylist<Float> Heap(Arraylist<Integer> lista) {
//
//        int tmp;
//        int tamanho = lista.size();
//
//        ArrayList<Integer> metricas = new ArrayList<>();
//
//        lista.add(lista.get(0));
//
//        for (int i = 1; i * 2 < lista.size(); i++) {
//            //analisa filho da esquerda
//            if (lista.get(i) < lista.get(i * 2)) {
//
//                tmp = lista.get(i);
//                lista.set(i, lista.get(i * 2));
//                lista.set(i * 2, tmp);
//
//            }
//
//            if (i*2 +1 < lista.size() && lista.get(i) < lista.get(i*2 +1)){
//                // analisa filho da direita se existir
//                tmp = lista.get(i);
//                lista.set(i, lista.get(i * 2));
//                lista.set(i * 2 + 1, tmp);
//
//            }
//            
//            tmp = lista.get(1);
//            lista.set(1, lista.get(lista.size()-1));
//            lista.set(lista.size()-1, tmp);
//            tamanho --;
//        }
//            lista.remove(0);
//            metricas.add(qtdComparacoes);
//            metricas.add(qtdTrocas);
//            return metricas;
//
// }

    public static boolean pesquisaBinaria(int numero, ArrayList<Integer> lista) {

        int ini = 0;
        int fim = lista.size() - 1;
        long quantidadeComparacoes = 0; // Variável para contar comparações
        while (ini <= fim) {
            int meio = (ini + fim) / 2;

            quantidadeComparacoes++; // Incrementa a contagem de comparações
            
            if (lista.get(meio) == numero) {
                System.out.println("Número de comparações: " + quantidadeComparacoes);
                return true; // Número encontrado
            } else if (lista.get(meio) < numero) {
                ini = meio + 1; // Busca na metade direita
            } else {
                fim = meio - 1; // Busca na metade esquerda
            }
        }

        return false; // Número não encontrado
    }

    
}
