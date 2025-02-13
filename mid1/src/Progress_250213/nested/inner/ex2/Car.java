package Progress_250213.nested.inner.ex2;

public class Car {
    private String model;
    private int chageLevel;
    private Engine engine;

    public Car(String model, int chageLevel) {
        this.model = model;
        this.chageLevel = chageLevel;
        this.engine = new Engine();
    }


    public void start(){
        engine.start();
        System.out.println(model + "시작 준비 완료");
    }

    private class Engine{
        public void start(){
            System.out.println(model+ "의 충전 레벨은 " + chageLevel + "입니다.");
            System.out.println(model + "의 엔진을 구동합니다.");
        }
    }
}