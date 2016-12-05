package lab9_1;
import static lab9_1.ClearScreen.clear;

public class MovablePoint implements Movable, Drawable {

    int x;
    int y;
    int xSpeed;
    int ySpeed;


    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }


    public String toString() {
        return String.format("POINT coordinates: x = %d, y = %d", x, y);
    }

    public void moveUp() {
        y -= ySpeed;
    }

    public void moveDown() {
        y += ySpeed;
    }

    public void moveLeft() {
        x -= xSpeed;
    }

    public void moveRight() {
        x += xSpeed;
    }

    public void render() {
        ClearScreen clr = new ClearScreen();
        clr.clear();
        int ctr = 0;
        while (ctr < y) {
            for (int i = 0; i <= x; i++) {
                System.out.print("-");
                if (i == x) {
                    System.out.println();
                }
            }
            ctr++;
        }
        for (int i = 0; i < x; i++) {
            System.out.print("-");
        }
        System.out.print("*");
    }
}