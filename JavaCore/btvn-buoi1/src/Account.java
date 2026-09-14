import java.time.LocalDate;

public class Account {
    int accountId;
    String userName;
    String fullName;
    String email;
    Department department;
    Position position;
    LocalDate date = LocalDate.now();
}
