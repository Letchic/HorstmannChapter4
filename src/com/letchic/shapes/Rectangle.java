package com.letchic.shapes;

import com.letchic.point.Point;

public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height){
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override
    public Point getCenter() {
        return new Point((point.getX()+width)/2,(point.getY()-height)/2);
    }

    @Override
    public Rectangle clone(){
        return new Rectangle(new Point(point.getX(),point.getY()),width,height);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", point=" + point +
                '}';
    }
}