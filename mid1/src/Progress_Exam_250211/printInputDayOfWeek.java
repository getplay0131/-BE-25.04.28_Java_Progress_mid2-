package Progress_Exam_250211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;

//Foundation_2
public class printInputDayOfWeek {
    public static void main(String[] args) throws Exception {
//    문제: 사용자로부터 연, 월, 일을 입력받아 해당 날짜의 요일을 출력하는 프로그램을 작성하세요.
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("확인할 연도를 입력해주세요 : ");
        int year = Integer.parseInt(reader.readLine());

        System.out.println();

        System.out.print("확인할 월을 입력해주세요 : ");
        int month = Integer.parseInt(reader.readLine());

        System.out.println();

        System.out.print("확인할 일을 입력해주세요 : ");
        int days = Integer.parseInt(reader.readLine());

        System.out.println();

        checkDayOfWeek(year,month,days);
    }

    public static void checkDayOfWeek(int year,int month, int days){
        LocalDate date = LocalDate.of(year, month, days);
        if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
        System.out.println("해당 날짜의 요일은 월요일 입니다.");
        } else if (date.getDayOfWeek() == DayOfWeek.TUESDAY) {
            System.out.println("해당 날짜의 요일은 화요일 입니다.");
        } else if (date.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            System.out.println("해당 날짜의 요일은 소요일 입니다.");
        } else if (date.getDayOfWeek() == DayOfWeek.THURSDAY) {
            System.out.println("해당 날짜의 요일은 목요일 입니다.");
        } else if (date.getDayOfWeek() == DayOfWeek.FRIDAY) {
            System.out.println("해당 날짜의 요일은 금요일 입니다.");
        } else if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
            System.out.println("해당 날짜의 요일은 토요일 입니다.");
        } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            System.out.println("해당 날짜의 요일은 일요일 입니다.");
        }
        

    }
}