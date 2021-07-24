package test;

import model.NumbersFriends;

public class RunnerFriends {
    public static void main(String[] args) {
        NumbersFriends nums = new NumbersFriends( 45,89);
        if( nums.isFriends() ){
            System.out.printf("Los Numeros %d y %d SON AMIGOS\n",nums.getNumOne(), nums.getNumTwo());
        }else{
            System.out.printf("Los Numeros %d y %d NO SON AMIGOS\n",nums.getNumOne(), nums.getNumTwo());
        }
    }
}
