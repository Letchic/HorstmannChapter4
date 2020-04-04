package com.letchic;

import com.letchic.differenttostring.Box;
import com.letchic.enumeration.Colors;
import com.letchic.itemequals.DiscountedItem;
import com.letchic.itemequals.Item;
import com.letchic.point.LabeledPoint;
import com.letchic.point.Point;
import com.letchic.reflection.PrintHelloWorld;
import com.letchic.reflection.Table;
import com.letchic.reflection.Test;
import com.letchic.reflection.tostring.Example;
import com.letchic.reflection.tostring.UniversalToString;
import com.letchic.shapes.Circle;
import com.letchic.shapes.Line;
import com.letchic.shapes.Rectangle;
import com.sun.org.apache.bcel.internal.classfile.InnerClass;
import java.lang.reflect.Method;
import java.util.function.DoubleFunction;
import static com.letchic.reflection.methods.AllMethods.printMethod;

public class Main {


    public static void main(String[] args) throws Throwable {

       //Ex1
        Point point = new Point(3,44);
        System.out.println(point);

        LabeledPoint lPoint = new LabeledPoint("Origin", 0, 0);
        System.out.println(lPoint);
        //Ex2
        LabeledPoint point1 = new LabeledPoint("A", 10, 20);
        LabeledPoint point2 = new LabeledPoint("A", 10, 20);
        LabeledPoint point3 = new LabeledPoint("B", 4, 2);

        System.out.println(point1.equals(point2));
        System.out.println(point2.equals(point1));
        System.out.println(point3.equals(point2));

        //Ex3

        //System.out.println(lPoint.x); //no access to x

        //Ex4
        Circle c = new Circle(new Point(1, 2), 3);
        Rectangle r = new Rectangle(new Point(5, 0), 10, 10);
        Line l = new Line(new Point(0, 0), new Point(10, 6));
        System.out.println(c.getCenter());
        System.out.println(r.getCenter());
        System.out.println(l.getCenter());

        //Ex5
        System.out.println(c.clone().toString());
        System.out.println(r.clone().toString());
        System.out.println(l.clone().toString());


        //Ex6
        DiscountedItem x = new DiscountedItem("Description",100,0);
        Item y = new Item          ("Description",100);
        DiscountedItem z = new DiscountedItem("Description",100,10);
        System.out.println(x.equals(y));
        System.out.println(y.equals(z));
        System.out.println(x.equals(z));

        //Ex7
        Colors red = Colors.getRed();
        System.out.println(red);

        //Ex8
        Class<?> cl1 = Integer[].class;
        Class<?> cl2 = Box.class;
        Class<?> cl3 = InnerClass.class;
        Class<?> cl4 = int.class;
        System.out.println("Canonical name:");
        System.out.println(cl1.getCanonicalName());
        System.out.println(cl2.getCanonicalName());
        System.out.println(cl3.getCanonicalName());
        System.out.println(cl4.getCanonicalName());
        System.out.println();
        System.out.println("Simple name:");
        System.out.println(cl1.getSimpleName());
        System.out.println(cl2.getSimpleName());
        System.out.println(cl3.getSimpleName());
        System.out.println(cl4.getSimpleName());
        System.out.println();
        System.out.println("Type name:");
        System.out.println(cl1.getTypeName());
        System.out.println(cl2.getTypeName());
        System.out.println(cl3.getTypeName());
        System.out.println(cl4.getTypeName());
        System.out.println();
        System.out.println("Name:");
        System.out.println(cl1.getName());
        System.out.println(cl2.getName());
        System.out.println(cl3.getName());
        System.out.println(cl4.getName());
        System.out.println();
        System.out.println("toString:");
        System.out.println(cl1);
        System.out.println(cl2);
        System.out.println(cl3);
        System.out.println(cl4);
        System.out.println();
        System.out.println("Generic string:");
        System.out.println(cl1.toGenericString());
        System.out.println(cl2.toGenericString());
        System.out.println(cl3.toGenericString());
        System.out.println(cl4.toGenericString());

        //Ex9
        Example exm = new Example("Some words", 42, true);
        System.out.println(UniversalToString.toString(exm));


        //Ex10
        int[] intArrayClass = new int[1];
        printMethod(intArrayClass);

        //Ex11
        PrintHelloWorld.print();

        //Ex12
        long t1 = System.currentTimeMillis();
        Test.testDirect(1);
        long t2 = System.currentTimeMillis();
        System.out.println("Direct invocation: " + (t2-t1) + "ms");

        long t3 = System.currentTimeMillis();
        Method m = Test.class.getDeclaredMethod("myMin", int.class, int.class);
        Test.testReflection(1, m);
        long t4 = System.currentTimeMillis();
        System.out.println("Invocation by reflection: " + (t4-t3) + "ms");

        //Ex13
        Method sqrt = Math.class.getMethod("sqrt",double.class);
        Table.printTable(sqrt,1,9,1);

        Method toHexString = Double.class.getMethod("toHexString",double.class);
        Table.printTable(toHexString,-2,2,0.5);

        DoubleFunction<Integer> df = (a) -> (int)(a * 10);
        Table.printTableDoubleFucntion(df,-2,2,0.5);
    }
}
