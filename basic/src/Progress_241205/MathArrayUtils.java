package Progress_241205;

public class MathArrayUtils {
private static int sum;
private static int ave;
private static int min;
private static int max;

//인스턴스 생성 막기
private MathArrayUtils(){

}
    public static int sum(int[] sums){
//        for (int i = 0; i < sums.length; i++) {
//            sum += sums[i];
//        }
        for (int num : sums) {
            sum += num;
        }
        return sum;
    }
public static double ave(int[] sums){
//    for (int i = 0; i < sums.length; i++) {
//        ave = sum / sums.length;
//    }
    return (double) sum(sums) / sums.length;
//    return ave;
    }

    public static int min(int[] sums){
//        for (int i = 0; i < sums.length; i++) {
//            min = Math.min(sums[0],sums[i]);
//        }
        int min = sums[0];
        for (int num : sums) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static int max(int[] sums){
    int max = sums[0];
    //        for (int i = 0; i < sums.length; i++) {
//            max = Math.max(sums[0],sums[i]);
//        }
        for (int num : sums) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }


}