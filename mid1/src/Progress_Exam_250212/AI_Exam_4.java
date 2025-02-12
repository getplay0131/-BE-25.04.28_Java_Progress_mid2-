package Progress_Exam_250212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

//출근 시간과 퇴근 시간을 입력받아 총 근무 시간을 계산하는 프로그램을 작성하세요.
public class AI_Exam_4 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("근무 시작 시간을 입력해 주세요! : ");
        String startTime = reader.readLine();

        System.out.print("근무 종료 시간을 입력해 주세요! : ");
        String endTime = reader.readLine();

        calculateDays(shapeConversion(splitStr(startTime)),shapeConversion(splitStr(endTime)));


        reader.close();
    }

    public static int[] shapeConversion(String[] arrays) {
        int[] intArr = {Integer.parseInt(arrays[0]), Integer.parseInt(arrays[1])};
        return intArr;
    }

    public static String[] splitStr(String str) {
        String[] strArr = new String[2];
        if (str.contains(":")) {
            strArr = str.split(":");
        }
        return strArr;
    }

    public static void calculateDays(int[] arrays, int[] arrays2) {
        LocalTime startTime = LocalTime.of(arrays[0], arrays[1]);
        LocalTime endTime = LocalTime.of(arrays2[0], arrays2[1]);
        long betweenHours = ChronoUnit.HOURS.between(startTime, endTime);
//        60으로 나눈 나머지를 구하면 분만 남는다.
        long minutes = ChronoUnit.MINUTES.between(startTime, endTime) % 60;
        long resultHours = 0;
        if (minutes <60) {
            resultHours = betweenHours - 1;
        }
        System.out.println("근무시간은 " + resultHours + "시간 " + minutes + "분 입니다. (점심시간 1시간 제외)");
    }
}
