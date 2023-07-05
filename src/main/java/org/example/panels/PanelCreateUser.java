package org.example.panels;

import org.example.listeners.CustomActionListener;

import javax.swing.*;
import java.awt.*;

public class PanelCreateUser extends JPanel {
    public PanelCreateUser(CustomActionListener customActionListener){
        setBackground(Color.RED);
        setPreferredSize(new Dimension(600,800));
        setVisible(false);
    }
}
