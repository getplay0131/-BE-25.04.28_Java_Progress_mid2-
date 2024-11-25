package ref;

public class VarChange2 {
    public static void main(String[] args) {
    Data dataA = new Data();
    dataA.value = 10;
Data dataB = dataA; // dataA로 작업한 결과물을 dataB가 공유하고, dataB가 작업한 결과물을 dataA가 공유한다. 즉 결과물을 공유한다.

// 만약 별도로 값을 관리하고 싶다면, 아래의 코드처럼 작성해야 한다.
//        아래의 코드처럼 코드를 구성하면 깊은 복사를 사용해 별도로 값을 관리 할 수 있다.
        //    Data dataB = new Data();
//    dataB.value = dataA.value;

        System.out.println("dataA 참조값=" + dataA);
        System.out.println("dataB 참조값=" + dataB);
        System.out.println("dataA value =" + dataA.value);
        System.out.println("dataB value =" + dataB.value);

    dataA.value = 20;
        System.out.println("변경 dataA.value = 20");
        System.out.println("dataA value =" + dataA.value);
        System.out.println("dataB value =" + dataB.value);

    dataB.value = 30;
        System.out.println("변경 dataB.value = 30");
        System.out.println("dataA value =" + dataA.value);
        System.out.println("dataB value =" + dataB.value);
    }
}