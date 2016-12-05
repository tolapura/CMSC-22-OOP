package lab9_2;

public class Circle implements GeometricObject{
	protected double radius;
	public Circle(){
		this(1.0);
	}
	public Circle(double radius){
		this.radius = radius;
	}
	public double getPerimeter(){
		return 2 * radius * Math.PI;
	}
	public double getArea(){
		return Math.PI * Math.pow(radius, 2);
	}
	public String toString(){
		return String.format("A circle with radius %.02f", radius);
	}

}
