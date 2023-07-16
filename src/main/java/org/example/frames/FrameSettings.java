package org.example.frames;

import org.example.handlers.HandlerData;
import org.example.objects.Procedure;
import org.example.panels.PanelOptionToAdd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

public class FrameSettings extends JFrame implements ActionListener {
    private JLabel labelEmpty ,labelName, labelInputType, labelProcedure;
    private JButton buttonAdd, buttonSave, buttonRemove, buttonCancel;
    private ArrayList<PanelOptionToAdd> optionsToAdd;
    private ArrayList<Procedure> procedures;
    private int windowHeight, panelBodyHeight;
    private JPanel panelBody;
    private HandlerData handlerData;

    public FrameSettings(HandlerData handlerData){
        this.handlerData = handlerData;
        //Handler needs to transfer data to optionsToAdd and procedures
        if(handlerData.getOptionsToAdd().size() == 0){
            optionsToAdd = new ArrayList<>();
            procedures = new ArrayList<>();
        }else {
            optionsToAdd = handlerData.getOptionsToAdd();
            procedures = new ArrayList<>();
        }
        JPanel panelLabels = new JPanel();
        panelLabels.setPreferredSize(new Dimension(650,40));

        labelEmpty = new JLabel("");
        labelEmpty.setBackground(Color.RED);
        labelEmpty.setOpaque(true);
        labelEmpty.setPreferredSize(new Dimension(25,40));

        labelName = new JLabel("Label/Navn:");
        labelName.setBackground(Color.GREEN);
        labelName.setOpaque(true);
        labelName.setPreferredSize(new Dimension(300,40));

        labelInputType = new JLabel("Input type:");
        labelInputType.setBackground(Color.RED);
        labelInputType.setOpaque(true);
        labelInputType.setPreferredSize(new Dimension(125,40));

        labelProcedure = new JLabel("Procedure:");
        labelProcedure.setBackground(Color.GREEN);
        labelProcedure.setOpaque(true);
        labelProcedure.setPreferredSize(new Dimension(130,40));

        panelLabels.add(labelEmpty);
        panelLabels.add(labelName);
        panelLabels.add(labelInputType);
        panelLabels.add(labelProcedure);


        JPanel panelButtons = new JPanel();
        panelButtons.setPreferredSize(new Dimension(650,40));

        buttonAdd = new JButton("Tilføj");
        buttonSave = new JButton("Gem");
        buttonRemove = new JButton("Fjern");
        buttonCancel = new JButton("Annuller");

        buttonAdd.addActionListener(this);
        buttonSave.addActionListener(this);
        buttonRemove.addActionListener(this);
        buttonCancel.addActionListener(this);

        panelButtons.add(buttonAdd);
        panelButtons.add(buttonSave);
        panelButtons.add(buttonRemove);
        panelButtons.add(buttonCancel);

        panelBodyHeight = 0;
        panelBody = new JPanel();

        panelBody.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        panelBody.setPreferredSize(new Dimension(650,panelBodyHeight));
        panelBody.setBackground(Color.YELLOW);

        add(panelLabels);
        add(panelBody);
        add(panelButtons);

        windowHeight = 800;
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(new Dimension(650,windowHeight));
        setVisible(true);

        if(optionsToAdd.size() > 0)
            addOption(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonAdd){
            addOption(true);
        }
        for(PanelOptionToAdd option : optionsToAdd){
            if(e.getSource() == option.getComboBox()){
                if(option.getComboBox().getSelectedIndex() == 1)
                    option.getButton().setVisible(true);
                else
                    option.getButton().setVisible(false);
            }
            if(e.getSource() == option.getButton()){
                Procedure procedure = new Procedure();
                procedures.add(procedure);
                new FrameCreateProcedure(option.getId(),procedure);
                //Code for combining procedure with option.
            }
        }
        if(e.getSource() == buttonSave){
            saveOptions();
        }
        if(e.getSource() == buttonRemove){
            ArrayList<PanelOptionToAdd> optionsToRemove = new ArrayList<>();
            optionsToAdd.forEach(optionToAdd -> {
                if(optionToAdd.getCheckBox().isSelected())
                    optionsToRemove.add(optionToAdd);
            });
            optionsToRemove.forEach(optionToAdd -> {
                optionsToAdd.remove(optionToAdd);
                addOption(false);

            });
            SwingUtilities.updateComponentTreeUI(this);// Use this if components don't show up in a panel
        }
    }

    private void saveOptions(){
        handlerData.setOptionsToAdd(optionsToAdd);
        handlerData.setProcedures(procedures);
        try {
            handlerData.saveOptionsAndProcedures();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void addOption(boolean addedViaButton){
        if(addedViaButton) {
            PanelOptionToAdd option = new PanelOptionToAdd(System.currentTimeMillis());
            option.getButton().addActionListener(this);
            option.getComboBox().addActionListener(this);
            optionsToAdd.add(option);
        }
        panelBody.removeAll();
        for(PanelOptionToAdd panelOptionToAdd : optionsToAdd){
            panelBody.add(panelOptionToAdd.getPanel());
        }
        panelBodyHeight = 40 * optionsToAdd.size();
        panelBody.setPreferredSize(new Dimension(650,panelBodyHeight));
        SwingUtilities.updateComponentTreeUI(this);// Use this if components don't show up in a panel
    }
}
