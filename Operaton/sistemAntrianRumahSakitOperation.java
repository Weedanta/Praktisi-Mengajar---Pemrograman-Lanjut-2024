package JavaCollection.Operaton;

import java.util.*;
import java.io.*;
import java.time.LocalDate;

/**
 * Sistem Antrian Rumah Sakit UB
 */
public class sistemAntrianRumahSakitOperation {

    public static void main(String[] args) {
        Queue<String> antrian = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        LocalDate tanggal = LocalDate.now();

        try (FileWriter fw = new FileWriter("dataAntrian.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {

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

            // Menampilkan dan menyimpan antrian ke dalam file
            System.out.println("Pasien dalam antrian");
            int i = 1;
            for (String pasien : antrian) {
                System.out.println(i + ". " + pasien);
                // Menyimpan data ke dalam file
                bw.write(i + ". " + pasien + " (" + tanggal + ")" + "\n");
                i++;
            }
            System.out.println("------------------------------");

            // Melayani pasien
            System.out.println("Melayani Pasien");
            while (!antrian.isEmpty()) {
                String pasienDilayani = antrian.poll();
                System.out.println("Melayani pasien : " + pasienDilayani);
            }
            System.out.println("------------------------------");

            // Memicu NoSuchElementException jika antrian kosong
            if (!antrian.isEmpty()) {
                System.out.println("Pasien pertama : " + antrian.remove());
            }

        } catch (InputMismatchException e) {
            System.out.println("Error!\nInput tidak valid. Harap memasukkan input yang sesuai");
        } catch (NoSuchElementException e) {
            System.out.println("Error!\nTerjadi kesalahan pada nomor antrian");
        } catch (IOException e) {
            System.out.println("Error!\nTerjadi kesalahan saat menulis ke file");
        } finally {
            System.out.println("Terima Kasih");
        }
    }
}
