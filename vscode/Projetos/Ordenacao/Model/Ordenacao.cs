
using System;
using System.Collections.Generic;

namespace Model;

public class Ordenacao {

    public static long agitacao(List<long> lista)
    {
        bool houveTroca;
        long tmp;
        int ini = 0;
        int fim = lista.Count;
        long qtdComparacoes = 0, qtdTrocas = 0;  //avalia a complexidade ou o esforço

        do
        {
            houveTroca = false;
            for (int i = ini; i < fim - 1; i++)
            {
                qtdComparacoes++;
                if (lista[i] > lista[i + 1])
                {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = tmp;
                }
            }

            if (!houveTroca)
            {
                break;
            }
            fim--;

            houveTroca = false;
            for (int i = fim; i >= ini + 1; i--)
            {
                qtdComparacoes++;
                if (lista[i] < lista[i - 1])
                {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista[i];
                    lista[i] = lista[i - 1];
                    lista[i - 1] = tmp;
                }
            }
            ini++;

        } while (houveTroca);

        return qtdTrocas;
    }

    public static long bubbleSort(List<long> lista)
    {
        int n = lista.Count;
        long qtdTrocas = 0;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (lista[j] > lista[j + 1])
                {
                    // Troca
                    long temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                    qtdTrocas++;
                }
            }
        }

        return qtdTrocas;
    }

    public static long insertionSort(List<long> lista)
    {
        long qttrocas = 0; // Variável para contar o número de trocas

        int n = lista.Count;
        for (int i = 1; i < n; i++)
        {
            long key = lista[i];
            int j = i - 1;
            while (j >= 0 && lista[j] > key)
            {
                lista[j + 1] = lista[j];
                j--;
                qttrocas++; // conta cada deslocamento como uma troca
            }
            lista[j + 1] = key;
        }

        return qttrocas;
    }

    public static long pente(List<long> lista) {
    bool houveTroca;
    long tmp;
    int distancia = lista.Count;
    int qtdComparacoes = 0, qtdTrocas = 0;

    do {
        distancia = (int)(distancia / 1.3);
        if (distancia < 1) {
            distancia = 1;
        }
        houveTroca = false;
        for (int i = 0; i < lista.Count - distancia; i++){
            qtdComparacoes++;
            if (lista[i] > lista[i+distancia]) {
                qtdTrocas++;
                houveTroca = true;
                tmp = lista[i];
                lista[i] = lista[i+distancia];
                lista[i+distancia] = tmp;
            }
        }
    } while (houveTroca || distancia > 1);

    return qtdTrocas;
}

}