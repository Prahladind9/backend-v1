package edu.prahlad.java.course4.chap9;

public class Circle {

    public static void main(String[] args) {
        Circle circle1 = new Circle();
        System.out.println("The area of the circle of radius "
                + circle1.radius + " is " + circle1.getArea());
    }

    double radius = 1;

    Circle(){}
    Circle(double newRadius){
        this.radius = newRadius;
    }

    double getArea(){
        return radius * radius * Math.PI;
    }

    double getPerimeter(){
        return 2 * radius * Math.PI;
    }

    void setRadius(double newRadius){
        this.radius = newRadius;
    }
}
