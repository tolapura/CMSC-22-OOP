package Pong;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Racquet {
    private static final int WIDTH = 60; // width of the racquet
    private static final int HEIGHT = 10; // height of the racquet
    int x = 100; // coordinate of the racquet
    int xa = 0;
    int score = 0;
    private Game game;
    int y; // y coordinate of the racquet

    public Racquet(Game game, int y) {
        this.game = game;
        this.y = y;
    }
    public void move() { // this method is called to move the racquet
        if (x + xa > 0 && x + xa < game.getWidth() - WIDTH)
            x = x + xa;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) { this.score = score; }
    public void addScore() {
        this.score++;
    }
    public void paint(Graphics2D g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }
}