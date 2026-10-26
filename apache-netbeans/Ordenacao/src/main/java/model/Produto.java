package model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Produto com descrição, código e data, usado no exemplo de ordenação por data.
 *
 * @author hermes
 */
public class Produto {

    private String produto;
    private int codigo;
    private LocalDate data;

    public Produto(String produto, int codigo, LocalDate data) {
        this.produto = produto;
        this.codigo = codigo;
        this.data = data;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.format("%-16s | código %3d | %s", produto, codigo, data);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.produto);
        hash = 31 * hash + this.codigo;
        hash = 31 * hash + Objects.hashCode(this.data);
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
        final Produto other = (Produto) obj;
        return this.codigo == other.codigo
                && Objects.equals(this.produto, other.produto)
                && Objects.equals(this.data, other.data);
    }
}
