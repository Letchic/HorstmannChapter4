package com.letchic.shapes;
import com.letchic.point.Point;

public class Line extends Shape {
    private Point to;

    public Line(Point from, Point to){
        super(from);
        this.to = to;
    }
    @Override
    public Point getCenter() {
        return new Point((to.getX()-point.getX())/2,(to.getY()-point.getY())/2);
    }
    @Override
    public Line clone(){
        return new Line(new Point(point.getX(),point.getY()),new Point(to.getX(),to.getY()));
    }

    @Override
    public String toString() {
        return "Line{" +
                "to=" + to +
                ", point=" + point +
                '}';
    }
}