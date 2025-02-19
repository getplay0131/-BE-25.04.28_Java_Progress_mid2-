package Progress_250219.nested.test;

public class OuterClass5Main {
    public static void main(String[] args) {
        OuterClass4 outerClass4 = new OuterClass4() {
            @Override
            public void hello() {
                System.out.println("이것은 익명 클래스 입니다.");
            }
        };
        outerClass4.hello();
    }
}