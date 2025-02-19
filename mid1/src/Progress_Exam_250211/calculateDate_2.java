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

        if ((inputStartDate.contains(" ") && inputEndDate.contains(" ")) ||(inputStartDate.contains(" ") || inputEndDate.contains(" ")) ) {
            startdates = inputStartDate.split(" ");
            enddates = inputEndDate.split(" ");
        } else if ((inputStartDate.contains("-") && inputEndDate.contains("-")) ||(inputStartDate.contains("-") || inputEndDate.contains("-"))) {
            startdates = inputStartDate.split("-");
            enddates = inputEndDate.split("-");
        } else if ((inputStartDate.contains("\\.") && inputEndDate.contains("\\.")) ||(inputStartDate.contains("\\.") || inputEndDate.contains("\\."))) {
            startdates = inputStartDate.split("\\.");
            enddates = inputEndDate.split("\\.");
        }

        System.out.println("시작 날짜 배열 내용");
        for (String startdate : startdates) {
            System.out.println(startdate);
        }

//        LocalDate startDate = LocalDate.of(Integer.parseInt(startdates[0]), Integer.parseInt(startdates[1]), Integer.parseInt(startdates[2]));
//        LocalDate endDate = LocalDate.of(Integer.parseInt(enddates[0]), Integer.parseInt(enddates[1]),
//                Integer.parseInt(enddates[2]));
//
//        Period between = Period.between(startDate, endDate);
//        System.out.println("두 날짜 사이의 간격은 " + between.getYears() + "년 " + between.getMonths() + "개월 " + between.getDays() + "일 입니다");


    }
}