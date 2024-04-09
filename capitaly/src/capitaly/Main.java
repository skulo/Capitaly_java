/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package capitaly;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * A program belépési pontja, amely inicializálja a játékot és végrehajtja a
     * köröket.
     *
     */
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Kerem, adjon meg egy szamot: ");
            int szam = scanner.nextInt();
            Jatek jatek = new Jatek();
            jatek.beolvas("test4.txt");

            for (int kor = 0; kor < szam; kor++) {
                jatek.kovetkezoKorFix();
            }
            jatek.kiIrat();
        } catch(IllegalArgumentException | IOException e){
            System.err.println("Error occured: " + e.getMessage());
            System.exit(-1);
        }
        

    }
}
