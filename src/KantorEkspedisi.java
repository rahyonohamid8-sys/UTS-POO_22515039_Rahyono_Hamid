import java.time.LocalDate;

public class KantorEkspedisi {
    private String namaKantor;
    private String alamatKantor;
    private double tarifPerKg;
    private Pengiriman[] daftarPengiriman;
    private int jumlahPengiriman;
    private int counter = 1;

    public KantorEkspedisi(String namaKantor, String alamatKantor, double tarifPerKg, int kapasitas) {
        this.namaKantor = namaKantor;
        this.alamatKantor = alamatKantor;
        this.tarifPerKg = tarifPerKg;
        this.daftarPengiriman = new Pengiriman[kapasitas];
        this.jumlahPengiriman = 0;
    }

    public boolean buatPaket(Pengirim pengirim, String tujuan, String alamatTujuan, double berat) {
        if (jumlahPengiriman >= daftarPengiriman.length || pengirim == null || berat <= 0) {
            return false;
        }
        String nomorResi = String.format("RESI%03d", counter++);
        Paket paket = new Paket(nomorResi, tujuan, alamatTujuan, berat, tarifPerKg, pengirim);
        daftarPengiriman[jumlahPengiriman++] =
            new Pengiriman(nomorResi, LocalDate.now().toString(), paket, 100);
        return true;
    }

    public Paket cariPaket(String nomorResi) {
        Pengiriman pengiriman = cariPengiriman(nomorResi);
        return pengiriman == null ? null : pengiriman.getPaket();
    }

    public boolean hapusPaket(String nomorResi) {
        int index = indexPengiriman(nomorResi);
        if (index == -1) {
            return false;
        }
        for (int i = index; i < jumlahPengiriman - 1; i++) {
            daftarPengiriman[i] = daftarPengiriman[i + 1];
        }
        daftarPengiriman[--jumlahPengiriman] = null;
        return true;
    }

    public boolean prosesStatus(String nomorResi, String statusBaru) {
        Pengiriman pengiriman = cariPengiriman(nomorResi);
        return pengiriman != null && pengiriman.tambahRiwayat(statusBaru);
    }

    public boolean batalkanStatus(String nomorResi) {
        Pengiriman pengiriman = cariPengiriman(nomorResi);
        return pengiriman != null && pengiriman.batalkanStatusTerakhir();
    }

    public void tampilkanPaket() {
        if (jumlahPengiriman == 0) {
            System.out.println("Belum ada paket");
            return;
        }
        for (int i = 0; i < jumlahPengiriman; i++) {
            daftarPengiriman[i].getPaket().tampilkanInfo();
        }
    }

    public void tampilkanRiwayat(String nomorResi) {
        Pengiriman pengiriman = cariPengiriman(nomorResi);
        if (pengiriman == null) {
            System.out.println("Paket tidak ditemukan");
            return;
        }
        pengiriman.tampilkanRiwayat();
    }

    private Pengiriman cariPengiriman(String nomorResi) {
        int index = indexPengiriman(nomorResi);
        return index == -1 ? null : daftarPengiriman[index];
    }

    private int indexPengiriman(String nomorResi) {
        if (nomorResi == null) {
            return -1;
        }
        for (int i = 0; i < jumlahPengiriman; i++) {
            if (nomorResi.equals(daftarPengiriman[i].getPaket().getNomorResi())) {
                return i;
            }
        }
        return -1;
    }
}
