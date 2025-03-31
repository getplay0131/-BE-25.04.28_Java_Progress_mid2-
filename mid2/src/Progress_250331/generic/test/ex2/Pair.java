package Progress_250331.generic.test.ex2;

public class Pair<Type1 ,Type2> {

    private Type1 value1;
    private Type2 value2;

    public Type1 getValue1() {
        return value1;
    }

    public void setValue1(Type1 value1) {
        this.value1 = value1;
    }

    public Type2 getValue2() {
        return value2;
    }

    public void setValue2(Type2 value2) {
        this.value2 = value2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
