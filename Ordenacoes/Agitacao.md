public static void agitacao(List<int> lista)
    {
        bool houveTroca;
        int tmp;
        int ini = 0;
        int fim = lista.Count;
        int qtdComparacoes = 0, qtdTrocas = 0;  //avalia a complexidade ou o esforço

        do
        {
            houveTroca = false;
            for (int i = ini; i < fim - 1; i++)
            {
                qtdComparacoes++;
                if (lista[i] > lista[i + 1])
                {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista[i];
                    lista[i] = lista[i + 1];
                    lista[i + 1] = tmp;
                }
            }

            if (!houveTroca)
            {
                break;
            }
            fim--;

            houveTroca = false;
            for (int i = fim; i >= ini + 1; i--)
            {
                qtdComparacoes++;
                if (lista[i] < lista[i - 1])
                {
                    qtdTrocas++;
                    houveTroca = true;
                    tmp = lista[i];
                    lista[i] = lista[i - 1];
                    lista[i - 1] = tmp;
                }
            }
            ini++;

        } while (houveTroca);
    }

    ```c#
void agitacao(List<> lista) {
    bool houveTroca;
    int tmp;
    int ini = 0;
    int fim = lista.Count;
    int qtdComparacoes = 0, qtdTrocas = 0;  //avalia a complexidade ou o esforço

    do {
        houveTroca = False;
        for (int i = ini; i < fim-1; i++){
            qtdComparacoes++;
            if (lista[i] > lista[i+1]) {
                qtdTrocas++;
                houveTroca = True;
                tmp = lista[i];
                lista[i] = lista[i+1];
                lista[i+1] = tmp;
            }
        }

        if (!houveTroca) {
            break;
        }
        fim--;

        houveTroca = False;
        for (int i = fim; i > ini+1; i--){
            qtdComparacoes++;
            if (lista[i] < lista[i-1]) {
                qtdTrocas++;
                houveTroca = True;
                tmp = lista[i];
                lista[i] = lista[i-1];
                lista[i-1] = tmp;
            }
        }
        ini++;

    } while (houveTroca);
}
````

```java
void agitacao(List<> lista) {
    boolean houveTroca;
    int tmp;
    int ini = 0;
    int fim = lista.size();
    int qtdComparacoes = 0, qtdTrocas = 0;

    do {
        houveTroca = false;
        for (int i = ini; i < fim-1; i++){
            qtdComparacoes++;
            if (lista.get(i) > lista.get(i+1)) {
                qtdTrocas++;
                houveTroca = True;
                tmp = lista.get(i);
                lista.set(i, lista.get(i+1));
                lista.set(i+1, tmp);
            }
        }

        if (!houveTroca) {
            break;
        }
        fim--;

        houveTroca = False;
        for (int i = fim; i > ini+1; i--){
            qtdComparacoes++;
            if (lista.get(i) < lista.get(i-1)) {
                qtdTrocas++;
                houveTroca = True;
                tmp = lista.get(i);
                lista.set(i, lista.get(i-1);
                lista.set(i-1, tmp);
            }
        }
        ini++;

    } while (houveTroca);
}
````

```python
def agitacao(lista):
    ini = 0
    fim = len(lista)
    qtd_comparacoes = 0
    qtd_trocas = 0

    while(True):
        houveTroca = False
        for i in range(ini, fim-1):
            qtd_comparacoes+=1
            if (lista[i] > lista[i+1]):
                qtd_trocas+=1
                houveTroca = True
                tmp = lista[i]
                lista[i] = lista[i+1]
                lista[i+1] = tmp
            
        if (not houveTroca):
            break
        
        fim-=1

        houveTroca = False
        for i in range(fim, ini, -1):
            qtd_comparacoes+=1
            if (lista[i] < lista[i-1]):
                qtd_trocas+=1
                houveTroca = True
                tmp = lista[i]  
                lista[i] = lista[i-1]
                lista[i-1] = tmp
            
        ini+=1

        if (not houveTroca):
            break
```

