/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

/**
 *
 * @author User
 */
public class Szerencse extends Mezo {

    private int jutalom;

    /**
     * A szerencse mező jutalmának beállítása.
     *
     * @param jutalom A jutalom összege, amit beállítani szeretnénk a szerencse
     * mezőnek.
     */
    public void setJutalom(int jutalom) {
        this.jutalom = jutalom;
    }

    /**
     * A szerencse mező jutalmának lekérdezése.
     *
     * @return A szerencse mező jutalma.
     */
    public int getJutalom() {
        return jutalom;
    }

    /**
     * A Szerencse osztály konstruktora.
     *
     * @param jutalom A jutalom összege, amit beállítani szeretnénk a szerencse
     * mezőnek.
     */
    public Szerencse(int jutalom) {
        this.jutalom = jutalom;
    }
}
