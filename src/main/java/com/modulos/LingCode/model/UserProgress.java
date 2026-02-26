package com.modulos.LingCode.model;

import java.util.HashSet;
import java.util.Set;

public class UserProgress {
    
      private String userId;
    private int totalXp;
    private Set<String> completedLessons;

    public UserProgress(String userId) {
        this.userId = userId;
        this.totalXp = 0;
        this.completedLessons = new HashSet<>();
    }

    public String getUserId() { return userId; }
    public int getTotalXp() { return totalXp; }
    public Set<String> getCompletedLessons() { return completedLessons; }

    public void addXp(int xp) {
        this.totalXp += xp;
    }

    public void completeLesson(String lessonId) {
        this.completedLessons.add(lessonId);
    }

    
}
