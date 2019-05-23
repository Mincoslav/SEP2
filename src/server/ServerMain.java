package server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {

    public static void main(String[] args) {
        try {
            System.out.println("Starting server...");

            //Locating the port and creating the server instance
            LocateRegistry.createRegistry(1099);
            RServer server = new RMIServer();
            Naming.rebind("shopping", server);

            System.out.println("Server started.\nReady for clients.");

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
