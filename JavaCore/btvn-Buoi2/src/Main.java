import javax.swing.text.Position;
import java.lang.runtime.SwitchBootstraps;

public class Main {
    static void main(String[] args) {
//        Exercise 1 (Optional): Flow Control
//        IF
        int departmentId = 2;
//        Question 1:
//        Kiểm tra account thứ 2
//        Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
//        "Nhân viên này chưa có phòng ban"
//        Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là …"
        if(departmentId <= 0){
            System.out.println("Nhân viên này chưa có phòng ban ");
        }else {
            System.out.println(" Phòng ban của nhân viên này là Marketing ");
        }

//        Question 2:
//        Kiểm tra account thứ 2
//        Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
//        Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên này là Java Fresher, C# Fresher"
//        Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người quan trọng, tham gia nhiều group"
//        Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là người hóng chuyện, tham gia tất cả các group"
        int GroupId = 3;

        if(GroupId <= 0){
            System.out.println("Nhân viên này chưa có group");
        } else if (GroupId == 1 || GroupId == 2 ) { // || (HOẶC)
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (GroupId == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else if (GroupId >= 4) {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
//
//        Question 3:
//        Sử dụng toán tử ternary để làm Question 1
        System.out.println(departmentId == 0 ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là Marketing ");
//
//        Question 4:
//        Sử dụng toán tử ternary để làm yêu cầu sau:
//        Kiểm tra Position của account thứ 1
//        Nếu Position = Dev thì in ra text "Đây là Developer"
//        Nếu không phải thì in ra text "Người này không phải là Developer"

        System.out.println(acc1.positionId == 1 ? "Đây là Developer" : "Người này không phải là Developer");
    //    System.out.println(acc1.position.positionName == Position.PositionName.DEV ? "Đây là Developer" : "Người này không phải là Developer");
//
//        SWITCH CASE
//        Question 5:
//        Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau: Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
//        Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
//        Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
//        Còn lại in ra "Nhóm có nhiều thành viên"
        int countAcc = group1.accounts != null ? group1.accounts.length : 0; // Hoặc gán số lượng cụ thể

        switch (countAcc) {
            case 1:
                System.out.println("Nhóm có một thành viên");
                break;
            case 2:
                System.out.println("Nhóm có hai thành viên");
                break;
            case 3:
                System.out.println("Nhóm có ba thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
                break;
        }


//        Question 6:
//        Sử dụng switch case để làm lại Question 2
        int acc2GroupCount = acc2.groups != null ? acc2.groups.length : 0;

        switch (acc2GroupCount) {
            case 0:
                System.out.println("Nhân viên này chưa có group");
                break;
            case 1:
            case 2:
                System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
                break;
            default:
                System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
                break;
        }
//
//        Question 7:
//        Sử dụng switch case để làm lại Question 4
        String posName = acc1.position.positionName.toString();

        switch (posName) {
            case "DEV":
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
                break;
        }
//
//        FOREACH
//        Question 8:
//        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ
        Account[] accounts = { acc1, acc2, acc3 };

        for (Account acc : accounts) {
            System.out.println("Email: " + acc.email + " | FullName: " + acc.fullName + " | Phòng ban: " + acc.department.departmentName);
        }
//
//        Question 9:
//        In ra thông tin các phòng ban bao gồm: id và name
        Department[] departments = { dep1, dep2, dep3 };

        for (Department dep : departments) {
            System.out.println("ID: " + dep.id + " | Name: " + dep.departmentName);
        }
//
//                FOR
//        Question 10:
//        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ theo định dạng như sau:
//        Thông tin account thứ 1 là:
//        Email: NguyenVanA@gmail.com
//        Full name: Nguyễn Văn A
//        Phòng ban: Sale
//
//        Thông tin account thứ 2 là:
//        Email: NguyenVanB@gmail.com
//        Full name: Nguyễn Văn B
//        Phòng ban: Marketting
        Account[] accounts = { acc1, acc2, acc3 };

        for (int i = 0; i < accounts.length; i++) {
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.departmentName + "\n");
        }
//
//        Question 11:
//        In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
//        Thông tin department thứ 1 là:
//        Id: 1
//        Name: Sale
//        Thông tin department thứ 2 là:
//        Id: 2
//        Name: Marketing
        Department[] departments = { dep1, dep2, dep3 };

        for (int i = 0; i < 2; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments[i].id);
            System.out.println("Name: " + departments[i].departmentName + "\n");
        }
//
//        Question 12:
//        Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10
        Department[] departments = { dep1, dep2, dep3 };

        for (int i = 0; i < 2; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments[i].id);
            System.out.println("Name: " + departments[i].departmentName + "\n");
        }
//
//        Question 13:
//        In ra thông tin tất cả các account ngoại trừ account thứ 2
        Account[] accounts = { acc1, acc2, acc3 };

        for (int i = 0; i < accounts.length; i++) {
            if (i == 1) { // Bỏ qua phần tử index 1 (account thứ 2)
                continue;
            }
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + accounts[i].department.departmentName + "\n");
        }
//
//        Question 14:
//        In ra thông tin tất cả các account có id < 4
        for (Account account : accounts){
            if (account.id < 4){
                System.out.println(4);
            }
        }
//
//        Question 15:
//        In ra các số chẵn nhỏ hơn hoặc bằng 20
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i);
            }
        }

    }
}
