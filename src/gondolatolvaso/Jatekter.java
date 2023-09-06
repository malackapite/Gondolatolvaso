package gondolatolvaso;

import java.util.ArrayList;
import java.util.Scanner;

public class Jatekter {
    private final static String[] szinek={"P","T","Z","M"};
    private final static String[] ertekek={"Ász","Kir","Fel","X","IX","VIII"};
    private String[] kartyak;
    private Scanner sc= new Scanner(System.in);

    public Jatekter() {
        this.kartyak=new String[szinek.length*ertekek.length];
        //this.variacio=new ArrayList();
        for(int ix=0; ix<szinek.length;ix++)
            for(int jx=0; jx<ertekek.length;jx++)
                this.kartyak[ix+jx*4]=szinek[ix]+ertekek[jx];
    }
    
    private void Kirak(){
        for (int ix = 0; ix < kartyak.length; ix+=3)
           System.out.println("%s\t%s\t%s".formatted(kartyak[ix],kartyak[ix+1],kartyak[ix+2]));
    }
    
    private int Melyik(){
        return sc.nextInt();
    }
    
    private void Kever(){
//        for(int ix=0; ix<kartyak.length;ix++){
//            
//        }
    }
    
    private boolean EzVolt(int oszlop){
        
        return false;
    }
    
    public void Jatek(){
        Kirak();
//        int oszlop=Melyik();
//        do{
//            Kirak();
//        }
//        while(!EzVolt(oszlop));
    }
}
