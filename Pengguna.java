package ReservasiHotel;

public class Pengguna {
    protected String nama;

    public Pengguna(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void lihatPesanan() {
        System.out.println(nama + " melihat pesanan umum.");
    }
}
