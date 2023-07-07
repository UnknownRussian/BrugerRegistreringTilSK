package org.example.frames;

import org.example.listeners.MenuActionListener;
import org.example.panels.PanelMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameMenu extends JFrame implements ActionListener {
    JLayeredPane layeredPane;
    JPanel panelMenu;


    public FrameMenu(){
        MenuActionListener menuActionListener = new MenuActionListener();

        panelMenu = new PanelMenu(menuActionListener);

        menuActionListener.setPanelMenu(panelMenu);

        add(panelMenu);

        setResizable(false);
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
