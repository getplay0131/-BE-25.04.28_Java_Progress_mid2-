package Exam_250321;
//문제 설명
//정수 배열 num_list와 정수 n이 매개변수로 주어집니다. num_list를 다음 설명과 같이 2차원 배열로 바꿔 return하도록 solution 함수를 완성해주세요.
//
//num_list가 [1, 2, 3, 4, 5, 6, 7, 8] 로 길이가 8이고 n이 2이므로 num_list를 2 * 4 배열로 다음과 같이 변경합니다. 2차원으로 바꿀 때에는 num_list의 원소들을 앞에서부터 n개씩 나눠 2차원 배열로 변경합니다.

import java.util.Arrays;

public class 프로그래머스_2차원으로만들기 {
    public int[][] solution(int[] num_list, int n) {
        //        2차원 배열을 선언하고, 크기를 행은 매개변수로 나눈 목, 열은 매개변수 만큼 선언한다.
        int[][] answer = new int[num_list.length / n][n];
//        배열의 시작 위치를 잡기 위해 인덱스로 사용할 변수를 선언한다.
        int idx = 0;

//        == 보통의 2중 반복문 로직
//        for (int i = 0; i < num_list.length / n; i++) {
//            for (int j = 0; j < n; j++) {
//                answer[i][j] = num_list[idx++];
//            }
//        }

//         == 연산자를 이용한 단일 반복문사용 로직!
        for (int i = 0; i < num_list.length; i++) {
            answer[i / n][i % n] = num_list[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 2;
//        2차원 배열을 선언하고, 크기를 행은 매개변수로 나눈 목, 열은 매개변수 만큼 선언한다.
        int[][] answer = new int[num_list.length / n][n];
//        배열의 시작 위치를 잡기 위해 인덱스로 사용할 변수를 선언한다.
        int idx = 0;
//        내 풀이
//        for (int i = 0; i < num_list.length / n; i++) {
//            for (int j = 0; j < n; j++) {
//                answer[i][j] = num_list[idx++];
//            }
//        }
//        다른 사람의 풀이
        for (int i = 0; i < num_list.length / n; i++) {
//            int num1 = i / n;
//            int num2 = i % n;
//            answer[num1][num2] = num_list[i];
            answer[i / n][i % n] = num_list[i];
        }
        for (int[] ints : answer) {
            System.out.print(Arrays.toString(ints));
        }
    }
}