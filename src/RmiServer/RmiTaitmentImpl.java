package RmiServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RmiTaitmentImpl extends UnicastRemoteObject implements RmiTaitment {
    private List<String> chatHistory;

    protected RmiTaitmentImpl() throws RemoteException {
        super();
        this.chatHistory = new ArrayList<>();
    }

    @Override
    public void sendMessage(String name, String message) throws RemoteException {
        String formattedMessage = name + ": " + message;
        System.out.println(formattedMessage);
        chatHistory.add(formattedMessage);
    }

    @Override
    public List<String> receiveMessages() throws RemoteException {
        List<String> messages = new ArrayList<>(chatHistory);
        chatHistory.clear(); // Clear the chat history after reading messages
        return messages;
    }
}
