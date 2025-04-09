package Progress_250407_08.collection.array;

import java.util.ArrayList;

public class MyArrayList4Main {
    public static void main(String[] args) {
       MyArrayListV4<String > strList = new MyArrayListV4<>(2);
        strList.add("a");
        strList.add("b");
        strList.add("c");
        String str = strList.get(0);
        System.out.println("str = " + str);

        MyArrayListV4<Integer> intList = new MyArrayListV4<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Integer integer = intList.get(0);
        System.out.println("integer = " + integer);

    }
}
