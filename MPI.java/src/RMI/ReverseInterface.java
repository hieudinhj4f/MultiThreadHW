package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ReverseInterface extends Remote {
    public String reverse(String input) throws RemoteException;
}
