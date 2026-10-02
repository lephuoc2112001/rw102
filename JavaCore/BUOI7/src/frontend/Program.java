package frontend;

import backend.IQLCB;
import backend.QLCB;

import java.util.Scanner;

public class Program {
    static void main(String[] args) {
        menu();
    }

    public static void menu(){
        Scanner sc = new Scanner(System.in);
        IQLCB iqlcb = new QLCB();
        while (true){
            System.out.println("===== Mời bạn chọn chức năng =====");
            System.out.println("1. Thêm mới cán bộ. ");
            System.out.println("2. Tìm kiếm cán bộ theo tên . ");
            System.out.println("3. hiển thị toàn bộ cán bộ.");
            System.out.println("4. Nhập vào tên của cán bộ và delete cán bộ đó.");
            System.out.println("5. Thoát khỏi chương trình. ");
            switch (choice){
                case"1":
                    iqlcb.themMoi();
                    break;
            }
        }
    }
}
