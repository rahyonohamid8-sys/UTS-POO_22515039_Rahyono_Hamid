public class Pengiriman {
    private String idPengiriman;
    private String tanggalKirim;
    private Paket paket;
    private StackRiwayat riwayat;

    public Pengiriman(String idPengiriman, String tanggalKirim, Paket paket, int kapasitasRiwayat) {
        this.idPengiriman = idPengiriman;
        this.tanggalKirim = tanggalKirim;
        this.paket = paket;
        this.riwayat = new StackRiwayat(kapasitasRiwayat);
        this.riwayat.push(paket.getStatus());
    }

    public boolean tambahRiwayat(String statusBaru) {
        if (!riwayat.push(statusBaru)) {
            return false;
        }
        if (!paket.ubahStatus(statusBaru)) {
            riwayat.pop();
            return false;
        }
        return true;
    }

    public boolean batalkanStatusTerakhir() {
        if (riwayat.size() <= 1) {
            return false;
        }
        riwayat.pop();
        return paket.ubahStatus(riwayat.peek());
    }

    public String getStatusTerakhir() {
        return riwayat.peek();
    }

    public void tampilkanRiwayat() {
        riwayat.tampilkan();
    }

    public Paket getPaket() {
        return paket;
    }
}
