package Pong;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
    private static final int DIAMETER = 20;
    int x = 0; // coordinates
    int y = 0; // coordinates
    int xa = 1; // speed in terms of x axis
    int ya = 1; // speed in terms of y axis
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }
    void move() { // this method is called to move the ball
        boolean changeDirection = true;
        if (x + xa <= 0) {
            xa = game.speed;
        } else if (x + xa > game.getWidth() - DIAMETER) {
            xa = -game.speed;
        } else if (y + ya < 0) {
            game.racquet2.addScore();
            game.speed = 1;
            game.gameOver();
        } else if (y + ya > game.getHeight() - DIAMETER) {
            game.racquet.addScore();
            game.speed = 1;
            game.gameOver();
        } else if (collision()) {
            System.out.println(y);
            ya = -game.speed++; // if the ball collides with the racquet, the speed increases
        } else if (collision2()){
            System.out.println(y);
            ya = game.speed++;
        } else changeDirection = false;
        if (changeDirection)
            Sound.BALL.play();
        x = x + xa;
        y = y + ya;
    }
    public boolean collision() {return game.racquet.getBounds().intersects(getBounds());}
    public boolean collision2() {return game.racquet2.getBounds().intersects(getBounds());}
    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }
    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}