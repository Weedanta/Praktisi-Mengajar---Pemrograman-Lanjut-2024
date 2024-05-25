package JavaCollection.Operaton;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import javax.swing.*;

public class AntrianRumahSakitGUI extends javax.swing.JFrame {

    private Queue<String> antrian;
    private LocalDate tanggal;
    private int maxAntrian; // Menyimpan jumlah maksimum antrian

    public AntrianRumahSakitGUI() {
        initComponents();
        antrian = new LinkedList<>();
        tanggal = LocalDate.now();
        maxAntrian = 0; // Inisialisasi jumlah maksimum antrian
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaAntrian = new javax.swing.JTextArea();
        jTextFieldNama = new javax.swing.JTextField();
        jButtonTambah = new javax.swing.JButton();
        jButtonLayani = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBanyakAntrian = new javax.swing.JTextField();
        jButtonSetAntrian = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nama Pasien:");

        jTextAreaAntrian.setColumns(20);
        jTextAreaAntrian.setRows(5);
        jScrollPane1.setViewportView(jTextAreaAntrian);

        jButtonTambah.setText("Tambah");
        jButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahActionPerformed(evt);
            }
        });

        jButtonLayani.setText("Layani");
        jButtonLayani.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLayaniActionPerformed(evt);
            }
        });

        jLabel2.setText("Banyak Antrian:");

        jButtonSetAntrian.setText("Set Antrian");
        jButtonSetAntrian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSetAntrianActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNama)
                    .addComponent(jTextFieldBanyakAntrian, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonSetAntrian)
                    .addComponent(jButtonTambah))
                .addGap(18, 18, 18)
                .addComponent(jButtonLayani)
                .addContainerGap(33, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldBanyakAntrian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSetAntrian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTambah)
                    .addComponent(jButtonLayani))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonSetAntrianActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            maxAntrian = Integer.parseInt(jTextFieldBanyakAntrian.getText());
            antrian.clear();
            jTextAreaAntrian.setText("");
            JOptionPane.showMessageDialog(this, "Banyak antrian diset ke " + maxAntrian);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan angka yang valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {
        if (antrian.size() < maxAntrian) {
            String nama = jTextFieldNama.getText();
            if (!nama.isEmpty()) {
                antrian.add(nama);
                int i = antrian.size();
                jTextAreaAntrian.append(i + ". " + nama + " (" + tanggal + ")\n");
                jTextFieldNama.setText("");
                try (FileWriter fw = new FileWriter("dataAntrian.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.write(i + ". " + nama + " (" + tanggal + ")\n");
                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, "Error saat menyimpan ke file", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Antrian sudah penuh", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButtonLayaniActionPerformed(java.awt.event.ActionEvent evt) {
        if (!antrian.isEmpty()) {
            String pasienDilayani = antrian.poll();
            JOptionPane.showMessageDialog(this, "Melayani pasien : " + pasienDilayani);
            jTextAreaAntrian.setText("");
            int i = 1;
            for (String pasien : antrian) {
                jTextAreaAntrian.append(i + ". " + pasien + " (" + tanggal + ")\n");
                i++;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Antrian kosong", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AntrianRumahSakitGUI().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonLayani;
    private javax.swing.JButton jButtonSetAntrian;
    private javax.swing.JButton jButtonTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaAntrian;
    private javax.swing.JTextField jTextFieldBanyakAntrian;
    private javax.swing.JTextField jTextFieldNama;
}
