package Progress_250225.exception.basic.checked;

public class Client {
    public void call()throws MyCheckedException{
//        예외를 던진다는 의미
        throw new MyCheckedException("ex");
    }
}