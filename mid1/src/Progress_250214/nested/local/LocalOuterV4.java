package Progress_250214.nested.local;

import java.lang.reflect.Field;

public class LocalOuterV4 {
private int outInstanceVar = 3;

public Printer process(int paramVar){
    int localVar = 1; // 스택 프레임, 즉 메서드와 함께 제거된다.
    class LocalPrinter implements Printer{
        int value = 0;

        @Override
        public void print() {
            System.out.println("value = " + value);

//          지역 변수보다는 더 오래 숨쉰다.
            System.out.println("localVar = " + localVar);
            System.out.println("paramVar = " + paramVar);

//            가장 길게 숨쉰다.
            System.out.println("outInstanceVar = " + outInstanceVar);
        }
    }

    LocalPrinter printer = new LocalPrinter();
//    printer.print();
//    localVar = 10; // 컴파일 오류
//    paramVar = 20; // 컴파일 오류
    return printer;
}

    public static void main(String[] args) {
        LocalOuterV4 localOuter = new LocalOuterV4();
        Printer printer = localOuter.process(2);
//        printer.print(); 를 나중에 실행한다. 프로세스 메서드의 스택 프레임이 사라진 이후에 실행
        printer.print();

        System.out.println("필드 확인");
        Field[] fields = printer.getClass().getDeclaredFields();
        for (Field field : fields) {
            System.out.println("field = " + field);
        }
    }
}