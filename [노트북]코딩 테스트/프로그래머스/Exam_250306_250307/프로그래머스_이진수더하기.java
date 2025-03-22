package Exam_250306_250307;

public class 프로그래머스_이진수더하기 {
    public String solution(String bin1, String bin2) {
        String answer = "";

//        parseInt는 문자열과 진수를 넣어주면 해당 문자열을 진수로 인식한다.
        int num1 = Integer.parseInt(bin1,2);
        int num2 = Integer.parseInt(bin2,2);
        int sum = num1+num2;
//        10진수를 2진수로 변환하는 함수이다.
        answer = Integer.toBinaryString(sum);
        System.out.println("answer = " + answer);
        return answer;
    }

    public static void main(String[] args) {
        String bin1 = "1001";
        String bin2 = "1111";

        int num1 = Integer.parseInt(bin1,2);
        int num2 = Integer.parseInt(bin2,2);
        int sum = num1+num2;
        String answer = "";
        answer = Integer.toBinaryString(sum);
        System.out.println("answer = " + answer);
    }
}