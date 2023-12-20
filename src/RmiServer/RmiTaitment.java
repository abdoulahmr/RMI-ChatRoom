package RmiServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RmiTaitment extends Remote {
    void sendMessage(String name, String message) throws RemoteException;
    List<String> receiveMessages() throws RemoteException;
}
