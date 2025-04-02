package Progress_250402.generic.test.ex3.unit;

public class Shuttle <T extends BioUnit>{
    private T target;

    public T getTarget() {
        return target;
    }

    public void setTarget(T target) {
        this.target = target;
    }

    public  void in(T unit){
        setTarget(unit);
    }

    public void showInfo(){
        System.out.println("이름 : " + target.getName() + ", HP : " + target.getHp());
    }
}
