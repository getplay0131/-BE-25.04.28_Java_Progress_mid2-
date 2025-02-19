package Progress_250219.nested.annoymous.ex;

import java.util.Random;

public class Ex1RefMainV3 {
    public static void hello(Process process){
        System.out.println("프로그램 시작");
        process.run();
        System.out.println("프로그램 종료");

    }

    public static void main(String[] args) {

        Process dice = new Process() {
            public void run() {
                int randomValue = new Random().nextInt(6) + 1;
                System.out.println("주사위  = " + randomValue);
            }
        };

        Process sum = new Process() {
            public void run() {
                for (int i = 1; i <= 3; i++) {
                    System.out.println("i = " + i);
                }
            }
        };
//        v2 익명 클래스
        dice.run();
        sum.run();
    }
}