package backend.repository.impl;

import backend.repository.ICanBoRepository;
import entity.CanBo;
import entity.CongNhan;
import entity.KySu;
import entity.NhanVien;
import entity.GioiTinh;
import entity.Loai;
import utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CanBoRepository implements ICanBoRepository {

    @Override
    public List<CanBo> findAll() {
        List<CanBo> canBos = new ArrayList<>();
        try {
            Connection connection = JDBCUtils.getConnection();
            String sql = "select * from can_bo";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String hoTen = resultSet.getString("ho_ten");
                int tuoi = resultSet.getInt("tuoi");
                String gt = resultSet.getString("gioi_tinh");
                GioiTinh gioiTinh = GioiTinh.valueOf(gt);
                String diaChi = resultSet.getString("dia_chi");
                String loaiString = resultSet.getString("loai");
                Loai loai = Loai.valueOf(loaiString);

                if (loai == Loai.CN) {
                    int bac = resultSet.getInt("bac");
                    CanBo cn = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, Loai.CN, bac); // thêm Loai.CN
                    canBos.add(cn);
                } else if (loai == Loai.KS) {
                    String nganhDaoTao = resultSet.getString("nganh");
                    CanBo ks = new KySu(hoTen, tuoi, gioiTinh, diaChi, Loai.KS, nganhDaoTao); // thêm Loai.KS
                    canBos.add(ks);
                } else if (loai == Loai.NV) {
                    String congViec = resultSet.getString("cong_viec");
                    CanBo nv = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, Loai.NV, congViec); // thêm Loai.NV
                    canBos.add(nv);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.closeConnection();
        }

        return canBos;
    }

    @Override
    public List<CanBo> findByName(String name) {
        return List.of();
    }

    @Override
    public boolean deleteByName(String name) {
        String sql = "DELETE FROM can_bo WHERE ho_ten LIKE ?";
        try (Connection connection = JDBCUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, "%" + name + "%");
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection();
        }
        return false;
    }

    @Override
    public void updateByName(String name, String newName) {

    }
}