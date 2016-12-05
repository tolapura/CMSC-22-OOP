package Pacman;

import org.lwjgl.input.Mouse;
import org.lwjgl.openal.AL;
import org.newdawn.slick.*;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

import static Pacman.Images.*;
import static Pacman.Main.*;
import static Pacman.MenuScreen.*;
import static Pacman.Scores.*;

public class WinScreen extends BasicGameState {
    private boolean b1flag = false;
    private boolean b2flag = false;
    private boolean b3flag = false;
    private TextField nameField;
    private boolean type = true;

    public WinScreen(int state) {

    }

    public WinScreen() {

    }

    @Override
    public int getID() {
        return 6;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        nameField = new TextField(gameContainer, gameContainer.getDefaultFont(), 200, 300, 180, 40);
        nameField.setBorderColor(Color.black);
        nameField.setAcceptingInput(true);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(winner, 0, 0);
        nameField.render(gameContainer, graphics);
        //graphics.drawString(name, 220, 300);

        if (!b1flag && !b2flag && !b3flag) {
            graphics.drawImage(b1, 130, 390);
            graphics.drawImage(b2, 230, 390);
            graphics.drawImage(b3, 320, 390);
        } else {
            if (b1flag) {
                graphics.drawImage(b2, 230, 390);
                graphics.drawImage(b3, 320, 390);
                b1.setFilter(Image.FILTER_LINEAR);
                b1.draw(120, 385, 1.2f);
            } else if (b2flag) {
                graphics.drawImage(b1, 130, 390);
                graphics.drawImage(b3, 320, 390);
                b2.setFilter(Image.FILTER_LINEAR);
                b2.draw(220, 385, 1.2f);
            } else if (b3flag) {
                graphics.drawImage(b2, 230, 390);
                graphics.drawImage(b1, 130, 390);
                b3.setFilter(Image.FILTER_LINEAR);
                b3.draw(310, 385, 1.2f);
            }
        }
        if (!type) {
            graphics.drawString("ADDED TO THE LEADERBOARD!", 135, 270);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        int xPos = Mouse.getX();
        int yPos = Mouse.getY();
        if((input.isKeyPressed(Input.KEY_ENTER) && type)){
            if(nameField.getText().length() < 9){
                p.setName(nameField.getText());
            }
            else{
                p.setName(nameField.getText().substring(0,8));
            }
            nameField.setText("");
            hs.saveToList(p);
            nameField.setAcceptingInput(false);
            type = false;
        }
        if ((xPos >= 130 && xPos <= 170) && (yPos <= 205 && yPos >= 160)) {
            b1flag = true;
            if (input.isMousePressed(0)) {
                nameField.setAcceptingInput(true);
                nameField.setText("");
                type = true;
                p = new Player();
                stateBasedGame.getState(prev).init(gameContainer, stateBasedGame);
                stateBasedGame.enterState(prev, new FadeOutTransition(), new FadeInTransition());
            }
        } else if ((xPos >= 235 && xPos <= 280) && (yPos <= 210 && yPos >= 160)) {
            b2flag = true;
            if (input.isMousePressed(0)) {
                nameField.setAcceptingInput(true);
                nameField.setText("");
                type = true;
                p = new Player();
                stateBasedGame.enterState(0, new FadeOutTransition(), new FadeInTransition());
            }
        } else if ((xPos >= 320 && xPos <= 370) && (yPos <= 205 && yPos >= 160)) {
            b3flag = true;
            if (input.isMousePressed(0)) {
                nameField.setAcceptingInput(true);
                nameField.setText("");
                type = true;
                p = new Player();
                stateBasedGame.enterState(3, new FadeOutTransition(), new FadeInTransition());
            }
        } else {
            b1flag = b2flag = b3flag = false;
        }
    }


}