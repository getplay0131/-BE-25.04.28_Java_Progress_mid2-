package Progress_250213.nested.ex1;

public class Network {

    public void sendMessage(String text){
        NetworkMessage networkMessage = new NetworkMessage(text);
        networkMessage.print();
    }
}