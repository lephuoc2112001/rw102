public class Exercise1 {
    public static void question1(Account account) {

        if (account.department == null) ;
        System.out.println("Nhân viên này chưa có phòng ban");
    }else

    {
        System.out.println("Phòng ban của nhân viên này là " + account.department.name);
    }

    public static void question2(Account account) {
        if (account.group == null) ;
        System.out.println("Nhân viên này chưa có group");
    }else if(accout.groups ==1||account.groups ==2)

    {
        System.out.println("Group của nhân viên này là JavaFresher , C#Fresher");
    }else if(account.group ==3)

    {
        System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
    }else

    {
        System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
    }

    public static void question3() {
        System.out.println("\n=== Question 3 ===");
        Account acc = accounts[1];
        String message = (acc.department == null)
                ? "Nhân viên này chưa có phòng ban"
                : "Phòng ban của nhân viên này là " + acc.department.name;
        System.out.println(message);
    }

    public static void question4() {
        System.out.println("\n=== Question 4 ===");
        Account acc = accounts[0]; // Account thứ 1 (index = 0)
        String message = (acc.position != null && "Dev".equalsIgnoreCase(acc.position.name))
                ? "Đây là Developer"
                : "Người này không phải là Developer";
        System.out.println(message);
    }

    public static void question5() {
        System.out.println("\n=== Question 5 ===");
        Group group = groups[0]; // Nhóm thứ 1
        int countAccount = (group.accounts != null) ? group.accounts.length : 0;

        switch (countAccount) {
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
    }

    public void static question6() {
        System.out.println("\n=== Question 6 ===");
        Account acc = accounts[1];
        int countGroup = (acc.groups != null) ? acc.groups.length : 0;

        switch (countGroup) {
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
    }

    public void static question7() {
        System.out.println("\n=== Question 7 ===");
        Account acc = accounts[0];
        String positionName = (acc.position != null) ? acc.position.name : "";

        switch (positionName) {
            case "Dev":
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
                break;
        }
    }


    public static void question8() {
        System.out.println("\n=== Question 8 ===");
        for (Account acc : accounts) {
            String depName = (acc.department != null) ? acc.department.name : "Chưa có phòng ban";
            System.out.println("Email: " + acc.email + " | FullName: " + acc.fullName + " | Phòng ban: " + depName);
        }
    }

    public static void question9() {
        System.out.println("\n=== Question 9 ===");
        for (Department dep : departments) {
            System.out.println("ID: " + dep.id + " | Name: " + dep.name);
        }
    }

    public static void question10() {
        System.out.println("\n=== Question 10 ===");
        for (int i = 0; i < accounts.length; i++) {
            String depName = (accounts[i].department != null) ? accounts[i].department.name : "Chưa có phòng ban";
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + depName);
            System.out.println();
        }
    }

    public static void question11() {
        System.out.println("\n=== Question 11 ===");
        for (int i = 0; i < departments.length; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("\tId: " + departments[i].id);
            System.out.println("\tName: " + departments[i].name);
        }
    }

    public static void question12() {
        System.out.println("\n=== Question 12 ===");
        int limit = Math.min(2, departments.length);
        for (int i = 0; i < limit; i++) {
            System.out.println("Thông tin department thứ " + (i + 1) + " là:");
            System.out.println("Id: " + departments[i].id);
            System.out.println("Name: " + departments[i].name);
        }
    }

    public static void question13() {
        System.out.println("\n=== Question 13 ===");
        for (int i = 0; i < accounts.length; i++) {
            if (i == 1) { // Bỏ qua account thứ 2 (index = 1)
                continue;
            }
            String depName = (accounts[i].department != null) ? accounts[i].department.name : "Chưa có phòng ban";
            System.out.println("Thông tin account thứ " + (i + 1) + " là:");
            System.out.println("Email: " + accounts[i].email);
            System.out.println("Full name: " + accounts[i].fullName);
            System.out.println("Phòng ban: " + depName);
            System.out.println();
        }
    }

    public static void question14() {
        System.out.println("\n=== Question 14 ===");
        for (Account acc : accounts) {
            if (acc.id < 4) {
                String depName = (acc.department != null) ? acc.department.name : "Chưa có phòng ban";
                System.out.println("ID: " + acc.id + " | Email: " + acc.email + " | FullName: " + acc.fullName + " | Phòng ban: " + depName);
            }
        }
    }

    public static void question15() {
        System.out.println("\n=== Question 15 ===");
        for (int i = 1; i <= 20; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
}


