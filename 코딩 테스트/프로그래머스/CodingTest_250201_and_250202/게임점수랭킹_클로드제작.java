package CodingTest_250201_and_250202;
//문제 설명:
//온라인 게임에서 플레이어들의 점수를 기준으로 랭킹을 매기려고 합니다.
//각 플레이어의 ID는 입력 배열의 인덱스(0부터 시작)이며,
//높은 점수부터 1등으로 매깁니다.
//동점의 경우 랭킹은 동일하게 부여됩니다.
public class 게임점수랭킹_클로드제작 {
    public int [] solution(int[] scores){
        int [] answer = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            answer[i] = gradeCalculate(scores,i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] scores = {2100, 4500, 2100, 4500, 123};
        int [] answer = new int[scores.length];
        for (int i = 0; i < scores.length; i++) {
            answer[i] = gradeCalculate(scores,i);
        }
        for (int i : answer) {
            System.out.println(i);
        }
    }

    public static int gradeCalculate(int [] arr, int idx) {
        int grade = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[idx] < arr[i]) {
                grade++;
            }
        }
        return grade;
    }

}


