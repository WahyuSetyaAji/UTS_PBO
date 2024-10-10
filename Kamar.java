package ReservasiHotel;

public class Kamar {
    private int nomorKamar;
    private boolean tersedia;
    private String tipeKamar;
    private double harga;

    public Kamar(int nomorKamar, String tipeKamar, double harga) {
        this.nomorKamar = nomorKamar;
        this.tipeKamar = tipeKamar;
        this.harga = harga;
        this.tersedia = true; 
    }

    public int getNomorKamar() {
        return nomorKamar;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public String getTipeKamar() {
        return tipeKamar;
    }

    public double getHarga() {
        return harga;
    }

    public void tampilkanDetailKamar() {
        System.out.println("Nomor Kamar: " + nomorKamar);
        System.out.println("Tipe Kamar: " + tipeKamar);
        System.out.println("Harga: " + harga);
        System.out.println("Ketersediaan: " + (tersedia ? "Tersedia" : "Terisi"));
    }
}
