package Generic;

import java.util.Scanner;

public class Objek {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nama, alamat;
        int noTelepon;

        System.out.println("PROGRAM Identitas Kantor ");
        System.out.print("Masukkan Nama : ");
        nama = sc.nextLine();
        System.out.print("Masukkan Alamat : ");
        alamat = sc.nextLine();
        System.out.print("Masukkan No. Telepon : ");
        noTelepon = sc.nextInt();

        Generic<String, String, Integer> identitas = new Generic<>();
        identitas.setNama(nama);
        identitas.setAlamat(alamat);
        identitas.setNoTelepon(noTelepon);

        identitas.print();
    }
}
