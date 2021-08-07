package model;

import java.time.LocalDate;

public class AccountDeposit extends Account{
    public static final double MIN_BALANCE =  50000.0;
    private double interestRate;
    private boolean excent;

    public AccountDeposit(String number, LocalDate dateOpen, double balance, double interestRate, boolean excent) {
        super(number, dateOpen, balance);
        this.excent = excent;
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public boolean withDraw(double value) {

        if( value <= ( balance - MIN_BALANCE ) ){
            balance -= value;

            return true;
        }

        return false;
    }

    public boolean isExcent() {
        return excent;
    }

    public void setExcent(boolean excent) {
        this.excent = excent;
    }

    public boolean transferAccount( AccountDeposit account, double value ){

        if( value <= ( balance - MIN_BALANCE)){
            balance -= value;
            account.deposit( value );

            return true;
        }

        return false;
    }
}
