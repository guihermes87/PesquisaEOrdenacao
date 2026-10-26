using System;
using System.Collections.Generic;
using System.Diagnostics;
using Model;


public class Visualizacao
{
    public static void exibir(List<long> lista)
    {
        foreach (var item in lista)
        {
            Console.WriteLine(item.ToString());
        }
    }

    public static void exibir(List<Processo> lista)
    {
        foreach (var item in lista)
        {
            Console.WriteLine($"Id: {item.Id}, Data: {item.Data:d}");
        }
    }

    public static void exibirTempo(Stopwatch sw, string frase)
    {
        Console.WriteLine(frase + " (ms): " + sw.ElapsedMilliseconds);
    }

    public static void exibirTrocas(string nome, long qtdTrocas)
    {
        Console.WriteLine(nome + " - trocas: " + qtdTrocas);
    }
}
