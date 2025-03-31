package Progress_250331.generic.ex1;

public class BoxMain2 {
    public static void main(String[] args) {
        ObjectBox integerBox = new ObjectBox();
        integerBox.setValue(10);
        Integer integer = (Integer) integerBox.getValue(); //인티저로 캐스팅
        System.out.println("integer = " + integer);

        ObjectBox StringBox = new ObjectBox();
        StringBox.setValue("hello"); //스트링으로 캐스팅
        String str = (String) StringBox.getValue();
        System.out.println("str = " + str);

        integerBox.setValue("문자100");
        Integer result = (Integer) integerBox.getValue(); //스트링을 인티저로 캐스팅

        System.out.println("result = " + result);

    }
}
