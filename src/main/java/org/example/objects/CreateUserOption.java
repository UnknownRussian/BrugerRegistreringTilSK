package org.example.objects;

import javax.swing.*;
import java.awt.*;

public class CreateUserOption {
    private JLabel label;
    private JRadioButton yesInput, noInput;
    private JTextField txtInput;
    private JPanel yesNoPanel, leftPanel, rightPanel, optionPanel;

    public int getHeight() {
        return height;
    }

    private int height;

    public boolean isText() {
        return isText;
    }

    private boolean isText;

    public CreateUserOption(boolean isText, String labelText){
        label = new JLabel(labelText);
        optionPanel = new JPanel();
        leftPanel = new JPanel();
        rightPanel = new JPanel();
        height = 40;
        optionPanel.setLayout(new GridLayout(1,2));
        optionPanel.setPreferredSize(new Dimension(610,height));


        leftPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        leftPanel.add(label);

        rightPanel.setLayout(new FlowLayout((FlowLayout.LEFT)));

        if(isText){
            txtInput = new JTextField();
            txtInput.setPreferredSize(new Dimension(300,30));
            txtInput.setFont(new Font("Calibri",Font.PLAIN,20));
            rightPanel.add(txtInput);
        }else {
            yesNoPanel = new JPanel();
            yesNoPanel.setLayout(new GridLayout(1,2));
            yesNoPanel.setPreferredSize(new Dimension(300,30));
            yesInput = new JRadioButton("Ja");
            noInput = new JRadioButton("Nej");

            ButtonGroup radioBtnGroup = new ButtonGroup();
            radioBtnGroup.add(yesInput);
            radioBtnGroup.add(noInput);

            yesNoPanel.add(yesInput);
            yesNoPanel.add(noInput);
            rightPanel.add(yesNoPanel);
        }

        optionPanel.add(leftPanel);
        optionPanel.add(rightPanel);
        this.isText = isText;
    }

    public JPanel getOptionPanel() {
        return optionPanel;
    }
}
