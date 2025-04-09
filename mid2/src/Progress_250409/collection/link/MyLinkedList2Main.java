package Progress_250409.collection.link;

public class MyLinkedList2Main {
    public static void main(String[] args) {
        MyLinkedListV2 list = new MyLinkedListV2();
//        마지막에 추가하므로 오엔 - 선형시간
        System.out.println("== 데이터 추가 == ");
        System.out.println(list);
        list.add("a");
        System.out.println(list);
        list.add("b");
        System.out.println(list);
        list.add("c");
        System.out.println(list);

//        첫번째에 추가 및 삭제
        System.out.println("== 첫번째에 추가 ==");
        list.add(0, "d");
        System.out.println(list);

     System.out.println("== 첫번째에 삭제 ==");
     list.remove(0); // 첫번째를 지우므로 상수시간이다.
     System.out.println(list);
        
//     중간 항목 삭제 및 추가
        System.out.println("== 중간 항목에 추가 ==");
        list.add(1,"e"); // 중간 추가이므로 오엔 - 선형시간
        System.out.println(list);
        
        list.remove(1); //중간 삭제이므로 오엔 - 선형시간
        System.out.println(list);

        list.add("f");
        System.out.println(list);

    }
}
