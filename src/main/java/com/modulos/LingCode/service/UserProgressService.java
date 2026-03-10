package com.modulos.LingCode.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.modulos.LingCode.model.LessonEntity;
import com.modulos.LingCode.model.UserProgress;

@Service
public class UserProgressService {

    // Simula una base de datos en memoria
    private Map<String, UserProgress> progressStore = new HashMap<>();

    private final LessonService lessonService;

    public UserProgressService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    public UserProgress getOrCreateProgress(String userId) {
        return progressStore.computeIfAbsent(userId, UserProgress::new);
    }

    public UserProgress completeLesson(String userId, String lessonId, int xp) {
        UserProgress progress = getOrCreateProgress(userId);

        if (!progress.getCompletedLessons().contains(lessonId)) {
            progress.completeLesson(lessonId);
            progress.addXp(xp);
            progress.updateStreak();
        }

        return progress;
    }

    public UserProgress getProgress(String userId) {
        System.out.println("USER ID: " + userId);
        return getOrCreateProgress(userId);
    }

    public int calculateModuleProgress(String userId, String moduleId) {

        UserProgress progress = getOrCreateProgress(userId);

        List<LessonEntity> lessons = lessonService.getLessonsByModule(moduleId);

        if (lessons == null || lessons.isEmpty()) {
            return 0;
        }

        long completed = lessons.stream()
                .filter(l -> progress.getCompletedLessons().contains(l.getId()))
                .count();

        return (int) ((completed * 100) / lessons.size());
    }

    public int calculateTotalProgress(String userId) {

        UserProgress progress = getOrCreateProgress(userId);

        // Obtener todas las lecciones
        List<LessonEntity> allLessons = lessonService.getAllLessons();
        if (allLessons.isEmpty())
            return 0;

        // Contar cuántas completó
        long completed = allLessons.stream()
                .filter(l -> progress.getCompletedLessons().contains(l.getId()))
                .count();

        return (int) Math.round((completed * 100.0) / allLessons.size());
    }
}
