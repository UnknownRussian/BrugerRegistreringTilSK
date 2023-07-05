package org.example.listeners;

import org.example.panels.PanelCheckList;
import org.example.panels.PanelCreateUser;
import org.example.panels.PanelMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomActionListener implements ActionListener {
    private JPanel panelMenu, panelCreateUser, panelCheckList;

    public void setPanelMenu(JPanel panelMenu) {
        this.panelMenu = panelMenu;
    }

    public void setPanelCreateUser(JPanel panelCreateUser) {
        this.panelCreateUser = panelCreateUser;
    }

    public void setPanelCheckList(JPanel panelCheckList) {
        this.panelCheckList = panelCheckList;
    }

    public PanelMenu getPanelMenuClass() {
        return panelMenuClass;
    }

    public void setPanelMenuClass(PanelMenu panelMenuClass) {
        this.panelMenuClass = panelMenuClass;
    }

    private PanelMenu panelMenuClass;

    public CustomActionListener(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelMenuClass.buttonCreateUser){
            panelCreateUser.setVisible(true);
            panelMenu.setVisible(false);
        }
    }

}
