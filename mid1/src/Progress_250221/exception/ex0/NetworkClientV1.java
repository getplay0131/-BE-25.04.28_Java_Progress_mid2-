package Progress_250221.exception.ex0;

public class NetworkClientV1 {
    private final String address;
    private boolean connectError;
    private boolean sendError;

    public NetworkClientV1(String address) {
        this.address = address;
    }

    public String connect() {
        if (connectError) {
            System.out.println(address + "서버 연결 실패");
            return "connect is failed";
        }

        System.out.println(address  + " 서버 연결 성공");
        return "success";
    }

    public String send(String data) {

        if (sendError) {
            System.out.println(address + " 서버에 데이터 전송 실패");
            return "send is failed";
        }
        //        전송 성공
        System.out.println(address + " 서버에 데이터 전송 : " + data);
        return "success";
    }

    public void disconnect() {
        System.out.println(address + " 서버 연결 해제");
    }

    public void initError(String data){
        if (data.contains("error1")) {
            connectError = true;
        }
        if (data.contains("error2")) {
            sendError = true;
        }
    }
}