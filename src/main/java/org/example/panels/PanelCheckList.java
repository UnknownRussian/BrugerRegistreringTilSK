package org.example.panels;

import org.example.listeners.CreateUserListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelCheckList extends JPanel {
    private ArrayList<PanelCreateUserOption> options; // Stores all options that are created from PanelCreateUser. This is given from PanelCreateUser, via setOptions() method.
    private JCheckBox checkBox; // Used to mark if checkPoint is complete
    private JLabel label; // Used to explain short what to do in a checkPoint

    private JButton buttonEnd, buttonSave, buttonRemove, buttonCancel, buttonStartProcedure; // Do I need to explain? xD
    private CreateUserListener listener;

    public PanelCheckList (Dimension dimension){
        setPreferredSize(dimension);
        setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        setVisible(false);
    }

    private void createCheckList(String strLabel, boolean setButtonVisible){
        JPanel panelCheckPoint = new JPanel();
        label = new JLabel("Er "+strLabel+ " oprettet?:");
        label.setPreferredSize(new Dimension(300,30));
        buttonStartProcedure = new JButton("Start");
        buttonStartProcedure.setPreferredSize(new Dimension(200,30));
        buttonStartProcedure.setVisible(setButtonVisible);
        checkBox = new JCheckBox();

        panelCheckPoint.add(label);
        panelCheckPoint.add(buttonStartProcedure);
        panelCheckPoint.add(checkBox);

        add(panelCheckPoint);
        SwingUtilities.updateComponentTreeUI(this);// Use this if components don't show up in a panel
    }

    private void createButtonPanel(){
        JPanel panelButtons = new JPanel();
        buttonEnd = new JButton("Afslut");
        buttonSave = new JButton("Gem");
        buttonRemove = new JButton("Fjern");
        buttonCancel = new JButton("Annuller");

        buttonEnd.addActionListener(listener);
        buttonSave.addActionListener(listener);
        buttonRemove.addActionListener(listener);
        buttonCancel.addActionListener(listener);

        panelButtons.add(buttonEnd);
        panelButtons.add(buttonSave);
        panelButtons.add(buttonRemove);
        panelButtons.add(buttonCancel);

        add(panelButtons);
    }

    private void createInfoLabels(String labelName, String info){
        label = new JLabel(labelName+": "+info);
        label.setPreferredSize(new Dimension(300,30));
        add(label);
        SwingUtilities.updateComponentTreeUI(this);
    }

    public void setOptions(ArrayList<PanelCreateUserOption> options){
        this.options = options;
        for(PanelCreateUserOption option : options){
            if(!option.getIsText()){
                if(option.getYesInput().isSelected())
                    createCheckList(option.getLabel().getText(),true);
            }else if(option.getIsText()){
                createInfoLabels(option.getLabel().getText(),option.getTxtInput().getText());
            }
        }
        createButtonPanel();
    }

    public JButton getButtonEnd() {
        return buttonEnd;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public JButton getButtonRemove() {
        return buttonRemove;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public JButton getButtonStartProcedure() {
        return buttonStartProcedure;
    }

    public JCheckBox getCheckBox() {
        return checkBox;
    }

    public JLabel getLabel() {
        return label;
    }

    public void setListener(CreateUserListener listener) {
        this.listener = listener;
    }
}
