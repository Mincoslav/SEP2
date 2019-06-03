package viewmodel;

import mediator.Model;
import mediator.ModelManager;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) {
        try {
            Model model = new ModelManager();
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
