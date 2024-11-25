package ref;

public class NullMain2 {
    public static void main(String[] args) {
    Data data = null; //참조값이 null임
        data.value = 10; // 이 코드는 참조값이 null인 객체에 값을 사용하려 하는 중임
        System.out.println("data = " + data.value);
    }
}