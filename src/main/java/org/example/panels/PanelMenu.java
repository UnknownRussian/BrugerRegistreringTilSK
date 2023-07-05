package org.example.panels;

import org.example.frames.FrameMain;
import org.example.listeners.CustomActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelMenu extends JPanel {
    public JButton buttonCreateUser, buttonShowStartedProgress, buttonShowEndedProgress, buttonSettings, buttonExit;

    public PanelMenu(CustomActionListener customActionListener){
        setLayout(new GridLayout(5,1,0,25));
        setPreferredSize(new Dimension(550,725));

        buttonCreateUser = new JButton("Start oprettelse af bruger");
        buttonShowStartedProgress = new JButton("Igangværende oprettelser");
        buttonShowEndedProgress = new JButton("Afsluttet oprettelser");
        buttonSettings = new JButton("Indstillinger");
        buttonExit = new JButton("Afslut program");

        buttonCreateUser.addActionListener(customActionListener);
        customActionListener.setPanelMenuClass(this);

        add(buttonCreateUser);
        add(buttonShowStartedProgress);
        add(buttonShowEndedProgress);
        add(buttonSettings);
        add(buttonExit);
    }
}
