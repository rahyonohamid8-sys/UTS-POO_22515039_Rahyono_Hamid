public class Paket {
    private String nomorResi;
    private String tujuan;
    private String alamatTujuan;
    private double berat;
    private double tarifPerKg;
    private double ongkir;
    private String status;
    private Pengirim pengirim;

    public Paket(String nomorResi, String tujuan, String alamatTujuan,
                 double berat, double tarifPerKg, Pengirim pengirim) {
        this.nomorResi = nomorResi;
        this.tujuan = tujuan;
        this.alamatTujuan = alamatTujuan;
        this.berat = berat;
        this.tarifPerKg = tarifPerKg;
        this.pengirim = pengirim;
        this.status = "Diterima";
        this.ongkir = hitungOngkir();
    }

    public double hitungOngkir() {
        return berat * tarifPerKg;
    }

    public boolean ubahStatus(String statusBaru) {
        if (statusBaru == null || statusBaru.trim().isEmpty()) {
            return false;
        }
        this.status = statusBaru;
        return true;
    }

    public void tampilkanInfo() {
        System.out.println("Nomor Resi    : " + nomorResi);
        System.out.println("Tujuan        : " + tujuan);
        System.out.println("Alamat Tujuan : " + alamatTujuan);
        System.out.println("Berat         : " + berat + " kg");
        System.out.println("Ongkir        : " + ongkir);
        System.out.println("Status        : " + status);
        System.out.println("--- Pengirim ---");
        pengirim.tampilkanInfo();
    }

    public String getNomorResi() {
        return nomorResi;
    }

    public String getTujuan() {
        return tujuan;
    }

    public String getAlamatTujuan() {
        return alamatTujuan;
    }

    public double getBerat() {
        return berat;
    }

    public double getOngkir() {
        return ongkir;
    }

    public String getStatus() {
        return status;
    }

    public Pengirim getPengirim() {
        return pengirim;
    }
}
