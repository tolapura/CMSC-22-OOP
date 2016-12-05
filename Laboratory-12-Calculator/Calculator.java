package Calculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Calculator extends JFrame {
    private JTextArea display;
    private JButton mod, subtract, dot, two, five, eight, delete, clear, divide,
            add, zero, three, six, nine, sign, multiply, equals, one, four, seven;
    private JPanel panel;
    private ArrayList<String> ans;

    public Calculator() {
        panel = new JPanel(new GridLayout(5, 4));
        Font font = new Font("CalibriHeader", Font.PLAIN, 20);
        Font font2 = new Font("Coronet", Font.PLAIN, 20);

        ans = new ArrayList<String>();
        display = new JTextArea();
        display.setPreferredSize(new Dimension(250, 80));
        display.setEditable(false);
        display.setBackground(Color.decode("#969696"));
        display.setForeground(Color.white);
        display.setFont(font2);
        display.setLineWrap(true);
        display.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        display.setText("0");

        clear = new JButton("AC");          sign = new JButton("+/-");          mod = new JButton("%");
        divide = new JButton("÷");          multiply = new JButton("x");        subtract = new JButton("-");
        add = new JButton("+");             equals = new JButton("=");          dot = new JButton(".");
        zero = new JButton("0");            one = new JButton("1");             two = new JButton("2");
        three = new JButton("3");           six = new JButton("6");             seven = new JButton("7");
        eight = new JButton("8");           nine = new JButton("9");            five = new JButton("5");
        four = new JButton("4");            delete = new JButton("C");

        ActionListener aListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event){
                eventHandling(event);
            }
        };

        JButton[] buttons = {sign, zero, two, four, six, eight, delete, clear, mod,
                dot, one, three, five, seven, nine, divide, subtract, equals, multiply, add};
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setFont(font);
            buttons[i].addActionListener(aListener);
            if (i < 15) { buttons[i].setBackground(Color.decode("#e0e0e0")); }
            else {
                buttons[i].setBackground(Color.decode("#f5923e"));
                buttons[i].setForeground(Color.white);
            }}
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
        panel.add(clear);           panel.add(delete);            panel.add(mod);             panel.add(divide);
        panel.add(seven);           panel.add(eight);           panel.add(nine);            panel.add(multiply);
        panel.add(four);            panel.add(five);            panel.add(six);             panel.add(subtract);
        panel.add(one);             panel.add(two);             panel.add(three);           panel.add(add);
        panel.add(sign);            panel.add(zero);            panel.add(dot);             panel.add(equals);

        pack();
        add(display, BorderLayout.NORTH);
        add(panel, BorderLayout.AFTER_LINE_ENDS);
        setTitle("Calculator");
        setSize(250, 350);
        setVisible(true);
        setResizable(false);
        JOptionPane.showMessageDialog(this,"This simple calculator operates given " +
                "input\nas soon as the user presses the equal button.\nBut like any other calculators" +
                ", this can\noperate multiple operations.\n\nImplementation inspired by my phone.\n" +
                "1. (~) for negative\n2. (20%100) works like 20 percent of 100\n3. long decimals are rounding off" +
                "\n4. BigDecimal and BigInteger operations (eg.2E+1)\nare converted to Plain String (eg.20)" +
                "\n5. Result with trailing zeros are stripped off" +
                "\n\nCreated by @tolapura (11/2/16)","Calculator", JOptionPane.YES_NO_OPTION);
    }
    public boolean isOperator(String operator) {
        return (operator.equals("x") || operator.equals("-") || operator.equals("+")
                || operator.equals("÷") || operator.equals("%"));
    }
    public void operate() {
        for (int i = 0; i < ans.size(); i++) {
            if (isOperator(ans.get(i))) {
                ans.add(i, " ");
                ans.add(i+2, " ");
                i += 3;
            }}
        String answer = "";
        for (String temp: this.ans) {
            answer += temp;
        }
        ArrayList<String> arr = new ArrayList<>();
        StringTokenizer strtok = new StringTokenizer(answer," ");
        while (strtok.hasMoreTokens()) {
            arr.add(strtok.nextToken());
        }
        int i = 1;
        String ansFinal = arr.get(0).charAt(0)=='~' ? "-" +
                arr.get(0).substring(1) : arr.get(0);
        BigDecimal a;
        while (i < arr.size()) {
            String operation = arr.get(i++);
             a = new BigDecimal(arr.get(i).charAt(0)=='~' ? "-" +
                     (arr.get(i++).substring(1)) : arr.get(i++));
            if (operation.equals("+")) {
                ansFinal = a.add(new BigDecimal(ansFinal)) + "";
            } else if (operation.equals("-")) {
                ansFinal = new BigDecimal(ansFinal) + "";
                ansFinal = new BigDecimal(ansFinal).subtract(a) + "";
            } else if (operation.equals("x")) {
                ansFinal = a.multiply(new BigDecimal(ansFinal)) + "";
            } else if (operation.equals("÷")) {
                if (a.intValue() == 0) { ansFinal = "err";
                } else {ansFinal = new BigDecimal(ansFinal).divide(a, 2, RoundingMode.HALF_EVEN) + "";}
            } else if (operation.equals("%")) {
                ansFinal = new BigDecimal(ansFinal).divide(new BigDecimal("100")).multiply(a) + "";
            }
        }
        if (ansFinal.equals("err")) {
            display.setText(ansFinal);
        } else {
            display.setText(new BigDecimal(ansFinal).stripTrailingZeros().toPlainString() + "");
        }
        this.ans.clear();
        ans.add(ansFinal);
    }
    public void display() {
        if (ans.isEmpty()) { display.setText("0");
        } else {
            String ans = "";
            for (String temp : this.ans) {
                ans += temp;
                display.setText(ans);
            }}
    }
    public void eventHandling(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        if (button.equals(clear)) { ans.clear();}
        else if (button.equals(delete)) { ans.remove(ans.size()-1);}
        else if (button.equals(equals)) {
            if (isOperator(ans.get(ans.size() - 1))) {
                ans.remove(ans.size() - 1);
                operate(); return;
            } else if (ans.get(ans.size() - 1).equals("~")) {// do nothing}
            } else {
                operate();
            }
        }
        else if (button.equals(dot)) {dot();}
        else if (button.equals(sign)) {sign();}
        else if (button.equals(mod) || button.equals(divide) || button.equals(multiply) ||
                    button.equals(add) || button.equals(subtract)) {
            if (ans.isEmpty()) { // do nothing
            } else if (isOperator(ans.get(ans.size()-1))) {
                ans.set(ans.size()-1, button.equals(sign)? "-":button.getText());
            } else {ans.add(button.equals(sign) ? "-" :button.getText());}
        } else {ans.add(button.getText());}
        display();
    }
    public void sign() {
        int i = 0;
        for (i = ans.size() - 1; i >= 0; i--) {
            if (isOperator(ans.get(i))) break;
        }
        if(i == ans.size() -1) { ans.add("~"); }
        else if (ans.get(i+1).equals("~")) {ans.remove(i+1);}
        else {ans.add(i + 1, "~");}
    }
    public void dot() {
        int dotCount = 0;
        for (int i = ans.size() - 1; i >= 0; i--) {
            if (ans.get(i).equals(".")) {
                dotCount++;
            } else if (isOperator(ans.get(i))) {
                break;
            }}
        if (dotCount == 0) { ans.add(".");}
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Calculator();
            }
        });
    }
}
