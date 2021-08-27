package persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomerDao {
    private ConnectDB connectDB;

    public CustomerDao(){
        connectDB = new ConnectDB();
    }

    public ResultSet getCustomers() throws SQLException {
        String query = "SELECT * FROM CUSTOMER";
        if( connectDB.isConnect()){
            Statement statement = connectDB.getConnect().createStatement();
            ResultSet result = statement.executeQuery( query );

            return result;
        }

        return null;
    }

    public ResultSet getCustomer( String nit ) throws SQLException {
        String query = "SELECT * FROM CUSTOMER WHERE nit='"+nit+"'";
        if( connectDB.isConnect()){
            Statement statement = connectDB.getConnect().createStatement();
            ResultSet result = statement.executeQuery( query );

            return result;
        }

        return null;
    }

    public void close( ) {
        try {
            connectDB.getConnect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
