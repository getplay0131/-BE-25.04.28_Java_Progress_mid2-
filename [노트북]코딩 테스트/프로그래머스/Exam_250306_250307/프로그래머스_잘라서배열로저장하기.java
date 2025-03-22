package Exam_250306_250307;

//문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.
public class 프로그래머스_잘라서배열로저장하기 {
    public String[] solution(String my_str, int n) {
        int count = 0;
        int startIdx = 0;
        int endIdx = 0;
//        결과 배열 크기 계산
        String[] answer = new String[(my_str.length() + n - 1) / n];
//        1단계. 매개변수의 문자열을 정수만큼 잘른다. 단 이때 반복문의 인덱스를 정수로 두고, 증가값은 정수만큼 증가하게 한다.
        while (startIdx < my_str.length()) {
            endIdx += n;
//            1.5단계. 종료 인덱스가 문자열의 크기를 벗어남을 감지하는 로직을 구성한다. 벗어나면 반복을 중단시킨다.
            if (endIdx > my_str.length()) {
                break;
            } else {
//            2단계. 결과 배열에 빌더에 원본 문자열에서 값을 추출해서 요소로 설정한다.
                answer[count++] = my_str.substring(startIdx, endIdx);
//            3단계. 새로 시작할 인덱스에 매개 변수의 정수를 더해서 설정한다.
                startIdx += n;
            }
        }
//        5단계. 마지막의 요소를 결과 배열에 추가한다.
        if (endIdx != my_str.length()) {
            answer[answer.length - 1] = my_str.substring(startIdx, my_str.length());
        }
        for (String string : answer) {
            System.out.println(string);
        }
        return answer;
    }

    public static void main(String[] args) {

//        (n+slice-1)/slice;
        String my_str = "abcdef123";
        int n = 3;
        int count = 0;
        int startIdx = 0;
        int endIdx = 0;
//        결과 배열 크기 계산
        String[] answer = new String[(my_str.length() + n - 1) / n];
//        1단계. 매개변수의 문자열을 정수만큼 잘른다. 단 이때 반복문의 인덱스를 정수로 두고, 증가값은 정수만큼 증가하게 한다.
        while (startIdx < my_str.length()) {
            endIdx += n;
//            1.5단계. 종료 인덱스가 문자열의 크기를 벗어남을 감지하는 로직을 구성한다. 벗어나면 반복을 중단시킨다.
            if (endIdx > my_str.length()) {
                break;
            } else {
//            2단계. 결과 배열에 빌더에 원본 문자열에서 값을 추출해서 요소로 설정한다.
                answer[count++] = my_str.substring(startIdx, endIdx);
//            3단계. 새로 시작할 인덱스에 매개 변수의 정수를 더해서 설정한다.
                startIdx += n;
            }
        }
//        5단계. 마지막의 요소를 결과 배열에 추가한다.
        if (endIdx != my_str.length()) {
            answer[answer.length - 1] = my_str.substring(startIdx, my_str.length());
        }
        for (String string : answer) {
            System.out.println(string);
        }
    }


}
