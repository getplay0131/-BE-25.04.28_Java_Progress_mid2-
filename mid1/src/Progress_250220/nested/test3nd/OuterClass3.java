package Progress_250220.nested.test3nd;

public class OuterClass3 {
    public void innerMethod(){
        class LocalClass{
            public void hello(){
                System.out.println("지역 클래스 임다");
            }
        }
        new LocalClass().hello();
    }
}
