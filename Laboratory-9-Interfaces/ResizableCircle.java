package lab9_2;

public class ResizableCircle extends Circle implements Resizable {
	public ResizableCircle(double radius){
		this.radius = radius;
	}
	public void resize(int percent){
		radius = radius * ((percent + 100)/100);
	}
	public String toString() {
		return String.format("A resizable circle with radius %.02f", radius);
	}
}
