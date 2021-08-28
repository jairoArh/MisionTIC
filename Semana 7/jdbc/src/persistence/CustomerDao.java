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

    public boolean addCustomer( String ... data ) throws SQLException {
        String query = "INSERT INTO CUSTOMER VALUES('"+data[0]+"'," + "'"+data[1]+"'," + "'"+data[2]+"'," + "'"+data[3]+"'," + "'"+data[4]+"'," + "'"+data[5]+"')";
        if( connectDB.isConnect()){
            Statement statement = connectDB.getConnect().createStatement();

            return statement.executeUpdate( query ) > 0;
        }

        return false;
    }

    public boolean delCustomer(String nit) throws SQLException {
        String query = "DELETE FROM CUSTOMER WHERE nit='" + nit + "'";

        if( connectDB.isConnect()){
            Statement statement = connectDB.getConnect().createStatement();

            return statement.executeUpdate( query ) > 0;
        }

        return false;
    }

    public boolean updateCustomer(String ... data ) throws SQLException {
        String query = "UPDATE CUSTOMER SET name='" + data[1] + "',"
                + "last_name='" + data[2] + "',"
                + "min_residue='" + data[3] + "',"
                + "city='" + data[4] + "',"
                + "phone='" + data[5] + "'"
                + "WHERE nit='" + data[0]+"'";

        if( connectDB.isConnect()){
            Statement statement = connectDB.getConnect().createStatement();

            return statement.executeUpdate( query ) > 0;
        }

        return false;
    }

    public void close( ) {
        try {
            connectDB.getConnect().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
