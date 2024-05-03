/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package JavaCollection;

import java.util.*;

/**
 *
 * @author wedanta
 */
public class sistemAntrianRumahSakit{

    public static void main(String[] args) {
        Queue<String> antrian = new LinkedList<>(); 
        Scanner sc = new Scanner(System.in);

        // Memasukkan banyak antrian
        System.out.print("Masukkan banyak antrian : ");
        int banyakAntrian = sc.nextInt();
        sc.nextLine();

        // Menambahkan antrian
        for (int i = 0; i < banyakAntrian; i++) {
            System.out.print("Masukkan nama : ");
            String nama = sc.nextLine();
            antrian.add(nama);
        }

        // Menapilkan antrian
        System.out.println("Pasien dalam antrian");
        int i = 1;
        for (String pasien : antrian) {
            System.out.println(i + ". " + pasien);
            i++;
        }

        // melayani pasien 
        System.out.println("\nMelayani Pasien");
        while (!antrian.isEmpty()) {
            String pasienDilayani = antrian.poll();
            System.out.println("Melayani pasien : " + pasienDilayani);
        }
    }

}
