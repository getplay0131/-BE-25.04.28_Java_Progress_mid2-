package Progress_241205;

import static Progress_241205.DecoData.*;

public class DecoDataMain {
    public static void main(String[] args) {
        System.out.println("1. 정적 호출");
//        DecoData decoData1 = new DecoData();
        staticCall();

        System.out.println("2. 인스턴스 호출1");
        DecoData decoData = new DecoData();
        decoData.instanceCall();

        System.out.println("3. 인스턴스 호출2");
        DecoData decoData2 = new DecoData();
        decoData2.instanceCall();

//       추가
//        인스턴스를 통한 접근
        DecoData data3 = new DecoData();
        data3.staticCall();

//        클래스를 통한 접근
        staticCall();

        staticCall();
        staticCall();
        staticCall();
        staticCall();
        staticCall();

    }
}