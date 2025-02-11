package Progress_Exam_250211;

import java.time.LocalDate;

//  introduction_1
public class calculateDate_1 {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate plussedDays = now.plusDays(100);
        LocalDate minusMonths = now.minusMonths(3);

        System.out.println("오늘은" + now + "이며, 100일 후는 " + plussedDays +" 이며, 3개월 전은 " + minusMonths + "입니다");
    }
}