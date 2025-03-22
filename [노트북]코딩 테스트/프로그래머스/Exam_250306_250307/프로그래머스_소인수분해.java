package Exam_250306_250307;

//소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다. 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수는 2와 3입니다. 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
public class 프로그래머스_소인수분해 {

    public static void main(String[] args) {
        int n = 420;
        int count = 0;
        int[] answer = {};
        final int PARAMSQRT = (int) Math.sqrt(n);
        int[] tempArr = new int[PARAMSQRT];

        for (int i = 2; i <= PARAMSQRT; i++) {
            while (n % i == 0) {
                boolean isDuplicate = false;
                for (int j = 0; j < tempArr.length; j++) {
                    if (tempArr[j] == i) {
                        isDuplicate = true;
                        break;
                    }

                }
                if (!isDuplicate) {
                    tempArr[count++] = i;
                }
                n /= i;
            }
        }
//        결과 배열에 옮기기 전에 소수에 대한 조건으로 검사하고 그 이후에 넣어야 로직이 올바르게 돌아간다.
        if (n > 1 && tempArr[count] == 0) {
            tempArr[count++] = n;
        }
        answer = new int[count];
        for (int i = 0; i < count; i++) {
            answer[i] = tempArr[i];
        }


        for (int i : answer) {
            System.out.println(i);
        }
    }
}
