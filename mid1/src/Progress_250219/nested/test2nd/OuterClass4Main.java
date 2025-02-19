package Progress_250219.nested.test2nd;

public class OuterClass4Main {
    public static void main(String[] args) {

        Hello hello = new Hello() {
            public void hello() {
                System.out.println("익명 클래스 입니다.");
            }
        };
hello.hello();

    }
}
