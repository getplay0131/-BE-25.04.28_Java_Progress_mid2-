package Progress_250227.exception.ex4.exception;

import Progress_250227.exception.ex3.exception.ConnectExceptionV3;
import Progress_250227.exception.ex3.exception.NetworkClientExceptionV3;
import Progress_250227.exception.ex3.exception.NetworkClientV3;

public class NetworkServiceV4 {
    public void sendMessage(String data){
        String address = "http://example.com";
        NetworkClientV4 client = new NetworkClientV4(address);
        client.initError(data);

        try {
            client.connect();
            client.send(data);
        }finally {
            client.disconnect();
        }
    }
}