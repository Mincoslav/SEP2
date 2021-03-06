package server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerMain {

    public static void main(String[] args) {
        try {
            System.out.println("Starting server...");

            //Locating the port and creating the server instance
            LocateRegistry.createRegistry(1099);
            RServer server = new RMIServer();
            Naming.rebind("abc", server);

            System.out.println("Server started.\nReady for clients.");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}
