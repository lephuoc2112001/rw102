public class Program {
    static void main(String[] args) {

        //Question 2:
        //Tạo file Program.java có chứa main() method và khởi tạo ít nhất 3 đối tượng đối với mỗi table trong java
        Department dep1 = new Department();
        dep1.departmentId = 1;
        dep1.departmentName = "Sale";

        Department dep2 = new Department();
        dep2.departmentId = 2;
        dep2.departmentName = "Maketing";

        Department dep3 = new Department();
        dep3.departmentId = 3;
        dep3.departmentName = "HR";

        Position pos1 = new Position();
        pos1.positionId = 1;
        pos1.positionName = Position.PositionName.DEV;

        Position pos2 = new Position();
        pos2.positionId = 2;
        pos2.positionName = Position.PositionName.PM;

        Position pos3 = new Position();
        pos3.positionId = 3;
        pos3.positionName =Position.PositionName.TEST;

        Account acc1 = new Account();
        acc1.accountId = 1;
        acc1.email = "Haidui789@gamil.com";
        acc1.fullName = "Nguyen Van Hai";
        acc1.userName = "HaiDui";
        acc1.department = dep1;
        acc1.position = pos1;

        Account acc2 = new Account();
        acc2.accountId = 2;
        acc2.email = "Khoa889@gamil.com";
        acc2.fullName = "Lo Van Khoa";
        acc2.userName = "Khoakhaukhinh";
        acc2.department = dep2;
        acc2.position = pos2;

        Account acc3 = new Account();
        acc3.accountId = 3;
        acc3.email = "Nam7989@gamil.com";
        acc3.fullName = "Hi Van Nam";
        acc3.userName = "NamHi";
        acc3.department = dep3;
        acc3.position = pos3;

//        Question 3:
//        Trong file Program.java, hãy in ít nhất 1 giá trị của mỗi đối tượng ra
        System.out.println("Department_Name :" + dep1.departmentName);
        System.out.println("Department_Id :" + dep1.departmentId );
        System.out.println("Position_Id :" + pos1.positionId);
        System.out.println("Position_Name :" + pos1.positionName);
        System.out.println("Acc1 - FullName :" + acc1.fullName + " | Phòng Ban :" + acc1.department.departmentName + " | Chức Vụ : " + acc1.position.positionName);


    }
}
