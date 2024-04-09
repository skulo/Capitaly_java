/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author User
 */
public class Taktikus extends Jatekos {

    private int lepesSzamlalo;

    /**
     * A Taktikus osztály konstruktora.
     *
     * @param nev A játékos neve, amit beállítani szeretnénk.
     */
    public Taktikus(String nev) {
        super(nev);
        this.lepesSzamlalo = 0;
    }

    /**
     * Az absztrakt ingatlanraLep metódust implementálja a Taktikus játékos
     * osztályban.
     *
     * @param i Az ingatlan mező, amire a játékos lép.
     */
    @Override
    public void ingatlanraLep(Ingatlan i) {

        if (lepesSzamlalo % 2 == 0) {
            if (i.getTulajdonos() == null && toke >= 1000) {
                lepesSzamlalo++;
                ingatlantVesz(i);
            } else if (!i.isVanHaz() && i.getTulajdonos() == this && toke >= 4000) {
                lepesSzamlalo++;
                hazatEpit(i);
            }
        }
        if (i.getTulajdonos() != null && i.getTulajdonos() != this && i.isVanHaz()) {
            if (toke < 2000) {
                i.getTulajdonos().toke += toke;
                toke -= toke;
                this.setKiesett(true);
            } else {
                toke -= 2000;
                i.getTulajdonos().toke += 2000;
            }
        }

        if (i.getTulajdonos() != null && i.getTulajdonos() != this && !i.isVanHaz()) {
            if (toke < 500) {
                i.getTulajdonos().toke += toke;
                toke -= toke;
                this.setKiesett(true);
            } else {
                toke -= 500;
                i.getTulajdonos().toke += 500;
            }
        }
    }
}
