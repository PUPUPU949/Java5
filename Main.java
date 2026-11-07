import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            System.out.println("=== Задание №1 ===");
            HelloWindow hello = new HelloWindow();
            hello.setVisible(true);

            System.out.println("=== Задание №2 ===");
            Calculator calculator = new Calculator();
            calculator.setVisible(true);
        });
    }
}