package org.example;

import org.example.objects.CreateUserOption;
import org.example.objects.OptionToAdd;

import java.util.ArrayList;

public class OptionUpdater {
    private ArrayList<OptionToAdd> optionsToAdd;
    private ArrayList<CreateUserOption> createUserOptions;

    public OptionUpdater() {
        optionsToAdd = new ArrayList<>();
        createUserOptions = new ArrayList<>();
    }

    public ArrayList<OptionToAdd> getOptionsToAdd() {
        return optionsToAdd;
    }

    public void setOptionsToAdd(ArrayList<OptionToAdd> optionsToAdd) {
        this.optionsToAdd = new ArrayList<>();
        for(OptionToAdd option : optionsToAdd){
            this.optionsToAdd.add(option);
        }
        System.out.println("Size of saved list: "+this.optionsToAdd.size());
    }

    public ArrayList<CreateUserOption> getCreateUserOptions() {
        return createUserOptions;
    }

    public void setCreateUserOptions(ArrayList<CreateUserOption> createUserOptions) {
        this.createUserOptions = createUserOptions;
    }
}
