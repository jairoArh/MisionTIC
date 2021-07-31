package run;

import javax.swing.*;

/**
 *Clase para ejemplos de gestión de Excepciones
 * Para gestionar las Excepciones, se debe proteger el código con un bloque try{} catch(){}
 * En el try{} se encuentra el código que puede generar la excepciónb y en el catch(), la acción
 * cuando ocurre la excepción
 */
public class Runner {
    public static void main(String[] args) {
        //Division por cero.
        int num1 = 10, num2 = 5;
        try{
            double div = num1 / num2;
            System.out.printf("%d/%d=%f\n",num1,num2,div);

            int number = Integer.parseInt( JOptionPane.showInputDialog("Valor") );
            System.out.printf("El valor es %d\n",number);

            int[] nums = {45,7,843,66};
            System.out.println(nums[10]);
        }catch (ArithmeticException e){
            System.out.println("Error, no se puede dividir por cero");
        }catch(NumberFormatException e){
            System.out.println("Valor no Válido");
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Indice Fuera de Limite ");
        }


        System.out.println("*************FIN DEL PROGRAMA***************");
    }
}
