package Progress_Exam_250211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class TestCalendarPrinterSelfFinal {
    public static void main(String[] args) throws Exception {
//    사용자에게 월과 연도를 입력 받아야 한다.
//        그 후 해당 연도와 월에 맞는 달력을 출력한다 (메서드 이용하자)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int checkNum = 0;
        while (checkNum != 2) {
            System.out.print("확인할 달력의 연도를 입력해주세요! : ");
            int year = Integer.parseInt(reader.readLine());

            System.out.println();

            System.out.print("확인할 달력의 월을 입력해주세요! : ");
            int month = Integer.parseInt(reader.readLine());

            printCalander(year, month);

            System.out.println();

            System.out.print("프로그램을 종료하시겠어요? (1은 종료 안함, 2는 종료)");
            int check = Integer.parseInt(reader.readLine());
            checkNum = check;
            if (checkNum == 2) {
                System.out.println("프로그램을 종료합니다.");
            }
        }

    }

    public static void printCalander(int year, int month) {
//    1단계. 코드 작업의 기반이 될 로컬데이트 변수 선언하여 현재 달과 다음달 변수로 저장
        LocalDate firstDayCurrentMonth = LocalDate.of(year, month, 1);
        LocalDate nextMonth = firstDayCurrentMonth.plusMonths(1);

//      2단계. 요일별 위치 지정을 위한 공백 지정 하기 위한 변수 선언 및 반복문으로 위치 설정
        int calculateSpace = firstDayCurrentMonth.getDayOfWeek().getValue() % 7;
//        3단계. 달력의 상단의 요일 안내 문구 출력
        System.out.println("Su Mo Tu We Th Fr Sa");

        for (int i = 0; i < calculateSpace; i++) {
            System.out.print("   ");
        }


//        4단계. 달력 내용 출력하기
        LocalDate dayCreator = firstDayCurrentMonth;
        while (dayCreator.isBefore(nextMonth)) {
            System.out.printf("%2d ", dayCreator.getDayOfMonth());
            if (dayCreator.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }
//            외부의 날짜 변수를 불러오면 외부 값이 바뀌기에 내부에서 사용할 변수인 데이 크리에이터를 사용하여 작업해야한다.
            dayCreator = dayCreator.plusDays(1);
        }
    }
}