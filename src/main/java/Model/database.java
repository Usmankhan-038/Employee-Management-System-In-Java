package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class database {

    public static Connection connectDb() {
        String url = "jdbc:mysql://localhost:3306/ems?useSSL=false&allowPublicKeyRetrieval=true";
        String username = "root";
        String password = ""; // No password

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected successfully!");
            connection.close();
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
