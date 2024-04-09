/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author User
 */
public class Szolgaltatas extends Mezo {

    private int ar;

    /**
     * A szolgáltatás mező árának beállítása.
     *
     * @param ar Az ár, amit beállítani szeretnénk a szolgáltatás mezőnek.
     */
    public void setAr(int ar) {
        this.ar = ar;
    }

    /**
     * A szolgáltatás mező árának lekérdezése.
     *
     * @return A szolgáltatás mező ára.
     */
    public int getAr() {
        return ar;
    }

    /**
     * A Szolgaltatas osztály konstruktora.
     *
     * @param ar Az ár, amit beállítani szeretnénk a szolgáltatás mezőnek.
     */
    public Szolgaltatas(int ar) {
        this.ar = ar;
    }
}
