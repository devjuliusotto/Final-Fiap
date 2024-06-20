package br.com.fiap.entity;

import java.util.Date;

public class Transaction {
    private int id;
    private long transactionNum;
    private int operationId;
    private Date transDatetime;
    private double total;
    private int paymentId;
    private int operatorId;
    private int typeOperationId;
    private String category;
    private String expenseType;
    private Date paymentDate;
    private String paymentMethod;
    private String classification;

    // Construtores
    public Transaction() {}

    public Transaction(int id, long transactionNum, int operationId, Date transDatetime, double total, int paymentId, int operatorId, int typeOperationId, String category, String expenseType, Date paymentDate, String paymentMethod, String classification) {
        this.id = id;
        this.transactionNum = transactionNum;
        this.operationId = operationId;
        this.transDatetime = transDatetime;
        this.total = total;
        this.paymentId = paymentId;
        this.operatorId = operatorId;
        this.typeOperationId = typeOperationId;
        this.category = category;
        this.expenseType = expenseType;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.classification = classification;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public long getTransactionNum() { return transactionNum; }
    public void setTransactionNum(long transactionNum) { this.transactionNum = transactionNum; }

    public int getOperationId() { return operationId; }
    public void setOperationId(int operationId) { this.operationId = operationId; }

    public Date getTransDatetime() { return transDatetime; }
    public void setTransDatetime(Date transDatetime) { this.transDatetime = transDatetime; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public int getPaymentId() { return paymentId; }
    public void setPaymentId(int paymentId) { this.paymentId = paymentId; }

    public int getOperatorId() { return operatorId; }
    public void setOperatorId(int operatorId) { this.operatorId = operatorId; }

    public int getTypeOperationId() { return typeOperationId; }
    public void setTypeOperationId(int typeOperationId) { this.typeOperationId = typeOperationId; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getExpenseType() { return expenseType; }
    public void setExpenseType(String expenseType) { this.expenseType = expenseType; }

    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getClassification() { return classification; }
    public void setClassification(String classification) { this.classification = classification; }
}
