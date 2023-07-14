package org.example.handlers;

import org.example.objects.OptionAndProcedure;
import org.example.objects.Procedure;
import org.example.panels.PanelCreateUserOption;
import org.example.panels.PanelOptionToAdd;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HandlerData {
    private ArrayList<PanelOptionToAdd> optionsToAdd;
    private ArrayList<PanelCreateUserOption> panelCreateUserOptions;
    private ArrayList<Procedure> procedures;
    private ArrayList<OptionAndProcedure> optionsAndProcedures;
    private JSONArray optionsAndProceduresJSONArray;

    public ArrayList<OptionAndProcedure> getOptionsAndProcedures() {
        return optionsAndProcedures;
    }

    public HandlerData() throws IOException, ParseException {
        optionsToAdd = new ArrayList<>();
        panelCreateUserOptions = new ArrayList<>();
        procedures = new ArrayList<>();
        optionsAndProcedures = new ArrayList<>();
        optionsAndProceduresJSONArray = new JSONArray();
        readFiles();
    }

    public void setOptionsToAdd(ArrayList<PanelOptionToAdd> optionsToAdd) {
        this.optionsToAdd = new ArrayList<>();
        for(PanelOptionToAdd option : optionsToAdd){
            this.optionsToAdd.add(option);
        }
        System.out.println("Size of saved list: "+this.optionsToAdd.size());
    }

    public void saveOptionsAndProcedures() throws IOException {
        if(optionsAndProcedures.size() != 0){
            optionsAndProcedures = new ArrayList<>();
        }
        for(PanelOptionToAdd option : optionsToAdd){
            if(option.getComboBox().getSelectedIndex() == 1){
                for(Procedure procedure : procedures){
                    if(option.getId() == procedure.getId()){
                        optionsAndProcedures.add(new OptionAndProcedure(
                                option.getId(),
                                procedure.getId(),
                                option.getTextField().getText(),
                                procedure.getProcedure(),
                                (option.getComboBox().getSelectedIndex() == 0)
                                ));
                    }
                }
            } else {
                optionsAndProcedures.add(new OptionAndProcedure(
                        option.getId(),
                        0,
                        option.getTextField().getText(),
                        "",
                        (option.getComboBox().getSelectedIndex() == 0)
                ));
            }
        }
        saveOptionsAndProceduresToJSONFile();
    }

    private void saveOptionsAndProceduresToJSONFile() throws IOException {
        optionsAndProceduresJSONArray = new JSONArray();
        for(OptionAndProcedure optionAndProcedure : optionsAndProcedures) {
            JSONObject addedOption = new JSONObject();
            addedOption.put("optionId", optionAndProcedure.getOptionId());
            addedOption.put("procedureId", optionAndProcedure.getProcedureId());
            addedOption.put("optionTextFieldText", optionAndProcedure.getOptionTextFieldText());
            addedOption.put("procedureText", optionAndProcedure.getProcedureText());
            addedOption.put("isText", optionAndProcedure.isText());
            optionsAndProceduresJSONArray.add(addedOption);
        }
        saveJSON("optionsAndProcedures.json", optionsAndProceduresJSONArray);
    }

    private void saveJSON(String fileName, JSONArray jsonArray) throws IOException {
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
    }

    private void readFiles() throws IOException, ParseException {
        File file1 = new File("optionsAndProcedures.json");
        if(file1.exists()){
            optionsAndProcedures = new ArrayList<>();
            FileReader optionsAndProceduresFile = new FileReader("optionsAndProcedures.json");
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(optionsAndProceduresFile);
            JSONArray jsonArray = (JSONArray) obj;
            jsonArray.forEach(optionAndProcedure -> {
                JSONObject jsonObject = (JSONObject) optionAndProcedure;
                optionsAndProcedures.add(new OptionAndProcedure(
                        (long)jsonObject.get("optionId"),
                        (long)jsonObject.get("procedureId"),
                        (String)jsonObject.get("optionTextFieldText"),
                        (String)jsonObject.get("procedureText"),
                        (boolean)jsonObject.get("isText")
                ));
            });
            System.out.println(optionsAndProcedures.size());
        }
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

    public ArrayList<PanelOptionToAdd> getOptionsToAdd() {
        return optionsToAdd;
    }
}
