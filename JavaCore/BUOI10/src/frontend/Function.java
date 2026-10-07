package frontend;

import backend.controller.CanBoController;
import entity.CanBo;

import java.util.List;
import java.util.Scanner;

public class Function {
    private CanBoController canBoController;
    private Scanner sc;

    public Function() {
        this.canBoController = new CanBoController();
        this.sc = new Scanner(System.in);
    }

    // them mới
//    public void themMoi() {
//        sc.nextLine();
//
//    }

    // hien thi
    public void hienThiToanBo() {
        // yêu cầu controller trả ra 1 ds các cán bộ
        List<CanBo> canBos = canBoController.findAll();

        System.out.println("==== HIỂN THỊ TOÀN BỘ CÁN BỘ ====");
        System.out.println("+-------------------------+-----+----------+--------------------+");
        System.out.printf("|%25s|%5s|%10s|%20s|\n", "Họ tên", "Tuổi", "Giới tính", "Địa chỉ");
        System.out.println("+-------------------------+-----+----------+--------------------+");
        for (CanBo cb : canBos) {
            System.out.printf("|%25s|%5s|%10s|%20s|\n", cb.getHoTen(), cb.getTuoi(), cb.getGioiTinh(), cb.getDiaChi());
        }
        System.out.println("+-------------------------+-----+----------+--------------------+");

    }

    // tim kiem
    public void timKiem(){
        System.out.println("==== TÌM KIẾM CÁN BỘ ====");
        System.out.println("Nhập họ tên cần tìm: ");
        String ten = sc.nextLine().trim();

        List<CanBo> canBos = canBoController.findByName(ten);

        if (canBos.isEmpty()) {      //canBos.size() == 0
            System.err.println("Không có kết quả tương ứng!");
            try{
                Thread.sleep(10);
            }catch (InterruptedException ignored){
            }
        } else {
            System.out.println("+-------------------------+-----+----------+--------------------+");
            System.out.printf("|%25s|%5s|%10s|%20s|\n", "Họ tên", "Tuổi", "Giới tính", "Địa chỉ");
            System.out.println("+-------------------------+-----+----------+--------------------+");
            for (CanBo cb : canBos) {
                System.out.printf("|%25s|%5s|%10s|%20s|\n", cb.getHoTen(), cb.getTuoi(), cb.getGioiTinh(), cb.getDiaChi());
            }
            System.out.println("+-------------------------+-----+----------+--------------------+");
        }

    }

    // xoa
    public void deleteByName() {
        System.out.println("==== XÓA CÁN BỘ ====");
        System.out.println("Nhập họ tên cần xóa: ");// like 'abc'
        String ten = sc.nextLine();
        boolean check = canBoController.deleteByName(ten);

        if (check) {
            System.out.println("Xóa thành công");
        } else {
            System.out.println("Xóa không thành công");
        }
    }


    // update
    public void updateByName() {
        System.out.println("==== UPDATE ĐỊA CHỈ THEO TÊN ====");
        System.out.println("Nhập họ tên cần update: ");// like 'abc'
        String ten = sc.nextLine();

        System.out.println("Nhập địa chỉ cần update: ");
        String diaChi = sc.nextLine();

        boolean check = canBoController.updateByName(ten, diaChi);
        if (check) {
            System.out.println("Update thành công");
        } else {
            System.out.println("Update không thành công");
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("==== Mời bạn chọn chức năng ====");
            System.out.println("1. Thêm mới cán bộ.");
            System.out.println("2. Tìm kiếm theo họ tên.");//
            System.out.println("3. Hiển thị toàn bộ các cán bộ.");//
            System.out.println("4. Nhập vào tên của cán bộ và xóa cán bộ đó.");// nhập đúng tên
            System.out.println("5. Update địa chỉ theo tên(nhập đúng).");
            System.out.println("6. Thoát khỏi chương trình.");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    this.themMoi();
                    break;
                case "2":
                    this.timKiem();
                    break;
                case "3":
                    this.hienThiToanBo();
                    break;
                case "4":
                    this.deleteByName();
                    break;
                case "5":
                    this.updateByName();
                    break;
                case "6":
                    System.out.println("Thoát.");
                    System.exit(0);
                default:
                    System.err.println("Chọn sai, Chọn lại!");
            }
        }

    }
    public void themMoi() {
        System.out.println("~~==== THÊM MỚI CÁN BỘ ====~~");

        // 1. Nhập Họ tên (không được để trống)
        String hoTen = "";
        String nameRegex = "^[a-zA-ZàáảãạăằắẳẵặâầấẩẫậèéẻẽẹêềếểễệđìíỉĩịòóỏõọôồốổỗộơờớởỡợùúủũụưừứửữựỳýỷỹỵÀÁẢÃẠĂẰẮẲẴẶÂẦẤẨẪẬÈÉẺẼẸÊỀẾỂỄỆĐÌÍỈĨỊÒÓỎÕỌÔỒỐỔỖỘƠỜỚỞỠỢÙÚỦŨỤƯỪỨỬỮỰỲÝỶỸỴ\\s]+$";
        while (true) {
            System.out.println("Vui lòng nhập họ tên: ");
            hoTen = sc.nextLine().trim();
            if (!hoTen.isEmpty() && hoTen.matches(nameRegex)) {
                break;
            }
            System.err.println("Vui lòng nhập đúng cú pháp!");
        }

        // 2. Nhập Tuổi (phải là số hợp lệ từ 18 - 100)
        int tuoi = 0;
        while (true) {
            System.out.println("Vui lòng nhập tuổi: ");
            try {
                tuoi = Integer.parseInt(sc.nextLine().trim());
                if (tuoi < 18 ) {
                    System.err.println("BẠN CHƯA ĐỦ TUỔI!");
                    try{
                        Thread.sleep(10);
                    }catch (InterruptedException ignored){
                    }
                }else if (tuoi >= 100) {
                    System.err.println("BẠN CÒN SỐNG À !");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ignored) {}
                } else {
                    break;
                }
                    } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập đúng cú pháp!");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ignored) {
                    }
                }
                }

        // 3. Nhập Email (đúng chuẩn có dấy @ và tên miền)
        String email = "";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        while (true) {
            System.out.println("Vui lòng nhập email: ");
            email = sc.nextLine().trim();
            if (email.matches(emailRegex)) {
                break;
            }
            System.err.println("Vui lòng nhập đúng cú pháp!");
        }

        System.out.println("Đã tạo thành công!");
    }

}