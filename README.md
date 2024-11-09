# Aplikasi CRUD Java Swing menggunakan Persistance
##  📋 Langkah - Langkah 
### 1. Pastikan anda sudah memiliki database sebelumnya
### 2. Buka netbeans anda, kemudian buat file JFrame Form, dan ubah nama variablenya sesuai yang anda inginkan. (contoh design gui seperti berikut)
![image](https://github.com/user-attachments/assets/ede34021-218e-476c-98e9-237a5f4b37f7)

### 3. Kemudian buat file baru pada package yang sama dengan file JForm Frame, Klik kanan pada package > New > Entitity Classes For Databases…
![image](https://github.com/user-attachments/assets/75b9e4a0-9301-42f4-86cc-5dceb210b0aa)
Kemudian akan muncul form seperti berikut :
![image](https://github.com/user-attachments/assets/fb4406a3-05b3-4979-80ac-8720d7b7d06a)
Pada Data Source, pilih database yang akan dikoneksikan pada program anda, apabila jdbc belum tersambungkan oleh database yang hendak anda gunakan, anda bisa memilih New Database Connection… dan ikuti langkah selanjutnya.

Setelah database terhubung dan dipilih, tampilan akan seperti berikut :
![image](https://github.com/user-attachments/assets/452e94c6-f48e-42dd-9432-9bc3925e75f4)
![image](https://github.com/user-attachments/assets/f53440a4-165a-47d2-9422-5b5d2f9a8627)
Pilih Add All >> dan table yang ada pada kolom Available Tables secara otomatis akan terpilih dan geser pada kolom Selected Tables kemudian klik Next > Next > Finish.

Kemudian otomatis akan membuat file .java dengan nama table yang ada dalam database anda dan Package baru yang didalamnya terdapat file persistence.xml. Ini nantinya yang akan digunakan sebagai koneksi CRUD tanpa SQL.

### 4. Kembali buka file JFrame Form anda, dan buat method baru dengan nama tampil() dan tulislah source code berikut untuk menampilkan data pada table nantinya. 
![image](https://github.com/user-attachments/assets/aa00407a-6937-4a2c-9809-15c18357707a)

### 5.	Kemudian masukkan source code pada button simpan, double klik pada button simpan.
![image](https://github.com/user-attachments/assets/6e9ed354-0aed-4d96-bf1e-4fac97d940c5)
![image](https://github.com/user-attachments/assets/f0e2823e-391e-46d4-a9f3-4430a145587e)

### 6.	Masukkan source code berikut untuk button update dan delete.
Update :
<pre>
  if (txtKodeMK.getText().equals("") | txtSks.getText().equals("")
                | txtMatakuliah.getText().equals("") | txtSemester.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            String kodemk, namamk, semesterAjar;
            kodemk = txtKodeMK.getText();
            namamk = txtMatakuliah.getText();
            int semester;
            int sks;

            try {
                sks = Integer.parseInt(txtSks.getText());
                semester = Integer.parseInt(txtSemester.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "SKS harus berupa angka", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("LatihanSemester3PU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Matakuliah mk = em.find(Matakuliah.class, kodemk);
            if (mk == null) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            } else {
                mk.setKodemk(kodemk);
                mk.setNamamk(namamk);
                mk.setSks(sks);
                mk.setSemesterajar(semester);

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");

                em.close();
                emf.close();
                bersih();
                txtKodeMK.setEditable(true);
            }
        }
        tampil();
</pre>

Delete :
<pre>
  EntityManagerFactory emf = Persistence.createEntityManagerFactory("LatihanSemester3PU");
        EntityManager em = emf.createEntityManager();

        try {
            // Validasi input
            if (txtKodeMK.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Masukkan Kode Mata Kuliah yang akan dihapus");
            } else {
                // Mulai transaksi
                em.getTransaction().begin();

                // Cari entitas Matakuliah berdasarkan kode mata kuliah
                String kodeMK = txtKodeMK.getText();
                Matakuliah matakuliah = em.find(Matakuliah.class, kodeMK);

                if (matakuliah != null) {
                    // Hapus entitas jika ditemukan
                    em.remove(matakuliah);

                    // Commit transaksi
                    em.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");

                    // Refresh data pada tampilan
                    tampil();
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan untuk KodeMK: " + kodeMK);
                    em.getTransaction().rollback();
                }
            }
        } catch (Exception e) {
            // Rollback transaksi jika terjadi kesalahan
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
            System.out.println(e.getMessage());
        } finally {
            em.close();
        }

        txtKodeMK.setText("");
        txtMatakuliah.setText("");
        txtSks.setText("");
        txtSemester.setText("");
        tampil();
  }
</pre>

### 7.	Coba demokan hasil dari Crud anda.

## SELAMAT MENCOBA DAN BERKREASI



