import java.time.LocalDate;

public class Main {
    public static void main (String[] args){

        System.out.println("Hello and welcome");

        for (int i = 1; i <= 5; i++)
            System.out.println("i = " + i);
        // viết System.out.println() nhanh "sout"

        String fullName = "Lê Hồng Phước";
        int age = 25;
        float point = 7.5f;
        // LocalDate birthday = LocalDate
        Gender gender1 = Gender.MALE;

        System.out.println("fullName :" + fullName);
        System.out.println("age :" + age);
        System.out.println("Point :" + point);

        // biến
        System.out.println("Gender :" + gender1);
        System.out.println("Gender :" + Gender.FEMALE);
        System.out.println("Gender :" + Gender.OTHER);



    }

    }

