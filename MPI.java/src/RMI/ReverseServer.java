package RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ReverseServer {
    public static void main(String[] args) {
        try {
            ReverseInterface stub = new ReverseImpl();
            Registry registry = LocateRegistry.createRegistry(6543);// Cổng mặc định
            registry.rebind("ReverseService", stub);
            System.out.println("Server da san sang.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
