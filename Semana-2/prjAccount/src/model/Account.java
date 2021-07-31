package model;

import java.time.LocalDate;
import java.time.Period;

public abstract class Account implements ActionsAccount {
     protected String number;
     protected LocalDate dateOpen;
     protected double balance;

    public Account(String number, LocalDate dateOpen, double balance) {
        this.number = number;
        this.dateOpen = dateOpen;
        this.balance = balance;

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


    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", dateOpen=" + dateOpen +
                ", balance=" + balance +
                '}';
    }

    @Override
    public void deposit(double value) {
        balance += value;
    }

    @Override
    public int getAge() {

        Period period = Period.between(dateOpen, LocalDate.now());

        return period.getYears();
    }
}
