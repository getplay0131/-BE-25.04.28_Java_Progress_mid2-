package Progress_250423.collection.set.test;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class UniqueNamesTest1 {
    public static void main(String[] args) {
        Integer[] inputArr =  {30,20,20,10,10};
//        LinkedHashSet<Integer> set = new LinkedHashSet<>();
//        for (Integer i : inputArr) {
//            set.add(i);
//        }
//
//        Iterator<Integer> iterator = set.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next() + " ");
//        }
//        System.out.println();
//        -=----------------------------------------


                Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < inputArr.length ; i++) {
            set.add(inputArr[i]);
        }
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext()){
                System.out.println(iterator.next() + " ");
            }
            System.out.println();
    }
}