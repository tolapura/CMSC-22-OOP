package Pong;
import java.applet.Applet;
import java.applet.AudioClip;

public class Sound { // this class holds all the sound effects used in the game
    public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("ball.wav"));
    public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
    //public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("back.wav"));
}