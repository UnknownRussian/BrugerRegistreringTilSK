package org.example.objects;

import javax.swing.*;
import java.awt.*;

public class OptionToAdd {
    JCheckBox checkBox;
    JTextField textField;
    JComboBox comboBox;
    JButton button;
    JPanel panel;

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public JButton getButton() {
        return button;
    }

    public JPanel getPanel() {
        return panel;
    }

    public OptionToAdd(){
        checkBox = new JCheckBox();
        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300,30));
        comboBox = new JComboBox<>();
        comboBox.insertItemAt("Text",0);
        comboBox.insertItemAt("Ja/Nej",1);
        comboBox.setSelectedIndex(0);
        comboBox.setPreferredSize(new Dimension(125,30));
        comboBox.setVisible(true);
        button = new JButton("Tilføj/Rediger");
        button.setVisible(false);
        button.setPreferredSize(new Dimension(125,30));
        panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new Dimension(600,40));
        panel.setBackground(Color.PINK);
        panel.add(checkBox);
        panel.add(textField);
        panel.add(comboBox);
        panel.add(button);
    }
}