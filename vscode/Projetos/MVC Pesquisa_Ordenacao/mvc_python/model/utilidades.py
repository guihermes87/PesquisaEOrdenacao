"""MODEL: lógica de negócio (popular listas). Sem print."""
import random


def popular_lista(lista, quantidade_numeros, inicio, fim, aleatorio):
    """Popula lista com números aleatórios ou sequenciais dentro de uma faixa.

    :param lista: lista a ser populada
    :param quantidade_numeros: quantidade de números
    :param inicio: início da faixa
    :param fim: fim da faixa
    :param aleatorio: se True os números devem ser aleatórios
    """
    if aleatorio:
        for _ in range(quantidade_numeros):
            lista.append(random.randint(inicio, fim - 1))

    if not aleatorio:
        for i in range(inicio, quantidade_numeros):
            lista.append(i)
