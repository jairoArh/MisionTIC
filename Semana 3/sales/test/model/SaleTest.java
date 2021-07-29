package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {

    @Test
    void testLiquidateSale() {

        Sale sale = new Sale("Pantalon",150000,(short)3,true);

        assertEquals(400500,sale.liquidateSale());

    }

    @Test
    void testCalcIVA() {
        Sale sale = new Sale("Pantalon",150000,(short)3,true);
        assertEquals(85500, sale.calcIVA());

        sale.setIva(false);
        assertEquals(0.0, sale.calcIVA());
    }
}