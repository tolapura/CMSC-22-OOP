package Pacman;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import java.util.*;
import java.util.Random;

import static Pacman.MenuScreen.*;
import static Pacman.Sounds.*;
import static Pacman.Images.*;
import static Pacman.Main.*;
public class Revenge extends BasicGameState {

    public Ghosts ghost;
    public int countScore;
    public float ghostSpeed;
    public int life;
    public Random random;
    public Pacman pacman;
    public List<Bullet> bullets;
    public List<Ghosts> listOfGhosts;
    public String pause;
    public int countDown;
    public Random rand;
    public int bomb;
    public int counter;
    public Input input;
    public Revenge(int state) {

    }

    @Override
    public int getID() {
        return 9;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        rand = new Random();
        counter = 0;
        bomb = 3;
        life = 3;
        ghostSpeed = 5.0f;
        countDown = 0;
        pause = "";
        random = new Random();
        ghost = new Ghosts(random.nextInt(4) + 1);
        countScore = 0;
        pacman = new Pacman();
        pacman.pacmanX = 200;
        bullets = new ArrayList<Bullet>();
        listOfGhosts = new ArrayList<Ghosts>();
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(modeRevenge, 0, 0);
        graphics.setColor(Color.yellow);
        graphics.fillOval(pacman.pacmanX, pacman.pacmanY, pacman.radius, pacman.radius, 200);
        for (Bullet b : bullets) {
            b.move.draw(b.bulletX, b.bulletY);
        }
        for (Ghosts g : listOfGhosts) {
            g.move.draw(g.ghostX, g.ghostY);
        }
        graphics.setColor(Color.white);
        graphics.drawString(pause, 150, 200);
        graphics.drawString("Lives: " + life + "  Kill Count: " + countScore + "   Bombs: " + bomb, 90, 15);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = gameContainer.getInput();
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
        if (input.isKeyDown(Input.KEY_UP)) {
            if (pacman.pacmanY > 10) {
                pacman.pacmanY -= delta / 3.f;
            }
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            if (pacman.pacmanY < 490) {
                pacman.pacmanY += delta / 3.f;
            }
        }
        if (input.isKeyPressed(Input.KEY_SPACE) && !gameContainer.isPaused()) {
            bullets.add(new Bullet(pacman.pacmanX, pacman.pacmanY));
            if(soundState) {
                shot.play();
            }
        }
        if (input.isKeyPressed(Input.KEY_C) && !gameContainer.isPaused()) {
            if(bomb != 0) {
                bullets.add(new Bullet(0));
                if(soundState) {
                    soundBomb.play();
                }
                bomb--;
            }
        }
        input.clearKeyPressedRecord();
        checkStatus(gameContainer,delta,stateBasedGame,input);
        moveBullets(delta);
        moveGhost(delta);
    }

    public void checkStatus(GameContainer gameContainer, int delta, StateBasedGame SBG,Input input )throws SlickException {
        if (life == 0) {
            s.stopAll();
            input.clearKeyPressedRecord();
            input.clearControlPressedRecord();
            p.setScore(countScore);
            p.setMode(3);
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

    public void moveGhost(int delta) throws SlickException {
        countDown += delta;
        counter += delta;
        if (countDown > 500) {
            listOfGhosts.add(new Ghosts(rand.nextInt(4) + 1));
            countDown = 0;
        }
        if (counter/100 % 200 == 0 && counter >= 20000) {
            System.out.println("ADD SPEED!");
            ghostSpeed -= .5f;
            counter += 100;
        }
        for (Iterator<Ghosts> iterator = listOfGhosts.iterator(); iterator.hasNext(); ) {
            Ghosts ghost = iterator.next();
            ghost.ghostY += delta / ghostSpeed;
            if (bullets.size() != 0) {
                for (Iterator<Bullet> iter = bullets.iterator(); iter.hasNext(); ) {
                    Bullet bullet = iter.next();//BULLETS
                    if (ghost.bounds().intersects(bullet.bounds())) {
                        countScore++;
                        if(countScore % 30 == 0 && countScore > 0){
                            bomb++;
                        }
                        if(bullet.type == 1) {
                            iter.remove();
                        }
                        iterator.remove();
                    }
                }
            }
        }
        for (Iterator<Ghosts> iterator = listOfGhosts.iterator(); iterator.hasNext(); ) {
            Ghosts ghost = iterator.next();
            if (ghost.ghostY > 500) {
                life--;
                iterator.remove();
            }
        }
    }

    public void moveBullets(int delta) throws SlickException {
        for (Iterator<Bullet> iterator = bullets.iterator(); iterator.hasNext(); ) {
            Bullet b = iterator.next();
            b.bulletY -= delta / 2.0f;
            if (b.bulletY <= 0) {
                if(b.type == 2){
                    if(b.bulletY <= 0){
                        iterator.remove();
                    }
                }else{
                    iterator.remove();
                }
            }
        }
    }
}