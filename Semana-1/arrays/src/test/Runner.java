package test;

import com.sun.tools.internal.xjc.model.CElement;
import com.sun.xml.internal.bind.v2.TODO;

import java.util.Random;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Digite Valor");
        int number = new Scanner(System.in).nextInt();

        System.out.println("Digite Otro Valor");
        String num = new Scanner(System.in).next();

        //A través del método estático parseInt() de la clase Integer, se convierte una cadena de valores a número entero
        int value = Integer.parseInt( num,16 );

        /***
         * Clases que envuelven los tipos primitivos
         * byte - Byte
         * short - Short
         * int - Integer
         * float - Float
         * double - Double
         * long - Long
         */

        System.out.printf("El Valor es %s\n", value + 10 );

        System.out.printf("El numero %d es %s\n",number, isPair(number) ? "PAR" : "IMPAR");
        System.out.printf("El numero %d es %s\n",number, isCousing(number) ? "PRIMO" : "NO PRIMO");

        arrays();

    }

    private static void arrays() {
        /***
         * Vectores--------------------------------------------------------------------
         */
        int[] vector = new int[5];
        vector[0] = 53;
        vector[1] = 75;
        vector[2] = 3;
        vector[3] = 8;
        vector[4] = 14;

        //Recorrido con indice
        for( int i = 0 ; i < vector.length ; i++ ){
            System.out.printf("vector[%d]=%d\n",i,vector[i]);
        }

        //Leer los valores desde el teclado
        for( int i = 0 ; i < vector.length ; i++ ){
            System.out.printf("Valor Para vector[%d]=\n",i );
            vector[i] = new Scanner(System.in).nextInt();
        }

        /***
         * for mejorado (for each) para recorrer arreglos
         * for( Clase objeto : arreglo )
         */

        for( Integer num : vector ){
            System.out.printf("%d\t",num);
        }

        System.out.println( );

        int[] array = new int[]{836,42,67,25,10,54,657,24};

        System.out.printf("La Suma de los Elementos del Arreglo es %d\n",sumArray( array ) );
        System.out.printf("El Promedio de los Elementos del Arreglo es %d\n",average( array ) );
        System.out.printf("La Suma de los Elementos del Arreglo es %d\n",sumArray( array ) );
        System.out.printf("El Elemento mayor del Arreglo es %d\n", findElementHigher( array ) );
        System.out.printf("El Elemento manor del Arreglo es %d\n", findElementLess( array ) );

        /***
         * Matrices ------------------------------------------------------------
         */

        int[][] matriz = new int[][]{{8, 1, 6},{3, 5, 7},{4, 9, 2}};
        showMatriz( matriz );
        System.out.println("-----------------------------------------------------");

        int[][] matrizOne = generateMatriz(8,7);

        showMatriz(  matrizOne );

        int row = 3;

        System.out.printf("La suma de la fila %d es %d\n",sumRow(matrizOne, row ));
        System.out.printf("La suma de la Diagonal Srincipal es %d\n",sumDiagMain(matrizOne ));
        System.out.printf("La suma de la Diagonal Secundaria es %d\n",sumDiagSec(matrizOne ));

    }

    private static Object sumDiagSec(int[][] matrizOne) {
        //TODO Implementar el método que sume la diagonal secundaria de la  matriz recibida como parametro.

        return null;
    }

    private static Object sumDiagMain(int[][] matrizOne) {
        //TODO Implementar el método que sume la diagonal principal de la  matriz recibida como parametro.

        return null;
    }

    private static Object sumRow(int[][] matrizOne, int row) {
        //TODO Sumar la fila especificada en row de la matriz recibida como parametro

        return null;
    }

    private static int[][] generateMatriz(int rows, int cols) {
        int[][] mat = new int[rows][cols];

        for( int i = 0 ; i < mat.length ; i++ ){
            for( int j = 0 ; j < mat[i].length ; j++ ){
               mat[i][j] = new Random().nextInt(91 ) + 10;
            }
        }

        return mat;
    }

    private static void showMatriz(int[][] matriz) {
        for( int i = 0 ; i < matriz.length ; i++ ){
            for( int j = 0 ; j < matriz[i].length ; j++ ){
                System.out.printf("%d\t",matriz[i][j]);
            }
            System.out.println();
        }
    }

    private static Object findElementHigher(int[] array) {
        //TODO implementar método para hallar el elemento mayor del vector que se recibe como parámetro

        return null;
    }

    private static Object findElementLess(int[] array) {
        //TODO implementar método para hallar el elemento menor del vector que se recibe como parámetro

        return null;
    }

    private static Object average(int[] array) {
        //TODO implementar el método para que retorne el promedio del vector que se recibe como parámetro
        return null;
    }

    private static int sumArray(int[] array) {

        int sum = 0;
        for( Integer value : array ){
            sum += value;  // sum = sum + value;
        }

        return sum;
    }

    static boolean isPair( int number ){

        return number % 2 == 0 ? true : false;

    }

    static boolean isCousing( int number ){

        int cont = 2;
        boolean cousing = true;
        while( cont <= number / 2 && cousing ){
            cousing = !( number % cont++ == 0 );
        }

        return cousing;
    }
}
