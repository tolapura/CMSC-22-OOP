package lab9_1;
import static lab9_1.ClearScreen.clear;

public class MovableRectangle implements Movable, Drawable {
	
	private MovablePoint topLeft;
	private MovablePoint bottomRight;

	public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed){
		topLeft = new MovablePoint(x1, y1, xSpeed, ySpeed);
		bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
	}

	public String toString(){
		return String.format("RECTANGLE Coordinates: topleft: %d %d, bottomright: %d %d with speeds x=%d y=%d", topLeft.x, topLeft.y, bottomRight.x, bottomRight.y, topLeft.xSpeed, topLeft.ySpeed);
	}

	public void moveUp() {
		topLeft.moveUp();
		bottomRight.moveUp();
	}

	public void moveDown() {
		topLeft.moveDown();
		bottomRight.moveDown();
	}

	public void moveLeft() {
		topLeft.moveLeft();
		bottomRight.moveLeft();
	}

	public void moveRight() {
		topLeft.moveRight();
		bottomRight.moveRight();
	}

	public void render() {
		ClearScreen clr = new ClearScreen();
		clr.clear();
		for(int i = 0, j = 0; i <= bottomRight.y; j++){
			if(j > bottomRight.x || i < topLeft.y){
				i++;
				j=0;
				System.out.println();
			}
			else if(j == topLeft.x || j == bottomRight.x){
				System.out.print("*");
			}
			else if(j <= topLeft.x){
				System.out.print("-");
			}
			else if(i == topLeft.y || i == bottomRight.y){
				System.out.print("*");
			}
			else if(j == topLeft.x || j == bottomRight.x){
				System.out.print("*");
			}
			else{
				System.out.print("-");
			}
		}
    }
}
