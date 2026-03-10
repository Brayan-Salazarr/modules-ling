package com.modulos.LingCode.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class UserProgress {

    private String userId;
    private int totalXp;
    private Set<String> completedLessons;

    private int currentStreak = 0;
    private int longestStreak = 0;
    private LocalDate lastCompletedDate;
    private int progressPercent;

    public UserProgress(String userId) {
        this.userId = userId;
        this.totalXp = 0;
        this.completedLessons = new HashSet<>();
        this.currentStreak = 0;
        this.longestStreak = 0;
        this.lastCompletedDate = null;
        this.progressPercent = 0;
    }

    // ========================
    // GETTERS
    // ========================
    public String getUserId() {
        return userId;
    }

    public int getTotalXp() {
        return totalXp;
    }

    public Set<String> getCompletedLessons() {
        return completedLessons;
    }

    public int getCurrentStreak() {
        return currentStreak;
    }

    public int getLongestStreak() {
        return longestStreak;
    }

    public LocalDate getLastCompletedDate() {
        return lastCompletedDate;
    }

    public int getProgressPercent(){
        return progressPercent;
    }

    // ========================
    // LÓGICA DE PROGRESO
    // ========================
    public void addXp(int xp) {
        this.totalXp += xp;
    }

    public void completeLesson(String lessonId) {
        this.completedLessons.add(lessonId);
    }

    // ========================
    // 🔥 LÓGICA DE RACHA
    // ========================

   public boolean updateStreak() {

    LocalDate today = LocalDate.now();

    // Primera vez que juega
    if (lastCompletedDate == null) {
        currentStreak = 1;
        lastCompletedDate = today;
        return true; // 🔥 activó racha
    }

    // Si ya jugó hoy → no hacer nada
    if (lastCompletedDate.equals(today)) {
        return false; // 🔥 NO activó racha
    }

    // Si jugó ayer → aumentar racha
    if (lastCompletedDate.plusDays(1).equals(today)) {
        currentStreak++;
    } else {
        // Perdió la racha
        currentStreak = 1;
    }

    if (currentStreak > longestStreak) {
        longestStreak = currentStreak;
    }

    lastCompletedDate = today;

    return true; // 🔥 sí activó racha
}

}
