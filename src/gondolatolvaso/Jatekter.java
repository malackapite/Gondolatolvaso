package gondolatolvaso;

import java.util.Scanner;

public class Jatekter {
    private String[] kartyak;
    private final static String[] szinek = {"P", "T", "Z", "M"};
    private final static String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
    private Scanner sc= new Scanner(System.in);

    public Jatekter() {
        this.kartyak=new String[szinek.length*ertekek.length];
        for (int ix = 0; ix < szinek.length; ix++) {
            for (int jx = 0; jx < ertekek.length; jx++) {
                this.kartyak[ix + jx * 4] = szinek[ix] + ertekek[jx];
            }
        }
        Kirak();
        Melyik();
    }
    
    
    private void Kirak(){
        for (int ix = 0; ix < kartyak.length; ix+=3)
           System.out.println("%s\t%s\t%s".formatted(kartyak[ix],kartyak[ix+1],kartyak[ix+2]));
    }
    
    private void Melyik() {
        boolean jo;
        do {
        System.out.print("melyik oszlop (1-3): ");
        int bekertSzam = sc.nextInt();
        jo = bekertSzam >= 1 && bekertSzam <= 3;
        } while (!jo);
    }
    
    private void Kever(){
        
    }
    
    private void EzVolt(){
        
    }
}