package gondolatolvaso;

import java.util.Scanner;

public class Jatekter {

    private String[] kartyak;
    private final static String[] szinek = {"P", "T", "Z", "M"};
    private final static String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
    private Scanner sc = new Scanner(System.in);

    public Jatekter() {
        this.kartyak = new String[szinek.length * ertekek.length];
        for (int ix = 0; ix < szinek.length; ix++) {
            for (int jx = 0; jx < ertekek.length; jx++) {
                this.kartyak[ix + jx * 4] = szinek[ix] + ertekek[jx];
            }
        }
        Jatek();
    }

    private void Kirak() {
        for (int ix = 0; ix < kartyak.length; ix += 3) {
            System.out.println("%-10s%-10s%-10s".formatted(kartyak[ix], kartyak[ix + 1], kartyak[ix + 2]));
        }
    }

    private int Melyik() {
        int bekertSzam;
        boolean jo;
        do {
            System.out.print("melyik oszlop (1-3): ");
            bekertSzam = sc.nextInt();
            jo = bekertSzam >= 1 && bekertSzam <= 3;
        } while (!jo);
        return bekertSzam;
    }

    private void Kever() {
        String[] temp = kartyak;
        switch (Melyik()) {
            case 1:
                for (int ix = 0; ix < kartyak.length / 3; ix++) {
                    kartyak[ix] = temp[kartyak.length - 2 - ix * 3];
                    kartyak[ix + kartyak.length / 3] = temp[kartyak.length - 3 - ix * 3];
                    kartyak[ix + kartyak.length / 3 * 2] = temp[kartyak.length - 1 - ix * 3];
                }
                break;
            case 2:
                for (int ix = 0; ix < kartyak.length / 3; ix++) {
                    kartyak[ix] = temp[kartyak.length - 3 - ix * 3];
                    kartyak[ix + kartyak.length / 3] = temp[kartyak.length - 2 - ix * 3];
                    kartyak[ix + kartyak.length / 3 * 2] = temp[kartyak.length - 1 - ix * 3];
                }
                break;
            case 3:
                for (int ix = 0; ix < kartyak.length / 3; ix++) {
                    kartyak[ix] = temp[kartyak.length - 3 - ix * 3];
                    kartyak[ix + kartyak.length / 3] = temp[kartyak.length - 1 - ix * 3];
                    kartyak[ix + kartyak.length / 3 * 2] = temp[kartyak.length - 2 - ix * 3];
                }
                break;
            default:
                throw new AssertionError();
        }
    }

    private void EzVolt() {

    }

    private void Jatek() {
        Kirak();
        for (int ix = 0; ix < 3; ix++) {
            Kever();
            Kirak();
        }
        EzVolt();
    }
}
