package frontend;

import backend.AccountBackend;
import backend.DepBackend;
import backend.IAcc;
import backend.IDep;
import entity.Account;
import entity.Department;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static IAcc accountBackend = new AccountBackend();
    private static IDep departmentBackend = new DepBackend();
    private static Scanner scanner = new Scanner(System.in);

    static void main(String[] args) {

        while (true) {
            System.out.println("\n================ QUẢN LÝ TÀI KHOẢN & PHÒNG BAN ================");
            System.out.println("1. Hiển thị toàn bộ account");
            System.out.println("2. Tìm kiếm account theo username");
            System.out.println("3. Hiển thị department");
            System.out.println("4. Tìm kiếm department theo tên");
            System.out.println("5. Thoát chương trình");

            int choice = 0;
            while (true) {
                try {
                    System.out.print("Mời bạn chọn chức năng (1-5): ");
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice >= 1 && choice <= 5) {
                        break;
                    }
                    System.err.println(" Vui lòng nhập từ 1 đến 5!");
                } catch (NumberFormatException e) {
                    System.err.println(" Lỗi: Phải nhập số!");
                }
            }

            switch (choice) {
                case 1:
                    hienThiAccount();
                    break;
                case 2:
                    timKiemAccount();
                    break;
                case 3:
                    hienThiDepartment();
                    break;
                case 4:
                    timKiemDepartment();
                    break;
                case 5:
                    System.out.println("👋 Cảm ơn bạn đã sử dụng chương trình!");
                    scanner.close();
                    return;
            }
        }
    }

    private static void hienThiAccount() {
        List<Account> list = accountBackend.getAllAccounts();
        inBangAccount(list);
    }

    private static void timKiemAccount() {
        System.out.print("Nhập username cần tìm: ");
        String username = scanner.nextLine();
        List<Account> list = accountBackend.getAccountsByUsername(username);
        inBangAccount(list);
    }

    private static void hienThiDepartment() {
        List<Department> list = departmentBackend.getAllDepartments();
        inBangDepartment(list);
    }

    private static void timKiemDepartment() {
        System.out.print("Nhập tên phòng ban cần tìm: ");
        String name = scanner.nextLine();
        List<Department> list = departmentBackend.getDepartmentsByName(name);
        inBangDepartment(list);
    }

    // In danh sách Account dưới dạng bảng
    private static void inBangAccount(List<Account> list) {
        if (list.isEmpty()) {
            System.out.println("⚠️ Không tìm thấy dữ liệu!");
            return;
        }
        System.out.println("+------+-----------------+----------------------+-----------------+-----------------+");
        System.out.printf("| %-4s | %-15s | %-20s | %-15s | %-15s |\n", "ID", "Username", "Full Name", "Department", "Position");
        System.out.println("+------+-----------------+----------------------+-----------------+-----------------+");

        for (int i = 0; i < list.size(); i++) {
            Account acc = list.get(i);
            String depName = (acc.getDepartment() != null) ? acc.getDepartment().getName() : "";
            String posName = (acc.getPosition() != null) ? acc.getPosition().getName() : "";
            System.out.printf("| %-4d | %-15s | %-20s | %-15s | %-15s |\n",
                    acc.getId(), acc.getUsername(), acc.getFullName(), depName, posName);
        }
        System.out.println("+------+-----------------+----------------------+-----------------+-----------------+");
    }

    // In danh sách Department dưới dạng bảng
    private static void inBangDepartment(List<Department> list) {
        if (list.isEmpty()) {
            System.out.println("⚠️ Không tìm thấy dữ liệu!");
            return;
        }
        System.out.println("+------+-----------------------------------+");
        System.out.printf("| %-4s | %-33s |\n", "ID", "Department Name");
        System.out.println("+------+-----------------------------------+");

        for (int i = 0; i < list.size(); i++) {
            Department dep = list.get(i);
            System.out.printf("| %-4d | %-33s |\n", dep.getId(), dep.getName());
        }
        System.out.println("+------+-----------------------------------+");
    }
    }

