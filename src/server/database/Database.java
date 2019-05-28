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

public class Database {

        Connection connection = null;

        private final String url = "jdbc:postgresql://localhost/postgres";
        private final String user = "postgres";
        private final String password = "postgres";

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

        public static void main(String[] args) {
            Database dtbs = new Database();
            dtbs.connect();
        }
}

