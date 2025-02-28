package Progress_250225.exception.basic.unchecked;

//RuntimeException을 상속 받으면 언체크 예외가 된다.
public class MyUncheckedException extends RuntimeException{
    public MyUncheckedException(String msg){
        super(msg);
    }
}