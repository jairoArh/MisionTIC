package run;

import model.Circle;
import model.Figure;
import model.Rectangle;
import model.Triangle;

import java.awt.*;

public class Runner {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle( new Point(10,5),10, 5);
        System.out.printf( "El Area del Rectangulo es %f\n",calcArea( rectangle ) );

        Circle circle = new Circle(new Point(34,87),50);
        System.out.printf( "El Area del Circulo es %f\n",calcArea( circle ));

        Triangle triangle = new Triangle( new Point(4,12), new Point(34,87), new Point(54,87));
        System.out.printf( "El Area del Triangulo es %f\n",calcArea( triangle ));

    }

    public static double calcArea( Figure figure ){

        return figure.calcArea();
    }
}
