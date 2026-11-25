public class Main {
    public static void main(String[] args) {
        Pengirim pengirim = new Pengirim(
            "PG001",
            "Rahyono",
            "08123456789",
            "Kendari"
        );

        pengirim.tampilkanInfo();

        Paket paket = new Paket(
            "RESI001",
            "Makassar",
            "Jl. Ahmad Yani",
            2.5,
            10000,
            pengirim
        );

        paket.tampilkanInfo();
    }
}
