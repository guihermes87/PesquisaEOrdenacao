
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Principal {


    public static void main(String a[]) {
        ArrayList<Integer> lista = new ArrayList<>();
        Util.carregarArquivoEmLista("numeros_aleatorios_1000.txt", lista);

        Ordenacao.insercao(lista);
       
        
        System.out.println("Total de elementos na lista: " + lista.size());

        int numeroPesquisa = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro para pesquisar: "));
        exibirResultados(lista, numeroPesquisa);

    }

    public static void exibirResultados(ArrayList<Integer> lista, int numeroPesquisa) {
        JOptionPane.showMessageDialog(null,"Resultado: " + lista.contains(numeroPesquisa) + "  " + Ordenacao.pesquisaBinaria(numeroPesquisa, lista));
    }

}
	