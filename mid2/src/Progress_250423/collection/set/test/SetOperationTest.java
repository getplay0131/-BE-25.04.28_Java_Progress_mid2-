package Progress_250423.collection.set.test;

import java.util.*;

public class SetOperationTest {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(List.of(1,2,3,4,5));
        Set<Integer> set2 = new HashSet<>(List.of(3,4,5,6,7));

//        합집합 => 완료
//        우선 두 세트를 새로운 세트에 중복 없이 데이터의 순서를 유지해서 출력하면 된다.
        Set<Integer> arr1 = new TreeSet<>();
        arr1.addAll(set1);
        arr1.addAll(set2);
        System.out.println("합집합 : " + arr1);


//        Iterator<Integer> iterator = arr1.iterator();
//        while (iterator.hasNext()){
//            System.out.print(iterator.next() + " ");
//        }
//        System.out.println();

//        교집합
        TreeSet<Integer> and = new TreeSet<>(set1);
        and.retainAll(set2);
        System.out.println("교집합 : " + and);


//        차집합
        TreeSet<Integer> sub = new TreeSet<>(set1);
        sub.removeAll(set2);
        System.out.println("차집합 : " + sub);

    }

    private static Set addSet(Set<Integer> set){
        TreeSet<Integer> arr1 = new TreeSet<>();
        for (int i = 0; i < set.size(); i++) {
            arr1.addAll(set);
        }
        return arr1;
    }
}