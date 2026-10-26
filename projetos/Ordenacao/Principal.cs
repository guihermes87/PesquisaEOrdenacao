using System;
using System.Collections.Generic;
using System.Diagnostics;
using Model;


public class Principal
{
    public static void Main(string[] args)
    {

        List<long> listaAgitacao = new List<long>();
        List<long> listaSort = new List<long>();
        List<long> listaBubble = new List<long>();
        List<long> listaInsertion = new List<long>();
        List<long> listaPente = new List<long>();


        var processo = new Model.Processo(101, new DateTime(2023, 8, 15));
        var processo2 = new Model.Processo(102, new DateTime(2023, 8, 16));
        var processo3 = new Model.Processo(103, new DateTime(2023, 8, 10));
        var processo4 = new Model.Processo(104, new DateTime(2023, 8, 11));

        List<Model.Processo> listaProcessos = new List<Model.Processo>
        {
            processo,
            processo2,
            processo3,
            processo4
        };

        Visualizacao.exibir(listaProcessos);

        // Util.popular(listaAgitacao, 100000);
        // Util.popular(listaSort, 100000);
        // Util.popular(listaBubble, 100000);
        // Util.popular(listaInsertion, 100000);
        // Util.popular(listaPente, 100000);

        // Stopwatch sw = new Stopwatch();

        // Util.MedirTrocas("Ordenacao por agitacao", () => Ordenacao.agitacao(listaAgitacao));
        // Util.MedirTrocas("Ordenacao por sort nativo", () => listaSort.Sort());
        // Util.MedirTrocas("Ordenacao por bubble sort", () => Ordenacao.bubbleSort(listaBubble));
        // Util.MedirTrocas("Ordenacao por insertion sort", () => Ordenacao.insertionSort(listaInsertion));
        // Util.MedirTrocas("Ordenacao por pente", () => Ordenacao.pente(listaPente));

        // Como ordenar uma lista por alguma chave do objeto, ordenar por data e id na segunda chave.
        //Criar lista ojeto com caracteres int id e Data data.
        //

    }


}
        