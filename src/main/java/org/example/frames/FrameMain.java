package org.example.frames;

import org.example.listeners.CustomActionListener;
import org.example.panels.PanelCreateUser;
import org.example.panels.PanelMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMain extends JFrame implements ActionListener {
    JLayeredPane layeredPane;
    JPanel panelMenu, panelCreateUser, panelCheckList;

    public FrameMain(){
        CustomActionListener customActionListener = new CustomActionListener();

        panelMenu = new PanelMenu(customActionListener);
        panelCreateUser = new PanelCreateUser(customActionListener);

        customActionListener.setPanelMenu(panelMenu);
        customActionListener.setPanelCreateUser(panelCreateUser);

        add(panelMenu);
        add(panelCreateUser);

        setResizable(true);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,800);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getSource());
    }
}
