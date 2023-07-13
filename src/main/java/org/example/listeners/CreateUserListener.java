package org.example.listeners;

import org.example.panels.PanelCheckList;
import org.example.panels.PanelCreateUser;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateUserListener implements ActionListener {
    private PanelCreateUser panelCreateUser;
    private PanelCheckList panelCheckList;

    public CreateUserListener(PanelCreateUser panelCreateUser, PanelCheckList panelCheckList){
        this.panelCreateUser = panelCreateUser;
        this.panelCheckList = panelCheckList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelCreateUser.getButtonStart()){
            panelCreateUser.setVisible(false);
            panelCheckList.setOptions(panelCreateUser.getOptions());
            panelCheckList.setVisible(true);
        }
        if(e.getSource() == panelCheckList.getButtonStartProcedure()){

        }
    }


}
