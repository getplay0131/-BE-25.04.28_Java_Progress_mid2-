package Progress_250415.test.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListEx2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integers = new ArrayList<>();
        System.out.println("n개의 정수를 입력하세요 (종료 0)");
        while (true){
        int inputValue = Integer.parseInt(reader.readLine());
            if (inputValue != 0) {
            integers.add(inputValue);
            } else {
                break;
            }
        }

        for (int i = 0; i < integers.size(); i++) {
            System.out.print(integers.get(i));
            if (i < integers.size() - 1) {
            System.out.print(", ");
            }
        }
    }
}
