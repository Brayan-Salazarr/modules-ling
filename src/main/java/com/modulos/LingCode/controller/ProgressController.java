package com.modulos.LingCode.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modulos.LingCode.dto.CompleteLessonRequest;
import com.modulos.LingCode.dto.ProgressResponse;
import com.modulos.LingCode.model.UserProgress;
import com.modulos.LingCode.service.UserProgressService;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin(origins = "http://localhost:4200")
public class ProgressController {

    private final UserProgressService progressService;

    public ProgressController(UserProgressService progressService) {
        this.progressService = progressService;
    }

    /**
     * Obtiene el progreso general del usuario
     */
    @GetMapping("/{userId}")
    public UserProgress getProgress(@PathVariable String userId) {
        return progressService.getProgress(userId);
    }

    /**
     * Obtiene el progreso de un módulo específico
     */
    @GetMapping("/{userId}/modules/{moduleId}")
    public int getModuleProgress(
            @PathVariable String userId,
            @PathVariable String moduleId) {
        return progressService.calculateModuleProgress(userId, moduleId);
    }

   // Obtener progreso general del usuario
    @GetMapping("/{userId}/total")
    public ProgressResponse getTotalProgress(@PathVariable String userId) {

        UserProgress progress = progressService.getOrCreateProgress(userId);
        int percent = progressService.calculateTotalProgress(userId);

        return new ProgressResponse(
                progress.getTotalXp(),
                progress.getCurrentStreak(),
                progress.getLongestStreak(),
                List.copyOf(progress.getCompletedLessons()),
                percent
        );
    }

    /**
     * Marca una lección como completada
     */
    @PostMapping("/{userId}/complete/{lessonId}")
    public UserProgress completeLesson(
            @PathVariable String userId,
            @PathVariable String lessonId,
            @RequestParam int xp) {

        return progressService.completeLesson(userId, lessonId, xp);
    }

    @PostMapping("/complete-lesson")
    public UserProgress completeLesson(@RequestBody CompleteLessonRequest request) {

        return progressService.completeLesson(
                request.getUserId(),
                request.getLessonId(),
                request.getXpReward());
    }
}
