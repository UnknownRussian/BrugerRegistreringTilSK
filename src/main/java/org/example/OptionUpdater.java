package org.example;

import org.example.panels.PanelCreateUserOption;
import org.example.panels.PanelOptionToAdd;

import java.util.ArrayList;

public class OptionUpdater {
    private ArrayList<PanelOptionToAdd> optionsToAdd;
    private ArrayList<PanelCreateUserOption> panelCreateUserOptions;

    public OptionUpdater() {
        optionsToAdd = new ArrayList<>();
        panelCreateUserOptions = new ArrayList<>();
    }

    public ArrayList<PanelOptionToAdd> getOptionsToAdd() {
        return optionsToAdd;
    }

    public void setOptionsToAdd(ArrayList<PanelOptionToAdd> optionsToAdd) {
        this.optionsToAdd = new ArrayList<>();
        for(PanelOptionToAdd option : optionsToAdd){
            this.optionsToAdd.add(option);
        }
        System.out.println("Size of saved list: "+this.optionsToAdd.size());
    }

    public ArrayList<PanelCreateUserOption> getCreateUserOptions() {
        return panelCreateUserOptions;
    }

    public void setCreateUserOptions(ArrayList<PanelCreateUserOption> panelCreateUserOptions) {
        this.panelCreateUserOptions = panelCreateUserOptions;
    }
}
