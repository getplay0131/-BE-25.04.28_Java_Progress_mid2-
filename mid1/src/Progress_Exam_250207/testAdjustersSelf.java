package Progress_Exam_250207;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

//제4 - 시작 요일, 마지막 요일 구하기
//```java
//입력 받은 월의 첫날 요일과 마지막날 요일을 구해라.
public class testAdjustersSelf {
    public static void main(String[] args) {
    int year = 2024;
    int month = 1;
//          입력 월의 값과 날짜에서의 월이 일치하는 값을 우선 찾기
        LocalDate date = LocalDate.of(year, month, 1);
        DayOfWeek dayOfWeek = date.with(TemporalAdjusters.firstDayOfMonth()).getDayOfWeek();
        System.out.println("dayOfWeek = " + dayOfWeek);
        DayOfWeek ofWeek = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfWeek();
        System.out.println("ofWeek = " + ofWeek);
        DayOfWeek nextYear = date.with(TemporalAdjusters.firstDayOfNextYear()).getDayOfWeek();
        System.out.println("nextYear = " + nextYear);

    }




}
