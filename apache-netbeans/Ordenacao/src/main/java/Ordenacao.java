/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Produto.model;

import .java.util.list;
import java.util.ArrayList;

/**
 *
 * @author hermes
 */
public class Ordenacao {

    public static void main(String[] args) {

        List<Produto> listaProduto = new Arraylist<>();
        LocalDate dataAtual = LocalDate.now();

        listaProduto.add(new Produto("Pão de Forma", 1, LocalDate.parse(dataAtual));
        listaProduto.add(new Produto("Leite Integral", 12, dataAtual));
        listaProduto.add(new Produto("Café Torrado", 5, dataAtual));
        listaProduto.add(new Produto("Arroz Branco", 30, dataAtual));
        listaProduto.add(new Produto("Feijão Preto", 20, dataAtual));
        listaProduto.add(new Produto("Açúcar Refinado", 15, dataAtual));
        listaProduto.add(new Produto("Óleo de Soja", 8, dataAtual));

        listaProduto.sort((p1, p2) -> p1.getData().compareTo(p2.getData());
        
        

        for (Produto item : listaProduto) {
            System.out.println(item);
        }
        
    }
}
