using System;
using System.Collections.Generic;
using System.Diagnostics;


public class Principal
{
    public static void Main(string[] args)
    {
        
        List<int> listaAgitacao = new List<int>();      
        List<int> listaSort = new List<int>();
        List<int> listaBubble = new List<int>();
        List<int> listaInsertion = new List<int>();

        Util.popular(listaAgitacao, 100000);
        Util.popular(listaSort, 100000);
        Util.popular(listaBubble, 100000);
        Util.popular(listaInsertion, 100000);

        Stopwatch sw = new Stopwatch();

        Util.MedirTrocas("Ordenacao por agitacao", () => Ordenacao.agitacao(listaAgitacao));
        Util.Medir("Ordenacao por sort nativo", () => listaSort.Sort());
        Util.MedirTrocas("Ordenacao por bubble sort", () => Ordenacao.bubbleSort(listaBubble));
        Util.MedirTrocas("Ordenacao por insertion sort", () => Ordenacao.insertionSort(listaInsertion));

    }


}
        