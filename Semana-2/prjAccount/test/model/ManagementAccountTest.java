package model;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;

class ManagementAccountTest {

    private ManagementAccount mngAccount;

    private void setup(){
        mngAccount = new ManagementAccount();
        mngAccount.addAccount( new AccountDeposit("596-234325", LocalDate.of(2017, Month.DECEMBER,21),100000,2.0,true));
        mngAccount.addAccount( new AccountCurrent("100-4546", LocalDate.of(2016, Month.DECEMBER,21),500000,200000));
    }

    @Test
    void findAccount() {
        setup();
        assertEquals(2, mngAccount.getAccounts().size());
        assertNotNull( mngAccount.findAccount("596-234325"));
        assertNotNull( mngAccount.findAccount("100-4546"));
        assertNull( mngAccount.findAccount("100-4534546"));
        assertEquals("596-234325",mngAccount.findAccount("596-234325").getNumber());
    }

    @Test
    void addAccount() {
        setup();
        mngAccount.addAccount( new AccountDeposit("596-234325", LocalDate.of(2017, Month.DECEMBER,21),100000,2.0,true));
        mngAccount.addAccount( new AccountDeposit("596-8765344", LocalDate.of(2017, Month.DECEMBER,21),1000000,2.0,true));
        assertEquals(4, mngAccount.getAccounts().size());
    }

    @Test
    void deposit() {
        setup();
        mngAccount.deposit(mngAccount.findAccount("596-234325"),150000);
        assertEquals(250000, mngAccount.findAccount("596-234325").getBalance());
        mngAccount.deposit(mngAccount.findAccount("100-4546"),400000);
        assertEquals(900000, mngAccount.findAccount("100-4546").getBalance());
    }

    @Test
    void withDraw() {
        setup();
        //Aserciones para la cuenta de depósito
        assertFalse( mngAccount.withDraw( mngAccount.findAccount("596-234325"),60000));
        assertTrue( mngAccount.withDraw( mngAccount.findAccount("596-234325"),10000));
        assertEquals(90000, mngAccount.findAccount("596-234325").getBalance());

        //Aserciones para la cuenta corriente
        assertFalse(mngAccount.withDraw(mngAccount.findAccount("100-4546"),700_001));
        assertTrue(mngAccount.withDraw(mngAccount.findAccount("100-4546"),700_000));
        assertEquals(-200000, mngAccount.findAccount("100-4546").getBalance());
    }

    @Test
    void transferAccount() {
        setup();
        AccountDeposit account = new AccountDeposit("453245",LocalDate.of(2010,Month.AUGUST,20),300_000,2.0,false);
        AccountDeposit target = (AccountDeposit) mngAccount.findAccount("596-234325");

        assertTrue( mngAccount.transferAccount( account,target,80_000));
        assertEquals(220000, account.getBalance());
        assertEquals(180000, target.getBalance());
    }
}