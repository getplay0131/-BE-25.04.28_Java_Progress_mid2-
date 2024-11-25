package ref;

public class Check_variable_value {
    public static void main(String[] args) {
    int a = 10;
    int b = a;
        System.out.println("a = " + a + ", b = " + b);
    a = 15;
        System.out.println("a = " + a + ", b = " + b);
    b = a;
        System.out.println("a = " + a + ", b = " + b);

    }
}