package org.example.objects;

public class OptionText {
    private String label, userInput;

    public OptionText(String label) {
        this.label = label;
        userInput = "";
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }
}
