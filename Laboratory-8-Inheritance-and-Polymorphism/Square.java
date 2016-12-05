package SHAPES;

public class Square extends Rectangle {

    public Square(){
        super(1.0, 1.0);
    }

    public Square(double side){
        super(side, side);
    }

    public Square(double side, String color, boolean filled){
        super(side, side, color, filled);
    }

    public double getSide(){
        return super.length; // you can also use the super.width
    }

    public void setSide(double side){
        super.setLength(side);
        super.setWidth(side);
    }

    public void setWidth(double side){
        super.setWidth(side);
    }

    public void setLength(double side){
        super.setLength(side);
    }

    public String toString() {
        return String.format("A square with side = %f, which is a subclass of %s", super.length, super.toString());
    }

    // try them out daw

    public double getArea() {
        return (super.length * super.width);
    }

    public double getPerimeter(){
        return (super.length + super.width) * 2;
    }

}

