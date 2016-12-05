import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main extends Frame {
    private Label label, playerLabel, computerLabel;
    private TextField playerField, computerField;
    private TextArea textarea;
    private Button click;
    private CheckboxGroup checkboxgroup;
    private Checkbox rock, scissors, paper, lizard, spock;
    public Main() {
        setLayout(new FlowLayout());
        label = new Label("Your Choice: ");
        checkboxgroup = new CheckboxGroup();
        rock = new Checkbox("Rock", checkboxgroup, true);
        scissors = new Checkbox("Scissors", checkboxgroup, true);
        paper = new Checkbox("Paper", checkboxgroup, true);
        lizard = new Checkbox("Lizard", checkboxgroup, true);
        spock = new Checkbox("Spock", checkboxgroup, true);
        click = new Button("RockPaperScissorsLizardSpock!");
        textarea = new TextArea("Results: ", 5, 25);
        textarea.setEditable(false);
        click.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkResult(checkboxgroup.getSelectedCheckbox());
            }
        });
        playerLabel = new Label("Player's Score        ");
        computerLabel = new Label("Computer's Score");
        playerField = new TextField("0", 10);
        playerField.setEditable(false);
        computerField = new TextField("0", 10);
        computerField.setEditable(false);
        add(label);
        add(rock);
        add(scissors);
        add(paper);
        add(lizard);
        add(spock);
        add(textarea);
        add(click);
        add(playerLabel);
        add(playerField);
        add(computerLabel);
        add(computerField);
        setTitle("RockPaperScissorsLizardSpock!");
        setSize(300, 300);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
    private void checkResult(Checkbox selectedCheckbox) {
        String[] op = {"Rock", "Scissors", "Paper", "Lizard", "Spock"};
        String computer = op[(int) (Math.random() * 4)];
        if (checkboxgroup.getSelectedCheckbox() == scissors) {
            if (computer.equals("Scissors")) {
                textarea.setText("Result:\nPlayer chose Scissors\nComputer chose " + computer + "\nIT'S A TIE!");
            } else if (computer.equals("Lizard") || (computer.equals("Paper"))) {
                textarea.setText("Result:\nPlayer chose Scissors\nComputer chose " + computer + "\nYOU WIN THIS ROUND!");
                playerField.setText(Integer.parseInt(playerField.getText()) + 1 + "");
            } else {
                textarea.setText("Result:\nPlayer chose Scissors\nComputer chose " + computer + "\nYOU LOOSE THIS ROUND!");
                computerField.setText(Integer.parseInt(playerField.getText()) + 1 + "");
            }
        } else if (checkboxgroup.getSelectedCheckbox() == paper) {
            if (computer.equals("Paper")) {
                textarea.setText("Result:\nPlayer chose Scissors\nComputer chose " + computer + "\nIT'S A TIE!");
            } else if (computer.equals("Spock") || (computer.equals("Rock"))) {
                textarea.setText("Result:\nPlayer chose Paper\nComputer chose " + computer + "\nYOU WIN THIS ROUND!");
                playerField.setText(Integer.parseInt(playerField.getText()) + 1 + "");
            } else {
                textarea.setText("Result:\nPlayer chose Paper\nComputer chose " + computer + "\nYOU LOOSE THIS ROUND!");
                computerField.setText(Integer.parseInt(playerField.getText()) + 1 + "");
            }
        } else if (checkboxgroup.getSelectedCheckbox() == lizard) {
            if (computer.equals("Lizard")) {
                textarea.setText("Result:\nPlayer chose Scissors\nComputer chose " + computer + "\nIT'S A TIE!");
            } else if (computer.equals("Paper") || (computer.equals("Spock"))) {
                textarea.setText("Result:\nPlayer chose Lizard\nComputer chose " + computer + "\nYOU WIN THIS ROUND!");
                playerField.setText(Integer.parseInt(playerField.getText()) + 1 + "");
            } else {
                textarea.setText("Result:\nPlayer chose Lizard\nComputer chose " + computer +"\nYOU LOOSE THIS ROUND!");
                computerField.setText(Integer.parseInt(playerField.getText()) + 1 + "");
            }
        } else {
            if (computer.equals("Rock")) {
                textarea.setText("Result:\nPlayer chose Scissors\nComputer chose " + computer + "\nIT'S A TIE!");
            } else if (computer.equals("Lizard") || (computer.equals("Scissors"))) {
                textarea.setText("Result:\nPlayer chose Rock\nComputer chose " + computer + "\nYOU WIN THIS ROUND!");
                playerField.setText(Integer.parseInt(playerField.getText()) + 1 + "");
            } else {
                textarea.setText("Result:\nPlayer chose Rock\nComputer chose " + computer + "\nYOU LOOSE THIS ROUND!");
                computerField.setText(Integer.parseInt(playerField.getText()) + 1 + "");
            }
        }
        if (computerField.getText().equals("5") || playerField.getText().equals("5")) {
            String winner = computerField.getText().equals("5") ? "COMPUTER" : "PLAYER";
            Dialog dialog = new Dialog(this, "GAME OVER", Dialog.ModalityType.DOCUMENT_MODAL);
            dialog.setLayout(new FlowLayout());
            Button ok = new Button("OK");
            ok.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    playerField.setText("0");
                    computerField.setText("0");
                    textarea.setText("Result:");
                    dialog.dispose();
                }
                });
            ok.setSize(60, 40);
            Label label = new Label("GAME OVER! " + winner + " WINS!    ");
            dialog.add(label);
            dialog.add(ok);
            dialog.setSize(230, 100);
            dialog.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Main();
    }
}
