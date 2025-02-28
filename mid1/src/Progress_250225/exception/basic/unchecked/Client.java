package Progress_250225.exception.basic.unchecked;

public class Client {
public void call(){
    throw new MyUncheckedException("ex");
}
}