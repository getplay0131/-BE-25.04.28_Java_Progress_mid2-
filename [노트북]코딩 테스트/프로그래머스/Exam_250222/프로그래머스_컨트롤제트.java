package Exam_250222;

//숫자와 "Z"가 공백으로 구분되어 담긴 문자열이 주어집니다. 문자열에 있는 숫자를 차례대로 더하려고 합니다. 이 때 "Z"가 나오면 바로 전에 더했던 숫자를 뺀다는 뜻입니다. 숫자와 "Z"로 이루어진 문자열 s가 주어질 때, 머쓱이가 구한 값을 return 하도록 solution 함수를 완성해보세요.
public class 프로그래머스_컨트롤제트 {
    public int solution(String s) {
        int answer = 0;
        String[] splitStr = s.split(" ");
        int lastNum = 0;
        for (String string : splitStr) {
//        만약 z를 만나면 결과값에서 라스트 넘버의 값을 뺀다.
            if (string.equals("Z")) {
                answer -= lastNum;
            } else {
//        해당 숫자를 라스트넘버의 변수에 저장하여 결과값에 담는다.
                lastNum = Integer.parseInt(string);
//        그 후 다시 해당 값을 결과값에 더한다.
                answer += lastNum;
            }
            System.out.println(answer);
        }
        return answer;
    }
    public static void main(String[] args) {
        String s = "-1 -2 -3 Z";
        String[] splitStr = s.split(" ");
        int lastNum = 0;
        int answer = 0;
        for (String string : splitStr) {
//        만약 z를 만나면 결과값에서 라스트 넘버의 값을 뺀다.
            if (string.equals("Z")) {
                answer -= lastNum;
                System.out.println("lastnum = " + lastNum);
                System.out.println("answer"+answer);
            } else {
//        해당 숫자를 라스트넘버의 변수에 저장하여 결과값에 담는다.
                lastNum = Integer.parseInt(string);
//        그 후 다시 해당 값을 결과값에 더한다.
                answer += lastNum;
                System.out.println("lastnum = " +lastNum);
                System.out.println("answer"+answer);
            }
            System.out.println(answer);
        }
    }
}