package Progress_250225.exception.basic.checked;
//Exception을 상속받으면 체크 예외가 된다.
//예외를 상속 받음
public class MyCheckedException extends Exception{
    public MyCheckedException(String message){
        super(message);
    }
}