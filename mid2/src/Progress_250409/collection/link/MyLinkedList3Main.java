package Progress_250409.collection.link;

public class MyLinkedList3Main {
    public static void main(String[] args) {
        MyLinkedListV3<String> list = new MyLinkedListV3<>();
//        마지막에 추가하므로 오엔 - 선형시간
        System.out.println(list);
        list.add("a");
        list.add("b");
        list.add("c");

        String str = list.get(0);
        System.out.println("str = " + str);

        MyLinkedListV3<Integer> intList = new MyLinkedListV3<>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        Integer integer = intList.get(0);
        System.out.println("integer = " + integer);

    }
}
