package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class AccountDepositTest {
    private AccountDeposit account;
    private AccountDeposit accountTarget;

    private void setup(){
        account = new AccountDeposit("563-45354", LocalDate.of(2010, Month.JUNE,25),100_000, 2.0,true);
        accountTarget = new AccountDeposit("563-45354", LocalDate.of(2010, Month.JUNE,25),50_000, 2.0,true);
    }

    @Test
    void testDeposit(){
        setup();
        assertEquals(100000,account.getBalance());
        account.deposit(180_000);
        assertEquals(280000,account.getBalance());
    }

    @Test
    void withDraw() {
        setup();
        assertFalse( account.withDraw(50_001));
        assertEquals(100000,account.getBalance());
        assertTrue( account.withDraw(50_000));
        assertEquals(50000,account.getBalance());
    }

    @Test
    void transferAccount() {
        setup();
        assertFalse(account.transferAccount( accountTarget, 50_001));
        assertEquals(100000,account.getBalance());
        assertTrue(account.transferAccount( accountTarget, 30_000));

        assertEquals(70000,account.getBalance());
        assertEquals(80000,accountTarget.getBalance());

        assertTrue( accountTarget.transferAccount(account,10000));

        assertEquals(80000,account.getBalance());
        assertEquals(70000,accountTarget.getBalance());
    }
}