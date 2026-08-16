"""VIEW: toda a exibição em tela fica aqui."""


def exibr_lista(lista, frase):
    """Exibe o conteúdo de uma lista de inteiros."""
    print(frase)
    for item in lista:
        print(item)
    print("--------------------------")
    print("Total de registros:", len(lista))


def exibir_tempo(rotina, tempo_ms):
    """Exibe o tempo gasto por uma rotina."""
    print(f"Tempo (ms) rotina {rotina}: {tempo_ms}")
