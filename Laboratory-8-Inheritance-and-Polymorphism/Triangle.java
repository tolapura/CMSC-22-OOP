package SHAPES;

public class Triangle extends Shape2 {

    public double a;
    public double b;
    public double c;

    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    public Triangle(double a, double b, double c) {
        if (!isValid())
            throw new IllegalArgumentException("INVALID LENGTHS");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean isValid() {
        return ((a < (b + c) && a > Math.abs(b - c)) ||
                (b < (a + c) && b > Math.abs(a - c)) ||
                (c < (a + b) && c > Math.abs(a - b)));
    }

    public Triangle(double a, double b, double c, String color, boolean filled) {
        super(color, filled);
        if (!isValid())
            throw new IllegalArgumentException("INVALID LENGTHS");
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void setLength(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getLengthA(){
        return a;
    }

    public double getLengthB(){
        return b;
    }

    public double getLengthC(){
        return c;
    }

    public double getArea() {
        double p = getPerimeter() / 2.0;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    public double getPerimeter() {
        return a + b + c;
    }

    public String toString() {
        return String.format("A Triangle with sides %f, %f, %f and a subclass of %s", a, b, c, super.toString());
    }
}
