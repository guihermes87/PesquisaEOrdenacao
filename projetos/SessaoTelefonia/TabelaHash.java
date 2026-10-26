/**
 * Tabela hash com encadeamento separado (lista ligada em cada posição).
 * Chave: String (telefone). Valor: SessaoTelefonia.
 */
public class TabelaHash {

    private static class No {
        final String chave;
        SessaoTelefonia valor;
        No proximo;
        No(String chave, SessaoTelefonia valor, No proximo) {
            this.chave = chave; this.valor = valor; this.proximo = proximo;
        }
    }

    private No[] tabela;
    private int tamanho;
    private static final double FATOR_CARGA_MAX = 0.75;

    public TabelaHash() { this(16); }

    public TabelaHash(int capacidadeInicial) {
        tabela = new No[Math.max(1, capacidadeInicial)];
    }

    /** Função hash: hashCode da String, sem sinal, módulo capacidade. */
    private int indice(String chave, int capacidade) {
        return (chave.hashCode() & 0x7fffffff) % capacidade;
    }

    /** Insere ou substitui. Retorna o valor anterior (ou null). */
    public SessaoTelefonia inserir(String chave, SessaoTelefonia valor) {
        if (chave == null) throw new IllegalArgumentException("Chave nula");
        int i = indice(chave, tabela.length);
        for (No n = tabela[i]; n != null; n = n.proximo) {
            if (n.chave.equals(chave)) {
                SessaoTelefonia antigo = n.valor;
                n.valor = valor;
                return antigo;
            }
        }
        tabela[i] = new No(chave, valor, tabela[i]);
        tamanho++;
        if ((double) tamanho / tabela.length > FATOR_CARGA_MAX) redimensionar();
        return null;
    }

    /** Consulta pela chave. Retorna null se não existir. */
    public SessaoTelefonia buscar(String chave) {
        if (chave == null) return null;
        for (No n = tabela[indice(chave, tabela.length)]; n != null; n = n.proximo) {
            if (n.chave.equals(chave)) return n.valor;
        }
        return null;
    }

    public boolean contem(String chave) { return buscar(chave) != null; }

    /** Remove pela chave. Retorna o valor removido (ou null). */
    public SessaoTelefonia remover(String chave) {
        if (chave == null) return null;
        int i = indice(chave, tabela.length);
        No anterior = null;
        for (No n = tabela[i]; n != null; anterior = n, n = n.proximo) {
            if (n.chave.equals(chave)) {
                if (anterior == null) tabela[i] = n.proximo; else anterior.proximo = n.proximo;
                tamanho--;
                return n.valor;
            }
        }
        return null;
    }

    public int tamanho() { return tamanho; }
    public int capacidade() { return tabela.length; }

    /** Maior lista encadeada (medida de colisões). */
    public int maiorCadeia() {
        int max = 0;
        for (No cabeca : tabela) {
            int c = 0;
            for (No n = cabeca; n != null; n = n.proximo) c++;
            max = Math.max(max, c);
        }
        return max;
    }

    private void redimensionar() {
        No[] nova = new No[tabela.length * 2];
        for (No cabeca : tabela) {
            No n = cabeca;
            while (n != null) {
                No prox = n.proximo;
                int i = indice(n.chave, nova.length);
                n.proximo = nova[i];
                nova[i] = n;
                n = prox;
            }
        }
        tabela = nova;
    }
}
