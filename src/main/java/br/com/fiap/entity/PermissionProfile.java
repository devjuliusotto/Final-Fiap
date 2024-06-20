package br.com.fiap.entity;

public class PermissionProfile {
    private int id;
    private String code;
    private String description;
    private int accessLevel;
    private int passwordPoliciesId;

    public PermissionProfile() {}

    public PermissionProfile(int id, String code, String description, int accessLevel, int passwordPoliciesId) {
        this.id = id;
        this.code = code;
        this.description = description;
        this.accessLevel = accessLevel;
        this.passwordPoliciesId = passwordPoliciesId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(int accessLevel) {
        this.accessLevel = accessLevel;
    }

    public int getPasswordPoliciesId() {
        return passwordPoliciesId;
    }

    public void setPasswordPoliciesId(int passwordPoliciesId) {
        this.passwordPoliciesId = passwordPoliciesId;
    }
}
