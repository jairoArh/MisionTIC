package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class ManagementAccount {
    private ArrayList<Account> accounts;

    public ManagementAccount() {
        accounts = new ArrayList<>();
    }

    public Account findAccount(String number){
        return null;
    }

    public boolean addAccount(String number, LocalDate dateOpen, double balance, double minBalance ){

        return false;
    }

    public ArrayList<Account> getAccounts(){

        return null;
    }
}
