package org.example;

import org.example.panels.PanelCreateUserOption;
import org.example.panels.PanelOptionToAdd;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OptionJSONFormatter {
    private ArrayList<PanelOptionToAdd> optionsToAdd;
    private ArrayList<PanelCreateUserOption> userOptions;
    private JSONArray optionsToAddJSONArray;
    private JSONArray userOptionsJSONArray;

    public OptionJSONFormatter() {
        userOptions = new ArrayList<>();
        optionsToAddJSONArray = new JSONArray();
        userOptionsJSONArray = new JSONArray();
    }

    public void saveAddedOptionsToJSONArray(ArrayList<PanelOptionToAdd> optionsToAdd) throws Exception {
        optionsToAddJSONArray = new JSONArray();
        for(PanelOptionToAdd option : optionsToAdd){
            JSONObject addedOption = new JSONObject();
            addedOption.put("checkBox", "{"+option.getCheckBox()+"}");
            addedOption.put("textField", "{"+option.getTextField()+"}");
            addedOption.put("comboBox", "{"+option.getComboBox()+"}");
            addedOption.put("button", "{"+option.getButton()+"}");
            addedOption.put("panel", "{"+option.getPanel()+"}");
            optionsToAddJSONArray.add(addedOption);
        }
        saveJSON("optionsToAdd.json", optionsToAddJSONArray);
        getOptionsToAddData();
    }

    public void saveCreateUserOptionsToJSONArray() throws Exception {
        userOptionsJSONArray = new JSONArray();
        for(PanelCreateUserOption option : userOptions){
            JSONObject createdOption = new JSONObject();
            createdOption.put("label", option.getLabel());
            createdOption.put("yesInput", option.getYesInput());
            createdOption.put("noInput", option.getNoInput());
            createdOption.put("txtInput", option.getTxtInput());
            createdOption.put("leftPanel", option.getLeftPanel());
            createdOption.put("rightPanel", option.getRightPanel());
            createdOption.put("optionPanel", option.getOptionPanel());
            createdOption.put("height", option.getHeight());
            userOptionsJSONArray.add(createdOption);
        }
        saveJSON("createdOptions.json", userOptionsJSONArray);
    }

    private void saveJSON(String fileName, JSONArray jsonArray) throws IOException {
        FileWriter file = new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
    }

    private void getOptionsToAddData() throws  Exception {
        optionsToAdd = new ArrayList<>();
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader("optionsToAdd.json");
        Object object = parser.parse(reader);
        JSONArray jsonArray = (JSONArray) object;
        jsonArray.forEach(option -> {

        });
    }
}
