/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author User
 */
public class Ingatlan extends Mezo {

    private Jatekos tulajdonos;
    private boolean vanHaz;

    /**
     * Az ingatlan tulajdonosának beállítása.
     *
     * @param tulajdonos Az ingatlan tulajdonosa, egy Jatekos objektum.
     */
    public void setTulajdonos(Jatekos tulajdonos) {
        this.tulajdonos = tulajdonos;
    }

    /**
     * Az ingatlanon lévő ház jelenlétének beállítása.
     *
     * @param vanHaz True, ha az ingatlanon van ház, különben false.
     */
    public void setVanHaz(boolean vanHaz) {
        this.vanHaz = vanHaz;
    }

    /**
     * Az ingatlan tulajdonosának lekérdezése.
     *
     * @return Az ingatlan tulajdonosa, egy Jatekos objektum.
     */
    public Jatekos getTulajdonos() {
        return tulajdonos;
    }

    /**
     * Ellenőrzi, hogy az ingatlanon van-e ház.
     *
     * @return True, ha az ingatlanon van ház, különben false.
     */
    public boolean isVanHaz() {
        return vanHaz;
    }

    /**
     * Az Ingatlan osztály konstruktora.
     *
     * @param tulajdonos Az ingatlan tulajdonosa, egy Jatekos objektum.
     * @param vanHaz True, ha az ingatlanon van ház, különben false.
     */
    public Ingatlan(Jatekos tulajdonos, boolean vanHaz) {
        this.tulajdonos = tulajdonos;
        this.vanHaz = vanHaz;
    }
}
