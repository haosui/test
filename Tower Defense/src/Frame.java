import javax.swing.*;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame{
    Screen screen = new Screen(this);

    public Frame(){
        inIt();
        setVisible(true);
    }

    public void inIt(){
        add(screen);
        pack();
        setTitle("Tower Defense Demo");
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args){
        new Frame();

    }
}
