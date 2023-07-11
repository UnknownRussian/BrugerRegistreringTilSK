package org.example.frames;

import org.example.OptionUpdater;
import org.example.objects.Account;
import org.example.objects.CreateUserOption;
import org.example.objects.OptionToAdd;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrameCreateUser extends JFrame {
    private JButton buttonStart, buttonSave, buttonCancel;
    private Account account;
    private ArrayList<CreateUserOption> options;
    private OptionUpdater optionUpdater;

    public FrameCreateUser(OptionUpdater optionUpdater){
        this.optionUpdater = optionUpdater;
        createOptions();

        setLayout(new FlowLayout(FlowLayout.CENTER));
        System.out.println((options.get(0).getHeight()+ " " +options.size()));
        setSize(new Dimension(650,(options.get(0).getHeight()*(options.size()+4))));

        for(CreateUserOption option : options){
            add(option.getOptionPanel());
        }

        buttonStart = new JButton("Start");
        buttonSave = new JButton("Gem");
        buttonCancel = new JButton("Annuller");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(buttonStart);
        buttonPanel.add(buttonSave);
        buttonPanel.add(buttonCancel);

        add(buttonPanel);

        setVisible(true);
    }

    private void createOptions(){
        options = new ArrayList<>();
        for(OptionToAdd optionToAdd : optionUpdater.getOptionsToAdd()){
            options.add(new CreateUserOption((optionToAdd.getComboBox().getSelectedIndex() == 0),optionToAdd.getTextField().getText()));
        }


//        options.add(new CreateUserOption(true,"Navn:"));
//        options.add(new CreateUserOption(true,"Efternavn:"));
//        options.add(new CreateUserOption(true, "Brugernavn:"));
//        options.add(new CreateUserOption(true, "Direkte nr.:"));
//        options.add(new CreateUserOption(true, "Mobil nr.:"));
//        options.add(new CreateUserOption(true, "Mail:"));
//        options.add(new CreateUserOption(true, "Afdeling:"));
//        options.add(new CreateUserOption(true, "Jobtitel DK:"));
//        options.add(new CreateUserOption(true, "Jobtitel ENG:"));
//        options.add(new CreateUserOption(true,"Firma:"));
//        options.add(new CreateUserOption(false, "Søulke:"));
//        options.add(new CreateUserOption(false, "Telefon:"));
//        options.add(new CreateUserOption(false, "SLS:"));
//        options.add(new CreateUserOption(false, "Adaptiv"));
//        options.add(new CreateUserOption(false, "BC:"));
    }
}
