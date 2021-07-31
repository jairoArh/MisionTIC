package model;

import java.time.LocalDate;

public class AccountDeposit extends Account{
    public static final double MIN_BALANCE =  50000.0;
    private boolean excent;

    public AccountDeposit(String number, LocalDate dateOpen, double balance, boolean excent) {
        super(number, dateOpen, balance);
        this.excent = excent;
    }

    @Override
    public boolean withDraw(double value) {

        if( value <= ( balance - MIN_BALANCE ) ){
            balance -= value;
        }

        return false;
    }

    public boolean isExcent() {
        return excent;
    }

    public void setExcent(boolean excent) {
        this.excent = excent;
    }
}
