package Progress_Exam_250212;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.DayOfWeek;
import java.time.LocalDate;

public class TestCalanderPrinter {
    public static void main(String[] args) throws Exception {
        int check = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] splitStr = new String[2];
        while (check != 2) {
            System.out.println("확인할 연도와 월을 입력해주세요 : ");
            String yearAndMonth = reader.readLine();
            if (yearAndMonth.contains(" ")) {
                splitStr = yearAndMonth.split(" ");
            } else if (yearAndMonth.contains("-")) {
                splitStr = yearAndMonth.split("-");
            } else if (yearAndMonth.contains(".")) {
                splitStr = yearAndMonth.split("\\.");
            }
            int[] yearMonthArr = shapeConversion(splitStr);
            printCalander(yearMonthArr);

            System.out.println();

            System.out.print("프로그램을 종료하시겠습니까? (1 : 종료 안함, 2 : 종료)");
            int checkInput = Integer.parseInt(reader.readLine());
            check = checkInput;
        }

    reader.close();
    }

    public static int[] shapeConversion(String[] arrays) {
        int[] intArr = {Integer.parseInt(arrays[0]), Integer.parseInt(arrays[1])};
        return intArr;
    }

    public static void printCalander(int[] arr) {
        LocalDate currentMonthDay = LocalDate.of(arr[0], arr[1], 1);
        LocalDate nextMonths = currentMonthDay.plusMonths(1);

        System.out.println("Su Mo Tu We Th Fr Sa");

        int calculateSpace = currentMonthDay.getDayOfWeek().getValue() & 7;

        for (int i = 0; i < calculateSpace; i++) {
            System.out.print("   ");
        }

        LocalDate printDays = currentMonthDay;
        while (printDays.isBefore(nextMonths)) {
            System.out.printf("%2d ", printDays.getDayOfMonth());
            if (printDays.getDayOfWeek() == DayOfWeek.SATURDAY) {
                System.out.println();
            }
            printDays = printDays.plusDays(1);
        }

    }
}
