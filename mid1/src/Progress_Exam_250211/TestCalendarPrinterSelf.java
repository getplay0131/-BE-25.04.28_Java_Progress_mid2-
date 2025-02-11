package Progress_Exam_250211;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;

//이 예제는 사용자에게 연도와 월을 입력받아서 해당 월을 달력 형식으로 출력해야 한다

//위에 요일은 프린트 문으로 지정하며 하단에 줄바꿈 하며 달을 출력해야한다.
//템포럴어드저스터를 이용해야한다.
//그리고 로컬데이트의 데이오브위크를 이용해야한다.


public class TestCalendarPrinterSelf {
    public static void main(String[] args) throws Exception {
//단계별 구현 기능

//1단계. 사용자에게 월과 연도 입력 받기
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int check = 0;
        while (check != 2) {
            System.out.print("확인할 년도를 입력해주세요 : ");
            int year = Integer.parseInt(reader.readLine());

            System.out.print("확인할 월(을)를 입력해주세요 : ");
            int month = Integer.parseInt(reader.readLine());
            System.out.println("입력하신 연도는 " + year + "년도 이며, 월은 " + month + "월 입니다.");
            printCalnder(year, month);
            System.out.println();
            System.out.print("프로그램을 다시 시작하시겠습니까?(1은 다시 시작, 2는 종료): ");
            int checkNum = Integer.parseInt(reader.readLine());
            check = checkNum;
            if (check == 2) {
                System.out.println("프로그램을 종료합니다");
            }
        }
    }

    public static void printCalnder(int year, int month) {
//2단계. 월의 첫 일과 다음 달의 첫 일을 구하기.
        LocalDate firstDayOfMonth = LocalDate.of(year, month, 1);
        LocalDate nextMonths = firstDayOfMonth.plusMonths(1);
//3단계. 프린트문으로 요일 지정하기
        System.out.println("Su Mo Tu We Th Fr Sa");

        //4단계. 반복문을 이용하여 공백 만들기
        int offsetDayOfWeek = firstDayOfMonth.getDayOfWeek().getValue() % 7 ;

//        공백 생성을 위한 수 가져오기 및 만들기
        for (int i = 0; i < offsetDayOfWeek; i++) {
            System.out.print("   ");
        }

//5단계. 일 제작 변수 만들기
        LocalDate dayCreator = firstDayOfMonth;
//6단계. 반복문을 이용하여 다음달 전까지 조건을 설정
    while (dayCreator.isBefore(nextMonths)){
//7단계. 반복문 내에서 프린트에프를 이용하여 형식을 지정하고 월의 일을 가져오기
//            두자리에 맞춰서 형식 지정 숫자를 뒤에 작성 되게끔
//        %2d : 2자리보다 작으면 여백을 추가해서 2자리를 확보한다.
        System.out.printf("%2d ", dayCreator.getDayOfMonth());
//8단계. 만약 가져온 요일이 토요일이라면 줄 바꿈 하기 (주의 요일 이넘 클래스 이용)
        if (dayCreator.getDayOfWeek() == DayOfWeek.SATURDAY) {
            System.out.println();
        }
//9단계. 하루씩 더하기
        dayCreator = dayCreator.plusDays(1);
    }



    }
}

