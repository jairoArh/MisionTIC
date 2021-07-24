package test;

import model.ExamplesNumber;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int value = new Scanner(System.in).nextInt();

        ExamplesNumber number = new ExamplesNumber(value);

        System.out.println( number.calcFactorial());
    }
}
