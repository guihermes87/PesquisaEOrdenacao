using System;
using System.Collections.Generic;
using System.Diagnostics;

public class Util
{
    public static void popular(List<long> lista, in long quantidade)
    {
        Random gerador = new Random();
        for (long i = 0; i < quantidade; i++)
        {
            lista.Add(gerador.Next(100000));
        }

    }

 
    public static void Medir(string nome, Action acao)
    {
        var sw = Stopwatch.StartNew();
        acao();
        sw.Stop();
        Visualizacao.exibirTempo(sw, nome);
    }

    public static void MedirTrocas(string nome, Func<long> acao)
    {
        var sw = Stopwatch.StartNew();
        long qtdTrocas = acao();
        sw.Stop();
        Visualizacao.exibirTempo(sw, nome);
        Visualizacao.exibirTrocas(nome, qtdTrocas);
    }
}