import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

public class Perpustakaan {
    public static void main(String[] args) {
        CreateLogin();
        DeleteLogin();
        UpdateLogin();
        
        login login = new login();
        login.login();

        Scanner scanner = new Scanner(System.in);
      

        List<DataPinjam> daftarPinjaman = new ArrayList<>();

        System.out.print("Masukkan nama peminjam: ");
        String namaPeminjam = scanner.nextLine();
        Peminjam peminjam = new Peminjam(namaPeminjam);

        System.out.print("Masukkan jumlah hari peminjaman: ");
        int jumlahHariPeminjaman = scanner.nextInt();

        Date tanggalPinjam = new Date();
        Date tanggalKembali = new Date(tanggalPinjam.getTime() + (jumlahHariPeminjaman * 24 * 60 * 60 * 1000));

        DataPinjam dataPinjam = new DataPinjam(tanggalPinjam, tanggalKembali);

        daftarPinjaman.add(dataPinjam);

        HitungDenda hitungDenda = new HitungDenda();
        int keterlambatan = hitungDenda.hitungKeterlambatan(jumlahHariPeminjaman);

        int denda = hitungDenda.hitungDenda(keterlambatan);

        System.out.println("\nInformasi Peminjaman:");
        System.out.println("Nama Peminjam: " + peminjam.getNama());
        System.out.println("Tanggal Pinjam: " + new SimpleDateFormat("dd-MM-yyyy").format(dataPinjam.getTanggalPinjam()));
        System.out.println("Tanggal Kembali: " + new SimpleDateFormat("dd-MM-yyyy").format(dataPinjam.getTanggalKembali()));
        System.out.println("Keterlambatan: " + keterlambatan + " hari");
        System.out.println("Denda: Rp" + denda);
    }
    private static void CreateLogin(){
        Scanner scanner = new Scanner(System.in);
        CreateNewEmployee.insertEmployeeData(scanner);
        System.out.println("");
    }
    private static void DeleteLogin(){
        DeleteEmployee.deleteEmployeeById();
        System.out.println("");
    }
    private static void UpdateLogin(){
        Scanner scan = new Scanner(System.in);
        UpdateEmployee.updateEmployeeCredentials(scan);
        System.out.println("");
    }
}