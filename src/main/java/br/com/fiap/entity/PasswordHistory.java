package br.com.fiap.entity;

import java.util.Date;

public class PasswordHistory {
    private int id;
    private int operatorId;
    private int changeOperatorId;
    private String password;
    private Date passwordChangeDate;

    public PasswordHistory() {}

    public PasswordHistory(int id, int operatorId, int changeOperatorId, String password, Date passwordChangeDate) {
        this.id = id;
        this.operatorId = operatorId;
        this.changeOperatorId = changeOperatorId;
        this.password = password;
        this.passwordChangeDate = passwordChangeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(int operatorId) {
        this.operatorId = operatorId;
    }

    public int getChangeOperatorId() {
        return changeOperatorId;
    }

    public void setChangeOperatorId(int changeOperatorId) {
        this.changeOperatorId = changeOperatorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getPasswordChangeDate() {
        return passwordChangeDate;
    }

    public void setPasswordChangeDate(Date passwordChangeDate) {
        this.passwordChangeDate = passwordChangeDate;
    }
}
