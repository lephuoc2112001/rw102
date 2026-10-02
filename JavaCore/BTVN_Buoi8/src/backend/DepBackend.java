package backend;

import entity.Department;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepBackend implements IDep {
    private Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/btvn_buoi8";
        String user = "root";
        String password = "211201";
        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public List<Department> getAllDepartments() {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM Department";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Department dep = new Department(rs.getInt("id"), rs.getString("name"));
                list.add(dep);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi truy vấn Department: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Department> getDepartmentsByName(String name) {
        List<Department> list = new ArrayList<>();
        String sql = "SELECT * FROM Department WHERE name LIKE ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "%" + name + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Department dep = new Department(rs.getInt("id"), rs.getString("name"));
                list.add(dep);
            }
        } catch (SQLException e) {
            System.err.println("Lỗi tìm kiếm Department: " + e.getMessage());
        }
        return list;
    }

}
