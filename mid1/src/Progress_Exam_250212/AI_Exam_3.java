package Progress_Exam_250212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

//특정 월에 주말(토요일과 일요일)이 몇 번 있는지 계산하는 프로그램을 작성하세요.
public class AI_Exam_3 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("확인하고 싶은 날짜를 입력해주세요! : ");
        String inputBirthDay = reader.readLine();

        calculateDays(shapeConversion(splitStr(inputBirthDay)));

        reader.close();
    }

    public static int[] shapeConversion(String[] arrays) {
        int[] intArr = {Integer.parseInt(arrays[0]), Integer.parseInt(arrays[1]), Integer.parseInt(arrays[2])};
        return intArr;
    }

    public static String[] splitStr(String str) {
        String[] strArr = new String[3];
        if (str.contains(" ")) {
            strArr = str.split(" ");
        } else if (str.contains("-")) {
            strArr = str.split("-");
        } else if (str.contains(".")) {
            strArr = str.split("\\.");
        }
        return strArr;
    }

    public static void calculateDays(int[] arrays) {
        LocalDate date = LocalDate.of(arrays[0], arrays[1], 1);
        LocalDate lastDay = date.with(TemporalAdjusters.lastDayOfMonth()).plusDays(1);
        int satCount = 0;
        int sunCount = 0;
        while (date.isBefore(lastDay)){
        if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
            satCount++;
        } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            sunCount++;
        }
        date = date.plusDays(1);
        }

        System.out.println("해당 월의 토요일은 " + satCount + "번, 일요일은 " + sunCount +"번 있습니다.");
    }

}
