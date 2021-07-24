package test;

import model.Car;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
        //Instanciar un ArrayList que almacena enteros
        ArrayList<Integer> numbers = new ArrayList<>();

        //Adicionar elementos al arreglo
        numbers.add(4);
        numbers.add(65);
        numbers.add(41);
        numbers.add(34);
        numbers.add(74);

        //Conocer el tamaño o numero de elmentos del aereglo
        System.out.printf("El Tamaño es %d\n",numbers.size());

        //Obtener un elemento del arreglo
        System.out.printf("El Tercer elemento es %d\n",numbers.get(2));
        //La siguiente línea genera un error y se lanza una excepción, por estar fuera
        //de los límites del arreglo
        //System.out.printf("El Tercer  elemento es %d\n",numbers.get(10));


        //Recorrer la coleccion
        for( int index = 0 ; index < numbers.size() ; index++ ){
            System.out.printf("numbers[%d]=%d\n", index, numbers.get( index ) );
        }

        for( Integer number : numbers ){
            System.out.printf("%d\t",number);
        }
        System.out.println();

        //Ejemplos de colecciones con objetos de una clase;
        mngCars();
    }

    private static void mngCars() {
        //Instanciar la colección
        ArrayList<Car> cars = new ArrayList<>();
         cars.add( new Car("JTR435","Renault 4",(short)1979,"Verde Militar",2_300_000));
         cars.add( new Car("HYW737","Chevrolert Corsa",(short)2004,"Gris",7_800_000));
         cars.add( new Car("ABC924","Mazda CX5",(short)2017,"Rojo Pasion",72_500_000));
         cars.add( new Car("USB301","Ford Fiesta",(short)2010,"Azul Tormenta",12_000_000));
         cars.add( new Car("JFA743","Nissan Murano",(short)2018,"Blanco",90_000_000));

         for( Car car : cars ){
             System.out.println( car );
         }

         //Ordenar los Elementos de la Colección
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Double.compare(o1.getValue(), o2.getValue());
            }
        });
        System.out.println("---------------Ordenado-----------------");
        //Visualizar el arreglo de carros ordenado
        for( Car car : cars ){
            System.out.println( car );
        }
    }
}
