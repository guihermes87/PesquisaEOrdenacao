using System;
using System.Collections.Generic;
using System.Diagnostics;

public class Util
{
    public static void popular(List<int> lista, int quantidade)
    {
        Random gerador = new Random();
        for (int i = 0; i < quantidade; i++)
        {
            lista.Add(gerador.Next(100000));
        }

    }

    // Para ordenações que não contam trocas (ex.: List<T>.Sort() nativo)
    public static void Medir(string nome, Action acao)
    {
        var sw = Stopwatch.StartNew();
        acao();
        sw.Stop();
        Visualizacao.exibirTempo(sw, nome);
    }

    // Para ordenações que retornam a quantidade de trocas realizadas.
    // Nome diferente de Medir de propósito: um lambda como "() => Ordenacao.bubbleSort(lista)"
    // é convertível tanto para Action quanto para Func<int>, então uma sobrecarga Medir(Func<int>)
    // deixaria a chamada ambígua (erro CS0121). Por isso um método com outro nome.
    public static void MedirTrocas(string nome, Func<int> acao)
    {
        var sw = Stopwatch.StartNew();
        int qtdTrocas = acao();
        sw.Stop();
        Visualizacao.exibirTempo(sw, nome);
        Visualizacao.exibirTrocas(nome, qtdTrocas);
    }
}