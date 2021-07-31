package model;

import java.time.LocalDate;

public class AccountCurrent extends Account{
    private double overdraft;

    public AccountCurrent(String number, LocalDate dateOpen, double balance, double overdraft) {
        super(number, dateOpen, balance);
        this.overdraft = overdraft;
    }

    @Override
    public boolean withDraw(double value) {

        if( value <= ( balance + overdraft ) ){

            balance -= value;

            return true;
        }

        return false;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }
}
