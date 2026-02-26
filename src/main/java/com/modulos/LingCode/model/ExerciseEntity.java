package com.modulos.LingCode.model;

import java.util.List;

public class ExerciseEntity {

    private String question;
    private List<OptionEntity> options;

    public ExerciseEntity(String question, List<OptionEntity> options) {
        this.question = question;
        this.options = options;
    }

    public String getQuestion() { return question; }
    public List<OptionEntity> getOptions() { return options; }
    
}
