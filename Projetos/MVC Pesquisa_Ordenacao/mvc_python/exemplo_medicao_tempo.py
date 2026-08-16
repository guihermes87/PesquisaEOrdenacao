"""CONTROLLER: coordena o Model (utilidades) e a View (visao).

Construir um programa que popule 2 listas: uma com números aleatórios
e outra com números sequenciais... temporizando cada rotina.
"""
import time

from model import utilidades
from view import visao


def main():
    lista_aleatoria = []
    lista_sequencial = []

    tempo_inicio = time.perf_counter_ns()
    # rotina1 - popular uma lista com 100000 aleatorios na faixa 100 a 100000
    utilidades.popular_lista(lista_aleatoria, 100000, 100, 100000, True)
    # visao.exibr_lista(lista_aleatoria, "Lista aleatoria")
    tempo_fim = time.perf_counter_ns()
    visao.exibir_tempo(1, (tempo_fim - tempo_inicio) // 1000000)

    tempo_inicio = time.perf_counter_ns()
    # rotina2 - popular uma lista com 100000 de forma crescente
    utilidades.popular_lista(lista_sequencial, 100000, 1, 100000, False)
    # visao.exibr_lista(lista_sequencial, "Lista sequencial")
    tempo_fim = time.perf_counter_ns()
    visao.exibir_tempo(2, (tempo_fim - tempo_inicio) // 1000000)


if __name__ == "__main__":
    main()
