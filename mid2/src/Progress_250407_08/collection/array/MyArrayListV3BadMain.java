package Progress_250407_08.collection.array;

public class MyArrayListV3BadMain {
    public static void main(String[] args) {
        MyArrayListV3 numList = new MyArrayListV3();

//        숫자만 입력하길 기대하자
        numList.add(1);
        numList.add(2);
        numList.add("문자"); // 문자를 입력
        System.out.println(numList);

//        object 반환으로 다운 캐스팅 필요
        Integer num1 = (Integer) numList.get(0);
        Integer num2 = (Integer) numList.get(1);

        Integer num3 = (Integer) numList.get(2);

    }
}
