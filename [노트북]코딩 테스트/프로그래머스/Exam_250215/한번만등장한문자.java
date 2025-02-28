package Exam_250215;

import java.util.Arrays;

//문자열 s가 매개변수로 주어집니다. s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.
public class 한번만등장한문자 {
    public String solution(String s) {
//        문자열을 캐릭터 배열로 변환
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {
        String answer = "";
        String s = "abcabcadc";
        int count = 1;
        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        System.out.println(answer);
    }
}