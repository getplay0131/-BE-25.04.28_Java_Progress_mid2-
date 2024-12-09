package Progress_241205;

public class DecoMain2 {
public static void main(String[] args) {
    String s = "hello java";
//    DecoUtil1 decoUtil1 = new DecoUtil1();
    String deco = DecoUtil2.deco(s);



    System.out.println("before : " + s);
    System.out.println("after : " + deco);
}
}

