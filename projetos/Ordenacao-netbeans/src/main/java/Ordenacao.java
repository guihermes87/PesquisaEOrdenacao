import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

/**
 * Ordena uma lista de produtos pela data usando List.sort() com um Comparator em lambda.
 *
 * @author hermes
 */
public class Ordenacao {

    public static void main(String[] args) {

        List<Produto> listaProduto = new ArrayList<>();
        LocalDate dataAtual = LocalDate.now();

        // Datas diferentes para que a ordenação tenha efeito visível
        listaProduto.add(new Produto("Pão de Forma", 1, LocalDate.parse("2026-10-20")));
        listaProduto.add(new Produto("Leite Integral", 12, dataAtual));
        listaProduto.add(new Produto("Café Torrado", 5, dataAtual.minusDays(10)));
        listaProduto.add(new Produto("Arroz Branco", 30, dataAtual.plusDays(3)));
        listaProduto.add(new Produto("Feijão Preto", 20, dataAtual.minusDays(2)));
        listaProduto.add(new Produto("Açúcar Refinado", 15, dataAtual.plusDays(7)));
        listaProduto.add(new Produto("Óleo de Soja", 8, dataAtual.minusDays(30)));

        System.out.println("=== Antes da ordenação ===");
        listaProduto.forEach(System.out::println);

        listaProduto.sort((p1, p2) -> p1.getData().compareTo(p2.getData()));

        System.out.println("\n=== Ordenado por data ===");
        for (Produto item : listaProduto) {
            System.out.println(item);
        }
    }
}
