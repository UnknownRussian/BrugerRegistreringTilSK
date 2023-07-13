package org.example.handlers;

import org.example.objects.Procedure;
import org.example.panels.PanelCreateUserOption;
import org.example.panels.PanelOptionToAdd;

import java.util.ArrayList;

public class HandlerData {
    private ArrayList<PanelOptionToAdd> optionsToAdd;
    private ArrayList<PanelCreateUserOption> panelCreateUserOptions;
    private ArrayList<Procedure> procedures;

    public HandlerData() {
        optionsToAdd = new ArrayList<>();
        panelCreateUserOptions = new ArrayList<>();
        procedures = new ArrayList<>();
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

    public ArrayList<Procedure> getProcedures() {
        return procedures;
    }

    public void setProcedures(ArrayList<Procedure> procedures) {
        this.procedures = procedures;
    }
}
