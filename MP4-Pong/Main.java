package Pong;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    JFrame frame;
    JLabel forBG;
    JButton start, quit, help;
    private Game game;
    public Main() {
        // all the instance variables are declared
        game = new Game();
        frame = new JFrame("PONG");
        frame.setLayout(null);
        frame.setSize(300, 400);
        forBG = new JLabel("");
        forBG.setIcon(new ImageIcon(getClass().getResource("image.jpg")));
        forBG.setBounds(0, 0, 300, 400);
        start = new JButton("Play");
        start.setBounds(100, 200, 100, 30);
        help = new JButton("Help");
        help.setBounds(100, 235, 100, 30);
        quit = new JButton("Quit");
        quit.setBounds(100, 270, 100, 30);
        frame.add(start);
        frame.add(help);
        frame.add(quit);
        frame.add(forBG);
        frame.setResizable(false);
        frame.setVisible(true);
        start.addActionListener(new MyButtonListener());
        help.addActionListener(new MyButtonListener());
        quit.addActionListener(new MyButtonListener());
    }
    class MyButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Play")) {
                frame.dispose();
                JFrame f = new JFrame("PONG");
                Game game = new Game();
                f.add(game);
                f.setSize(300, 400);
                f.setResizable(false);
                f.setVisible(true);
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                // the following code is a substitute for my thread.sleep(10) because
                // my thread.sleep(10) didn't work and I still have to figure out why
                final ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
                    service.scheduleWithFixedDelay(new Runnable() {
                        @Override
                        public void run() {
                            game.move();
                            game.repaint();
                        }
                    }, 0, 10, TimeUnit.MILLISECONDS);
            } else if (e.getActionCommand().equals("Help")) {
               JOptionPane.showMessageDialog(frame, "CONTROL KEYS:\n" +
                       "\tPlayer 1: \n     A Key, Z Key\n     W Key for Smash\nPlayer 2: \n     " +
                               "Left Arrow Key, Right Arrow Key\n     Up Key for Smash\n\n" +
                               "First to reach 3 points wins!","GAME RULES", JOptionPane.YES_OPTION);
            } else
                System.exit(0);
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
    }
}
