package Progress_250422.collection.set;


public class MyHashSetV3Main {
    public static void main(String[] args) {
        MyHashSetV3 set = new MyHashSetV3(10);

        set.add("A");
        set.add("B");
        set.add("C");

        System.out.println("set = " + set);

//        검색
        String searchValue = "A";
        boolean result = set.contain(searchValue);
        System.out.println("set.contains(" + searchValue + ") = " + result);

    }


}
