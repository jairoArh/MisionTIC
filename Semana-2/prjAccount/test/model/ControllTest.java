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
        assertEquals(5, controll.findAccount("596-43534").length);
        assertEquals(4, controll.findAccount("23423432").length);
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
    }

    @Test
    void transferAccount() {
    }
}