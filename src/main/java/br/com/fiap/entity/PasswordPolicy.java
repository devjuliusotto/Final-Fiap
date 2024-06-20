package br.com.fiap.entity;

public class PasswordPolicy {
    private int id;
    private long code;
    private String description;
    private int passwordLength;
    private Integer numberAlphaCharacters;
    private Integer numberNumericCharacters;
    private Integer numberSpecialCharacters;
    private Integer numberUppercaseCharacters;
    private Integer passwordReuseHistory;
    private Integer passwordExpirationDays;
    private Integer failedLoginAttempts;

    public PasswordPolicy() {}

    public PasswordPolicy(int id, long code, String description, int passwordLength, Integer numberAlphaCharacters, Integer numberNumericCharacters, Integer numberSpecialCharacters, Integer numberUppercaseCharacters, Integer passwordReuseHistory, Integer passwordExpirationDays, Integer failedLoginAttempts) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.passwordLength = passwordLength;
        this.numberAlphaCharacters = numberAlphaCharacters;
        this.numberNumericCharacters = numberNumericCharacters;
        this.numberSpecialCharacters = numberSpecialCharacters;
        this.numberUppercaseCharacters = numberUppercaseCharacters;
        this.passwordReuseHistory = passwordReuseHistory;
        this.passwordExpirationDays = passwordExpirationDays;
        this.failedLoginAttempts = failedLoginAttempts;
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

    public int getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public Integer getNumberAlphaCharacters() {
        return numberAlphaCharacters;
    }

    public void setNumberAlphaCharacters(Integer numberAlphaCharacters) {
        this.numberAlphaCharacters = numberAlphaCharacters;
    }

    public Integer getNumberNumericCharacters() {
        return numberNumericCharacters;
    }

    public void setNumberNumericCharacters(Integer numberNumericCharacters) {
        this.numberNumericCharacters = numberNumericCharacters;
    }

    public Integer getNumberSpecialCharacters() {
        return numberSpecialCharacters;
    }

    public void setNumberSpecialCharacters(Integer numberSpecialCharacters) {
        this.numberSpecialCharacters = numberSpecialCharacters;
    }

    public Integer getNumberUppercaseCharacters() {
        return numberUppercaseCharacters;
    }

    public void setNumberUppercaseCharacters(Integer numberUppercaseCharacters) {
        this.numberUppercaseCharacters = numberUppercaseCharacters;
    }

    public Integer getPasswordReuseHistory() {
        return passwordReuseHistory;
    }

    public void setPasswordReuseHistory(Integer passwordReuseHistory) {
        this.passwordReuseHistory = passwordReuseHistory;
    }

    public Integer getPasswordExpirationDays() {
        return passwordExpirationDays;
    }

    public void setPasswordExpirationDays(Integer passwordExpirationDays) {
        this.passwordExpirationDays = passwordExpirationDays;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }
}
