
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
        gui.setkeyListener(new cryptListener());
        gui.setinputListener(new cryptListener());

    }

    private class cryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.setInput(gui.getMessage());
            model.setKey(gui.getKey());
            model.crypt_string();
            gui.setCrypt(model.getCrypt());
        }
    }

    public static void main(String[] args) {
        model m = new model();
        gui v = new gui();
        controller thisIsTheProgram = new controller(m,v);
        thisIsTheProgram.setVisible(true);

    }
}
