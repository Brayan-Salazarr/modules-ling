package com.modulos.LingCode.model;

import java.util.List;

public class ExerciseEntity {

    private String question;
    private String description;
    private String type; // "multiple" | "order" | "translate" | "fill" | "match"

    private List<OptionEntity> options;
    private List<String> correctOrder; // solo para tipo "order"
    private String correctAnswer;
    private List<MatchPair> pairs;

    // Constructor para multiple choice
    public ExerciseEntity(String question, String description, List<OptionEntity> options) {
        this.question = question;
        this.description = description;
        this.type = "multiple";
        this.options = options;
    }

    // Constructor para ordenar palabras
    public ExerciseEntity(String question, String description,
            List<OptionEntity> options, List<String> correctOrder) {
        this.question = question;
        this.description = description;
        this.type = "order";
        this.options = options;
        this.correctOrder = correctOrder;
    }

    // Constructor Translate y Fill
    public ExerciseEntity(String question, String description,
            String correctAnswer, String type) {
        this.question = question;
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.type = type;
    }

    // Constructor para match
    public ExerciseEntity(String question, String description,
            List<MatchPair> pairs, String type) {
        this.question = question;
        this.description = description;
        this.type = type;
        this.pairs = pairs;
    }

    public String getQuestion() {
        return question;
    }

    public List<OptionEntity> getOptions() {
        return options;
    }

    public String getType() {
        return type;
    }

    public List<String> getCorrectOrder() {
        return correctOrder;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<MatchPair> getPairs() {
        return pairs;
    }

    public String getDescription() {
        return description;
    }
}
