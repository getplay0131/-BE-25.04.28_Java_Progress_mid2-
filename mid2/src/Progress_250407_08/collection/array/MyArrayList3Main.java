package Progress_250407.collection.array;

public class MyArrayList3Main {
    public static void main(String[] args) {
        MyArrayListV3 list = new MyArrayListV3(2);
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(list);

//        원하는 위치에 추가
        System.out.println("2번째에 요소 추가");
        list.add("addMiddle",2);
        System.out.println(list);

//        앞에 추가
        System.out.println("앞에 추가");
        list.add("addFirst",0);
        System.out.println(list);

//        뒤에 추가
        System.out.println("뒤에 추가");
        list.add("addLast");
        System.out.println(list);

//        삭제
        System.out.println("삭제 1");
        list.remove(list.getSize());
        System.out.println(list);

        System.out.println("삭제 2");
        list.remove(0);
        System.out.println(list);

//        list.add("e");
//        list.add("f");

    }
}
