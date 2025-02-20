package Progress_250220.nested.test3nd;

public class OuterClass4Main {
    public static void main(String[] args) {
        Hello hello = new Hello() {
            @Override
            public void helloMsg() {
                System.out.println("이것은 익명 클래스 임다");
            }
        };
    hello.helloMsg();
    }
}
