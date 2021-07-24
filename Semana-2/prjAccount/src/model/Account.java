package model;

import java.time.LocalDate;
import java.time.Period;

public class Account implements ActionsAccount {
     protected String number;
    private LocalDate dateOpen;
    private double balance;
    private double minBalance;

    public Account(String number, LocalDate dateOpen, double balance, double minBalance) {
        this.number = number;
        this.dateOpen = dateOpen;
        this.balance = balance;
        this.minBalance = minBalance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public LocalDate getDateOpen() {
        return dateOpen;
    }

    public void setDateOpen(LocalDate dateOpen) {
        this.dateOpen = dateOpen;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", dateOpen=" + dateOpen +
                ", balance=" + balance +
                ", minBalance=" + minBalance +
                '}';
    }


    @Override
    public void deposit(double value) {
        balance += value;
    }

    @Override
    public boolean withDraw(double value) {
        if( value <= ( getBalance() - getMinBalance( ) ) ){
            balance -= value;

            return true;
        }

        return false;
    }

    @Override
    public int getAge() {

        Period period = Period.between(dateOpen, LocalDate.now());

        return period.getYears();
    }
}
