package utils;


 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.SQLException;

public class JDBCUtils {
     private static Connection connection;

     //hàm này đc sử dụng nhiều lần
     public static Connection getConnection() {
         try {
             // Kiểm tra nếu connection chưa khởi tạo hoặc đã bị đóng thì mới mở mới
             if (connection == null || connection.isClosed()) {
                 String url = "jdbc:mysql://127.0.0.1:3306/qlcb_buoi10";
                 String username = "root";
                 String password = "211201";

                 connection = DriverManager.getConnection(url, username, password);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return connection;
     }

    // Hàm đóng kết nối
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
