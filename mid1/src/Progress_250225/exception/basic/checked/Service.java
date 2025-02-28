package Progress_250225.exception.basic.checked;

//checked 예외는 던지거나, 처리하거나!
public class Service {
Client client = new Client();

//예외 잡는 코드
    public void callCatch(){
        try {
            client.call();
        } catch (Exception e){
//           예외 처리
            System.out.println("예외 처리, message = " + e.getMessage());
        }
        System.out.println("정상 흐름");
    }
//    체크 예외를 밖으로 던지는 코드
//    밖으로 던지려면 throws를 써야한다.
    public void callThrow() throws MyCheckedException{
        client.call();
    }
}