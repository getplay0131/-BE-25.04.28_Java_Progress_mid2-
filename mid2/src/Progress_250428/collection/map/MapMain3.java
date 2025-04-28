package Progress_250428.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MapMain3 {
    public static void main(String[] args) {
        Map<String, Integer> studentMap = new HashMap<>();
        String studentA = "studentA";

        studentMap.put(studentA,50);
        System.out.println(studentMap);

        if (!studentMap.containsKey(studentA)) {
            studentMap.put(studentA,100);
        }
        System.out.println(studentMap);

        studentMap.putIfAbsent(studentA,100);
        studentMap.putIfAbsent("studentB",100);
        System.out.println(studentMap);
    }
}