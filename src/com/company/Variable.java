package com.company;

public class Variable {
    private String identifier;
    private String content;

    public Variable(String identifier, String content) {
        this.content = content;
        this.identifier = identifier;
    }

    public Variable(String identifier) {
        this.identifier = identifier;
    }

    public Variable() {

    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
