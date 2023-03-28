package Coursework2;

public enum Type {
    WORK ("Рабочая задача"),
    PERSONAL ("Личная задача");

    Type (String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    private String type;




}