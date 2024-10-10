package ReservasiHotel;

public class Admin extends Pengguna {
    private Kamar[] daftarKamar = new Kamar[10]; 
    private int countKamar = 0; 
    private Customer[] daftarPesanan = new Customer[10]; 
    private int countPesanan = 0; 

    public Admin(String nama) {
        super(nama);
    }

    public void tambahKamar(Kamar kamar) {
        if (countKamar < daftarKamar.length) {
            daftarKamar[countKamar] = kamar;
            countKamar++;
        } else {
            System.out.println("Daftar kamar penuh.");
        }
    }

    public void hapusKamar(int nomorKamar) {
        boolean kamarDihapus = false;
        for (int i = 0; i < countKamar; i++) {
            if (daftarKamar[i] != null && daftarKamar[i].getNomorKamar() == nomorKamar) {
                daftarKamar[i] = null; 
                System.out.println("Kamar dengan nomor " + nomorKamar + " dihapus.");
                kamarDihapus = true;
                break;
            }
        }
        if (!kamarDihapus) {
            System.out.println("Kamar dengan nomor " + nomorKamar + " tidak ditemukan.");
        }
    }

    public void tampilkanDaftarKamar() {
        boolean kamarTersedia = false;
        for (int i = 0; i < countKamar; i++) {
            if (daftarKamar[i] != null) {
                daftarKamar[i].tampilkanDetailKamar();
                kamarTersedia = true;
            }
        }
        if (!kamarTersedia) {
            System.out.println("Tidak ada kamar yang tersedia.");
        }
    }

    public void lihatPesanan() {
        if (countPesanan == 0) {
            System.out.println("Tidak ada pesanan.");
        } else {
            System.out.println("Daftar Pesanan:");
            for (int i = 0; i < countPesanan; i++) {
                if (daftarPesanan[i] != null) {
                    System.out.println("- " + daftarPesanan[i].getNama() + " memesan kamar " + daftarPesanan[i].getKamarDipesan().getNomorKamar());
                }
            }
        }
    }

    public void tambahPesanan(Customer customer) {
        if (countPesanan < daftarPesanan.length) {
            daftarPesanan[countPesanan] = customer;
            countPesanan++;
        }
    }

    public Kamar[] getDaftarKamar() {
        return daftarKamar;
    }
}
