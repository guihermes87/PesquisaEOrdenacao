 public static void insertionSort(List<int> lista)
    {
        int n = lista.Count;
        for (int i = 1; i < n; i++)
        {
            int key = lista[i];
            int j = i - 1;
            while (j >= 0 && lista[j] > key)
            {
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = key;
        }
    }

 }
 
```c#
void insercao(Lista<> lista) {
    int i, j;
    int tmp;
    int qtdComparacoes = 0, qtdTrocas = 0;

    for (i = 1; i < lista.Count(); i++) {
        tmp = lista[i];
        for (j = i - 1; j >= 0; j--) {
            qtdComparacoes++;
            if (tmp < lista[j]) {
                lista[j + 1] = lista[j]; //shift eh trocar para o lado
                qtdTrocas++;
            } else break;
        }
        lista[j + 1] = tmp;
        qtdTrocas++;
    }
}
```

```java
void insercao(Lista<> lista) {
    int i, j;
    int tmp;
    int qtdComparacoes = 0, qtdTrocas = 0;

    for (i = 1; i < n; i++) {
        tmp = lista.get(i);
        for (j = i - 1; j >= 0; j--) {
            qtdComparacoes++;
            if (tmp < lista.get(j)) {
                lista.set(j + 1, lista.get(j));
                qtdTrocas++;
            } else break;
        }
        lista.set(j + 1, tmp);
        qtdTrocas++;
    }
}
```

```python
def insercao(lista):
    qtd_comparacoes = 0
    qtd_trocas = 0

    for i in range(1, len(lista)):
        tmp = lista[i]
        for j in range(i - 1, -2, -1):
            qtd_comparacoes+=1
            if (tmp < lista[j]):
                lista[j + 1] = lista[j]
                qtd_trocas+=1
            else:
                break

        lista[j + 1] = tmp
        qtd_trocas+=1
```

