package SHAPES;

public class Circle extends Shape {

    private double radius;
    public static final double Math_PI = 3.141592653;

    public Circle() {
        radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, Boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math_PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math_PI * radius;
    }

    public String toString() {
        return String.format("A circle with radius = %f, which is a subclass of %s", radius, super.toString());
    }

}
