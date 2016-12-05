package lab9_1;
import static lab9_1.ClearAndSleep.clear;

public class MovableCircle implements Movable, Drawable {
	
	private int radius;
	private MovablePoint center;

	public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius){
		center = new MovablePoint(x, y, xSpeed, ySpeed);
		this.radius = radius;
	}

	public String toString(){
		return String.format("CIRCLE coordinates: x = %d, y = %d", center.x, center.y);
	}

	public void moveUp() { center.moveUp(); }

	public void moveDown() {
		center.moveDown();
	}

	public void moveLeft() {
		center.moveLeft();
	}

	public void moveRight() {
		center.moveRight();
	}

	public void render() {

	}
}