import java.awt.Font;
import javax.swing.*;

public class App {
  private static JFrame frame;
  private static JLabel resultLabel;
  private static JComboBox<String> selectComboBox;
  private static final String[] AVAILABLE_ACTIONS = {
    "Действие: сложение",
    "Действие: вычитание",
    "Действие: умножение",
    "Действие: деление"
  };

  public static void main(String[] args) {
    display();
  }

  private static void showError(String text) {
    Object[] options = { "Понял" };

    JOptionPane.showOptionDialog(
      frame,
      text,
      "Ошибка",
      JOptionPane.ERROR_MESSAGE,
      JOptionPane.DEFAULT_OPTION,
      null,
      options,
      options[0]
    );
  }

  private static void calculate() {
    String selectedAction = selectComboBox.getSelectedItem().toString();
    switch (selectedAction) {
      case "Действие: сложение": 
        break;
      case "Действие: вычитание": 
        break;
      case "Действие: умножение": 
        break;
      case "Действие: деление": 
        break;
      default:
        showError("Действие не найдено!");
    }
  }

  private static void display() {
    frame = new JFrame("Калькулятор комплексных чисел");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Font defaultFont = new Font("Inter", Font.PLAIN, 16);

    selectComboBox = new JComboBox<>(AVAILABLE_ACTIONS);
    selectComboBox.setBounds(20, 20, 550, 30);
    selectComboBox.setFont(defaultFont);
    frame.add(selectComboBox);

    Font labelFont = new Font("Inter", Font.PLAIN, 20);
    JLabel xJLabel = new JLabel("X = ");
    xJLabel.setBounds(20, 60, 40, 20);
    xJLabel.setFont(labelFont);
    frame.add(xJLabel);

    JLabel yJLabel = new JLabel("Y = ");
    yJLabel.setBounds(20, 90, 40, 20);
    yJLabel.setFont(labelFont);
    frame.add(yJLabel);

    JTextField xTextFieldRe1 = new JTextField(1);
    xTextFieldRe1.setBounds(60, 60, 100, 24);
    xTextFieldRe1.setFont(labelFont);
    frame.add(xTextFieldRe1);

    JTextField yTextFieldIm1 = new JTextField(1);
    yTextFieldIm1.setBounds(60, 90, 100, 24);
    yTextFieldIm1.setFont(labelFont);
    frame.add(yTextFieldIm1);

    JLabel plusJLabel1 = new JLabel("+");
    plusJLabel1.setBounds(170, 60, 20, 20);
    plusJLabel1.setFont(labelFont);
    frame.add(plusJLabel1);

    JLabel plusJLabel2 = new JLabel("+");
    plusJLabel2.setBounds(170, 90, 20, 20);
    plusJLabel2.setFont(labelFont);
    frame.add(plusJLabel2);

    JTextField xTextFieldRe2 = new JTextField(1);
    xTextFieldRe2.setBounds(192, 60, 100, 24);
    xTextFieldRe2.setFont(labelFont);
    frame.add(xTextFieldRe2);

    JTextField yTextFieldIm2 = new JTextField(1);
    yTextFieldIm2.setBounds(192, 90, 100, 24);
    yTextFieldIm2.setFont(labelFont);
    frame.add(yTextFieldIm2);

    JLabel iJLabel1 = new JLabel("i");
    iJLabel1.setBounds(294, 60, 20, 20);
    iJLabel1.setFont(labelFont);
    frame.add(iJLabel1);

    JLabel iJLabel2 = new JLabel("i");
    iJLabel2.setBounds(294, 90, 20, 20);
    iJLabel2.setFont(labelFont);
    frame.add(iJLabel2);

    JButton calculateButton = new JButton("Вычислить");
    calculateButton.setBounds(20, 120, 550, 30);
    calculateButton.setFont(defaultFont);
    calculateButton.addActionListener(e -> calculate());
    frame.add(calculateButton);

    resultLabel = new JLabel("РЕЗУЛЬТАТ:");
    resultLabel.setBounds(20, 130, 400, 80);
    resultLabel.setFont(defaultFont);
    frame.add(resultLabel);

    frame.setSize(600, 230);
    frame.setLayout(null);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}
