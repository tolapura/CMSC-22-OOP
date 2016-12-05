package Pacman;

import org.newdawn.slick.*;

public class Sounds {
    public static Music backgroundMenu;
    public static Sound gameOver;
    public static Sound feed;
    public static Sound invisibleMode;
    public static Sound click;
    public static Sound shot;
    public static Sound halloween;
    public static Sound halloweenFast;
    public static Sound revenge;
    public static Sound day;
    public static Sound dayFast;
    public static Sound night;
    public static Sound nightFast;
    public static Sound school;
    public static Sound schoolFast;
    public static Sound summer;
    public static Sound summerFast;
    public static Sound timed;
    public static Sound soundBomb;


    public Sounds() throws SlickException {
        soundBomb = new Sound("res/Sounds/bomb.wav");
        backgroundMenu = new Music("res/Sounds/bg.wav");
        gameOver = new Sound("res/Sounds/gameOver.wav");
        feed = new Sound("res/Sounds/ball.wav");
        click = new Sound("res/Sounds/click effect.wav");
        shot = new Sound("res/Sounds/gun.wav");
        halloween = new Sound("res/Sounds/songHalloween.wav");
        halloweenFast = new Sound("res/Sounds/songHalloween2.wav");
        day = new Sound("res/Sounds/songDay.wav");
        dayFast = new Sound("res/Sounds/songDay2.wav");
        summer = new Sound("res/Sounds/songSummer.wav");
        summerFast = new Sound("res/Sounds/songSummer2.wav");
        school = new Sound("res/Sounds/songSchool.wav");
        schoolFast = new Sound("res/Sounds/songSchool2.wav");
        night = new Sound("res/Sounds/songNight.wav");
        nightFast = new Sound("res/Sounds/songNight2.wav");
        timed = new Sound("res/Sounds/songTimed.wav");
        revenge = new Sound("res/Sounds/songRevenge.wav");
    }

    public void stopAll(){
        backgroundMenu.stop();
        gameOver.stop();
        feed.stop();
        click.stop();
        shot.stop();
        halloween.stop();
        halloweenFast.stop();
        revenge.stop();
        night.stop();
        nightFast.stop();
        school.stop();
        schoolFast.stop();
        day.stop();
        dayFast.stop();
        timed.stop();
        summer.stop();
        summerFast.stop();
    }
}
