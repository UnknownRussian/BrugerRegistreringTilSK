package org.example.panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelCheckList extends JPanel {
    private ArrayList<PanelCreateUserOption> options;

    public PanelCheckList (Dimension dimension){
        setPreferredSize(dimension);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setBackground(Color.BLUE);
        setVisible(false);
    }

    public void setOptions(ArrayList<PanelCreateUserOption> options){
        this.options = options;
        for(PanelCreateUserOption option : options){
            if(!option.getIsText()){
                if(option.getYesInput().isSelected())
                    System.out.println("Er adgang til "+ option.getLabel().getText() +" oprettet?");
            }
        }
    }
}
