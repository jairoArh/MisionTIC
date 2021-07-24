package model;

public class NumbersFriends {
    private int numOne;
    private int numTwo;

    public NumbersFriends(int numOne, int numTwo) {
        this.numOne = numOne;
        this.numTwo = numTwo;
    }

    public int getNumOne() {
        return numOne;
    }

    public void setNumOne(int numOne) {
        this.numOne = numOne;
    }

    public int getNumTwo() {
        return numTwo;
    }

    public void setNumTwo(int numTwo) {
        this.numTwo = numTwo;
    }

    private int sumDiv(int number){
        return 0;
    }

    public boolean isFriends(){

        if( sumDiv( numOne) == numTwo && sumDiv( numTwo) == numOne){
            return true;
        }

        return false;
    }
}
