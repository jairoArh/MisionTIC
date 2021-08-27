package persistence;

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
}