package parolemapadv;

// @author Francesco

import control.Parole;
import java.io.IOException;


public class ParoleMapAdv {

    public static void main(String[] args) throws IOException {
        
        Parole p = new Parole();
        
        p.read("data/davidcopperfield.txt");
    }
}
