package com.letchic.shapes;
import com.letchic.point.Point;

public class Circle extends Shape {

    private double radius;
    public Circle(Point center, double radius){
        super(center);
        this.radius = radius;
    }
    @Override
    public Point getCenter() {
        return point;
    }
    @Override
    public Circle clone(){
        return new Circle(new Point(point.getX(),point.getY()),radius);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", point=" + point +
                '}';
    }
}
