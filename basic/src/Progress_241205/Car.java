package Progress_241205;

public class Car {
    private static int count;
    private String name;
    Car(String carName){
        if (carName != null) {
            System.out.println("차량 구입, 모델명 : " + carName);
            this.name = carName;
            count++;
        }
    }

    public static int showTotalCars() {
        System.out.println();
        System.out.println("구매한 자동차 수 : " + count);
    return count;
    }

}