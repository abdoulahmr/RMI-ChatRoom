package RmiServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter server port: ");
        String port = scanner.nextLine();
        RmiTaitment stub = (RmiTaitment) Naming.lookup("rmi://localhost:" + port + "/RMI");
        System.out.println(port + " connected");
        System.out.print("Enter message (or 'exit' to quit): ");
     // Join the chat
        while (true) {
            String message = scanner.nextLine();

            if ("exit".equalsIgnoreCase(message)) {
                break;
            }

            stub.sendMessage(name, message);
            List<String> receivedMessages = stub.receiveMessages();
            for (String receivedMessage : receivedMessages) {
                System.out.println("Received: " + receivedMessage);
            }
        }

    }
}
