package Pacman;

import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.Random;

import static Pacman.Images.*;
import static Pacman.Sounds.*;
import static Pacman.Scores.*;
import static Pacman.MenuScreen.*;
import static Pacman.Main.*;


public class Timed extends BasicGameState {

    public Ghosts ghost;
    public int countScore;
    public int ghostSpeed;
    public int ammo;
    public Random random;
    public Pacman pacman;
    public List<Bullet> bullets;
    public String pause;
    public String gameEnd;
    public int countDown;
    public int counter;
    public boolean time;
    public float timeX;
    public float timeY;
    public Image timer;

    public Timed(int state) {

    }
    @Override
    public int getID() {
        return 8;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        timer = new Image("res/Images/alarm.png");
        time = false;
        ammo = 5;
        ghostSpeed = 0;
        countDown = 15000;
        counter = 0;
        pause = "";
        gameEnd = "";
        random = new Random();
        ghost = new Ghosts(random.nextInt(4) + 1);
        countScore = 0;
        pacman = new Pacman();
        pacman.pacmanX = 200;
        bullets = new ArrayList<Bullet>();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(background, 0, 0);
        graphics.setColor(Color.yellow);
        graphics.fillOval(pacman.pacmanX, pacman.pacmanY, pacman.radius, pacman.radius, 200);
        for (Bullet b : bullets) {
            b.move.draw(b.bulletX, b.bulletY);
        }
        graphics.setColor(Color.white);
        graphics.drawString(pause, 150, 200);
        graphics.drawString(gameEnd,170,270);
        graphics.drawString("Bullets: " + ammo + "  Kill Count: " + countScore + "  Countdown: " + countDown / 1000, 70,20);
        ghost.move.draw(ghost.ghostX, ghost.ghostY);
        if(time){
            timer.draw(timeX, timeY);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = gameContainer.getInput();
        checkStatus(gameContainer, delta, stateBasedGame);
        if(time){
            timeY += delta/2.0f;
        }
        if (input.isKeyPressed(Input.KEY_ENTER)) {
            if (gameContainer.isPaused()) {
                pause = " ";
                gameContainer.resume();
            } else {
                pause = "Press Enter to play.";
                gameContainer.pause();
            }
        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            if (pacman.pacmanX >= 15.5) {
                pacman.pacmanX -= delta / 3.f;
            }
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            if (pacman.pacmanX <= 458) {
                pacman.pacmanX += delta / 3.f;
            }
        }
        if (input.isKeyPressed(Input.KEY_SPACE) && !gameContainer.isPaused() && ammo != 0) {
            bullets.add(new Bullet(pacman.pacmanX));
            if(soundState) {
                shot.play();
            }
            ammo--;
        }
        if(time) {
            Rectangle r = new Rectangle((int)timeX, (int)timeY, timer.getWidth(), timer.getHeight());
            if (r.intersects(pacman.bounds())){
                s.feed.play();
                countDown += 3000;
                time = false;
            }
        }
        moveBullets(delta);
        moveGhost(delta);
    }

    public void checkStatus(GameContainer gameContainer, int delta, StateBasedGame SBG)throws SlickException {
        counter += delta;
        if(counter > 5000){
            Random rand = new Random();
            counter = 0;
            time = true;
            timeX = rand.nextInt(410) + 17;
            timeY = 0;
        }
        if(timeY > 500){
            time = false;
        }
        if(!gameContainer.isPaused()){
        countDown -= delta;
        }
        if ((bullets.size() == 0 && ammo == 0) || countDown / 1000 <= 0) {
            s.stopAll();
            gameEnd = "G A M E  O V E R";
            p.setScore(countScore);
            p.setMode(2);
            if (soundState) {
                gameOver.play();
                backgroundMenu.play();
            }
            if(hs.checkTopTen(p)){
                SBG.enterState(6, new FadeOutTransition(Color.black, 2000), new FadeInTransition());
            }
            else{
                SBG.enterState(5, new FadeOutTransition(Color.black, 2000), new FadeInTransition());
            }
        }
    }

    public void moveGhost(int delta) {
        ghostSpeed += delta;
        if (ghostSpeed >= 900) {
            ghost.ghostX = random.nextInt(410) + 17;
            ghostSpeed = 0;
        }
        ghost.ghostY += delta / 5.0f;
        if (ghost.ghostY > 430) {
            ghost.ghostY = 10;
        }
    }

    public void moveBullets(int delta) throws SlickException {
        for (Iterator<Bullet> iterator = bullets.iterator(); iterator.hasNext(); ) {
            Bullet b = iterator.next();
            b.bulletY -= delta / 2.0f;
            if (b.bounds().intersects(ghost.bounds())) {
                iterator.remove();
                ghost = new Ghosts(random.nextInt(4) + 1);
                countScore++;
                ammo += 3;
            }
            if(b.bulletY <= 0){
                iterator.remove();
            }
        }
    }
}