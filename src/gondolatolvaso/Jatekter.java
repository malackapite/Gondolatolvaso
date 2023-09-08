package gondolatolvaso;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Jatekter {

    private final static String[] szinek = {"P", "T", "Z", "M"};
    private final static String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
    private final ArrayList<String> variaciok;
    private final ArrayList<String> maradekok = new ArrayList<String>();
    private String[] kartyak;
    private final Scanner sc = new Scanner(System.in);

    public Jatekter() {
        this.kartyak = new String[szinek.length * ertekek.length];
        this.variaciok = new ArrayList();
        for (int ix = 0; ix < szinek.length; ix++) {
            for (int jx = 0; jx < ertekek.length; jx++) {
                this.kartyak[ix + jx * 4] = szinek[ix] + ertekek[jx];
                this.variaciok.add(szinek[ix] + ertekek[jx]);
            }
        }
    }

    private void Kirak() {
        for (int ix = 0; ix < kartyak.length; ix += 3) {
            System.out.println("%s\t%s\t%s".formatted(kartyak[ix], kartyak[ix + 1], kartyak[ix + 2]));
        }
    }

    private int Melyik() {
        System.out.print("\r\nVálasz egy oszlopot: ");
        int bekertSzam = sc.nextInt();
        while (bekertSzam > 3 || bekertSzam < 1) {
            System.out.print("Ez az oszlop nem létezik.\r\nVálasz egy oszlopot: ");
            bekertSzam = sc.nextInt();
        }
        System.out.println("");
        return bekertSzam;
    }

    private void Kever() {
        Random rnd = new Random();
        int melyik = Melyik() - 1;
        String[] tmpLista = new String[szinek.length * ertekek.length];

        for (int ix = 0; ix < kartyak.length; ix++) {
            if (ix % 3 != melyik) {
                if (variaciok.contains(kartyak[ix])) {
                    variaciok.remove(kartyak[ix]);
                }
                if (!maradekok.contains(kartyak[ix])) {
                    maradekok.add(kartyak[ix]);
                }
            }
        }
        for (int ix = 0; ix < variaciok.size(); ix++) {
            int rndSzam;

            do {
                rndSzam = rnd.nextInt(variaciok.size()) * 3 + ix % 3;
            } while (tmpLista[rndSzam] != null);
            tmpLista[rndSzam] = variaciok.get(ix);
        }
        for (int ix = 0; ix < maradekok.size(); ix++) {
            int rndSzam;

            do {
                rndSzam = rnd.nextInt(kartyak.length);
            } while (tmpLista[rndSzam] != null);
            tmpLista[rndSzam] = maradekok.get(ix);
        }
        this.kartyak = tmpLista;
    }

    private void EzVolt() {
        System.out.println("A választott kártya:");
        System.out.println(variaciok.get(0));
    }

    public void Jatek() {
        do {
            Kirak();
            Kever();
        } while (this.variaciok.size() > 1);
        EzVolt();
    }
}
