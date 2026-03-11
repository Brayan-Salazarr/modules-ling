package com.modulos.LingCode.dto;

import java.util.List;

public class ProgressResponse {

    private int totalXp;
    private int currentStreak;
    private int longestStreak;
    private List<String> completedLessons;
    private int progressPercent;

    public ProgressResponse(int totalXp, int currentStreak, int longestStreak,
            List<String> completedLessons, int progressPercent) {
        this.totalXp = totalXp;
        this.currentStreak = currentStreak;
        this.longestStreak = longestStreak;
        this.completedLessons = completedLessons;
        this.progressPercent = progressPercent;
    }

    // getters
    public int getTotalXp() {
        return totalXp;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public List<String> getCompletedLessons() {
        return completedLessons;
    }

    public int getProgressPercent() {
        return progressPercent;
    }

    private List<Progress> progress;

    public ProgressResponse(List<Progress> progress) {
        this.progress = progress;
    }

    public List<Progress> getProgress() {
        return progress;
    }

    public void setProgress(List<Progress> progress) {
        this.progress = progress;
    }
}
