import java.time.LocalDate;

public class Exam {
    int examId;
    Long code;
    String title;
    CategoryQuestion category;
    int duration;
    int creatorId;
    private LocalDate date = LocalDate.now();
}
