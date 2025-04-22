package Progress_250422.collection.set;


import Progress_250422.collection.set.member.Member;

public class MyHashSetV2Main2 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(10);
        Member hi = new Member("hi");
        Member JPA = new Member("JPA");
        Member java = new Member("java");
        Member spring = new Member("spring");

        System.out.println("set = " + set);

        System.out.println("\"hi\".hashCode() = " + "hi".hashCode());
        System.out.println("\"JPA\".hashCode() = " + "JPA".hashCode());
        System.out.println("\"java\".hashCode() = " + "java".hashCode());
        System.out.println("\"spring\".hashCode() = " + "spring".hashCode());

        set.add(hi);
        set.add(JPA);
        set.add(java);
        set.add(spring);
        System.out.println("set = " + set);



//        검색
        Member searchValue = new Member("JPA");
        boolean result = set.contains(searchValue);
        System.out.println("set.contains(" + searchValue + ") = " + result);

    }


}
