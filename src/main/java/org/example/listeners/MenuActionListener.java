package org.example.listeners;

import org.example.frames.FrameCreateUser;
import org.example.panels.PanelMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuActionListener implements ActionListener {
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

    public MenuActionListener(){
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == panelMenuClass.buttonCreateUser){
            new FrameCreateUser();
        }
        if(e.getSource() == panelMenuClass.buttonExit){
            int dialogBtn = JOptionPane.showConfirmDialog(null, "Vil du lukke programmet?","Afslut",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(dialogBtn == JOptionPane.YES_OPTION)
                System.exit(0);
        }
    }

}
