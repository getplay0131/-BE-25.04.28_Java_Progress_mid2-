package Exam_250222;
//머쓱이는 행운의 숫자 7을 가장 좋아합니다. 정수 배열 array가 매개변수로 주어질 때, 7이 총 몇 개 있는지 return 하도록 solution 함수를 완성해보세요.

//1 ≤ array의 길이 ≤ 100
//0 ≤ array의 원소 ≤ 100,000

//내 생각에 방법은 두가지이다.
//1.정수 배열 > 캐릭터 배열 > 값을 비교하거나

//2.나머지 연산자와 나누기 연산자를 이용해 해당 요소를 숫자와 비교하기
public class 프로그래머스_7의개수 {
    //    2번 방법 먼저 시도
//    public int solution(int[] array) {
//        int answer = 0;
//        answer = countSevenNum(array);
//        return answer;
//    }

    public int solution(int[] array) {
        int answer = 0;
        int count = 0;
        for (int i : array) {
            char[] charArray = String.valueOf(i).toCharArray();
            for (char c : charArray) {
                if (c == '7' ) {
                    count++;
                }
            }
        }
        answer = count;
        return answer;
    }

    public static void main(String[] args) {
        int answer = 0;
        int count = 0;
        int[] array = {7, 77, 17};
        for (int i : array) {
            char[] charArray = String.valueOf(i).toCharArray();
            for (char c : charArray) {
                if (c == '7' ) {
                        count++;
                }
            }
        }
        System.out.println(count);
    }


//    public static void main(String[] args) {
//        int answer = 0;
//        int[] array = {7,77,17};
//        answer = countSevenNumRoute2(array);
//        System.out.println(answer);
//    }

//    public static int countSevenNum(int[] intArr) {
//        int num1, num2, num3, num4, num5 = 0;
//        int count = 0;
//        for (int i = 0; i < intArr.length; i++) {
//            if (intArr[i] >= 10000) {
//                num1 = (intArr[i] / 10000) % 10;
//                if (num1 == 7) {
//                    count++;
//                }
//            }
//            if (intArr[i] >= 1000) {
//                num2 = (intArr[i] / 1000) % 10;
//                if (num2 == 7) {
//                    count++;
//                }
//            }
//            if (intArr[i] >= 100) {
//                num3 = (intArr[i] / 100) % 10;
//                if (num3 == 7) {
//                    count++;
//                }
//            }
//            if (intArr[i] >= 10) {
//                num4 = (intArr[i] / 10) % 10;
//                if (num4 == 7) {
//                    count++;
//                }
//            }
//            num5 = intArr[i] % 10;
//            if (num5 == 7) {
//                count++;
//            }
//        }
//        return count;
//    }
    public static int countSevenNumRoute2(int[] intArr) {
        int count = 0;
        for (int i : intArr) {
            while (i > 0){
                if (i % 10 == 7) {
                    count++;
                }
                    i /= 10;
            }
        }
        return count;
    }
}