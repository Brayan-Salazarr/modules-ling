package com.modulos.LingCode.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.modulos.LingCode.model.ExerciseEntity;
import com.modulos.LingCode.model.LessonEntity;
import com.modulos.LingCode.model.OptionEntity;
import com.modulos.LingCode.model.UserProgress;

@Service
public class LessonService {
    
    private List<LessonEntity> lessons = new ArrayList<>();

    public LessonService() {

        List<OptionEntity> options1 = List.of(
            new OptionEntity("git init", true),
            new OptionEntity("git start", false),
            new OptionEntity("git create", false)
        );

        ExerciseEntity exercise1 =
            new ExerciseEntity("Init", options1);

        LessonEntity lesson1 = new LessonEntity(
            "1",
            "1", // moduleId
            "Comandos GitHub",
            20,
            List.of(exercise1)
        );

        lessons.add(lesson1);
    }

    public List<LessonEntity> getLessonsByModule(String moduleId) {
        return lessons.stream()
                .filter(l -> l.getModuleId().equals(moduleId))
                .toList();
    }

    private List<UserProgress> usersProgress = new ArrayList<>();

    public boolean submitAnswer(String userId, String lessonId, String answer) {

    LessonEntity lesson = lessons.stream()
            .filter(l -> l.getId().equals(lessonId))
            .findFirst()
            .orElse(null);

    if (lesson == null) return false;

    boolean correct = lesson.getExercises().get(0).getOptions()
            .stream()
            .anyMatch(o -> o.getText().equals(answer) && o.isCorrect());

    if (correct) {

        UserProgress progress = usersProgress.stream()
                .filter(u -> u.getUserId().equals(userId))
                .findFirst()
                .orElseGet(() -> {
                    UserProgress newUser = new UserProgress(userId);
                    usersProgress.add(newUser);
                    return newUser;
                });

        progress.addXp(lesson.getXpReward());
        progress.completeLesson(lessonId);
    }

    return correct;
}
}
