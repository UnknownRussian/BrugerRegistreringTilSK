package org.example.objects;

public class OptionYesNo {
    private String label;
    private boolean isYes;

    public OptionYesNo(String label) {
        this.label = label;
        this.isYes = false;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isYes() {
        return isYes;
    }

    public void setYes(boolean yes) {
        isYes = yes;
    }
}
