/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Jatek {

    private int dobasszam;
    private final ArrayList<Jatekos> jatekosok;
    private final ArrayList<Mezo> palya;
    private final ArrayList<Integer> dobasok;

    /**
     * A Jatek osztály konstruktora.
     */
    public Jatek() {
        this.jatekosok = new ArrayList<Jatekos>();
        this.palya = new ArrayList<Mezo>();
        this.dobasok = new ArrayList<Integer>();
        dobasszam = 0;
    }


    /**
     * A játékosok listájának lekérdezése.
     *
     * @return A játékosok listája.
     */
    public ArrayList<Jatekos> getJatekosok() {
        return jatekosok;
    }

    /**
     * A pálya mezőinek lekérdezése.
     *
     * @return A pálya mezőinek listája.
     */
    public ArrayList<Mezo> getPalya() {
        return palya;
    }

    /**
     * A következő kör lépéseit végrehajtó metódus. A játékosok dobását, mezőre
     * lépését és a mező típusától függő történéseket végzi el.
     */
    public void kovetkezoKor() {
        for (Jatekos jatekos : jatekosok) {
            if (!jatekos.isKiesett()) {
                int counter = 0;
                for (Jatekos jatekoss : jatekosok) {
                    if (!jatekoss.isKiesett()) {
                        counter++;
                    }

                }
                if (counter == 1) {
                    break;
                }
                int dobottSzam = jatekos.kockaDobas();
                dobasszam++;
                int ujPozicio = (jatekos.getPozicio() + dobottSzam) % palya.size();
                jatekos.setPozicio(ujPozicio);
                Mezo aktualisMezo = palya.get(ujPozicio);
                if (aktualisMezo instanceof Ingatlan) {
                    jatekos.ingatlanraLep((Ingatlan) aktualisMezo);
                } else if (aktualisMezo instanceof Szolgaltatas) {
                    jatekos.szolgaltatasraLep((Szolgaltatas) aktualisMezo);
                } else if (aktualisMezo instanceof Szerencse) {
                    jatekos.szerencsereLep((Szerencse) aktualisMezo);
                }
            }
        }

    }

    /**
     * A következő kör lépéseit végrehajtó metódus, a dobásokat előre megadott
     * listából veszi. Az aktív játékosok dobását, mezőre lépését és a mező
     * típusától függő történéseket végzi el.
     */
    public void kovetkezoKorFix() {
        for (Jatekos jatekos : jatekosok) {
            if (!jatekos.isKiesett()) {
                int counter = 0;
                for (Jatekos jatekoss : jatekosok) {
                    if (!jatekoss.isKiesett()) {
                        counter++;
                    }

                }
                if (counter == 1) {
                    break;
                }
                int dobottSzam = dobasok.get(dobasszam);
                dobasszam++;
                int ujPozicio = (jatekos.getPozicio() + dobottSzam) % palya.size();
                jatekos.setPozicio(ujPozicio);
                Mezo aktualisMezo = palya.get(ujPozicio);
                if (aktualisMezo instanceof Ingatlan) {
                    jatekos.ingatlanraLep((Ingatlan) aktualisMezo);
                } else if (aktualisMezo instanceof Szolgaltatas) {
                    jatekos.szolgaltatasraLep((Szolgaltatas) aktualisMezo);
                } else if (aktualisMezo instanceof Szerencse) {
                    jatekos.szerencsereLep((Szerencse) aktualisMezo);
                }
            }
        }

    }

    /**
     * Adatok beolvasása egy fájlból a játék inicializálásához.
     *
     * @param fajlNev A fájl neve, amelyből az adatokat beolvassa.
     */
    public void beolvas(String fajlNev) throws IllegalArgumentException, IOException, NumberFormatException, ArrayIndexOutOfBoundsException, FileNotFoundException{
        try (BufferedReader br = new BufferedReader(new FileReader(fajlNev))) {
            String sor;
            sor = br.readLine();

            int palyaHossz = Integer.parseInt(sor);

            for (int i = 0; i < palyaHossz; i++) {
                sor = br.readLine();
                String[] mezok = sor.split(" ");
                if ("Ingatlan".equals(mezok[0])) {
                    palya.add(new Ingatlan(null, false));
                } else if ("Szolgaltatas".equals(mezok[0])) {
                    int ar = Integer.parseInt(mezok[1]);
                    palya.add(new Szolgaltatas(ar));
                } else if ("Szerencse".equals(mezok[0])) {
                    int jutalom = Integer.parseInt(mezok[1]);
                    palya.add(new Szerencse(jutalom));
                } else {
                    throw new IllegalArgumentException("Ismeretlen mezotipus: " + mezok[0]);
                }
            }

            sor = br.readLine();
            int jatekosokSzama = Integer.parseInt(sor);

            for (int i = 0; i < jatekosokSzama; i++) {
                sor = br.readLine();
                String[] jatekosAdatok = sor.split(" ");
                String nev = jatekosAdatok[0];
                String strategia = jatekosAdatok[1];

                Jatekos jatekos;
                if ("Moho".equals(strategia)) {
                    jatekos = new Moho(nev);
                } else if ("Ovatos".equals(strategia)) {
                    jatekos = new Ovatos(nev);
                } else if ("Taktikus".equals(strategia)) {
                    jatekos = new Taktikus(nev);
                } else {
                    throw new IllegalArgumentException("Ismeretlen strategia: " + strategia);
                }

                jatekosok.add(jatekos);
            }

            String[] darabolt = br.readLine().split(" ");
            for (String str : darabolt) {
                dobasok.add(Integer.parseInt(str));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Nem talalhato a fajl.");
        } 
    }

    /**
     * A játék állapotának kiírása a konzolra. Minden játékos vagyonát és
     * birtokolt ingatlanjait írja ki.
     */
    public void kiIrat() {
        for (Jatekos jatekos : jatekosok) {

            System.out.println(jatekos.getNev() + ": Vagyon: " + jatekos.getToke() + ", Birtokolt ingatlanok: " + jatekos.getBirtokoltIngatlanok());

        }

    }

}
