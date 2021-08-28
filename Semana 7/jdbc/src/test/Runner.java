package test;

import persistence.CustomerDao;
import persistence.A;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        CustomerDao customerDao = new CustomerDao();

        try {
            ResultSet resultSet = customerDao.getCustomers();
            while( resultSet.next()){
                String nit = resultSet.getString("nit");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("last_name");
                int minResidue = resultSet.getInt("min_residue");
                String city = resultSet.getString("city");
                String phone = resultSet.getString("phone");

                System.out.printf("%s %s %s %d %s %s\n",nit,name,lastName,minResidue,city,phone);
            }

            System.out.println();
            ResultSet result = customerDao.getCustomer("123444567");
            while( result.next()){
                String nit = result.getString("nit");
                String name = result.getString("name");
                String lastName = result.getString("last_name");
                int minResidue = result.getInt("min_residue");
                String city = result.getString("city");
                String phone = result.getString("phone");

                System.out.printf("%s %s %s %d %s %s\n",nit,name,lastName,minResidue,city,phone);
            }

            customerDao.addCustomer("827475","Mora Pedraza","Angela maría","340000","Paipa","4526344");

            resultSet.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("FINNNNNNNNNNNNNNN********");

        A a = new A();

        A.B b = a.new B();
    }
}
