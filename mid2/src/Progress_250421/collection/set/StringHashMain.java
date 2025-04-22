package Progress_250421.collection.set;


public class StringHashMain {
    static final int CAPACITY = 10;

    public static void main(String[] args) {
        char charA = 'A';
        char charB = 'B';
        System.out.println(charA + " = " + (int)charA);
        System.out.println(charB + " = " + (int)charB);

//        hashcode
        System.out.println("hashCode(A) = " + hashCode("A"));
        System.out.println("hashCode(B) = " + hashCode("B"));
        System.out.println("hashCode(AB) = " + hashCode("AB"));
        System.out.println("hashCode(C) = " + hashCode("C"));

//        hashIndex
        System.out.println("hashCode(A) = " + hashIndex(hashCode("A")));
        System.out.println("hashCode(B) = " + hashIndex(hashCode("B")));
        System.out.println("hashCode(AB) = " + hashIndex(hashCode("AB")));
        System.out.println("hashCode(C) = " + hashIndex(hashCode("C")));
    }

    static int hashIndex(int a) {
    return a % CAPACITY;

    }

    static int hashCode(String a) {
        char[] charArray = a.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum += c;
        }
return sum;
    }
}