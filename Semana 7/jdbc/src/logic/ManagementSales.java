package logic;

import persistence.CustomerDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

public class ManagementSales {

    private CustomerDao customer;

    public ManagementSales() {
        customer = new CustomerDao();
    }

    public Customer findCustomer( String nit ) throws SQLException {
        ResultSet resultSet = customer.getCustomer(nit);

        if ( resultSet.next() ){
            String nitCustomer = resultSet.getString("nit");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("last_name");
            int minResidue = resultSet.getInt("min_residue");
            String city = resultSet.getString("city");
            String phone = resultSet.getString("phone");

            Customer customer = new Customer(nitCustomer, name, lastName, minResidue, city, phone);

            return customer;
        }

        return null;
    }

    public ArrayList<Customer> getCustomers() throws SQLException {

        ArrayList<Customer> customers = new ArrayList<>();
        ResultSet resultSet = customer.getCustomers();

        while (resultSet.next()) {
            String nit = resultSet.getString("nit");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("last_name");
            int minResidue = resultSet.getInt("min_residue");
            String city = resultSet.getString("city");
            String phone = resultSet.getString("phone");

            customers.add(new Customer(nit, name, lastName, minResidue, city, phone));
        }

        return customers;
    }

    public Customer getCustomer(String aux) throws SQLException {

        ResultSet resultSet = customer.getCustomer(aux);

        while( resultSet.next( ) ){
            String nit = resultSet.getString("nit");
            String name = resultSet.getString("name");
            String lastName = resultSet.getString("last_name");
            int minResidue = resultSet.getInt("min_residue");
            String city = resultSet.getString("city");
            String phone = resultSet.getString("phone");

            Customer customer = new Customer(nit, name, lastName, minResidue, city, phone);

            return customer;
        }

        return null;
    }

    public boolean addCustomer( String nit, String name, String lastName, int minResidue, String city, String phone ) throws SQLException {

        if ( !customer.getCustomer( nit ).next() ){
            customer.addCustomer( nit, name, lastName, Integer.toString( minResidue), city,phone);

            return true;
        }

        return false;
    }

    public boolean delCustomer( String nit ) throws SQLException {
        if ( customer.getCustomer( nit ).next() ){

            return customer.delCustomer( nit );
        }

        return false;
    }

    public boolean updateCustomer( String nit, String name, String lastName, int minResidue, String city, String phone ) throws SQLException {
        if ( customer.getCustomer( nit ).next() ){

            return customer.updateCustomer( nit, name, lastName, Integer.toString(minResidue), city, phone );
        }

        return false;
    }
}
