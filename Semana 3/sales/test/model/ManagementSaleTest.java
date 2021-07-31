package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagementSaleTest {
    private ManagementSale mng;

    private void setup(){
        mng = new ManagementSale();
        mng.addSale("Vta342","Pantalon",120_000,(short)10,false);
    }

    @Test
    void testFindSale() {
        setup();
        assertNull( mng.findSale("45645"));
        assertNotNull(mng.findSale("Vta342"));
        assertEquals("Pantalon",mng.findSale("Vta342").getProduct());
    }

    @Test
    void testAddSale() {
        setup();
        assertFalse(mng.addSale("Vta342","Camisa",20_000,(short)5,false));
        assertTrue(mng.addSale("Vta354742","Camisa",20_000,(short)5,false));
    }

    @Test
    void testGetSales() {
        setup();
        ArrayList<Sale> clonSale = mng.getSales();
        assertEquals(1,clonSale.size());
        clonSale.add(new Sale("vtarew2","Falda",80_000,(short)12,true));
        assertEquals(2,clonSale.size());
        assertEquals(1,mng.getSales().size());
    }

    @Test
    void testTotallySale(){
        setup();
        //assertTrue(mng.addSale("Vta354742","Camisa",20_000,(short)5,false));
        //assertTrue(mng.addSale("Vta34742","Falda",200_000,(short)10,false));
        assertEquals(1,mng.getSales().size());
        assertEquals(840000,mng.totallSales(),0.1);
    }
}