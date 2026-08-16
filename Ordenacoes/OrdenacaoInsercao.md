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
