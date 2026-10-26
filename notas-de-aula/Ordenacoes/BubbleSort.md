public static void bubbleSort(List<int> lista)
    {
        int n = lista.Count;
        for (int i = 0; i < n - 1; i++)
        {
            for (int j = 0; j < n - i - 1; j++)
            {
                if (lista[j] > lista[j + 1])
                {
                    // Troca
                    int temp = lista[j];
                    lista[j] = lista[j + 1];
                    lista[j + 1] = temp;
                }
            }
        }
    }

```java

void bolha(List<> lista) {
    boolean houveTroca;
    int tmp;
    int qtdComparacoes = 0, qtdTrocas = 0;

    do {
        houveTroca = False;
        for (int i = 0; i < lista.size()-1; i++){
            qtdComparacoes++;
            if (lista.get(i) > lista.get(i+1)) {
                qtdTrocas++;
                houveTroca = True;
                tmp = lista.get(i);
                lista.set(i, lista.get(i+1));
                lista.set(i+1, tmp);
            }
        }
    } while (houveTroca);
}
```

```python

def bolha(lista):
    houve_troca = true
    qtd_comparacoes = 0
    qtd_trocas = 0
    while (houve_troca):    
        houveTroca = false
        for i in range (len(lista) - 1):
            qtd_comparacoes+=1
            if (lista[i] > lista[i+1]):
                qtd_trocas+=1
                houve_troca = true
                tmp = lista[i]
                lista[i] = lista[i+1]
                lista[i+1] = tmp
```
