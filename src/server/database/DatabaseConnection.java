package server.database;
import domain.Categories;
import domain.Order;
import domain.Product;
import domain.ShoppingBag;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseConnection {

    Connection connection;

    private final String url;
    private final String password;
    private final String user;

    public DatabaseConnection() {
        connection = connect();
        user = "postgres";
        password = "postgres";
        url = "jdbc:postgresql://localhost/postgres";
    }

    /**
     * Connect to the PostgreSQL database
     * @return a Connection object
     */
    public Connection connect() {

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    public void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/*
    public static void main(String[] args) {
            Database dtbs = new Database();
            dtbs.connect();
        }*/
}
