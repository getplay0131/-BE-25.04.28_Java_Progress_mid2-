package Progress_Exam_250212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

//당신의 다음 생일까지 며칠이 남았는지 계산하는 프로그램을 작성하세요.
public class AI_Exam_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("당신의 생일을 입력해주세요! : ");
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
        LocalDate date = LocalDate.of(arrays[0], arrays[1], arrays[2]);
        System.out.println("입력 날짜는 " + date.getYear() + "년도, " + date.getMonth().getValue() + "월, " + date.getDayOfMonth() + "일" +
                " 입니다");
        LocalDate currentDays = LocalDate.now();
        System.out.println("currentDays = " + currentDays);
        LocalDate withYear = date.withYear(currentDays.getYear());
        System.out.println("withYear = " + withYear);
        LocalDate nextYear = withYear.plusYears(1);
        System.out.println("nextYear = " + nextYear);
        if (currentDays.isBefore(nextYear)) {
            long betweenDays = ChronoUnit.DAYS.between(currentDays, nextYear);
            System.out.println("내년 생일까지 " + betweenDays + "일 남았습니다.");
//            Period between = Period.between(currentDays, nextYear);
//            System.out.println("내년 생일까지 " + between.getYears() + "년, " + between.getMonths() + "개월, " + between.getDays() + "일 남았습니다.");
        }
    }
}
