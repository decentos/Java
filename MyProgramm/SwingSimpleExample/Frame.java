import javax.swing.*;
import java.awt.*;

public class Frame {
    public static void main(String[] args) {

        Frame gui = new Frame();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);

        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JButton button = new JButton("Click me");
        JButton button1 = new JButton("Click");
        JButton button2 = new JButton("Me");

        panel.add(button);
        panel.add(button1);
        panel.add(button2);

        frame.getContentPane().add(BorderLayout.EAST, panel);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}
