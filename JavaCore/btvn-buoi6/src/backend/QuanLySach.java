package backend;

import entity.TaiLieu;
import entity.Sach;
import entity.TapChi;
import entity.Bao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



    public class QuanLySach {
        private List<TaiLieu> danhSachTaiLieu;
        private Scanner scanner;

        public QuanLySach() {
            danhSachTaiLieu = new ArrayList<>();
            scanner = new Scanner(System.in);
        }

        // 1. Thêm mới tài liệu
        public void themTaiLieu() {
            System.out.println("\n--- CHỌN LOẠI TÀI LIỆU CẦN THÊM ---");
            System.out.println("1. Sách");
            System.out.println("2. Tạp chí");
            System.out.println("3. Báo");
            System.out.print("Mời chọn (1-3): ");
            int type = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Nhập mã tài liệu: ");
            String maTaiLieu = scanner.nextLine();

            // Kiểm tra mã tài liệu trùng lặp
            for (TaiLieu tl : danhSachTaiLieu) {
                if (tl.getMaTaiLieu().equalsIgnoreCase(maTaiLieu)) {
                    System.out.println(" Mã tài liệu đã tồn tại! Thêm mới thất bại.");
                    return;
                }
            }

            System.out.print("Nhập tên nhà xuất bản: ");
            String tenNhaXuatBan = scanner.nextLine();
            System.out.print("Nhập số bản phát hành: ");
            int soBanPhatHanh = scanner.nextInt();
            scanner.nextLine();

            switch (type) {
                case 1:
                    System.out.print("Nhập tên tác giả: ");
                    String tenTacGia = scanner.nextLine();
                    System.out.print("Nhập số trang: ");
                    int soTrang = scanner.nextInt();
                    scanner.nextLine();
                    danhSachTaiLieu.add(new Sach(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, tenTacGia, soTrang));
                    System.out.println(" Thêm mới Sách thành công!");
                    break;
                case 2:
                    System.out.print("Nhập số phát hành: ");
                    int soPhatHanh = scanner.nextInt();
                    System.out.print("Nhập tháng phát hành: ");
                    int thangPhatHanh = scanner.nextInt();
                    scanner.nextLine();
                    danhSachTaiLieu.add(new TapChi(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, soPhatHanh, thangPhatHanh));
                    System.out.println(" Thêm mới Tạp chí thành công!");
                    break;
                case 3:
                    System.out.print("Nhập ngày phát hành (dd/MM/yyyy): ");
                    String ngayPhatHanh = scanner.nextLine();
                    danhSachTaiLieu.add(new Bao(maTaiLieu, tenNhaXuatBan, soBanPhatHanh, ngayPhatHanh));
                    System.out.println(" Thêm mới Báo thành công!");
                    break;
                default:
                    System.out.println(" Loại tài liệu không hợp lệ!");
            }
        }

        // 2. Xóa tài liệu theo mã
        public void xoaTaiLieu() {
            System.out.print("Nhập mã tài liệu cần xóa: ");
            String maXoa = scanner.nextLine();
            boolean isRemoved = danhSachTaiLieu.removeIf(tl -> tl.getMaTaiLieu().equalsIgnoreCase(maXoa));

            if (isRemoved) {
                System.out.println(" Đã xóa thành công tài liệu có mã: " + maXoa);
            } else {
                System.out.println(" Không tìm thấy tài liệu có mã: " + maXoa);
            }
        }

        // 3. Hiển thị thông tin tài liệu
        public void hienThiThongTin() {
            if (danhSachTaiLieu.isEmpty()) {
                System.out.println(" Danh sách tài liệu đang trống!");
                return;
            }
            System.out.println("\n--- DANH SÁCH TẤT CẢ TÀI LIỆU ---");
            for (TaiLieu tl : danhSachTaiLieu) {
                tl.hienThiThongTin();
            }
        }

        // 4. Tìm kiếm tài liệu theo loại
        public void timKiemTheoLoai() {
            System.out.println("\n--- CHỌN LOẠI TÀI LIỆU CẦN TÌM ---");
            System.out.println("1. Sách");
            System.out.println("2. Tạp chí");
            System.out.println("3. Báo");
            System.out.print("Mời chọn (1-3): ");
            int choose = scanner.nextInt();
            scanner.nextLine();

            boolean timThay = false;
            System.out.println("\n--- KẾT QUẢ TÌM KIẾM ---");
            for (TaiLieu tl : danhSachTaiLieu) {
                if (choose == 1 && tl instanceof Sach) {
                    tl.hienThiThongTin();
                    timThay = true;
                } else if (choose == 2 && tl instanceof TapChi) {
                    tl.hienThiThongTin();
                    timThay = true;
                } else if (choose == 3 && tl instanceof Bao) {
                    tl.hienThiThongTin();
                    timThay = true;
                }
            }

            if (!timThay) {
                System.out.println(" Không tìm thấy tài liệu nào thuộc loại này!");
            }
        }
}
