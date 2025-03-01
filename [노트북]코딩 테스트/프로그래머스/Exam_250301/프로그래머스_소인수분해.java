package Exam_250301;
//소인수분해란 어떤 수를 소수들의 곱으로 표현하는 것입니다. 예를 들어 12를 소인수 분해하면 2 * 2 * 3 으로 나타낼 수 있습니다. 따라서 12의 소인수는 2와 3입니다. 자연수 n이 매개변수로 주어질 때 n의 소인수를 오름차순으로 담은 배열을 return하도록 solution 함수를 완성해주세요.
public class 프로그래머스_소인수분해 {
//    소인수 분해는 해당 수를 구성하는 소수를 나탄내며, 숫자의 제곱으로 표시하는게 원래 구성이나, 이 문제에서는 구성하는 숫자만 반환해야 한다.
//    즉 이를 위해 구성하는 소수를 찾아야 하며 반복문을 이용해 소수를 증가시키며 제곱근의 정수 변환형으로 까지 진행시켜 소수를 찾는다.
//    제곱근은 그 수를 제곱으로 구성하는 수 이므로 제곱근 까지만 구해도 된다.
public static void main(String[] args) {
    int n = 420;
    final int  NUMBERSQRT = (int) Math.sqrt(n);
    int count = 0;
    int [] tempNumArr = new int[NUMBERSQRT];

    for (int i = 2; i <= NUMBERSQRT; i++) {
            boolean duplicateNum = false;
        if (n % i == 0) {
            for (int j = 0; j <count ; j++) {
                if (tempNumArr[j]==i){
                duplicateNum = true;
                break;
                }
            }

            if (!duplicateNum) {
            tempNumArr[count++] = i;
            }
            n /= i;
        }
    }

    int[] answer = new int[count];
    for (int i = 0; i < count; i++) {
        answer[i] = tempNumArr[i];
    }

    for (int i : answer) {
        System.out.println(i + " ");
    }
}
}
