package org.example.panels;

import javax.swing.*;
import java.awt.*;

public class PanelOptionToAdd {
    //Fields that needs to be saved:
    private long id; //Used to combine a procedure (if created), to the option.
    private JTextField textField; //Used to give names for the Labels created with PanelCreateUserOptions
    private JComboBox comboBox; //Used for selecting if an option, created in PanelCreateUserOption, needs to be with a text box or yes/no radio buttons, also if yes/no is selected a button to add a procedure becomes visible

    //Fields that doesn't need to be saved:
    private JCheckBox checkBox; //Used to mark an option in setting (if you want to remove an option)
    private JButton button; //This is used to add a procedure, if needed. If procedure is not added, button created in PanelCreateUser will be disabled.
    private JPanel panel; //Adds every component needed to create an option in FrameSettings

    public PanelOptionToAdd(long id){
        this.id = id;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(JCheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(JTextField textField) {
        this.textField = textField;
    }

    public JComboBox getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    @Override
    public String toString() {
        return "PanelOptionToAdd [ " +
                "id:" + id +
                ", checkBox:" + checkBox +
                ", textField:" + textField +
                ", comboBox:" + comboBox +
                ", button:" + button +
                ", panel:" + panel +
                " ]";
    }
}
