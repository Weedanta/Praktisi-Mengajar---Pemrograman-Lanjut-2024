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
public class sistemAntrianRumahSakit {

    public static void main(String[] args) {
        Queue<String> antrian = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        try {
            // Memasukkan banyak antrian
            System.out.println("--- Layanan Rumah Sakit UB ---");
            System.out.print("Masukkan banyak antrian : ");
            int banyakAntrian = sc.nextInt();
            System.out.println("------------------------------");
            sc.nextLine();

            // Menambahkan antrian
            for (int i = 0; i < banyakAntrian; i++) {
                System.out.print("Masukkan nama : ");
                String nama = sc.nextLine();
                antrian.add(nama);
            }
            System.out.println("------------------------------");

            // Menapilkan antrian
            System.out.println("Pasien dalam antrian");
            int i = 1;
            for (String pasien : antrian) {
                System.out.println(i + ". " + pasien);
                i++;
            }
            System.out.println("------------------------------");

            // melayani pasien
            System.out.println("\nMelayani Pasien");

            while (!antrian.isEmpty()) {
                String pasienDilayani = antrian.poll();
                System.out.println("Melayani pasien : " + pasienDilayani);
            }
            System.out.println("------------------------------");
            // memicu noSuchElemen
            System.out.println("Pasien pertama : " + antrian.remove());
        } catch (InputMismatchException e) {
            System.out.println("Error!\nInput tidak valid. Harap memasukkan input yang sesuai");
        } catch (NoSuchElementException e) {
            System.out.println("Error!\nTerjadi kesalahan pada nomor antrian");
        } finally {
            System.out.println("Terima Kasih");
        }

    }

}
