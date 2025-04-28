package Progress_250428.collection.map;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueuqMain {
    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();

//데이터 추가
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue);

//        다음 데이터 조회
        System.out.println("queue.peek() = " + queue.peek());

//        데이터 꺼내기
        System.out.println("poll = " + queue.poll());
        System.out.println("poll = " + queue.poll());
        System.out.println("poll = " + queue.poll());
        System.out.println(queue);

    }
}
