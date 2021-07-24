package model;

public class ExamplesNumber {
    private int number;

    public ExamplesNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long calcFactorial(){
        long fact = 1;

        for( int cont = 2 ; cont <= number ; cont++ ){
            fact *= cont; //fact = fact * cont;
        }

        return fact;
    }
}
