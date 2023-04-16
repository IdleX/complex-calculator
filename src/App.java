/*
 * Copyright 2023 Complex calculator
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import utils.*;
import java.awt.Font;
import javax.swing.*;

public class App {
  private static JFrame frame;
  private static JLabel resultLabel;
  private static JTextField xTextFieldRe;
  private static JTextField xTextFieldIm;
  private static JTextField yTextFieldRe;
  private static JTextField yTextFieldIm;
  private static JComboBox<String> selectComboBox;
  private static final String[] AVAILABLE_ACTIONS = {
      "Действие: сложение",
      "Действие: вычитание",
      "Действие: умножение",
      "Действие: деление",
      "Действие: среднее арифметическое"
  };

  public static void main(String[] args) {
    display();
  }

  private static void showError(String text) {
    final Object[] options = { "Понял" };

    JOptionPane.showOptionDialog(
        frame,
        text,
        "Ошибка",
        JOptionPane.ERROR_MESSAGE,
        JOptionPane.DEFAULT_OPTION,
        null,
        options,
        options[0]);
  }

  private static void calculate() {
    Complex a;
    Complex b;

    try {
      a = new Complex(
          Double.parseDouble(xTextFieldRe.getText()),
          Double.parseDouble(xTextFieldIm.getText()));

      b = new Complex(
          Double.parseDouble(yTextFieldRe.getText()),
          Double.parseDouble(yTextFieldIm.getText()));
    } catch (NumberFormatException e) {
      showError("Введены некорректные данные!");
      return;
    }

    String selectedAction = selectComboBox.getSelectedItem().toString();
    switch (selectedAction) {
      case "Действие: сложение":
        a.plus(b);
        break;
      case "Действие: вычитание":
        a.minus(b);
        break;
      case "Действие: умножение":
        a.multiply(b);
        break;
      case "Действие: деление":
        try {
          a.divide(b);
        } catch (ArithmeticException e) {
          showError(e.getMessage());
          return;
        }

        break;
      case "Действие: среднее арифметическое":
        a.average(b);
        break;
      default:
        showError("Действие не найдено!");
        return;
    }

    resultLabel.setText("РЕЗУЛЬТАТ: " + a.toString());
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

    xTextFieldRe = new JTextField(1);
    xTextFieldRe.setBounds(60, 60, 100, 24);
    xTextFieldRe.setFont(labelFont);
    frame.add(xTextFieldRe);

    yTextFieldRe = new JTextField(1);
    yTextFieldRe.setBounds(60, 90, 100, 24);
    yTextFieldRe.setFont(labelFont);
    frame.add(yTextFieldRe);

    JLabel plusJLabel1 = new JLabel("+");
    plusJLabel1.setBounds(170, 60, 20, 20);
    plusJLabel1.setFont(labelFont);
    frame.add(plusJLabel1);

    JLabel plusJLabel2 = new JLabel("+");
    plusJLabel2.setBounds(170, 90, 20, 20);
    plusJLabel2.setFont(labelFont);
    frame.add(plusJLabel2);

    xTextFieldIm = new JTextField(1);
    xTextFieldIm.setBounds(192, 60, 100, 24);
    xTextFieldIm.setFont(labelFont);
    frame.add(xTextFieldIm);

    yTextFieldIm = new JTextField(1);
    yTextFieldIm.setBounds(192, 90, 100, 24);
    yTextFieldIm.setFont(labelFont);
    frame.add(yTextFieldIm);

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
    resultLabel.setBounds(20, 130, 550, 80);
    resultLabel.setFont(defaultFont);
    frame.add(resultLabel);

    frame.setSize(600, 230);
    frame.setLayout(null);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}