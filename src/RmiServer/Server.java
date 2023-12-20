package RmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        LocateRegistry.createRegistry(1099);
        RmiTaitmentImpl rmi = new RmiTaitmentImpl();
        Naming.rebind("rmi://localhost:1099/RMI", rmi);
        System.out.println(rmi.toString());
        System.out.println("Server is on | port 1099");
    }
}
