package RMIClient;

import RMI.ReverseInterface;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("172.20.10.2", 6543);
            ReverseInterface stub = (ReverseInterface) registry.lookup("ReverseService");

            String input = "Hello RMI!";
            Scanner sc = new Scanner(System.in);
            String result = stub.reverse(input);
            System.out.println("Original: " + input);
            System.out.println("Reversed: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
