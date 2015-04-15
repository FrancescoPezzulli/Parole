package control;

// @author Francesco

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Parole {
    
    Map<String, Integer> m;

    public Parole() {
        m = new HashMap<>();
    }
    
    public Map read(String filename) throws IOException{
        BufferedReader in;
        int max = 0;
        try {
            in = new BufferedReader(new FileReader(filename));
            String letta;
            while ((letta = in.readLine()) != null) {
                String parti[] = letta.split("\\W+");
                for (int i = 1; i < parti.length; i++) {
                    if (m.containsKey(parti[i])) {
                        int tmp = m.get(parti[i]);
                        int value = tmp + 1;
                        m.replace(parti[i].toLowerCase(), value);
                        if (max < value) {
                            max = value;
                        }
                    } else {
                        m.put(parti[i].toLowerCase(), 1);
                    }
                }
            }   
            in.close();
            System.out.println("è stata ripetuta una parola per un massimo di " + max + " volte");
            System.out.println(m.toString());
        } catch (FileNotFoundException ex) {
            System.out.println("File non trovato!");
        }
        return m;
    }
}

