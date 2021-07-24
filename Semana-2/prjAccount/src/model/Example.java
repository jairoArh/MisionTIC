package model;

import java.time.LocalDate;
import java.time.Month;

public class Example {
    private Account account;

    public Example(Account account){
        this.account = account;
    }

    public void example(){
        Account acc = new Account("2345235", LocalDate.of(2010, Month.JUNE,26),100_000,30_000);


    }

    private void dependency( Account acc ){

    }

    private void otherMethod(){

    }
}
