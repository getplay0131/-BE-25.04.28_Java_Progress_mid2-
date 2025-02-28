package Progress_250227.exception.ex4.exception;


import Progress_250227.exception.ex3.exception.NetworkClientExceptionV3;

public class ConnectExceptionV4 extends NetworkClientExceptionV4 {
    private final String address;

    public ConnectExceptionV4(String address, String message) {
        super(message);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}