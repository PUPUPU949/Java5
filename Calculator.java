import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {

    private JTextField firstNumber;
    private JTextField secondNumber;
    private JLabel result;

    public Calculator() {
        setTitle("Мини-калькулятор");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        firstNumber = new JTextField();
        secondNumber = new JTextField();
        result = new JLabel("Результат: ", SwingConstants.CENTER);

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton clearButton = new JButton("Очистить");

        JPanel inputPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        inputPanel.add(new JLabel("Первое число:"));
        inputPanel.add(firstNumber);
        inputPanel.add(new JLabel("Второе число:"));
        inputPanel.add(secondNumber);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        buttonPanel.add(addButton);
        buttonPanel.add(subtractButton);
        buttonPanel.add(multiplyButton);
        buttonPanel.add(divideButton);

        addButton.addActionListener(e -> calculate("+"));
        subtractButton.addActionListener(e -> calculate("-"));
        multiplyButton.addActionListener(e -> calculate("*"));
        divideButton.addActionListener(e -> calculate("/"));

        clearButton.addActionListener(e -> {
            firstNumber.setText("");
            secondNumber.setText("");
            result.setText("Результат: ");
        });

        setLayout(new BorderLayout(10, 10));

        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new GridLayout(2, 1));
        bottomPanel.add(result);
        bottomPanel.add(clearButton);

        add(bottomPanel, BorderLayout.SOUTH);
    }

    private void calculate(String operation) {
        try {
            double a = Double.parseDouble(firstNumber.getText());
            double b = Double.parseDouble(secondNumber.getText());
            double answer;

            switch (operation) {
                case "+":
                    answer = a + b;
                    break;

                case "-":
                    answer = a - b;
                    break;

                case "*":
                    answer = a * b;
                    break;

                case "/":
                    if (b == 0) {
                        result.setText("Ошибка: деление на ноль!");
                        return;
                    }
                    answer = a / b;
                    break;

                default:
                    return;
            }

            result.setText("Результат: " + answer);

        } catch (NumberFormatException e) {
            result.setText("Ошибка: введите корректные числа!");
        }
    }
}