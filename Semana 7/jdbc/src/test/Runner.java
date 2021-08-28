package test;

import logic.Customer;
import logic.ManagementSales;
import persistence.CustomerDao;
import persistence.A;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Runner {
    public static void main(String[] args) {
        /*CustomerDao customerDao = new CustomerDao();

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

        A.B b = a.new B();*/

        management();
    }

    private static void management() {
        ManagementSales mng = new ManagementSales();

        try {
            System.out.println("---------Listado de Clientes----------------");
            mng.getCustomers().forEach( customer -> System.out.println( customer ) );

            //Buscar Cliente
            System.out.println("-----------------Buscar Cliente----------------");
            Customer customer = mng.getCustomer("1234567");
            System.out.println( customer );

            //Adicionar Cliente
            String nit = null;
            /*nit = JOptionPane.showInputDialog("Nit");
            String name = JOptionPane.showInputDialog("Nombres");
            String lastName = JOptionPane.showInputDialog("Apellidos");
            int minResidue = Integer.parseInt( JOptionPane.showInputDialog("Saldo Minimo"));
            String city = JOptionPane.showInputDialog("Ciudad");
            String phone = JOptionPane.showInputDialog("Telefono");
            System.out.println( mng.addCustomer( nit, name, lastName, minResidue, city, phone));*/

            //Eliminar Cliente
            nit = JOptionPane.showInputDialog("Nit a Eliminar");
            if( mng.delCustomer( nit )){
                JOptionPane.showMessageDialog(null,"El clientre se Elimino","OK",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null,"El cliente NO Existe","OK",JOptionPane.ERROR_MESSAGE);
            }

            //Actualizar Cliente - Create Retrieve Update Delete
            nit = JOptionPane.showInputDialog("Nit Cliente a Actualizar");
            if( mng.findCustomer( nit ) != null ){
                String name = JOptionPane.showInputDialog("Nombres");
                String lastName = JOptionPane.showInputDialog("Apellidos");
                int minResidue = Integer.parseInt( JOptionPane.showInputDialog("Saldo Minimo"));
                String city = JOptionPane.showInputDialog("Ciudad");
                String phone = JOptionPane.showInputDialog("Telefono");

                if ( mng.updateCustomer( nit, name,lastName,minResidue,city,phone)){
                    JOptionPane.showMessageDialog(null,"El clientre se Actualizó","OK",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null,"El cliente NO Existe no se puede Actualizar","OK",JOptionPane.ERROR_MESSAGE);
                }
            }else{
                JOptionPane.showMessageDialog(null,"El cliente NO Existe no se puede Actualizar","OK",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"El cliente NO Existe","OK",JOptionPane.ERROR_MESSAGE);
        }
        System.out.println("****************FIN***************");
    }
}
