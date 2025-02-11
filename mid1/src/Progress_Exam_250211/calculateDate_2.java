package Progress_Exam_250211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.Period;

public class calculateDate_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        Ver.1
//        System.out.print("시작 연도를 입력해 주세요 : ");
//        int startYear = Integer.parseInt(reader.readLine());
//
//        System.out.print("시작 월을 입력해 주세요 : ");
//        int startMonth = Integer.parseInt(reader.readLine());
//
//        System.out.print("시작 일을 입력해 주세요 : ");
//        int startDays = Integer.parseInt(reader.readLine());
//
//        System.out.print("종료 연도를 입력해 주세요 : ");
//        int endYear = Integer.parseInt(reader.readLine());
//
//        System.out.print("종료 월을 입력해 주세요 : ");
//        int endMonth = Integer.parseInt(reader.readLine());
//
//        System.out.print("종료 일을 입력해 주세요 : ");
//        int endDays = Integer.parseInt(reader.readLine());
//
//        System.out.println();
//
//        LocalDate startDate = LocalDate.of(startYear, startMonth, startDays);
//        LocalDate endDate = LocalDate.of(endYear, endMonth, endDays);
//
//        Period between = Period.between(startDate, endDate);
//        System.out.println("두 날짜 사이의 간격은 " + between.getYears() + "년 " + between.getMonths() + "개월 " + between.getDays() + "일 입니다");

//        Ver.2
        System.out.print("시작 날짜를 입력해주세요 : ");
        String inputStartDate = reader.readLine();
        System.out.print("종료 날짜를 입력해주세요 : ");
        String inputEndDate = reader.readLine();

        String[] startdates = new String[3];
        String[] enddates = new String[3];

        startdates = checkSplit(startdates, inputStartDate);
        enddates =   checkSplit(enddates, inputEndDate);

        int[] startIntArr = shapeConversion(startdates);
        int[] endIntArr = shapeConversion(enddates);

        LocalDate startDate = LocalDate.of(startIntArr[0], startIntArr[1], startIntArr[2]);
        LocalDate endDate = LocalDate.of(endIntArr[0], endIntArr[1], endIntArr[2]);

        Period between = Period.between(startDate, endDate);
        System.out.println("두 날짜 사이의 간격은 " + between.getYears() + "년 " + between.getMonths() + "개월 " + between.getDays() + "일 입니다");


    }

    public static String[] checkSplit(String[] arrays, String dates) {
        if (dates.contains(" ")) {
            arrays = dates.split(" ");
        } else if (dates.contains("-")) {
            arrays = dates.split("-");
        } else if (dates.contains(".")) {
            arrays = dates.split("\\.");
        }

        for (String array : arrays) {
            if (array == null || array.isEmpty()) {
                System.out.println("입력 값 분리에 실패하였습니다.");
            }
        }
        return arrays;
    }

    public static int[] shapeConversion(String[] arrays) {
        int[] intArr = {Integer.parseInt(arrays[0]), Integer.parseInt(arrays[1]), Integer.parseInt(arrays[2])};

        return intArr;
    }
}