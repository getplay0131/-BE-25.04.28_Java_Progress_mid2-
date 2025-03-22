package Exam_250306_250307;

//문제 설명
//머쓱이는 친구들과 동그랗게 서서 공 던지기 게임을 하고 있습니다. 공은 1번부터 던지며 오른쪽으로 한 명을 건너뛰고 그다음 사람에게만 던질 수 있습니다. 친구들의 번호가 들어있는 정수 배열 numbers와 정수 K가 주어질 때, k번째로 공을 던지는 사람의 번호는 무엇인지 return 하도록 solution 함수를 완성해보세요.
public class 프로그래머스_공던지기 {
    public int solution(int[] numbers, int k) {
        int answer = 0;
//        이동할 때 옆 친구가 아닌 옆에 옆친구로 이동하므로 2포인트씩 이동한다.
        int movePoint = 2;
//        이동시 매개변수의 -1 한 값을 이동 포인트에 곱해야 순서대로 던지게 된다. 그 이유는 만약 k가 2라면 1번이 3번한테 던지고, 3번이 두번째로 던지게 되므로 3이 리턴되는 것이다.
        int moveIdx = movePoint * (k - 1);
//        만약 이동 해야하는 인덱스가 친구들의 수보다 크다면
        if (moveIdx >= numbers.length) {
//            결과값에서 배열 요소의 개수를 빼면 던질 친구의 위치를 찾게 된다.
//           이 과정에서 빼는것이 아니라 나머지 연산으로 인덱스 내에 위치하게 해야한다 > ai 조언
            answer = numbers[moveIdx % numbers.length];
        } else {
//            크지 않다면 공을 던질 친구의 위치는 이동 횟수를 통해서 구할 수 있다.
            answer = numbers[moveIdx];
        }
        System.out.println(answer);
        return answer;
    }
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int k = 5;
        int answer = 0;
//        이동할 때 옆 친구가 아닌 옆에 옆친구로 이동하므로 2포인트씩 이동한다.
        int movePoint = 2;
//        이동시 매개변수의 -1 한 값을 이동 포인트에 곱해야 순서대로 던지게 된다. 그 이유는 만약 k가 2라면 1번이 3번한테 던지고, 3번이 두번째로 던지게 되므로 3이 리턴되는 것이다.
        int moveIdx = movePoint * (k - 1);
//        만약 이동 해야하는 인덱스가 친구들의 수보다 크다면
        if (moveIdx >= numbers.length) {
//            결과값에서 배열 요소의 개수를 빼면 던질 친구의 위치를 찾게 된다.
            answer = numbers[moveIdx - numbers.length];
        } else {
//            크지 않다면 공을 던질 친구의 위치는 이동 횟수를 통해서 구할 수 있다.
            answer = numbers[moveIdx];
        }
        System.out.println(answer);
    }
}