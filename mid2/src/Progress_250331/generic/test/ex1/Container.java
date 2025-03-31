package Progress_250331.generic.test.ex1;

public class Container<Type> {
    private Type value;

    public Type getValue() {
        return value;
    }

    public void setValue(Type value) {
        this.value = value;
    }

    public boolean isEmpty(){
        if (value == null) {
            return true;
        }

        if (value instanceof String str) {
            if (str.isEmpty()){
                System.out.println("문자열 공백임.");
                return true;
            }
        }
        return false;
    }
}
