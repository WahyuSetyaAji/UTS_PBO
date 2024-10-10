package ReservasiHotel;

public class Customer extends Pengguna implements Reservasi {
    private Kamar kamarDipesan;

    public Customer(String nama) {
        super(nama);
    }

    @Override
    public void lihatPesanan() {
        if (kamarDipesan != null) {
            System.out.println("Pesanan untuk " + getNama());
            kamarDipesan.tampilkanDetailKamar();
        } else {
            System.out.println(getNama() + " belum memesan kamar.");
        }
    }

    @Override
    public void pesanKamar(Kamar kamar) {
        if (kamar.isTersedia()) {
            kamar.setTersedia(false);
            kamarDipesan = kamar;
            System.out.println(getNama() + " telah memesan kamar nomor " + kamar.getNomorKamar());
        } else {
            System.out.println("Kamar tidak tersedia.");
        }
    }

    public void batalkanPesanan() {
        if (kamarDipesan != null) {
            kamarDipesan.setTersedia(true);
            System.out.println("Pesanan kamar nomor " + kamarDipesan.getNomorKamar() + " telah dibatalkan.");
            kamarDipesan = null;
        } else {
            System.out.println("Tidak ada pesanan untuk dibatalkan.");
        }
    }

    public Kamar getKamarDipesan() {
        return kamarDipesan;
    }
}
