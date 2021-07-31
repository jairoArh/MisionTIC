package model;

import java.awt.*;

public class Rectangle extends Figure{
    private double width;
    private double height;

    public Rectangle(Point point, double width, double height) {
        super(point);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height;
    }

    @Override
    public double calcPerimeter() {
        return 2 * width + 2 * height;
    }

    @Override
    public void draw(Graphics graphics) {

    }

    public double getDiagonal(){
        return Math.sqrt(Math.pow(width,2) + Math.pow( height, 2));
    }

    public boolean isSquare(){
        return width == height;
    }
}
