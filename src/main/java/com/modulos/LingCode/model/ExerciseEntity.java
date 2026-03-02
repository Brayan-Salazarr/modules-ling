package com.modulos.LingCode.model;

import java.util.List;

public class ExerciseEntity {

    private String question;
    private String type; // "multiple" o "order"
    private List<OptionEntity> options;
    private List<String> correctOrder; // solo para tipo "order"

     // Constructor para multiple choice
    public ExerciseEntity(String question, List<OptionEntity> options) {
        this.question = question;
        this.type = "multiple";
        this.options = options;
    }


    // Constructor para ordenar palabras
    public ExerciseEntity(String question,
                          String type,
                          List<OptionEntity> options,
                          List<String> correctOrder) {
        this.question = question;
        this.type = type;
        this.options = options;
        this.correctOrder = correctOrder;
    }

    public String getQuestion() {
        return question;
    }

    public List<OptionEntity> getOptions() {
        return options;
    }

    public String getType(){
        return type;
    }

    public List<String> getCorrectOrder(){
        return correctOrder;
    }

}
