package com.calculator.model;

public enum Type {
    STUDENT(0.00f),
    AUTO(500f),
    PERSONAL(750f),
    MORTGAGE(1500f);

    public final float label;

    private Type(float label) {
        this.label = label;
    }
}
