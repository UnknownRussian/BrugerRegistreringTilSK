package org.example.objects;

public class OptionAndProcedure {
    private long optionId, procedureId;
    private String optionTextFieldText, procedureText; //ProcedureText is only created
    private boolean isText; //true = text, false = yes/no radioButtons

    public OptionAndProcedure(long optionId, long procedureId, String optionTextFieldText, String procedureText, boolean isText){
        if(isText){
            this.optionId = optionId;
            this.optionTextFieldText = optionTextFieldText;
            this.isText = isText;
        }else {
            this.optionId = optionId;
            this.optionTextFieldText = optionTextFieldText;
            this.isText = isText;
            this.procedureId = procedureId;
            this.procedureText = procedureText;
        }
    }

    public long getOptionId() {
        return optionId;
    }

    public void setOptionId(long optionId) {
        this.optionId = optionId;
    }

    public long getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(long procedureId) {
        this.procedureId = procedureId;
    }

    public String getOptionTextFieldText() {
        return optionTextFieldText;
    }

    public void setOptionTextFieldText(String optionTextFieldText) {
        this.optionTextFieldText = optionTextFieldText;
    }

    public String getProcedureText() {
        return procedureText;
    }

    public void setProcedureText(String procedureText) {
        this.procedureText = procedureText;
    }

    public boolean isText() {
        return isText;
    }

    public void setText(boolean text) {
        isText = text;
    }
}
