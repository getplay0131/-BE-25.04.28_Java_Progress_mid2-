package Progress_250428.collection.map;

import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();

//    데이터 삽입
stack.push(1);
stack.push(2);
stack.push(3);
        System.out.println(stack);

//        최상층 데이터 확인
        System.out.println("stack.peek() = " + stack.peek());

//        데이터 인출
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println(stack);
    }


}
