package com.modulos.LingCode.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.modulos.LingCode.dto.AnswerRequest;
import com.modulos.LingCode.model.LessonEntity;
import com.modulos.LingCode.service.LessonService;

@RestController
@RequestMapping("/api/modules")
@CrossOrigin(origins = "http://localhost:4200")
public class LessonController {

    private final LessonService lessonService;

    public LessonController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @GetMapping("/{moduleId}/lessons")
    public List<LessonEntity> getLessons(@PathVariable String moduleId) {
        return lessonService.getLessonsByModule(moduleId);
    }

    @PostMapping("/lessons/{lessonId}/answer")
    public boolean submitAnswer(
            @PathVariable String lessonId,
            @RequestBody AnswerRequest request) {

        return lessonService.submitAnswer(
                request.getUserId(),
                lessonId,
                request.getExerciseIndex(),
                request.getAnswer());
    }

}
