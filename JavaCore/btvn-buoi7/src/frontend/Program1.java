package frontend;

import backend.QuanLySach;
import java.util.Scanner;



public class Program1 {
    static void main(String[] args) {
        QuanLySach qlsv = new QuanLySach();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n================ QUẢN LÝ THƯ VIỆN ================");
            System.out.println("1. Thêm mới tài liệu (Sách, Tạp chí, Báo)");
            System.out.println("2. Xóa tài liệu theo mã");
            System.out.println("3. Hiển thị thông tin về tài liệu");
            System.out.println("4. Tìm kiếm tài liệu theo loại");
            System.out.println("5. Thoát khỏi chương trình");
            System.out.print("Mời bạn chọn chức năng : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    qlsv.themTaiLieu();
                    break;
                case 2:
                    qlsv.xoaTaiLieu();
                    break;
                case 3:
                    qlsv.hienThiThongTin();
                    break;
                case 4:
                    qlsv.timKiemTheoLoai();
                    break;
                case 5:
                    System.out.println(" Cảm ơn bạn đã sử dụng chương trình! Tạm biệt.");
                    scanner.close();
                    return;
                default:
                    System.out.println(" Chức năng chọn không hợp lệ, vui lòng thử lại!");
            }
        }

    }
}
