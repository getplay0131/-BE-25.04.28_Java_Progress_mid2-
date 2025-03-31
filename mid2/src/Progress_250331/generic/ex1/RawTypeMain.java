package Progress_250331.generic.ex1;

public class RawTypeMain {
    public static void main(String[] args) {
//        로타입은 원시타입이라고도 부르며, 내부의 타입 매개변수가 Object
        GenericBox integerBox = new GenericBox();
//        보통 아래와 같이 우리가 배운 타입으로 구현하길 권장한다.
        GenericBox<Object> objectGenericBox = new GenericBox<>();
        integerBox.setValue(10);
        Integer result = (Integer)integerBox.getValue();
        System.out.println("result = " + result);
    }
}
