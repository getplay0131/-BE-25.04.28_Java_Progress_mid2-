package Progress_250415.test.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListEx3 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integers = new ArrayList<>();
        int total = 0;

        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true){
        int inputValue = Integer.parseInt(reader.readLine());
            if (inputValue != 0) {
            integers.add(inputValue);
            } else {
                break;
            }
        }

        for (Integer integer : integers) {
            total += integer;
        }

        double ave = (double)(total / integers.size());
        System.out.println("입력한 정수의 합계 : " + total);
        System.out.println("입력한 정수의 평균 : " + ave);
    }
}
