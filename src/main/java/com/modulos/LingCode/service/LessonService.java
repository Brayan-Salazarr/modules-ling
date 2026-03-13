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
                                "_______ to initialize a new repository",
                                "Git init",
                                "fill");

                ExerciseEntity exercise5 = new ExerciseEntity(
                                "Relaciona el comando con su significado",
                                "match",
                                List.of(
                                                new MatchPair("Git clone", "Clonar"),
                                                new MatchPair("Git status", "Estado"),
                                                new MatchPair("Git add", "Guardar"),
                                                new MatchPair("Git init", "Iniciar"),
                                                new MatchPair("Git commit", "Confirmar")));

                LessonEntity lesson1 = new LessonEntity(
                                "1",
                                "1", // moduleId
                                "Comandos GitHub",
                                20,
                                List.of(exercise1, exercise2, exercise3, exercise4, exercise5));

                List<OptionEntity> options1Lesson2 = List.of(
                                new OptionEntity("Conectar", false),
                                new OptionEntity("Crear", true),
                                new OptionEntity("Actualizar", false),
                                new OptionEntity("Eliminar", false));

                ExerciseEntity exercise1Lesson2 = new ExerciseEntity("Create", options1Lesson2);

                List<String> correctOrderLesson2 = List.of("Crear", "una", "nueva", "base", "de", "datos");
                List<OptionEntity> scrambledLesson2 = List.of(
                                new OptionEntity("una", false),
                                new OptionEntity("Crear", false),
                                new OptionEntity("nueva", false),
                                new OptionEntity("datos", false),
                                new OptionEntity("base", false),
                                new OptionEntity("de", false));

                ExerciseEntity exercise2Lesson2 = new ExerciseEntity(
                                "Create a new database",
                                "order",
                                scrambledLesson2,
                                correctOrderLesson2);

                ExerciseEntity exercise3Lesson2 = new ExerciseEntity(
                                "Crear una nueva base de datos",
                                "Create a new database",
                                "translate");

                ExerciseEntity exercise4Lesson2 = new ExerciseEntity(
                                "____ to create a new database",
                                "CREATE",
                                "fill");

                ExerciseEntity exercise5Lesson2 = new ExerciseEntity(
                                "Relaciona el comando con su significado",
                                "match",
                                List.of(
                                                new MatchPair("Create database", "Crear base de datos"),
                                                new MatchPair("Drop database", "Eliminar base de datos"),
                                                new MatchPair("Alter table", "Modificar tabla"),
                                                new MatchPair("Insert into", "Insertar datos"),
                                                new MatchPair("Select", "Consultar datos")));

                LessonEntity lesson2 = new LessonEntity(
                                "2",
                                "2",
                                "Comandos MySQL",
                                0,
                                List.of(exercise1Lesson2, exercise2Lesson2, exercise3Lesson2, exercise4Lesson2,
                                                exercise5Lesson2));

                LessonEntity lesson3 = new LessonEntity(
                                "3",
                                "1",
                                "Comandos GitHub",
                                0,
                                List.of());

                lessons.add(lesson1);
                lessons.add(lesson2);
                lessons.add(lesson3);
        }

        public List<LessonEntity> getAllLessons() {
                return lessons;
        }

        public List<LessonEntity> getLessonsByModule(String moduleId) {
                return lessons.stream()
                                .filter(l -> l.getModuleId().equals(moduleId))
                                .toList();
        }

        public LessonEntity getLessonById(String lessonId) {
                return lessons.stream()
                                .filter(l -> l.getId().equals(lessonId))
                                .findFirst()
                                .orElse(null);
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
                                List<String> userWords = List.of(answer.trim().split("\\s+"));
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
