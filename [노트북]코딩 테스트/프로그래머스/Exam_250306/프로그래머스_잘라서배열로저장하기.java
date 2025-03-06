package Exam_250306;
//문자열 my_str과 n이 매개변수로 주어질 때, my_str을 길이 n씩 잘라서 저장한 배열을 return하도록 solution 함수를 완성해주세요.
public class 프로그래머스_잘라서배열로저장하기 {
    public static void main(String[] args) {
//        1단계. 문자열을 캐릭터 배열로 바꾼 배열도 만들자
//        2단계. 해당 문자열을 매개변수의 값만큼 잘라서 결과 배열에 저장하고, 캐릭터 배열의 값 중 이미 나간 값을 공백으로 마꾸자.
//        3단계. 그 후 스트링 빌더의 값을 결과 배열에 각 요소에 값으로 바꾸자.
//        4단계. 그 후 결과 배열을 출력해서 확인해보자

//        (n+slice-1)/slice;
        String my_str = "abc1Addfggg4556b";
        int n = 6;
        int count = 0;
        StringBuilder builder = new StringBuilder();
        String[] answer = new String[(my_str.length()+6-1) / 6];
        char[] charArray = my_str.toCharArray();
        for (int i = n; i < my_str.length(); n++) {

        }
        for (String s : answer) {
            System.out.println(s);
        }
    }
}