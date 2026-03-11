package com.modulos.LingCode.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modulos.LingCode.dto.Progress;
import com.modulos.LingCode.model.LessonEntity;
import com.modulos.LingCode.model.ModuleEntity;
import com.modulos.LingCode.model.UserProgress;

@Service
public class UserProgressService {

    // Simula una base de datos en memoria
    private Map<String, UserProgress> progressStore = new HashMap<>();

    private final LessonService lessonService;

    @Autowired
    private ModuleService moduleService;

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

    // NUEVO MÉTODO PARA HISTORIAL
    public List<Progress> getProgressHistory(String userId) {

        UserProgress userProgress = getProgress(userId);

        List<Progress> history = new ArrayList<>();

        for (String lessonId : userProgress.getCompletedLessons()) {

            LessonEntity lesson = lessonService.getAllLessons()
                    .stream()
                    .filter(l -> l.getId().equals(lessonId))
                    .findFirst()
                    .orElse(null);

            if (lesson == null)
                continue;

            ModuleEntity module = moduleService.getAllModules()
                    .stream()
                    .filter(m -> m.getId().equals(lesson.getModuleId()))
                    .findFirst()
                    .orElse(null);
            int progress = calculateModuleProgress(module.getId(), userProgress);
            if (module == null)
                continue;

            Progress dto = new Progress();
            dto.setModuleId(module.getId());
            dto.setModuleName(module.getTitle());
            dto.setProgress(progress);
            dto.setUpdatedAt(userProgress.getLastCompletedDate().atStartOfDay());

            history.add(dto);
        }

        return history;
    }

    private int calculateModuleProgress(String moduleId, UserProgress userProgress) {

        long completedLessons = userProgress.getCompletedLessons()
                .stream()
                .filter(lessonId -> {
                    LessonEntity lesson = lessonService.getLessonById(lessonId);
                    return lesson != null && lesson.getModuleId().equals(moduleId);
                })
                .count();

        int totalLessons = lessonService.getLessonsByModule(moduleId).size();

        if (totalLessons == 0)
            return 0;

        return (int) ((completedLessons * 100) / totalLessons);
    }
}
