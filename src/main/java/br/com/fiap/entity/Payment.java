package br.com.fiap.entity;

public class Payment {
    private int id;
    private long code;
    private String description;
    private int enabled;

    public Payment() {}

    public Payment(int id, long code, String description, int enabled) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
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
}
