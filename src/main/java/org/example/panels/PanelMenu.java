package org.example.panels;

import org.example.listeners.MenuActionListener;

import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {
    public JButton buttonCreateUser, buttonShowStartedProgress, buttonShowEndedProgress, buttonSettings, buttonExit;

    public PanelMenu(MenuActionListener menuActionListener){
        setLayout(new GridLayout(5,1,0,25));
        setPreferredSize(new Dimension(550,725));

        buttonCreateUser = new JButton("Start oprettelse af bruger");
        buttonShowStartedProgress = new JButton("Igangværende oprettelser");
        buttonShowEndedProgress = new JButton("Afsluttet oprettelser");
        buttonSettings = new JButton("Indstillinger");
        buttonExit = new JButton("Afslut program");

        buttonCreateUser.addActionListener(menuActionListener);
        buttonExit.addActionListener(menuActionListener);
        menuActionListener.setPanelMenuClass(this);

        add(buttonCreateUser);
        add(buttonShowStartedProgress);
        add(buttonShowEndedProgress);
        add(buttonSettings);
        add(buttonExit);
    }
}
