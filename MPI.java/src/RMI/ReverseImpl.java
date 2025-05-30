package RMI;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ReverseImpl extends UnicastRemoteObject implements ReverseInterface {
    protected ReverseImpl() throws RemoteException {
        super();
        String input;
    }

    @Override
    public String reverse(String input) throws RemoteException {
        System.out.println("Data trc khi sua la: "+input);
        System.out.println("Data sau khi sua la: " +  new StringBuilder(input).reverse().toString());
        return new StringBuilder(input).reverse().toString();
    }
}
