package backend;

import entity.CanBo;
import entity.GioiTinh;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QLCB implements IQLCB{

    // private CanBo[] canBos = new CanBo[1000]; //lưu trữ dũ liệu , fix cứng ố lượng lưu trữ
    private List<CanBo> canBoList;
    private Scanner sc = new Scanner(System.in);
    public  QLCB {
        canBoList = new ArrayList<>();
        canBoList = new ArrayList<>("nguyen van a", 20, GioiTinh.NAM, "HN");
        canBoList = new ArrayList<>("nguyen van b", 21, GioiTinh.NU, "ĐN");
        canBoList = new ArrayList<>("le thi c", 22, GioiTinh.KHAC, "HCM");
        canBoList = new ArrayList<>("nguyen ba a", 23, GioiTinh.NAM, "HN");
    }

    @Override
    public void themMoi(){
        System.out.println("====== THEM MỚI CÁN BỘ =======");
    }

    @Override
    public void timKiemTheoTen(){
        System.out.println("====== TÌM KIẾM CÁN BỘ =======");
        System.out.println("Nhập họ tên cần tìm");
        String ten = sc .nextLine();
        System.out.println("++-----------------+--------+----------+--------------------++");
        System.out.println("|%25s|%5s|%10s|%20s|\n" ,"Họ tên", "Tuổi", "Giới Tính", "Địa chỉ");
        System.out.println("++-----------------+--------+----------+--------------------++");
        for (CanBo cb : canBoList){
            if (cb.getHoTen().contains(ten)){ //like %ten%
                System.out.println("|%25s|%5s|%10s|%20s|\n" ,cb.getHoTen(), cb.getTuoi(), cb.getGoitinh(), cb.getDiaChi());
            }
        }
        System.out.println("++-----------------+--------+----------+--------------------++");
    }
    @Override
    public void hienThiToanBo(){
        System.out.println("====== HIỂN THỊ TOÀN BỘ CÁN BỘ =======");
        System.out.println("++-----------------+--------+----------+--------------------++");
    }
//        public void themMoi() {
//            System.out.println("==== THÊM MỚI CÁN BỘ ====");
//            // nhập dữ liệu chung
//            System.out.print("Nhập họ tên: ");
//            String hoTen = sc.nextLine();
//            System.out.print("Nhập tuổi: ");
//            int tuoi = sc.nextInt();
//            sc.nextLine();
//
//            System.out.print("Nhập giới tính: 1. NAM    2. NỮ    khác: KHÁC");
//            String gt = sc.nextLine();
//            GioiTinh gioiTinh;
//            switch (gt) {
//                case "1":
//                    gioiTinh = GioiTinh.NAM;
//                    break;
//                case "2":
//                    gioiTinh = GioiTinh.NU;
//                    break;
//                default:
//                    gioiTinh = GioiTinh.KHAC;
//            }
//
//            System.out.print("Nhập địa chỉ: ");
//            String diaChi = sc.nextLine();
//
//            // chọn loại cán bộ
//            System.out.print("Nhập loại cán bộ: 1. Công nhân    2. Kỹ sư    3. Nhân viên");
//            String choice = sc.nextLine();
//            switch (choice) {
//                case "1":
//                    System.out.print("Nhập bậc: ");
//                    int bac = sc.nextInt();
//                    sc.nextLine();
//                    CanBo congNhan = new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac);
//                    canBoList.add(congNhan); // thêm vào ds
//                    System.out.println("Thêm công nhân thành công!");
//                    break;
//                case "2":
//                    System.out.print("Nhập ngành đào tạo: ");
//                    String nganhDaoTao = sc.nextLine();
//                    CanBo kySu = new KySu(hoTen, tuoi, gioiTinh, diaChi, nganhDaoTao);
//                    canBoList.add(kySu); // thêm vào ds
//                    System.out.println("Thêm kỹ sư thành công!");
//                    break;
//                default:
//                    System.out.print("Nhập công việc: ");
//                    String congViec = sc.nextLine();
//                    CanBo nhanVien = new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec);
//                    canBoList.add(nhanVien); // thêm vào ds
//                    System.out.println("Thêm nhân viên thành công!");
//            }
//        }
    }
}
