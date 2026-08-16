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

        sw.Start();
        Ordenacao.agitacao(listaAgitacao);
        sw.Stop();
        Visualizacao.exibirTempo(sw, "Ordenacao por agitacao");
        sw.Reset();

        sw.Start();
        listaSort.Sort();
        sw.Stop();
        Visualizacao.exibirTempo(sw, "Ordenacao por sort nativo");
        sw.Reset();

        sw.Start();
        Ordenacao.bubbleSort(listaBubble);
        sw.Stop();
        Visualizacao.exibirTempo(sw, "Ordenacao por bubble sort");
        sw.Reset();

        sw.Start();
        Ordenacao.insertionSort(listaInsertion);
        sw.Stop();
        Visualizacao.exibirTempo(sw, "Ordenacao por insertion sort");
        sw.Reset();

    }


}
        