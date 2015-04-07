package control;

// @author Francesco

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Parole {
    
    int uniche, ripetute, totale;
    HashMap h;
    String[] book;
    
    public Parole() {
        uniche = 0;
        ripetute = 0;
        totale = 0;
        h = new HashMap();
    }
    
    public void read(String filename) {
        try {
            FileInputStream f = new FileInputStream(filename);
            InputStreamReader in = new InputStreamReader(f);
            BufferedReader b = new BufferedReader(in);
            while (b.readLine()!=null) {
                String s = b.readLine();
                book = s.split(" |,|\\.|;|:|'|-|!|\\?");
                for (int i = 0; i < book.length; i++) {
                    if (h.containsValue(book[i])) {
                        ripetute++;
                        totale++;
                    }
                    else {
                        uniche++;
                        totale++;
                    }
                    h.put(book[i], book[i]);
                }
            }
            
            System.out.println("Totale parole: " + totale);
            System.out.println("Paole uniche: " + uniche);
            System.out.println("Parole ripetute: " + ripetute);
            
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato!");
        } catch (IOException ex) {
            System.out.println("Errore nell'apertura del file");
        }
    }
    
}
   
    
