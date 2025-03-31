package Progress_250331.generic.ex1;

public class BoxMain3 {
    public static void main(String[] args) {
        // 생성 시점에 T의 타입 결정
        GenericBox<Integer> integerBox = new GenericBox<Integer>();
        integerBox.setValue(10);
//        integerBox.setValue("문자100"); // 인티저 타입만 허용, 컴파일 오류
        Integer integer = integerBox.getValue();
        System.out.println("integer = " + integer);


        GenericBox<String> stringBox = new GenericBox<>();
        stringBox.setValue("hello");
        String str = stringBox.getValue();
        System.out.println("str = " + str);

        GenericBox<Double> doubleBox = new GenericBox<>();
    doubleBox.setValue(10.1);
        Double doubleBoxValue = doubleBox.getValue();
        System.out.println("doubleBoxValue = " + doubleBoxValue);

//        타입 추론 : 생성하는 제네릭 타입 생략 가능
        GenericBox<Integer> integerBox2 = new GenericBox<>();
    }
}
