package com.projectmanager.model.enums;

import lombok.Getter;

public enum Type {
    MANAGER("MANAGER"), TECHNICAL_SPECIALIST("TECHNICAL SPECIALIST");
    private final String type;

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
