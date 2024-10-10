package ReservasiHotel;

import java.util.Scanner;

public class AplikasiHotel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin1 = new Admin("Admin1");
        admin1.tambahKamar(new Kamar(201, "Deluxe", 3000000));
        admin1.tambahKamar(new Kamar(101, "Suite", 5000000));

        System.out.println("Selamat datang di Aplikasi Hotel Mercure Karawang");

        Pengguna user = null;

        while (true) {
            if (user == null) {
                System.out.print("Masukkan nama Anda (Admin/Customer): ");
                String nama = scanner.nextLine();
                if (nama.equalsIgnoreCase("Admin1")) {
                    user = admin1;
                } else {
                    user = new Customer(nama);
                }
            }

            System.out.println("\nMenu Aplikasi Hotel");
            System.out.println("1. Lihat Ketersediaan Kamar");
            System.out.println("2. Pesan Kamar (Hanya Customer)");
            System.out.println("3. Lihat Pesanan");
            System.out.println("4. Batalkan Pesanan");
            System.out.println("5. Tambah/Hapus Kamar (Admin)");
            System.out.println("6. Ganti Pengguna");
            System.out.println("7. Keluar");

            int pilihan = -1;
            while (pilihan == -1) {
                System.out.print("Pilih: ");
                String input = scanner.nextLine();

                if (isNumeric(input)) {
                    pilihan = Integer.parseInt(input);
                } else {
                    System.out.println("Input harus berupa angka. Silakan coba lagi.");
                }
            }

            switch (pilihan) {
                case 1:
                    admin1.tampilkanDaftarKamar();
                    break;
                case 2:
                    if (user instanceof Customer) {
                        System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
                        String nomorInput = scanner.nextLine();
                        if (isNumeric(nomorInput)) {
                            int nomorKamar = Integer.parseInt(nomorInput);
                            boolean kamarDitemukan = false;
                            for (Kamar kamar : admin1.getDaftarKamar()) {
                                if (kamar != null && kamar.getNomorKamar() == nomorKamar) {
                                    ((Customer) user).pesanKamar(kamar);
                                    admin1.tambahPesanan((Customer) user);
                                    System.out.println("Kamar " + nomorKamar + " telah dipesan.");
                                    kamarDitemukan = true;
                                    break;
                                }
                            }
                            if (!kamarDitemukan) {
                                System.out.println("Nomor kamar tidak ditemukan.");
                            }
                        } else {
                            System.out.println("Nomor kamar harus berupa angka.");
                        }
                    } else {
                        System.out.println("Hanya customer yang bisa memesan kamar.");
                    }
                    break;
                case 3:
                    user.lihatPesanan();
                    break;
                case 4:
                    if (user instanceof Customer) {
                        ((Customer) user).batalkanPesanan();
                    } else {
                        System.out.println("Hanya customer yang bisa membatalkan pesanan.");
                    }
                    break;
                case 5:
                    if (user instanceof Admin) {
                        System.out.print("1. Tambah kamar\n2. Hapus kamar\nPilih: ");
                        String adminInput = scanner.nextLine();
                        if (isNumeric(adminInput)) {
                            int pilihanAdmin = Integer.parseInt(adminInput);
                            if (pilihanAdmin == 1) {
                                System.out.print("Nomor Kamar: ");
                                String nomorKamarInput = scanner.nextLine();
                                if (isNumeric(nomorKamarInput)) {
                                    int nomorKamar = Integer.parseInt(nomorKamarInput);
                                    System.out.print("Tipe Kamar: ");
                                    String tipe = scanner.nextLine();
                                    System.out.print("Harga: ");
                                    String hargaInput = scanner.nextLine();
                                    if (isNumeric(hargaInput)) {
                                        double harga = Double.parseDouble(hargaInput);
                                        admin1.tambahKamar(new Kamar(nomorKamar, tipe, harga));
                                        admin1.tampilkanDaftarKamar();
                                    } else {
                                        System.out.println("Harga harus berupa angka.");
                                    }
                                } else {
                                    System.out.println("Nomor kamar harus berupa angka.");
                                }
                            } else if (pilihanAdmin == 2) {
                                System.out.print("Nomor kamar yang ingin dihapus: ");
                                String nomorKamarInput = scanner.nextLine();
                                if (isNumeric(nomorKamarInput)) {
                                    int nomorKamar = Integer.parseInt(nomorKamarInput);
                                    admin1.hapusKamar(nomorKamar);
                                } else {
                                    System.out.println("Nomor kamar harus berupa angka.");
                                }
                            }
                        } else {
                            System.out.println("Pilihan harus berupa angka.");
                        }
                    } else {
                        System.out.println("Hanya admin yang bisa menambah/menghapus kamar.");
                    }
                    break;
                case 6:
                    user = null;
                    break;
                case 7:
                    System.out.println("Terima kasih telah menggunakan aplikasi. Selamat tinggal!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
