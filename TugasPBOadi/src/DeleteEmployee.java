import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteEmployee {

    private static final String URL = "jdbc:mysql://localhost:3306/dbmuayya";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static void deleteEmployeeById() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "DELETE FROM adi WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                Scanner del = new Scanner(System.in);
                System.out.println("----MENGHAPUS DATA LOGIN Peminjam----");
                System.out.print("Masukkan id Peminjam untuk dihapus: ");
                int employeeId = del.nextInt();
                preparedStatement.setInt(1, employeeId);
                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("data Peminjam berhasil dihapus!");
                } else {
                    System.out.println("tidak ditemukan data Peminjam dengan id tersebut.");
                }
        
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
