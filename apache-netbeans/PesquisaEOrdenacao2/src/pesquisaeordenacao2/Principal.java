package pesquisaeordenacao2;


import java.util.List;
import java.util.ArrayList;
import java.util.Collections;




public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List <Pessoa> lista  = new Arraylist<>();
        // TODO code application logic here
        
        lista.add(new Pessoa("Gabriel", 19));
        lista.add(new Pessoa("Alex",52));
        lista.add(new Pessoa("Gabriel",20));
        lista.add(new Pessoa("Alex",51));
        
        
        Collections.sort(lista);
        
       
    }
    
}
