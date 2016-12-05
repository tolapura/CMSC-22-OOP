package Pong;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Game extends JPanel {
    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this, 350); // instances of 2 racquets
    Racquet racquet2 = new Racquet(this, 10);
    int speed = 1; // this is the starting speed of the ball

    public Game() {
        // this part is the implementation of the KeyListener which gets
        // the key controls clicked by the players
        addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {}
            public void keyReleased(KeyEvent e) { racquet.xa = racquet2.xa =  0;}
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                    racquet.xa = -2; // the racquet goes to left
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                    racquet.xa = 2; // the racquet goes to right
                } else if ((e.getKeyCode() == KeyEvent.VK_UP) && (ball.y <= 340 && ball.y >= 320)) {
                    speed += 5; // speed adds 10 when power smash is used
                } else if (e.getKeyCode() == KeyEvent.VK_A) {
                    racquet2.xa = -2;
                } else if (e.getKeyCode() == KeyEvent.VK_D) {
                    racquet2.xa = 2;
                } else if ((e.getKeyCode() == KeyEvent.VK_W) && (ball.y <= 25 && ball.y >= 5)) {
                    speed += 5;
                }
            }
        });
        setFocusable(true);
       // Sound.BACK.loop();
    }
    public void move() {
        // this method allows the ball and racquet to move
        ball.move();
        racquet.move();
        racquet2.move();
    }
    @Override
    public void paint(Graphics g) {
        // this paints the game screen
        super.paint(g); // cleans the screen
        g.setColor(Color.decode("#f5f7b8")); // hexa code of a color.
        g.fillRect(0, 0, 300, 175);
        g.setColor(Color.decode("#8ddaee")); // i got these color codes in Photoshop, isn't it amazing?
        g.fillRect(0, 175, 300, 200);
        g.setColor(Color.black);
        g.fillRect(0, 173, 300, 3);
        g.setColor(Color.decode("#613131"));
        g.fillRect(0, 0, 300, 5);
        g.fillRect(0, 367, 300, 5);
        g.fillRect(0, 0, 5, 400);
        g.fillRect(290, 0, 5, 400);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); // makes the border smoother
        int R = (int) (Math.random( )*256);
        int G = (int)(Math.random( )*256);
        int B= (int)(Math.random( )*256);
        Color randomColor = new Color(R, G, B); // random color for the ball
        g2d.setColor(randomColor);
        ball.paint(g2d);

        g2d.setColor(Color.darkGray);
        racquet.paint(g2d); // racquet is painted dark gray
        racquet2.paint(g2d);
        g2d.setColor(Color.darkGray);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore()), 10, 170);

        g2d.setColor(Color.darkGray);
        g2d.setFont(new Font("Verdana", Font.BOLD, 30));
        g2d.drawString(String.valueOf(getScore2()), 265, 200);
    }
    private int getScore() { // this returns the score of player 1
        return racquet.getScore();}
    private int getScore2() { // this returns the score of player 2
        return racquet2.getScore(); }
    public void gameOver() {
        // this method is called once the game ends
       // Sound.BACK.stop();
        if (racquet.getScore() == 3 || racquet2.getScore() == 3) {
            Sound.GAMEOVER.play();
            int n = JOptionPane.showConfirmDialog(this,
                    getScore() > getScore2() ? "Player 1 wins! Try Again?" : "Player 2 wins! Try Again?",
                    "Game Over", JOptionPane.YES_NO_OPTION);
            if (n == JOptionPane.YES_OPTION) {
                racquet.setScore(0); // new game begins, scores for both racquets go back to 0
                racquet2.setScore(0);
                gameOver();
            } else {
                JOptionPane.showMessageDialog(this, "Thanks for playing Pong!", "EXIT", JOptionPane.OK_OPTION);
                System.exit(0); // the system exits
            }
        } else {
            racquet.x = 100; // the components are set to their starting position
            racquet2.x  = 100;
            ball.x = 0;
            ball.y = 0;
            ball.xa = 1;
            ball.ya = 1;
        }
    }
}