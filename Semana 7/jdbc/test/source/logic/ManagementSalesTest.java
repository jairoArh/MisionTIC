package logic;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ManagementSalesTest {

    @Test
    void getCustomers(){
        ManagementSales mng = new ManagementSales();
        try {
            assertEquals(5 , mng.getCustomers().size());
            assertEquals( "1234567",mng.getCustomers().get(0).getNit());
            assertEquals( "98383",mng.getCustomers().get(4).getNit());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getCustomer(){
        ManagementSales mng = new ManagementSales();
        try {
            assertNull(mng.getCustomer("99933344"));
            assertNotNull(mng.getCustomer("1234567"));
            assertEquals( "1234567",mng.getCustomer("1234567").getNit());
            assertEquals( "Ana Catalina",mng.getCustomer("1234567").getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addCustomer() throws SQLException {
        ManagementSales mng = new ManagementSales();

        assertFalse( mng.addCustomer("1234567","Gloria Estela","Vanegas Ricaurte",1000000,"Bogota","5345345345"));
        assertFalse( mng.addCustomer("467239469","Gloria Estela","Vanegas Ricaurte",1000000,"Bogota","5345345345"));
    }

    @Test
    void delCustomer(){
        ManagementSales mng = new ManagementSales();
        try {
            assertFalse( mng.delCustomer("66666666"));
            assertFalse( mng.delCustomer("98734"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void updateCustomer(){
        ManagementSales mng = new ManagementSales();
        try {
            assertFalse( mng.updateCustomer("66666666","Juan Camilo","Perez Buitrago",1000000,"Sogamoso","3006728965"));
            assertTrue( mng.updateCustomer("7654321","Juan Camilo","Perez Buitrago",1000000,"Sogamoso","3006728965"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void findCustomer(){
        ManagementSales mng = new ManagementSales();
        try {
            assertNull(mng.findCustomer("34564564"));
            assertNotNull( mng.getCustomer("1234567"));
            assertNotNull( mng.getCustomer("7654321"));
            assertEquals("Ana Catalina",mng.findCustomer("1234567").getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}