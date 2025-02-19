package Progress_250218.nested.anomymous.ex;

public class Ex0RefMain {


    public static void printMsg(String msg){
        System.out.println("프로그램 시작");
        System.out.println("Hello " + msg + "!");
        System.out.println("프로그램 종료");
        System.out.println("==========");
    }

    public static void main(String[] args) {
        printMsg("Java");
        printMsg("Spring");
    }
}