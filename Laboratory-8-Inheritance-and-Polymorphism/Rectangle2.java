package SHAPES;

public class Rectangle2 extends Shape2 {
    protected double width;
    protected double length;

    public Rectangle2(){
        this(1.0, 1.0);
    }

    public Rectangle2(double width, double length){
        this.width = width;
        this.length = length;
    }

    public Rectangle2(double width, double length, String color, boolean filled){
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth(){
        return width;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public double getLength(){
        return length;
    }

    public void setLength(double length){
        this.length = length;
    }

    public double getArea(){
        return width * length;
    }

    public double getPerimeter(){
        return 2 * (length + width);
    }
    public String toString(){
        return String.format("A Rectangle with width = %f and length = %f, which is a subclass of A shape with a color of %s and %s.", width, length, color, super.toString());
    }

}
