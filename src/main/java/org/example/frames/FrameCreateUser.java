package org.example.frames;

import org.example.handlers.HandlerData;
import org.example.listeners.CreateUserListener;
import org.example.panels.PanelCheckList;
import org.example.panels.PanelCreateUser;
import org.example.panels.PanelCreateUserOption;
import org.example.panels.PanelOptionToAdd;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrameCreateUser extends JFrame {
    private ArrayList<PanelCreateUserOption> options;
    private HandlerData handlerData;
    private PanelCreateUser panelCreateUser;
    private PanelCheckList panelCheckList;
    private CreateUserListener createUserListener;
    private Dimension dimension;

    public FrameCreateUser(HandlerData handlerData){
        this.handlerData = handlerData;
        createOptions();
        dimension = new Dimension(650,(options.get(0).getHeight()*(options.size()+4)));
        panelCreateUser = new PanelCreateUser(handlerData,options, dimension);
        panelCheckList = new PanelCheckList(dimension);
        createUserListener = new CreateUserListener(panelCreateUser, panelCheckList);

        //Set Listener for panels
        panelCreateUser.setListener(createUserListener);
        panelCheckList.setListener(createUserListener);

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(dimension);

        add(panelCreateUser);
        add(panelCheckList);

        setVisible(true);
    }

    private void createOptions(){
        options = new ArrayList<>();
        for(PanelOptionToAdd panelOptionToAdd : handlerData.getOptionsToAdd()){
            options.add(new PanelCreateUserOption((panelOptionToAdd.getComboBox().getSelectedIndex() == 0), panelOptionToAdd.getTextField().getText()));
        }
    }
}
