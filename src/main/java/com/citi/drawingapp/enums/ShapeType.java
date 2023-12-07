package com.citi.drawingapp.enums;

public enum ShapeType {
    C("Canvas", 1),
    L("Line", 2),
    R("Rectangle", 3);

    private String name;
    private int type;

    private ShapeType(String name, int type) {
        this.name = name;
        this.type = type;
    }
}
