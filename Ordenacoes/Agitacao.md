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
