package model;

import java.time.LocalDate;

public class Controll {
    private ManagementAccount mngAccount;

    public Controll() {
        mngAccount = new ManagementAccount();
    }

    /***
     * Método que permite consigar a una cuenta
     * @param numberAccount Especifica el numero de la cuenta a donde se va a consignar
     * @param value Especifica el valor a consignar
     * @return boolea, indica si tuvo exito la operación
     */
    public boolean deposit(String numberAccount, double value){

        //Se crea un nuevo objeto para validar si la cuenta existe
        Account account =  mngAccount.findAccount( numberAccount );

        if( account != null ){
            account.deposit( value );

            return true;
        }

        return false;
    }

    /***
     * Método que busca una cuenta
     * @param numberAccount Especifica el numero de la cuenta a buscar
     * @return Arreglo de objetos con los datos de la cuenta.
     */
    public Object[ ] findAccount(String numberAccount){

        Account account = mngAccount.findAccount(numberAccount);

        if( account != null ){
            if( account instanceof AccountDeposit ){
                Object[] output = {account.getNumber(),account.getDateOpen(),account.getBalance(),((AccountDeposit) account).getInterestRate(),((AccountDeposit) account).isExcent()};

                return output;
            }else{
                Object[] output = {account.getNumber(),account.getDateOpen(),account.getBalance(),((AccountCurrent)account).getOverdraft()};

                return output;
            }
        }

        return null;
    }

    /**
     * Método que permite agrgar una cuenta de depósito
     * @param numberAccount Numero de la cuenta
     * @param dateOpen Fecha de apertura
     * @param balance saldo
     * @param interestRate tasa de ineterés
     * @param excent indica si la cuenta es excenta o no del 4xmil
     * @return Un valor lógico indicando si tuvo éxito la operación
     */
    public boolean addAccount(String numberAccount, LocalDate dateOpen, double balance, double interestRate, boolean excent){

        if( mngAccount.findAccount( numberAccount) == null ){

            AccountDeposit account = new AccountDeposit(numberAccount,dateOpen,balance, interestRate, excent );
            mngAccount.addAccount( account );

            return true;
        }

        return false;
    }

    public boolean addAccount(String numberAccount, LocalDate dateOpen, double balance, double overDraft ){

        if( mngAccount.findAccount( numberAccount) == null ) {

            AccountCurrent account = new AccountCurrent(numberAccount, dateOpen, balance, overDraft);
            mngAccount.addAccount(account);

            return true;
        }

        return false;
    }

    public boolean withDraw( String numberAccount, double value){

        return false;
    }

    public boolean transferAccount( String sourceAccount, String targetAccount, double value){

        return false;
    }
}
