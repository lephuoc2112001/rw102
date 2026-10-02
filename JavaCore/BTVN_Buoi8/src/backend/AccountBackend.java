package backend;
import entity.Account;
import entity.Department;
import entity.Position;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountBackend implements IAcc {
    private Connection getConnection() throws SQLException {
        // Đổi password thành mật khẩu MySQL trên máy của bạn nếu cần
        String url = "jdbc:mysql://127.0.0.1:3306/btvn_buoi8";
        String user = "root";
        String password = "211201";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public List<Account> getAllAccounts() {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT a.id, a.username, a.full_name, d.id as dep_id, d.name as dep_name, p.id as pos_id, p.name as pos_name " +
                "FROM Account a " +
                "LEFT JOIN Department d ON a.department_id = d.id " +
                "LEFT JOIN Position p ON a.position_id = p.id";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Department dep = new Department(rs.getInt("dep_id"), rs.getString("dep_name"));
                Position pos = new Position(rs.getInt("pos_id"), rs.getString("pos_name"));
                Account acc = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("full_name"), dep, pos);
                list.add(acc);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn Account: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Account> getAccountsByUsername(String username) {
        List<Account> list = new ArrayList<>();
        String sql = "SELECT a.id, a.username, a.full_name, d.id as dep_id, d.name as dep_name, p.id as pos_id, p.name as pos_name " +
                "FROM Account a " +
                "LEFT JOIN Department d ON a.department_id = d.id " +
                "LEFT JOIN Position p ON a.position_id = p.id " +
                "WHERE a.username LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + username + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Department dep = new Department(rs.getInt("dep_id"), rs.getString("dep_name"));
                Position pos = new Position(rs.getInt("pos_id"), rs.getString("pos_name"));
                Account acc = new Account(rs.getInt("id"), rs.getString("username"), rs.getString("full_name"), dep, pos);
                list.add(acc);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi tìm kiếm Account: " + e.getMessage());
        }
        return list;
    }

}
