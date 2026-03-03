package com.modulos.LingCode.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.modulos.LingCode.model.ExerciseEntity;
import com.modulos.LingCode.model.LessonEntity;
import com.modulos.LingCode.model.MatchPair;
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

                ExerciseEntity exercise3 = new ExerciseEntity(
                                "Iniciar un nuevo repositorio",
                                "Initialize a new repository",
                                "translate");

                ExerciseEntity exercise4 = new ExerciseEntity(
                                "____ to initialize a new repository",
                                "Git init",
                                "fill");

                ExerciseEntity exercise5 = new ExerciseEntity(
                                "Relaciona el comando con su significado",
                                "match",
                                List.of(
                                                new MatchPair("Git clone", "Estado"),
                                                new MatchPair("Git status", "Iniciar"),
                                                new MatchPair("Git add", "Guardar"),
                                                new MatchPair("Git init", "Clonar"),
                                                new MatchPair("Git commit", "Confirmar")));

                LessonEntity lesson1 = new LessonEntity(
                                "1",
                                "1", // moduleId
                                "Comandos GitHub",
                                20,
                                List.of(exercise1, exercise2, exercise3, exercise4, exercise5));

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

                boolean correct = false;

                switch (exercise.getType()) {

                        case "multiple":
                                correct = exercise.getOptions()
                                                .stream()
                                                .anyMatch(o -> o.getText().equals(answer) && o.isCorrect());
                                break;

                        case "order":
                                List<String> userWords = List.of(answer.split(" "));
                                correct = userWords.equals(exercise.getCorrectOrder());
                                break;

                        case "translate":
                        case "fill":
                                correct = normalize(exercise.getCorrectAnswer())
                                                .equals(normalize(answer));
                                break;
                }

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

        private String normalize(String text) {
                String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
                return normalized.replaceAll("\\p{M}", "")
                                .trim()
                                .toLowerCase();
        }
}
