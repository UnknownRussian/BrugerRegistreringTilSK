package org.example.objects;

import javax.swing.*;
import java.awt.*;

public class CreateUserOption {
    private JLabel label;
    private JRadioButton yesInput, noInput;
    private JTextField txtInput;
    private JPanel  leftPanel, rightPanel, optionPanel;
    private int height;

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

        if(isText){
            rightPanel.setLayout(new FlowLayout((FlowLayout.LEFT)));
            txtInput = new JTextField();
            txtInput.setPreferredSize(new Dimension(300,30));
            txtInput.setFont(new Font("Calibri",Font.PLAIN,20));
            rightPanel.add(txtInput);
        }else {
            rightPanel.setLayout(new GridLayout(1,2));
            rightPanel.setPreferredSize(new Dimension(300,30));
            yesInput = new JRadioButton("Ja");
            noInput = new JRadioButton("Nej");

            ButtonGroup radioBtnGroup = new ButtonGroup();
            radioBtnGroup.add(yesInput);
            radioBtnGroup.add(noInput);

            rightPanel.add(yesInput);
            rightPanel.add(noInput);
        }

        optionPanel.add(leftPanel);
        optionPanel.add(rightPanel);
    }

    public JPanel getOptionPanel() {
        return optionPanel;
    }

    public int getHeight() {
        return height;
    }
}
