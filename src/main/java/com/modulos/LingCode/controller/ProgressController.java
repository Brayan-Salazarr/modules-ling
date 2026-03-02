package com.modulos.LingCode.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modulos.LingCode.service.UserProgressService;

@RestController
@RequestMapping("/api/progress")
@CrossOrigin
public class ProgressController {
    
    private final UserProgressService progressService;

    public ProgressController(UserProgressService progressService) {
        this.progressService = progressService;
    }

    /**
     * Obtiene el progreso general del usuario
     */
    @GetMapping
    public Object getProgress(@RequestParam String userId) {
        return progressService.getProgress(userId);
    }

    /**
     * Obtiene el progreso de un módulo específico
     */
    @GetMapping("/modules/{moduleId}")
    public int getModuleProgress(
            @PathVariable String moduleId,
            @RequestParam String userId
    ) {
        return progressService.calculateModuleProgress(userId, moduleId);
    }
}
