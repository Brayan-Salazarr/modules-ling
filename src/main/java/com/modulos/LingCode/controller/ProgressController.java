package com.modulos.LingCode.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
      Obtiene el progreso general del usuario
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
            @PathVariable String moduleId
    ) {
        return progressService.calculateModuleProgress(userId, moduleId);
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
}
