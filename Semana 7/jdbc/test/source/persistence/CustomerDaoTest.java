package persistence;

import com.mysql.cj.jdbc.exceptions.SQLError;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoTest {

    @Test
    void getCustomers() {
        CustomerDao customerDao = new CustomerDao();
        try {
            assertNotNull( customerDao.getCustomers());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        customerDao.close();
    }

    @Test
    void getCustomer(){
        CustomerDao customerDao = new CustomerDao();
        try {
            assertNotNull( customerDao.getCustomer("1234567"));
            assertNotNull( customerDao.getCustomer("123434567"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        customerDao.close();
    }

    @Test
    void addCustomer(){
        CustomerDao customerDao = new CustomerDao();
        try {
            assertTrue( customerDao.addCustomer( "45523","López Vargas","Sergio","500000","Bogota D.C","3135022002"));
            assertFalse( customerDao.addCustomer( "45523","Daza Sánchez","Juliana","400000","Bogota D.C","3007823402"));
        } catch (SQLException e) {
            System.out.println("Exception");
            e.printStackTrace();
        }
        System.out.println("Passed");
    }

    @Test
    void delCustomer()  {
        CustomerDao customerDao = new CustomerDao();
        try {
            assertFalse( customerDao.delCustomer("827475"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateCustomer(){
        CustomerDao customerDao = new CustomerDao();
        try {
            assertTrue( customerDao.updateCustomer("45523","Juan Jose","Ochoa Linares","4534544","Oicata","4535353"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}