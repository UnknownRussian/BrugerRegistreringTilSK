package org.example.frames;

import org.example.handlers.OptionUpdater;
import org.example.handlers.ProcedureTransfer;
import org.example.panels.PanelOptionToAdd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameSettings extends JFrame implements ActionListener {
    private JLabel labelEmpty ,labelName, labelInputType, labelProcedure;
    private JButton buttonAdd, buttonSave, buttonRemove, buttonCancel;
    private ArrayList<PanelOptionToAdd> optionsToAdd;
    private ArrayList<ProcedureTransfer> procedures;
    private int windowHeight, panelBodyHeight;
    private JPanel panelBody;
    private OptionUpdater optionUpdater;

    public FrameSettings(OptionUpdater optionUpdater){
        this.optionUpdater = optionUpdater;
        optionsToAdd = new ArrayList<>();
        procedures = new ArrayList<>();
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonAdd){
            addOption();
        }
        for(PanelOptionToAdd option : optionsToAdd){
            if(e.getSource() == option.getComboBox()){
                if(option.getComboBox().getSelectedIndex() == 1)
                    option.getButton().setVisible(true);
                else
                    option.getButton().setVisible(false);
            }
            if(e.getSource() == option.getButton()){
                ProcedureTransfer procedure = new ProcedureTransfer();
                procedures.add(procedure);
                new FrameCreateProcedure(option.getId(),procedure);
                //Code for combining procedure with option.
            }
        }
        if(e.getSource() == buttonSave){
            optionUpdater.setOptionsToAdd(optionsToAdd);
            optionUpdater.setProcedures(procedures);
//            try {
//                new OptionJSONFormatter().saveAddedOptionsToJSONArray(optionsToAdd);
//            } catch (Exception ex) {
//                throw new RuntimeException(ex);
//            }
//            System.out.println("Data saved, Size = "+optionsToAdd.size());
//            System.out.println("Procedure id: "+procedures.get(0).getId());
//            System.out.println("Procedure text: "+procedures.get(0).getProcedure());
        }
    }

    private void addOption(){
        PanelOptionToAdd option = new PanelOptionToAdd(System.currentTimeMillis());
        option.getButton().addActionListener(this);
        option.getComboBox().addActionListener(this);
        optionsToAdd.add(option);
        panelBody.removeAll();
        System.out.println(optionsToAdd.size());
        for(PanelOptionToAdd panelOptionToAdd : optionsToAdd){
            panelBody.add(panelOptionToAdd.getPanel());
        }
        panelBodyHeight = 40 * optionsToAdd.size();
        panelBody.setPreferredSize(new Dimension(650,panelBodyHeight));
        SwingUtilities.updateComponentTreeUI(this);// Use this if components don't show up in a panel
    }
}
