package Progress_250402.generic.test.ex3.unit;

public class UnitPrinter {

    public static  <T extends BioUnit> void printV1(Shuttle<T> shuttle){
        System.out.println("이름 : " + shuttle.getTarget().getName() + ", HP : " + shuttle.getTarget().getHp());
    }

    public static void printV2(Shuttle<? extends BioUnit> shuttle){
        System.out.println("이름 : " + shuttle.getTarget().getName() + ", HP : " + shuttle.getTarget().getHp());
    }
}
