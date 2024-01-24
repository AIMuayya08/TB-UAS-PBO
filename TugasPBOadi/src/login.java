import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class login {
    public String Code[] = {"SKA123","SKB123","PBO321"};
    public String capca;
    public int hitung =-1;

    public void login(){
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Menghubungkan ke database (localhost)
            String url = "jdbc:mysql://localhost:3306/dbmuayya";
            String username = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(url, username, password);

            String id;
            String passwordInput;
            Scanner scan = new Scanner(System.in);

            //log in sistem
            System.out.println("Mesin Denda Perpustakaan");
            System.out.println("Log in  ");
            do {
                System.out.print("Username         : ");
                id = scan.next();
                System.out.print("Password         : ");
                passwordInput = scan.next();

                if (validateUser(connection, id, passwordInput)) {
                    int random = 0;
                    do {
                        if (random > 0) {
                            System.out.println("Captcha Salah !!!");
                        }
                        random++;
                        hitung++;
                        hitung %= 3;
                        System.out.println("Kode Captcha     : " + Code[hitung]);
                        System.out.print("Entry Captcha    : ");
                        Scanner kode = new Scanner(System.in);
                        capca = kode.next();
                    } while (!capca.equals(Code[hitung]));

                    System.out.println();
                    System.out.println("Akun Ditemukan");
                    System.out.println();
                    break;
                } else {
                    System.out.println("Coba Lagi");
                }
            } while (true);

            // tutup koneksi database
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
     // validasi password dan username
     private boolean validateUser(Connection connection, String username, String password) throws SQLException {
        String query = "SELECT * FROM adi WHERE Username=? AND Password=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();
        }
    }
}
    

