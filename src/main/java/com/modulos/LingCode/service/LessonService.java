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
                new OptionEntity("Borrar", false),
                new OptionEntity("Iniciar", true),
                new OptionEntity("Copiar", false),
                new OptionEntity("Estado", false));

        ExerciseEntity exercise1 = new ExerciseEntity("Init", options1);

        List<String> correctOrder = List.of(
                "Iniciar",
                "un",
                "nuevo",
                "repositorio");

        List<OptionEntity> scrambled = List.of(
                new OptionEntity("nuevo", false),
                new OptionEntity("Iniciar", false),
                new OptionEntity("repositorio", false),
                new OptionEntity("un", false));

        ExerciseEntity exercise2 = new ExerciseEntity(
                "Initialize a new repository",
                "order",
                scrambled,
                correctOrder);

        LessonEntity lesson1 = new LessonEntity(
                "1",
                "1", // moduleId
                "Comandos GitHub",
                20,
                List.of(exercise1, exercise2));

        lessons.add(lesson1);
    }

    public List<LessonEntity> getLessonsByModule(String moduleId) {
        return lessons.stream()
                .filter(l -> l.getModuleId().equals(moduleId))
                .toList();
    }

    private List<UserProgress> usersProgress = new ArrayList<>();

    public boolean submitAnswer(String userId, String lessonId, int exerciseIndex, String answer) {

        LessonEntity lesson = lessons.stream()
                .filter(l -> l.getId().equals(lessonId))
                .findFirst()
                .orElse(null);

        if (lesson == null)
            return false;

        if (exerciseIndex >= lesson.getExercises().size())
            return false;

        ExerciseEntity exercise = lesson.getExercises().get(exerciseIndex);

        boolean correct = exercise.getOptions()
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
