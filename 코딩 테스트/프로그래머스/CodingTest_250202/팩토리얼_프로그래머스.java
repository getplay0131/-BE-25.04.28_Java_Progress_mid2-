package CodingTest_250202;
//이 문제는:
//
//주어진 숫자가 있고
//1부터 차례대로 곱해가면서
//주어진 숫자를 넘지 않는 선에서
//가장 가까운 팩토리얼을 만드는 수를 찾으면 됩니다
public class 팩토리얼_프로그래머스 {
    public int solution(int n) {
        int factorial = 1;
        int answer = 0;
        for (int i = 1; factorial <= n; i++) {
            factorial *= i;
            answer = i-1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 7;
        int factorial = 1;
        int answer = 0;
        for (int i = 1; factorial <= n; i++) {
            factorial *= i;
            answer = i-1;
        }
        System.out.println(factorial);
    }
}
