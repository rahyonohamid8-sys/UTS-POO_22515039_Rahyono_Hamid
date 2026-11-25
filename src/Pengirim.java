public class Pengirim {
    private String idPengirim;
    private String nama;
    private String noTelepon;
    private String alamat;

    public Pengirim(String idPengirim, String nama, String noTelepon, String alamat) {
        this.idPengirim = idPengirim;
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
    }

    public void ubahData(String nama, String noTelepon, String alamat) {
        this.nama = nama;
        this.noTelepon = noTelepon;
        this.alamat = alamat;
    }

    public void tampilkanInfo() {
        System.out.println("ID Pengirim : " + idPengirim);
        System.out.println("Nama        : " + nama);
        System.out.println("No Telepon  : " + noTelepon);
        System.out.println("Alamat      : " + alamat);
    }

    public String getIdPengirim() {
        return idPengirim;
    }

    public String getNama() {
        return nama;
    }

    public String getNoTelepon() {
        return noTelepon;
    }

    public String getAlamat() {
        return alamat;
    }
}
