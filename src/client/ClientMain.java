package client;

import domain.Order;
import domain.Product;
import domain.ShoppingBag;
import server.RServer;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientMain {

    public static void main(String[] args) {
        try {
            RemoteClient client = new RMIClient();
            ShoppingBag shoppingBag = new ShoppingBag();
            Product product = new Product("shoe","location", 0,1234,1,10,false,"some description", 1);
            shoppingBag.addProduct(product);
            Order order = new Order(shoppingBag,"","",0);
            int ID = order.getOrderID();
            System.out.println(ID);
            System.out.println(client.getOrderID(order));
            System.out.println(client.getOrderByID(ID));


        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
