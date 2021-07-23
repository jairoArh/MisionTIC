package test;

import java.util.Random;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        /***
         * Entradas / Salidas
         * Usar la Clase Scanner para leer del Teclado
         */

        //Entrada desde el Teclado
        Scanner input = new Scanner(System.in);
        System.out.println("Digite Valor...: ");
        int number = input.nextInt();

        //Salida
        System.out.println("El Valor es.. " + number );

        /***
         * Condicionales
         * if - then
         * if(expresion lógica){
         *     sentencias si cumple
         * }
         *
         * if - then - else
         * if( expresion){
         *     sentencias si cumple
         * }else{
         *     sentencias si no cumple
         * }
         */

        if( number % 2 == 0 ){
            System.out.println("El Numero " + number + " es PAR");
        }else{
            System.out.println("El Numero " + number + " es IMPAR");
        }

        //operador ternario
        System.out.println( number % 2 == 0 ? "El Numero " + number + " es PAR" : "El Numero " + number + " es IMPAR");

        /***
         * Estructuras de Control Iteratias
         * - while
         * - do .. while
         * - for
         *
         * //while - repite o itera mientras el resultado de la expresion sea verdadero
         * while(expresion logica){
         *     sentencias
         * }
         *
         * //do .. while - repite o itera mientras el resultado de la expresion sea verdadero
         * do{
         *     sentencias
         * }while( expresion logica)
         *
         * //for - repite o itera mientras el resultado de la expresion sea verdadero
         *
         * para generar numeros aleatoris se usa un instancia de la clase Random con el
         * método nextInt( limSup - limInf + 1) + limInf
         */

        System.out.printf("Digite el Numero de Intentos.");
        int intents = input.nextInt();
        int cont = 1;
        boolean found = false;
        //SE genera el numero oculto
        int numHidden = new Random().nextInt( 10 ) + 1;
        while( cont <= intents && !found ){
            System.out.printf("Intento %d de %d__: ",cont,intents);
            number = input.nextInt();
            if( number == numHidden ){
                found = true;
                //continue;
            }else{
                System.out.printf("Fallaste... Te quedan %d intentos\n", intents - cont);
                System.out.printf("%s\n",number < numHidden ? "El numero debe ser Mayor" : "El Numero debe ser Menor");
            }
            cont++;
        }
        if( found ){
            System.out.printf("Eureka lo Encontraste\n");
        }else {
            System.out.printf("El Numero era %d\n",numHidden);
        }

    }
}
