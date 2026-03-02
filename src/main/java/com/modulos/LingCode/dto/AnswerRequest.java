package com.modulos.LingCode.dto;

public class AnswerRequest {
    
     private String userId;
    private int exerciseIndex;
    private String answer;

    public String getUserId() {
        return userId;
    }

    public int getExerciseIndex() {
        return exerciseIndex;
    }

    public String getAnswer() {
        return answer;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setExerciseIndex(int exerciseIndex) {
        this.exerciseIndex = exerciseIndex;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
