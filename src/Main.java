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

        StackRiwayat riwayat = new StackRiwayat(100);

        riwayat.push("Diterima");
        riwayat.push("Diproses");
        riwayat.push("Dalam Perjalanan");

        System.out.println(riwayat.peek());

        riwayat.pop();

        System.out.println(riwayat.peek());

        Pengiriman pengiriman = new Pengiriman(
            "KRM001",
            "25-11-2026",
            paket,
            100
        );

        pengiriman.tambahRiwayat("Diproses");
        pengiriman.tambahRiwayat("Dalam Perjalanan");

        pengiriman.tampilkanRiwayat();

        pengiriman.batalkanStatusTerakhir();
    }
}
