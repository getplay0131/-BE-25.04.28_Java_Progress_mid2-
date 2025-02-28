package Progress_250226.exception.ex2;

public class NetworkClientExceptionV2 extends Exception{
    private String errorCode;

    public NetworkClientExceptionV2(String errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}