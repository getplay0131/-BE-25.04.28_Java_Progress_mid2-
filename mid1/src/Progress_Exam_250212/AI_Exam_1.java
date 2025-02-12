package Progress_Exam_250212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;

//당신의 프로그래밍 학습을 시작한 날부터 100일 후가 언제인지 계산하는 프로그램을 작성하세요.
public class AI_Exam_1 {
    public static void main(String[] args)throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("프로그래밍 학습 시작 날짜를 입력해주세요 : ");
        String inputDate = reader.readLine();

        String[] dateArr = splitStr(inputDate);
        int[] dateIntShape = shapeConversion(dateArr);
        calculateDays(dateIntShape);
        reader.close();
    }

    public static int[] shapeConversion(String[] arrays) {
        int[] intArr = {Integer.parseInt(arrays[0]), Integer.parseInt(arrays[1]),Integer.parseInt(arrays[2])};
        return intArr;
    }

    public static String[] splitStr(String str){
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
        LocalDate plusDays = date.plusDays(100);
        System.out.println("100일 후는 " + plusDays + "입니다.");
    }
}
