package pesquisaeordenacao2;

import java.util.Objects;

/**
 * Pessoa com ordem natural definida por Comparable: primeiro pelo nome, depois pela idade.
 *
 * @author hermes
 */
public class Pessoa implements Comparable<Pessoa> {

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Ordem natural: nome em ordem alfabética; em caso de empate, idade crescente.
     */
    @Override
    public int compareTo(Pessoa outra) {
        int porNome = this.nome.compareTo(outra.nome);
        if (porNome != 0) {
            return porNome;
        }
        return Integer.compare(this.idade, outra.idade);
    }

    @Override
    public String toString() {
        return "Pessoa{" + "nome=" + nome + ", idade=" + idade + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + this.idade;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final Pessoa other = (Pessoa) obj;
        return this.idade == other.idade && Objects.equals(this.nome, other.nome);
    }
}
