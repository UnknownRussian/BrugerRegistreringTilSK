package org.example.panels;

import org.example.handlers.HandlerData;
import org.example.listeners.CreateUserListener;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelCreateUser extends JPanel {
    private JButton buttonStart, buttonSave, buttonCancel;
    private HandlerData handlerData;
    private ArrayList<PanelCreateUserOption> options;
    private CreateUserListener listener;
    private Dimension dimension;

    public PanelCreateUser(HandlerData handlerData, ArrayList<PanelCreateUserOption> options, Dimension dimension){
        this.handlerData = handlerData;
        this.options = options;

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(dimension);

        for(PanelCreateUserOption option : options){
            add(option.getOptionPanel());
        }

        buttonStart = new JButton("Start");
        buttonSave = new JButton("Gem");
        buttonCancel = new JButton("Annuller");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonSave);
        buttonPanel.add(buttonCancel);

        add(buttonPanel);

        setVisible(true);
    }

    public JButton getButtonStart() {
        return buttonStart;
    }

    public JButton getButtonSave() {
        return buttonSave;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public ArrayList<PanelCreateUserOption> getOptions() {
        return options;
    }

    public void setListener(CreateUserListener listener) {
        this.listener = listener;
        //Adds listener to buttons
        buttonStart.addActionListener(listener);
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}
