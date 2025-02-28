package Progress_250221.exception.ex0;

import java.util.Scanner;

public class MainV1_2 {
    public static void main(String[] args) {
        NetworkServiceV1_2 service = new NetworkServiceV1_2();

        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.print("전송할 문자 : ");
            String input = scanner.nextLine();
            if (input.equals("exit")){
                break;
            }
            service.sendMessage(input);
            System.out.println();
        }
        System.out.println("프로그램을 정상 종료합니다.");
    }
}