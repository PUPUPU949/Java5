import javax.swing.*;
import java.awt.*;

public class HelloWindow extends JFrame {

    public HelloWindow() {
        setTitle("Приветствие");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton button = new JButton("Привет");
        JLabel label = new JLabel(
                "Нажмите на кнопку",
                SwingConstants.CENTER
        );

        button.addActionListener(e ->
                label.setText("Привет, мир!")
        );

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
    }
}