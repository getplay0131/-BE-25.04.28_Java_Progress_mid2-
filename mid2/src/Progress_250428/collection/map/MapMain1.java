package Progress_250428.collection.map;

import java.util.*;

public class MapMain1 {
    public static void main(String[] args) {
        HashMap<String, Integer> studentmap = new HashMap<>();

        studentmap.put("studentA", 90);
        studentmap.put("studentB", 80);
        studentmap.put("studentC", 80);
        studentmap.put("studentD", 100);
        System.out.println(studentmap);

        System.out.println("keySet 활용");
        Set<String> keySet = studentmap.keySet();
        for (String key : keySet) {
            Integer value = studentmap.get(key);
            System.out.println("key  = " + key + ", value = " + value);
        }

        System.out.println("entrySet 활용");
        Set<Map.Entry<String,Integer>> entries = studentmap.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key  = " + key + ", value = " + value);
        }

        System.out.println("values 활용");
        Collection<Integer> values = studentmap.values();
        for (Integer value : values) {
            System.out.println("value = " + value);
        }

    }
}