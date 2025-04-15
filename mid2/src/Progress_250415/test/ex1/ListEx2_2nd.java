package Progress_250415.test.ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ListEx2_2nd {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("n개의 정수를 입력하세요. (종료 : 0)");
        while (true){
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                break;
            }
            list.add(value);
        }
        for (int i = 0; i <list.size() ; i++) {
            System.out.print(list.get(i));
            if (i < list.size()-1) {
                System.out.print(", ");
            }
        }
    }
}
