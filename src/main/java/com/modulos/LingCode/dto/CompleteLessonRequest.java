package com.modulos.LingCode.dto;

public class CompleteLessonRequest {
    
    private String userId;
    private String lessonId;
    private int xpReward;

    public String getUserId(){
        return userId;
    }

    public String getLessonId(){
        return lessonId;
    }

    public int getXpReward(){
        return xpReward;
    }

     public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setLessonId(String lessonId) {
        this.lessonId = lessonId;
    }

    public void setAnswer(int xpReward) {
        this.xpReward = xpReward;
    }
}
