import java.util.Arrays;
import java.util.Scanner;

public class Ciclo2 {
    public static void main(String[] args) {
        //int number = new Scanner(System.in).nextInt();
        //System.out.println(calcFactorial( number ));
        sortArray();
    }

    private static void sortArray() {
        int[] vector = {4,6,2,17,85,54,69,21,27};

        for( int aux = vector.length ; aux > 0 ; aux-- ){
            for( int i = 0 ; i > aux -1 ; i++ ){
                if( vector[i] < vector[i+1]){
                    int temp = vector[i];
                    vector[i] = vector[i+1];
                    vector[i+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString( vector) );
    }

    private static long calcFactorial(int number) {
        long fact = 1;

        for( int cont = 2 ; cont <= number ; cont++ ){
             fact *= cont; //fact = fact * cont;
        }

        return fact;
    }
}


/***
 * 20 10
 *
 * divisores 20 --> 1 2 4 5 10 ==> 22
 * divisores 10 --> 1 2 5 ==> 8
 *
 *
 */
