using System;
using System.Collections.Generic;
using System.Diagnostics;


public class Principal
{
    public static void Main(string[] args)
    {

        List<long> listaAgitacao = new List<long>();
        List<long> listaSort = new List<long>();
        List<long> listaBubble = new List<long>();
        List<long> listaInsertion = new List<long>();

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
        