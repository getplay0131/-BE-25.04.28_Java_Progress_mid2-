package ref;

public class VarChange1 {
    public static void main(String[] args) {
        int a = 10;
        int b = a;
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        //a 변경
        a = 20; //값 직접 변경
        System.out.println("변경 a = 20");
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        //b 변경
        b = 30; //값 직접 변경
        System.out.println("변경 b = 30");
        System.out.println("a = " + a);
        System.out.println("b = " + b);

        System.out.println(" ================ ");
//        해당 인덱스의 참조값이 해당 값을 설정
        int [] numArr = {1,2};
        for (int i = 0; i < numArr.length; i++) {
            System.out.println("numArr[" + i + "] = " + numArr[i]);
        }
//        참조값을 바꾸는 것이 아닌 인덱스의 참조 주소로 이동하여, 값을 변경
        numArr[0] = 3;
        for (int i = 0; i < numArr.length; i++) {
            System.out.println("numArr[" + i + "] = " + numArr[i]);
        }
    }
}