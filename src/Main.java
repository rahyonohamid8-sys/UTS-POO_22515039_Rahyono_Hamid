import java.util.Scanner;

public class Main {
    private Scanner scanner;
    private KantorEkspedisi kantor;

    public Main() {
        scanner = new Scanner(System.in);
        kantor = new KantorEkspedisi("Kantor Ekspedisi", "Kendari", 10000, 100);
    }

    public static void main(String[] args) {
        new Main().tampilkanMenu();
    }

    void tampilkanMenu() {
        int pilihan;
        do {
            System.out.println("===================================");
            System.out.println("    SISTEM INFORMASI EKSPEDISI");
            System.out.println("===================================");
            System.out.println("1. Daftarkan Paket");
            System.out.println("2. Tampilkan Semua Paket");
            System.out.println("3. Cari Paket");
            System.out.println("4. Ubah Status Pengiriman");
            System.out.println("5. Tampilkan Riwayat Pengiriman");
            System.out.println("6. Batalkan Status Terakhir");
            System.out.println("7. Hapus Paket");
            System.out.println("0. Keluar");
            System.out.println("===================================");

            pilihan = inputAngka("Pilih menu: ");
            prosesPilihan(pilihan);
        } while (pilihan != 0);

        scanner.close();
    }

    void prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                daftarPaket();
                break;
            case 2:
                kantor.tampilkanPaket();
                break;
            case 3:
                cariPaket();
                break;
            case 4:
                perbaruiStatus();
                break;
            case 5:
                tampilkanRiwayat();
                break;
            case 6:
                batalkanStatus();
                break;
            case 7:
                hapusPaket();
                break;
            case 0:
                System.out.println("Terima kasih.");
                break;
            default:
                System.out.println("Pilihan tidak valid.");
        }
    }

    void daftarPaket() {
        Pengirim pengirim = inputPengirim();
        String tujuan = inputBaris("Tujuan        : ");
        String alamatTujuan = inputBaris("Alamat tujuan : ");
        double berat = inputDesimal("Berat (kg)    : ");

        if (kantor.buatPaket(pengirim, tujuan, alamatTujuan, berat)) {
            System.out.println("Paket berhasil didaftarkan.");
        } else {
            System.out.println("Pendaftaran gagal. Periksa data atau kapasitas.");
        }
    }

    Pengirim inputPengirim() {
        String idPengirim = inputBaris("ID pengirim   : ");
        String nama = inputBaris("Nama          : ");
        String noTelepon = inputBaris("No telepon    : ");
        String alamat = inputBaris("Alamat        : ");
        return new Pengirim(idPengirim, nama, noTelepon, alamat);
    }

    void cariPaket() {
        String nomorResi = inputBaris("Nomor resi : ");
        Paket paket = kantor.cariPaket(nomorResi);
        if (paket == null) {
            System.out.println("Paket tidak ditemukan.");
        } else {
            paket.tampilkanInfo();
        }
    }

    void perbaruiStatus() {
        String nomorResi = inputBaris("Nomor resi : ");
        String statusBaru = inputBaris("Status baru: ");
        if (kantor.prosesStatus(nomorResi, statusBaru)) {
            System.out.println("Status berhasil diperbarui.");
        } else {
            System.out.println("Gagal memperbarui status.");
        }
    }

    void tampilkanRiwayat() {
        String nomorResi = inputBaris("Nomor resi : ");
        kantor.tampilkanRiwayat(nomorResi);
    }

    void batalkanStatus() {
        String nomorResi = inputBaris("Nomor resi : ");
        if (kantor.batalkanStatus(nomorResi)) {
            System.out.println("Status terakhir dibatalkan.");
        } else {
            System.out.println("Gagal membatalkan status.");
        }
    }

    void hapusPaket() {
        String nomorResi = inputBaris("Nomor resi : ");
        if (kantor.hapusPaket(nomorResi)) {
            System.out.println("Paket berhasil dihapus.");
        } else {
            System.out.println("Paket tidak ditemukan.");
        }
    }

    private String inputBaris(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private int inputAngka(String prompt) {
        try {
            return Integer.parseInt(inputBaris(prompt));
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private double inputDesimal(String prompt) {
        try {
            return Double.parseDouble(inputBaris(prompt));
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
