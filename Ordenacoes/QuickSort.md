int particiona(int *vetor, int ini, int fim) {
    int pivo;
    int tmp; //para as trocas

    pivo = ini; //na bibliografia do método, é possível ser o ini, o fim ou uma posição sorteada
    while (fim > ini) {

        //analise da direita para esquerda
        for (; fim > pivo && vetor[fim] > vetor[pivo]; fim--, qtd_comparacoes++); //garantindo que os maiores fiquem na direita

        if (fim > pivo) {
            qtdTrocas++;
            tmp = vetor[pivo];
            vetor[pivo] = vetor[fim];
            vetor[fim] = tmp;
            pivo = fim;
        }

        //analise da esquerda para direita
        for (ini++; ini < pivo && vetor[ini] < vetor[pivo]; ini++, qtdComparacoes++);

        if (ini < pivo) {
            qtdTrocas++;
            tmp = vetor[pivo];
            vetor[pivo] = vetor[ini];
            vetor[ini] = tmp;
            pivo = ini;
        }
    }
    return pivo;
}

void quickSort(int *vetor, int ini, int fim) { //método recurisivo baseado em árvore desbalanceada
    int pivo;

    pivo = particiona(vetor, ini, fim); //no final do particiona, o pivo está ordenado e é retornado a posição do pivo
    
    if (ini < pivo - 1) //tem lado esquerdo com mais de 1 elemento
        quickSort(vetor, ini, pivo - 1); //se existe lado esq do pivo, executa lado esq
    if (pivo + 1 < fim) //tem lado direito com mais de 1 elemento
        quickSort(vetor, pivo + 1, fim); //se existe lado dir do pivo, executa lado dir
}
```
