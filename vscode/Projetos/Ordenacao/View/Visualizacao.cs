using System;
using System.Collections.Generic;
using System.Diagnostics;


public class Visualizacao
{
    public static void exibir(List<long> lista)
    {
        foreach (var item in lista)
        {
            Console.WriteLine(item.ToString());
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
