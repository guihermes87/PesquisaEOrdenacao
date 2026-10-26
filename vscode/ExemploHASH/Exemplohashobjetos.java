import java.util.HashSet;

class Aluno {

int matricula;
String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
        
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + matricula;
        
        return result;
    }


@Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (matricula != other.matricula)
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }


}

public class Exemplohashobjetos {
 
    @Override
    public String toString() {
        return "Exemplohashobjetos []";
    }

    public static void main(String[] args) {
        
        HashSet<Aluno> tabelahashAluno = new HashSet<Aluno>();

        tabelahashAluno.add(new Aluno(1, "Hermes"));
        tabelahashAluno.add(new Aluno(2, "David"));
        tabelahashAluno.add(new Aluno(3, "Rafael"));
        tabelahashAluno.add(new Aluno(4, "Alan"));
        tabelahashAluno.add(new Aluno(5, "Alexandre"));

        for (Aluno aluno : tabelahashAluno) {
            System.out.println(aluno.nome + " - " + aluno.matricula);
        }
    }

}
