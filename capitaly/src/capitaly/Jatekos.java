/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 */
public abstract class Jatekos {

    protected int toke;
    protected String nev;
    protected ArrayList<Ingatlan> birtokoltIngatlanok;
    protected boolean kiesett;
    protected int pozicio;

    /**
     * A játékos rendelkezésre álló tőkéjének beállítása.
     *
     * @param toke A játékos tőkéje, amit beállítani szeretnénk.
     */
    
    public void setToke(int toke) {
        this.toke = toke;
    }

    /**
     * A játékos nevének beállítása.
     *
     * @param nev A játékos neve, amit beállítani szeretnénk.
     */
    public void setNev(String nev) {
        this.nev = nev;
    }

    /**
     * A játékos által birtokolt ingatlanok listájának beállítása.
     *
     * @param birtokoltIngatlanok A játékos által birtokolt ingatlanok listája.
     */
    public void setBirtokoltIngatlanok(ArrayList<Ingatlan> birtokoltIngatlanok) {
        this.birtokoltIngatlanok = birtokoltIngatlanok;
    }

    /**
     * A játékos nevének lekérdezése.
     *
     * @return A játékos neve.
     */
    public String getNev() {
        return nev;
    }

    /**
     * A játékos által birtokolt ingatlanok listájának lekérdezése.
     *
     * @return A játékos által birtokolt ingatlanok listája.
     */
    public ArrayList<Ingatlan> getBirtokoltIngatlanok() {
        return birtokoltIngatlanok;
    }

    /**
     * Ellenőrzi, hogy a játékos kiesett-e a játékból.
     *
     * @return True, ha a játékos kiesett, különben false.
     */
    public boolean isKiesett() {
        return kiesett;
    }

    /**
     * A Jatekos osztály konstruktora.
     *
     * @param nev A játékos neve.
     */
    public Jatekos(String nev) {
        this.toke = 10000;
        this.nev = nev;
        this.birtokoltIngatlanok = new ArrayList<Ingatlan>();
        this.kiesett = false;
        this.pozicio = -1;
    }

    /**
     * A játékos pozíciójának beállítása a játék táblán.
     *
     * @param pozicio A játékos pozíciója.
     */
    public void setPozicio(int pozicio) {
        this.pozicio = pozicio;
    }

    /**
     * A játékos tőkéjének lekérdezése.
     *
     * @return A játékos tőkéje.
     */
    public int getToke() {
        return toke;
    }

    /**
     * A játékos pozíciójának lekérdezése a játék táblán.
     *
     * @return A játékos pozíciója.
     */
    public int getPozicio() {
        return pozicio;
    }

    /**
     * A játékos kiesésének beállítása vagy visszavonása.
     *
     * @param kiesett True, ha a játékos kiesett, különben false.
     */
    public void setKiesett(boolean kiesett) {
        if (kiesett) {
            for (Ingatlan i : birtokoltIngatlanok) {
                i.setTulajdonos(null);
                i.setVanHaz(false);
            }
            birtokoltIngatlanok.clear();
        }
        this.kiesett = kiesett;
    }

    /**
     * A játékos kockával való dobásának eredményét visszaadja.
     *
     * @return A dobott szám.
     */
    public int kockaDobas() {
        Random rand = new Random();
        int dobottSzam = rand.nextInt(6) + 1;
        return dobottSzam;
    }

    /**
     * Az adott ingatlant megvásárolja és hozzáadja a játékos birtokolt
     * ingatlanjaihoz.
     *
     * @param i Az ingatlan, amit a játékos megvásárol.
     */
    public void ingatlantVesz(Ingatlan i) {

        birtokoltIngatlanok.add(i);
        toke -= 1000;
        i.setTulajdonos(this);

    }

    /**
     * Az adott ingatlanra házat épít, ha a játékosnak van elég pénze.
     *
     * @param i Az ingatlan, amire a játékos házat épít.
     */
    public void hazatEpit(Ingatlan i) {

        toke -= 4000;
        i.setVanHaz(true);

    }

    /**
     * A játékos szolgáltatás mezőre lép, és kifizeti a szolgáltatás díját, ha
     * megengedi a tőkéje.
     *
     * @param szo A szolgáltatás mező, amire a játékos lép.
     */
    public void szolgaltatasraLep(Szolgaltatas szo) {
        if (szo.getAr() > toke) {
            this.setKiesett(true);
            toke = 0;
        } else {
            toke -= szo.getAr();
        }
    }

    /**
     * A játékos szerencse mezőre lép, és a szerencse kártya jutalmát hozzáadja
     * a tőkéjéhez.
     *
     * @param sze A szerencse mező, amire a játékos lép.
     */
    public void szerencsereLep(Szerencse sze) {
        if (this.isKiesett()) {
            return;
        }
        toke += sze.getJutalom();
    }

    /**
     * Absztrakt metódus, amelyet a leszármazott osztályok felüldefiniálnak az
     * ingatlan mezőre lépéshez.
     *
     * @param i Az ingatlan mező, amire a játékos lép.
     */
    protected abstract void ingatlanraLep(Ingatlan i);
}
