package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ControllTest {
    private Controll controll;

    private void setup(){
        controll = new Controll();
        controll.addAccount("596-43534", LocalDate.of(2018, Month.DECEMBER,10),100000,2.0,true);
        controll.addAccount("23423432", LocalDate.of(2018, Month.DECEMBER,10),500_000,200000);
    }

    @Test
    void deposit() {
        setup();
        assertFalse( controll.deposit("235345",50000));
        assertTrue( controll.deposit("596-43534",50000));
        Object[] accountDeposit = controll.findAccount("596-43534");
        assertEquals(150000.0, accountDeposit[2]);


        assertTrue( controll.deposit("23423432",300_000));
        Object[] accountCurrent = controll.findAccount("23423432");
        assertEquals(800000.0, accountCurrent[2]);
    }

    @Test
    void findAccount() {
        setup();
        //Si el número de campos es cinco, la cuenta es de Depósito
        assertEquals(5, controll.findAccount("596-43534").length);

        //Si el número de campos es cuatro, la cuenta es corriente
        assertEquals(4, controll.findAccount("23423432").length);

        //Cuando la cuenta no existe, retona null
        assertNull( controll.findAccount("453453"));
    }

    @Test
    void addAccount() {
        setup();
    }

    @Test
    void testAddAccount() {
    }

    @Test
    void withDraw() {
        setup();
        //Para la cuenta de Depósito, solo se podrá retirar $50.000
        try {
            assertFalse(controll.withDraw("596-43534",50001));
            assertTrue(controll.withDraw("596-43534",30000));
            assertEquals(70000.0, controll.findAccount("596-43534")[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Para la cuenta Corriente, teniendo en cuenta el sobregiro, se podrá retirar hasta $700.000
        try {
            assertFalse(controll.withDraw("23423432",700001));
            assertTrue(controll.withDraw("23423432",600000));
            assertEquals(-100000.0, controll.findAccount("23423432")[2]);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertThrows( Exception.class,() -> assertFalse(controll.withDraw("56754",50001)));
    }

    @Test
    void transferAccount() {
    }
}