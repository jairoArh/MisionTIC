package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @Test
    void testLiquidateSale() {

        Sale sale = new Sale("42534","Pantalon",150000,(short)3,true);

        assertEquals(400500,sale.liquidateSale(),0.1);

    }

    @Test
    void testCalcIVA() {
        Sale sale = new Sale("vta945","Pantalon",150000,(short)3,true);
        assertEquals(85500, sale.calcIVA(),0.1);

        sale.setIva(false);
        assertEquals(0.0, sale.calcIVA(),0.1);
    }
}