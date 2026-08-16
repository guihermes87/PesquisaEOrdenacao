
```c#
void pente(List<> lista) {
    bool houveTroca;
    int tmp;
    int distancia = lista.Count;
    int qtdComparacoes = 0, qtdTrocas = 0;

    do {
        distancia = (int)distancia / 1.3;
        if (distancia < 1) {
            distancia = 1;
        }
        houveTroca = false;
        for (int i = 0; i < lista.Count - distancia; i++){
            qtdComparacoes++;
            if (lista[i] > lista[i+distancia]) {
                qtdTrocas++;
                houveTroca = true;
                tmp = lista[i];
                lista[i] = lista[i+distancia];
                lista[i+distancia] = tmp;
            }
        }
    } while (houveTroca || distancia > 1);
}
````


```java
void pente(List<> lista) {
    bool houveTroca;
    int tmp;
    int distancia = lista.size();
    int qtdComparacoes = 0, qtdTrocas = 0;

    do {
        distancia = (int)distancia / 1.3;
        if (distancia < 1) {
            distancia = 1;
        }
        houveTroca = false;
        for (int i = 0; i+distancia < lista.size(); i++){
            qtdComparacoes++;
            if (lista.get(i) > lista.get(i+distancia)) {
                qtdTrocas++;
                houveTroca = True;
                tmp = lista[i];
                lista.set(i, lista[i+distancia]);
                lista.set(i+distancia, tmp);
            }
        }
    } while (houveTroca || distancia > 1);
}
````
