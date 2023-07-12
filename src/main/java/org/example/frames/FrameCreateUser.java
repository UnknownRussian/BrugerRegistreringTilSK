package org.example.frames;

import org.example.handlers.OptionUpdater;
import org.example.listeners.CreateUserListener;
import org.example.objects.Account;
import org.example.panels.PanelCheckList;
import org.example.panels.PanelCreateUser;
import org.example.panels.PanelCreateUserOption;
import org.example.panels.PanelOptionToAdd;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrameCreateUser extends JFrame {
    private ArrayList<PanelCreateUserOption> options;
    private OptionUpdater optionUpdater;
    private PanelCreateUser panelCreateUser;
    private PanelCheckList panelCheckList;
    private CreateUserListener createUserListener;
    private Dimension dimension;

    public FrameCreateUser(OptionUpdater optionUpdater){
        this.optionUpdater = optionUpdater;
        createOptions();
        dimension = new Dimension(650,(options.get(0).getHeight()*(options.size()+4)));
        panelCreateUser = new PanelCreateUser(optionUpdater,options, dimension);
        panelCheckList = new PanelCheckList(dimension);
        createUserListener = new CreateUserListener(panelCreateUser, panelCheckList);

        //Set Listener for panels
        panelCreateUser.setListener(createUserListener);

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(dimension);

        add(panelCreateUser);
        add(panelCheckList);

        setVisible(true);
    }

    private void createOptions(){
        options = new ArrayList<>();
        for(PanelOptionToAdd panelOptionToAdd : optionUpdater.getOptionsToAdd()){
            options.add(new PanelCreateUserOption((panelOptionToAdd.getComboBox().getSelectedIndex() == 0), panelOptionToAdd.getTextField().getText()));
        }
    }
}
