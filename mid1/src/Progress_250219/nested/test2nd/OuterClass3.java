package Progress_250219.nested.test2nd;

public class OuterClass3 {
        public void method(){

            class LocalClass{
                public void hello(){
                    System.out.println("지역 클래스 입니다.");
                }
            }
            LocalClass localClass = new LocalClass();
            localClass.hello();
        }
}
