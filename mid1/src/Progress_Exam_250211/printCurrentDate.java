package Progress_Exam_250211;

import java.time.LocalDate;

//Foundation_1
public class printCurrentDate {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        
        int [] dates = {now.getYear(),now.getMonthValue(), now.getDayOfMonth()};

        for (int i = 0; i < dates.length ; i++) {
            if (i == 0) {
                System.out.print("연도 : "  + dates[i] + "년도");
            } else if (i == 1) {
                System.out.print(", 월 : "  + dates[i] + "월");
            } else if (i == dates.length-1) {
                System.out.println(",  일 : "  + dates[i] + " 일 입니다.");
            }
        }
    }
}