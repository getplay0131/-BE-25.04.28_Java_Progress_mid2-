package Progress_250428.collection.map;

import java.util.HashMap;

public class MapMain2 {
    public static void main(String[] args) {
        HashMap<String, Integer> studentMap = new HashMap<>();

        String studentA = "studentA";

        studentMap.put(studentA,90);
        System.out.println(studentMap);

        studentMap.put(studentA,100); // 같은 키라면 값은 덮어씌워진다. 그래서 이전 값이 필요할시 별도로 백업 해야 한다.
        System.out.println(studentMap);

        boolean containsKey = studentMap.containsKey(studentA);
        System.out.println("containsKey = " + containsKey);

        studentMap.remove(studentA);
        System.out.println(studentMap);
    }
}