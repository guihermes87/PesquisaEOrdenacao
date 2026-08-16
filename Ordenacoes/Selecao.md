```c#
void selecao(List<> lista) {
    int posMenor;
    int qtd_comparacoes = 0, qtd_trocas = 0;
    for (int i = 0; i < lista.Count()-1; i++) {
        posMenor = i;
        for (int j = i+1; j < lista.Count(); j++) {
            qtd_comparacoes++;
            if (lista[j] < lista[posMenor]) {
                posMenor = j;
            }
        }
        if (i != posMenor) {
            qtd_trocas++;
            tmp = lista[i];
            lista[i] = lista[posMenor];
            lista[posMenor] = tmp;
        }
    }
}
```

```java
void selecao(List<> lista) {
    int posMenor;
    int qtd_comparacoes = 0, qtd_trocas = 0;
    for (int i = 0; i < lista.size()-1; i++) {
        posMenor = i;
        for (int j = i+1; j < lista.size(); j++) {
            qtd_comparacoes++;
            if (lista.get(j) < lista.get(posMenor)) {
                posMenor = j;
            }
        }
        if (i != posMenor) {
            qtd_trocas++;
            tmp = lista.get(i);
            lista.set(i, lista.get(posMenor));
            lista.set(posMenor, tmp);
        }
    }
}
```

```python
def selecao(lista):
    qtd_comparacoes = 0
    qtd_trocas = 0
    for i in range(len(lista) - 1):
        posMenor = i
        for j in range(i+1, len(lista)):
            qtd_comparacoes+=1
            if (lista[j] < lista[posMenor]):
                posMenor = j
            
        if (i != posMenor):
            qtd_trocas+=1
            tmp = lista[i]
            lista[i] = lista[posMenor]
            lista[posMenor] = tmp        
```
