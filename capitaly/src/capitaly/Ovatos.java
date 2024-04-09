/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author User
 */
public class Ovatos extends Jatekos {

    /**
     * Az Ovatos osztály konstruktora.
     *
     * @param nev A játékos neve, amit beállítani szeretnénk.
     */
    public Ovatos(String nev) {
        super(nev);
    }

    /**
     * Az absztrakt ingatlanraLep metódust implementálja az Ovatos játékos
     * osztályban.
     *
     * @param i Az ingatlan mező, amire a játékos lép.
     */
    @Override
    public void ingatlanraLep(Ingatlan i) {

        if (i.getTulajdonos() == null && toke / 2 >= 1000) {
            ingatlantVesz(i);
        } else if (!i.isVanHaz() && i.getTulajdonos() == this && toke / 2 >= 4000) {
            hazatEpit(i);
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
