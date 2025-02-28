package Progress_250221.exception.self.ex0;

import java.util.Scanner;

public class MainV0 {
    public static void main(String[] args) {
        NetworkServiceV0 service = new NetworkServiceV0();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.print("전솔할 데이터 : ");
            String input = scanner.nextLine();
            if (input.equals("exit") || input.equals("종료")) {
                break;
            }
            service.sendMessage(input);
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }
}