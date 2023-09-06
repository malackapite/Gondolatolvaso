package gondolatolvaso;

import java.util.Scanner;

public class Jatekter {
    private int[] kartyak;
    private Scanner sc= new Scanner(System.in);

    public Jatekter() {
        this.kartyak=new int[21];
        for(int ix=0; ix<kartyak.length;ix++)
            this.kartyak[ix]=ix+1;
        Kirak();
    }
    
    
    private void Kirak(){
        for (int ix = 0; ix < kartyak.length; ix+=3)
           System.out.println("%d\t%d\t%d".formatted(kartyak[ix],kartyak[ix+1],kartyak[ix+2]));
    }
    
    private int Melyik(){
        return sc.nextInt();
    }
    
    private void Kever(){
        
    }
    
    private void EzVolt(){
        
    }
}
