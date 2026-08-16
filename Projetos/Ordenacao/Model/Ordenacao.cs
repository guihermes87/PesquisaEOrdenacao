 
 public class Ordenacao {
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
