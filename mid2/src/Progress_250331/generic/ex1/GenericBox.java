package Progress_250331.generic.ex1;

public class GenericBox<T>
//    T == 타입 매개변수라고 한다. 이 매개변수는 추후 인티저나 스트링으로 변할 수 있다.
{
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
