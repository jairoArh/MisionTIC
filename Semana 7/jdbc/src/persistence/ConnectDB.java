package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost/SALES";
    private final String USER = "Perseo";
    private final String PASSWORD = "olimpo.";
    private Connection connect;

    public boolean isConnect(){
        boolean state = false;
        try {
            Class.forName( DRIVER );
            connect = DriverManager.getConnection(URL,USER,PASSWORD);
            state = true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return state;
    }

    public Connection getConnect() {
        return connect;
    }
}
