package com.starlingsoftwares.mymanagement.model;

public class Delete {
    String uniqueId;

    public Delete() {
    }

    public Delete(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
}
