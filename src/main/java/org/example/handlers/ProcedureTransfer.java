package org.example.handlers;

public class ProcedureTransfer {
    private String procedure;
    private long id;

    public ProcedureTransfer() {
        procedure = "";
        id = 0;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProcedure() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure = procedure;
    }
}
