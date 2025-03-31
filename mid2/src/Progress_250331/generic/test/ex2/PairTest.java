package Progress_250331.generic.test.ex2;

public class PairTest {
    public static void main(String[] args) {
        Pair<Integer, String> pair1 = new Pair<>();

        pair1.setValue1(1);
        pair1.setValue2("data");
        System.out.println(pair1.getValue1());
        System.out.println(pair1.getValue2());
        System.out.println("pair1 = " + pair1);

        Pair<String, String>pair2 = new Pair<>();
        pair2.setValue1("key");
        pair2.setValue2("value");
        System.out.println(pair2.getValue1());
        System.out.println(pair2.getValue2());
        System.out.println("pair2 = " + pair2);

    }

}
