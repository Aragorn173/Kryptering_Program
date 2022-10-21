package Kryptering_Program;

import javax.swing.*;
import java.awt.event.ActionListener;

public class gui {
    private JPanel panel;
    private JTextField inputtextfield;
    private JTextField inputkeyfield;
    private JButton importKeyFromFileButton;
    private JButton importTextFromInputButton;
    private JButton exportToOutputTxtButton;
    private JButton encryptDecryptButton;
    private JTextArea outputcrypt;

    public gui() {

    }

    public JPanel getPanel() {
        return panel;
    }

    public String getInput() {
        return inputtextfield.getText();
    }

    public void setInput(String c) { inputtextfield.setText(c);}

    public String getKey() {
        return inputkeyfield.getText();
    }

    public void setKey(String c) {inputkeyfield.setText(c);}


    public void setCrypt(String c) {outputcrypt.setText(c);}

    public static void main(String[] args) {
        JFrame frame = new JFrame("View");
        frame.setContentPane(new gui().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    public void setCryptListener(ActionListener cryptListener) {
        encryptDecryptButton.addActionListener(cryptListener);
    }
    public void setkeyListener(ActionListener keyListener) {
        importKeyFromFileButton.addActionListener(keyListener);
    }
    public void setinputListener(ActionListener inputListener) {
        importTextFromInputButton.addActionListener(inputListener);
    }
    public void setexportListner(ActionListener exportListener) {
        exportToOutputTxtButton.addActionListener(exportListener);
    }
}
