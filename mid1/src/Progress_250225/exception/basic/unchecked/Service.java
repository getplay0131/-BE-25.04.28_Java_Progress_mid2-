package Progress_250225.exception.basic.unchecked;

//언체크는 예외를 잡지 않으면 자동으로 밖으로 던진다.
public class Service {
Client client = new Client();

public void callCatch(){
    try {
        client.call();
    } catch (MyUncheckedException e){
        System.out.println( "예외 처리, message = "+ e.getMessage());
    }
    System.out.println("정상 로직");
}

//예외 잡는게 필수가 아니다. 자연스럽게 상위로 넘어간다.
    public void callThrow(){
    client.call();
    }
}