import java.util.HashSet;

public class  Exemplohashsimples {
    public static void main(String[] args) {
        
        HashSet<String> tabelahashString = new HashSet<String>();
       
        tabelahashString.add("Hermes");
        tabelahashString.add("David");
        tabelahashString.add("Rafael");
        tabelahashString.add("Alan");
        tabelahashString.add("Alexandre");
        tabelahashString.add("Davi");

        for (String nome : tabelahashString) {
            System.out.println(nome + " - " + nome.hashCode());
        }

        System.out.println(tabelahashString.contains("Hermes") + " - " + "Hermes".hashCode());
    }
}