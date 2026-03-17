package com.modulos.LingCode.model;

public class OptionEntity {

    private String text;
    private boolean correct;
    private String translation;

    public OptionEntity(String text, boolean correct, String translation) {
        this.text = text;
        this.correct = correct;
        this.translation = translation;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getTranslation() {
        return translation;
    }
}
