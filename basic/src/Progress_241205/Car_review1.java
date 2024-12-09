package Progress_241205;

public class Car_review1 {
private static int count;
private String name;

  Car_review1 (String name){
      if (name != null) {
          System.out.println("차량 구입, 이름 : " + name);
          this.name = name;
          count++;
      }
}

    public static void showTotalCars() {
        System.out.println();
        System.out.println("구매한 차량 수 : " + count + "대");
//        return count;
    }
}