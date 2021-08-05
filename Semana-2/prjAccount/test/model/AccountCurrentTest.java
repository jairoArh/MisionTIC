package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AccountCurrentTest {

    @Test
    void withDraw() {
        AccountCurrent account = new AccountCurrent("2545535-7",LocalDate.of(2019,Month.AUGUST,10),300000,200000);
        assertTrue(account.withDraw(350000));
        assertEquals(-50000,account.getBalance());
        assertFalse(account.withDraw(200000));
        assertEquals(-50000,account.getBalance());
    }
}