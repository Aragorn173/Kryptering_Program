package Kryptering_Program;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class controller extends JFrame {
    model model;
    gui gui;

    public controller(model m, gui v) {
        this.model = m;
        this.gui = v;
        this.setContentPane(gui.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        gui.setCryptListener(new cryptListener());
        gui.setkeyListener(new keyListener());
        gui.setinputListener(new inputListener());
        gui.setexportListner(new exportListener());
    }

    private class cryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setInput(gui.getInput());
            model.setKey(gui.getKey());
            model.extendKey();
            model.crypt_string();
            gui.setCrypt(model.getCrypt());
        }
    }
    private class inputListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setInput(model.fileread());
            gui.setInput(model.getinput());

        }
    }
    private class keyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setKey(model.keyread());
            gui.setKey(model.getkey());
        }
    }

    private class exportListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.filewrite();
        }
    }

    public static void main(String[] args) {
        model m = new model();
        gui v = new gui();
        controller thisIsTheProgram = new controller(m,v);
        thisIsTheProgram.setVisible(true);

    }
}
