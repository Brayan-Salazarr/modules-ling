package com.modulos.LingCode.model;

public class OptionEntity {

    private String text;
    private boolean correct;

     public OptionEntity(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getText() { return text; }
    public boolean isCorrect() { return correct; }
}
