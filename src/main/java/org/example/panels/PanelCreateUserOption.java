package org.example.panels;

import javax.swing.*;
import java.awt.*;

public class PanelCreateUserOption {
    private JLabel label;
    private JRadioButton yesInput, noInput;
    private JTextField txtInput;
    private JPanel  leftPanel, rightPanel, optionPanel;
    private int height;

    public PanelCreateUserOption(boolean isText, String labelText){
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

    public JLabel getLabel() {
        return label;
    }

    public void setLabel(JLabel label) {
        this.label = label;
    }

    public JRadioButton getYesInput() {
        return yesInput;
    }

    public void setYesInput(JRadioButton yesInput) {
        this.yesInput = yesInput;
    }

    public JRadioButton getNoInput() {
        return noInput;
    }

    public void setNoInput(JRadioButton noInput) {
        this.noInput = noInput;
    }

    public JTextField getTxtInput() {
        return txtInput;
    }

    public void setTxtInput(JTextField txtInput) {
        this.txtInput = txtInput;
    }

    public JPanel getLeftPanel() {
        return leftPanel;
    }

    public void setLeftPanel(JPanel leftPanel) {
        this.leftPanel = leftPanel;
    }

    public JPanel getRightPanel() {
        return rightPanel;
    }

    public void setRightPanel(JPanel rightPanel) {
        this.rightPanel = rightPanel;
    }

    public void setOptionPanel(JPanel optionPanel) {
        this.optionPanel = optionPanel;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public JPanel getOptionPanel() {
        return optionPanel;
    }

    public int getHeight() {
        return height;
    }
}
