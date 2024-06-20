package br.com.fiap.entity;

public class OperationType {
    private int id;
    private int code;
    private String description;
    private int enabled;
    private int typeOperation;

    public OperationType() {}

    public OperationType(int id, int code, String description, int enabled, int typeOperation) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.enabled = enabled;
        this.typeOperation = typeOperation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getTypeOperation() {
        return typeOperation;
    }

    public void setTypeOperation(int typeOperation) {
        this.typeOperation = typeOperation;
    }
}
