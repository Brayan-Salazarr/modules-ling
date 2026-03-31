package com.modulos.LingCode.service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
                                new OptionEntity("Borrar", false, ""),
                                new OptionEntity("Iniciar", true, ""),
                                new OptionEntity("Copiar", false, ""),
                                new OptionEntity("Estado", false, ""));

                ExerciseEntity exercise1 = new ExerciseEntity("Init",
                                "Un desarrollador quiere comenzar a trabajar en un nuevo repositorio desde cero. ¿Qué acción representa el comando 'init'?",
                                options1);

                List<String> correctOrder = List.of(
                                "Iniciar",
                                "un",
                                "nuevo",
                                "repositorio");

                List<OptionEntity> scrambled = List.of(
                                new OptionEntity("nuevo", false, "new"),
                                new OptionEntity("Iniciar", false, "Initialize"),
                                new OptionEntity("repositorio", false, "repository"),
                                new OptionEntity("un", false, "a"));

                ExerciseEntity exercise2 = new ExerciseEntity(
                                "Initialize a new repository",
                                "Un desarrollador necesita ejecutar un comando para iniciar un repositorio. Ordena correctamente las palabras para formar la instrucción adecuada.",
                                scrambled,
                                correctOrder);

                ExerciseEntity exercise3 = new ExerciseEntity(
                                "Iniciar un nuevo repositorio",
                                "Un desarrollador necesita ejecutar este comando en inglés. Escribe la forma correcta de la instrucción.",
                                "Initialize a new repository",
                                "translate");

                ExerciseEntity exercise4 = new ExerciseEntity(
                                "Git ____ to initialize a new repository",
                                "Para iniciar un nuevo repositorio en Git, completa el comando correcto.",
                                "init",
                                "fill");

                ExerciseEntity exercise5 = new ExerciseEntity(
                                "Relaciona el comando con su significado",
                                "Un estudiante está aprendiendo comandos de Git. Relaciona cada comando con la acción que realiza.",
                                List.of(
                                                new MatchPair("Git clone", "Clonar"),
                                                new MatchPair("Git status", "Estado"),
                                                new MatchPair("Git add", "Añadir"),
                                                new MatchPair("Git init", "Iniciar"),
                                                new MatchPair("Git commit", "Comentar")),
                                "match");

                LessonEntity lesson1 = new LessonEntity(
                                "1-1",
                                "1", // moduleId
                                "Comandos GitHub",
                                20,
                                List.of(exercise1, exercise2, exercise3, exercise4, exercise5));

                List<OptionEntity> options1Lesson2 = List.of(
                                new OptionEntity("Connect", false, "conectar"),
                                new OptionEntity("Create", true, "crear"),
                                new OptionEntity("Update", false, "actualizar"),
                                new OptionEntity("Delete", false, "eliminar"));

                ExerciseEntity exercise1Lesson2 = new ExerciseEntity("Create",
                                "Un desarrollador está aprendiendo vocabulario en inglés sobre bases de datos. ¿Qué significa la palabra 'create'?",
                                options1Lesson2);

                List<String> correctOrderLesson2 = List.of("Crear", "una", "nueva", "base", "de", "datos");
                List<OptionEntity> scrambledLesson2 = List.of(
                                new OptionEntity("una", false, "a"),
                                new OptionEntity("Crear", false, "create"),
                                new OptionEntity("nueva", false, "new"),
                                new OptionEntity("datos", false, "date"),
                                new OptionEntity("base", false, "base"),
                                new OptionEntity("de", false, ""));

                ExerciseEntity exercise2Lesson2 = new ExerciseEntity(
                                "Create a new database",
                                "Un desarrollador debe escribir correctamente la traduccion para crear una base de datos. Ordena las palabras para formar la instrucción adecuada en inglés.",
                                scrambledLesson2,
                                correctOrderLesson2);

                ExerciseEntity exercise3Lesson2 = new ExerciseEntity(
                                "Crear una nueva base de datos",
                                "Traduce la siguiente frase al inglés:",
                                "Create a new database",
                                "translate");

                ExerciseEntity exercise4Lesson2 = new ExerciseEntity(
                                "____ to create a new database",
                                "Completa la oración correctamente:",
                                "CREATE",
                                "fill");

                ExerciseEntity exercise5Lesson2 = new ExerciseEntity(
                                "Relaciona el comando con su significado",
                                "Un desarrollador está aprendiendo vocabulario básicos de MySQL. Relaciona cada palabra en inglés con su significado en español.",
                                List.of(
                                                new MatchPair("create", "Crear"),
                                                new MatchPair("drop", "Eliminar"),
                                                new MatchPair("alter ", "Modificar"),
                                                new MatchPair("Insert", "Insertar"),
                                                new MatchPair("select", "Consultar")),
                                "match");

                LessonEntity lesson2 = new LessonEntity(
                                "2-1",
                                "2",
                                "Comandos MySQL",
                                0,
                                List.of(exercise1Lesson2, exercise2Lesson2, exercise3Lesson2, exercise4Lesson2,
                                                exercise5Lesson2));

                List<String> correctOrderLesson3 = List.of(
                                "Clone",
                                "a",
                                "repository");

                List<OptionEntity> scrambledLesson3 = List.of(
                                new OptionEntity("repository", false, "repositorio"),
                                new OptionEntity("Clone", false, "clonar"),
                                new OptionEntity("a", false, "un"));

                ExerciseEntity exercise1Lesson3 = new ExerciseEntity(
                                "Construcción de oración",
                                "Un desarrollador está aprendiendo vocabulario en inglés relacionado con tecnología. Ordena las palabras correctamente para formar una instrucción adecuada.",
                                scrambledLesson3,
                                correctOrderLesson3);

                ExerciseEntity exercise2Lesson3 = new ExerciseEntity(
                                "____ to copy a repository",
                                "Un desarrollador desea expresar en inglés la acción de copiar un repositorio. Completa la oración correctamente:",
                                "clone",
                                "fill");

                ExerciseEntity exercise3Lesson3 = new ExerciseEntity(
                                "Clonar un repositorio",
                                "Un desarrollador necesita escribir en inglés una instrucción relacionada con copiar un proyecto. Traduce la siguiente frase:",
                                "Clone a repository",
                                "translate");

                List<OptionEntity> options4Lesson3 = List.of(
                                new OptionEntity("Clonar", true, ""),
                                new OptionEntity("Eliminar", false, ""),
                                new OptionEntity("Actualizar", false, ""),
                                new OptionEntity("Crear", false, ""));

                ExerciseEntity exercise4Lesson3 = new ExerciseEntity(
                                "Clone",
                                "Un desarrollador está aprendiendo vocabulario en inglés. ¿Qué significa la palabra 'clone'?",
                                options4Lesson3);

                ExerciseEntity exercise5Lesson3 = new ExerciseEntity(
                                "Relaciona de vocabulario",
                                "Relaciona cada palabra en inglés con su significado en español.",
                                List.of(
                                                new MatchPair("clone", "clonar"),
                                                new MatchPair("status", "estado"),
                                                new MatchPair("add", "guardar cambios"),
                                                new MatchPair("commit", "Guardar cambios"),
                                                new MatchPair("log", "historial")),
                                "match");

                LessonEntity lesson3 = new LessonEntity(
                                "1-2",
                                "1",
                                "Comandos GitHub",
                                0,
                                List.of(exercise1Lesson3, exercise2Lesson3, exercise3Lesson3, exercise4Lesson3,
                                                exercise5Lesson3));

                List<OptionEntity> lesson4Gitmul1 = List.of(
                                new OptionEntity("Eliminar", false, ""),
                                new OptionEntity("Actualizar", false, ""),
                                new OptionEntity("Guardar", false, ""),
                                new OptionEntity("Clonar", true, ""));

                ExerciseEntity exercise1Gitmulti1 = new ExerciseEntity("Clone",
                                "Un desarrollador está aprendiendo palabras en inglés usadas en programación. Si desea expresar la acción de clonar un proyecto, ¿qué significa la palabra 'clone'?",
                                lesson4Gitmul1);

                List<OptionEntity> lesson4Gitmul2 = List.of(
                                new OptionEntity("Git add", false, ""),
                                new OptionEntity("Git clone", true, ""),
                                new OptionEntity("Git commit", false, ""),
                                new OptionEntity("Git init", false, ""));

                ExerciseEntity exercise1Gitmulti2 = new ExerciseEntity("Uso de la palabra",
                                "Un desarrollador necesita expresar en inglés la acción de clonar un proyecto. ¿Qué palabra debería utilizar?",
                                lesson4Gitmul2);

                List<OptionEntity> lesson4Gitmul3 = List.of(
                                new OptionEntity("Eliminar repositorio", false, ""),
                                new OptionEntity("Guardar cambios", false, ""),
                                new OptionEntity("Copiar un repositorio", true, ""),
                                new OptionEntity("Actualizar infotmsción", false, ""));

                ExerciseEntity exercise1Gitmulti3 = new ExerciseEntity("Clone",
                                "En el contexto de la programación, ¿cuál de las siguientes opciones describe mejor el significado de 'clone'?",
                                lesson4Gitmul3);

                List<String> correctOrder1Lesson4 = List.of(
                                "Clone",
                                "the",
                                "repository");

                List<OptionEntity> lesson4GitOrder1 = List.of(
                                new OptionEntity("repository", false, "repositorio"),
                                new OptionEntity("Clone", false, "Clonar"),
                                new OptionEntity("the", false, "el"));

                ExerciseEntity exercise2GitOrder1 = new ExerciseEntity(
                                "Clonar el respositorio",
                                "Un desarrollador desea expresar en inglés la acción de clonar un repositorio. Ordena correctamente las palabras para formar una oración adecuada.",
                                lesson4GitOrder1,
                                correctOrder1Lesson4);

                List<String> correctOrder2Lesson4 = List.of(
                                "Clone",
                                "a",
                                "project",
                                "from",
                                "GitHub");

                List<OptionEntity> lesson4GitOrder2 = List.of(
                                new OptionEntity("GitHub", false, "GitHub"),
                                new OptionEntity("Clone", false, "Clonar"),
                                new OptionEntity("from", false, "de"),
                                new OptionEntity("project", false, "proyecto"),
                                new OptionEntity("a", false, "un"));

                ExerciseEntity exercise2GitOrder2 = new ExerciseEntity(
                                "Clonar un proyecto de Github",
                                "Un desarrollador necesita escribir en inglés una instrucción relacionada con clonar un proyecto desde una plataforma. Ordena las palabras correctamente.",
                                lesson4GitOrder2,
                                correctOrder2Lesson4);

                List<String> correctOrder3Lesson4 = List.of(
                                "Clone",
                                "the",
                                "repository",
                                "to",
                                "your",
                                "computer");

                List<OptionEntity> lesson4GitOrder3 = List.of(
                                new OptionEntity("your", false, "tú"),
                                new OptionEntity("repository", false, "repositorio"),
                                new OptionEntity("Clone", false, "Clonar"),
                                new OptionEntity("computer", false, "computador"),
                                new OptionEntity("to", false, "en"),
                                new OptionEntity("the", false, "el"));

                ExerciseEntity exercise2GitOrder3 = new ExerciseEntity(
                                "Clonar el repositorio en tú computador",
                                "Un desarrollador está escribiendo una instrucción en inglés para clonar un repositorio a su computador. Ordena las palabras para formar una oración correcta.",
                                lesson4GitOrder3,
                                correctOrder3Lesson4);

                ExerciseEntity exercise3Lesson4Tras1 = new ExerciseEntity(
                                "Clonar un repositorio",
                                "Un desarrollador está aprendiendo vocabulario en inglés relacionado con tecnología. Traduce la siguiente frase al inglés:",
                                "Clone a repository",
                                "translate");

                ExerciseEntity exercise3Lesson4Tras2 = new ExerciseEntity(
                                "Clonar el repositorio desde GitHub",
                                "Un desarrollador necesita escribir en inglés una instrucción para clonar un proyecto. Traduce la siguiente frase:",
                                "Clone the repository from GitHub",
                                "translate");

                ExerciseEntity exercise3Lesson4Tras3 = new ExerciseEntity(
                                "Clonar el repositorio en tu computadora",
                                "Un desarrollador está documentando un proceso en inglés. Traduce correctamente la siguiente instrucción:",
                                "Clone the repository to your computer",
                                "translate");

                ExerciseEntity exercise4Lesson4Fill3 = new ExerciseEntity(
                                "____ the repository to your computer",
                                "Un desarrollador está documentando un proceso en inglés. Completa la instrucción correctamente:",
                                "Clone",
                                "fill");

                ExerciseEntity exercise5Lesson4Mat1 = new ExerciseEntity(
                                "Relación de vocabulario",
                                "Un desarrollador está aprendiendo palabras en inglés. Relaciona cada palabra con su significado en español.",
                                List.of(
                                                new MatchPair("clone", "clonar"),
                                                new MatchPair("repository", "repositorio"),
                                                new MatchPair("project", "proyecto"),
                                                new MatchPair("computer", "computador")),
                                "match");

                LessonEntity lesson4 = new LessonEntity(
                                "1-3",
                                "1",
                                "Comandos GitHub",
                                0,
                                List.of(exercise2GitOrder1, exercise1Gitmulti1, exercise2GitOrder2, exercise1Gitmulti2,
                                                exercise1Gitmulti3, exercise2GitOrder3, exercise3Lesson4Tras1,
                                                exercise3Lesson4Tras2, exercise3Lesson4Tras3,
                                                exercise4Lesson4Fill3, exercise5Lesson4Mat1));

                List<String> correctOrderLesson2my = List.of(
                                "Insert",
                                "data",
                                "into",
                                "a",
                                "table");

                List<OptionEntity> scrambledLesson2my = List.of(
                                new OptionEntity("table", false, "tabla"),
                                new OptionEntity("Insert", false, "insertar"),
                                new OptionEntity("into", false, "en"),
                                new OptionEntity("data", false, "datos"),
                                new OptionEntity("a", false, "una"));

                ExerciseEntity exercise2Lesson2my = new ExerciseEntity(
                                "Construcción de oración",
                                "Un desarrollador quiere expresar una acción en inglés. ¿Cuál es el orden correcto?",
                                scrambledLesson2my,
                                correctOrderLesson2my);

                List<OptionEntity> options1Lesson2my = List.of(
                                new OptionEntity("Insert", true, "insertar"),
                                new OptionEntity("Delete", false, "eliminar"),
                                new OptionEntity("Select", false, "consultar"),
                                new OptionEntity("Update", false, "actualizar"));

                ExerciseEntity exercise1Lesson2my = new ExerciseEntity(
                                "Insert",
                                "Un desarrollador está aprendiendo vocabulario en inglés. ¿Qué significa la palabra 'insert'?",
                                options1Lesson2my);

                ExerciseEntity exercise3Lesson2my = new ExerciseEntity(
                                "Actualizar datos en una tabla",
                                "Traduce la siguiente frase al inglés:",
                                "Update data in a table",
                                "translate");

                ExerciseEntity exercise4Lesson2my = new ExerciseEntity(
                                "____ data from a table",
                                "Completa la oración correctamente:",
                                "Select",
                                "fill");

                ExerciseEntity exercise4Lesson2mys = new ExerciseEntity(
                                "Relación de vocabulario",
                                "Relaciona cada palabra en inglés con su significado en español.",
                                List.of(
                                                new MatchPair("insert", "insertar"),
                                                new MatchPair("select", "consultar"),
                                                new MatchPair("update", "actualizar"),
                                                new MatchPair("delete", "eliminar"),
                                                new MatchPair("table", "tabla")),
                                "match");

                LessonEntity lesson5 = new LessonEntity(
                                "2-2",
                                "2",
                                "Comandos GitHub",
                                0,
                                List.of(exercise2Lesson2my, exercise1Lesson2my, exercise3Lesson2my, exercise4Lesson2my,
                                                exercise4Lesson2mys));

                // ORDEN
                List<String> correctOrder1 = List.of(
                                "Create",
                                "a",
                                "database");

                List<OptionEntity> scrambled1 = List.of(
                                new OptionEntity("database", false, "base de datos"),
                                new OptionEntity("a", false, "una"),
                                new OptionEntity("Create", false, "crear"));

                ExerciseEntity ex1 = new ExerciseEntity(
                                "Crear una base de datos",
                                "Un desarrollador está aprendiendo inglés técnico. ¿Cuál es el orden correcto de la siguiente frase?",
                                scrambled1,
                                correctOrder1);

                // OPCIÓN (SIGNIFICADO)
                List<OptionEntity> options2 = List.of(
                                new OptionEntity("crear", true, ""),
                                new OptionEntity("eliminar", false, ""),
                                new OptionEntity("consultar", false, ""),
                                new OptionEntity("actualizar", false, ""));

                ExerciseEntity ex2 = new ExerciseEntity(
                                "Create",
                                "Un desarrollador encuentra la palabra 'create' en un sistema. ¿Qué significa en español?",
                                options2);

                // TRADUCCIÓN
                ExerciseEntity ex3 = new ExerciseEntity(
                                "Insert data",
                                "Traduce la siguiente frase al español:",
                                "Insertar datos",
                                "translate");

                // FILL
                ExerciseEntity ex4 = new ExerciseEntity(
                                "____ data",
                                "Completa la frase en inglés para decir 'insertar datos':",
                                "Insert",
                                "fill");

                // MATCH
                ExerciseEntity ex5 = new ExerciseEntity(
                                "Relación de vocabulario",
                                "Relaciona cada palabra en inglés con su significado en español.",
                                List.of(
                                                new MatchPair("create", "crear"),
                                                new MatchPair("insert", "insertar"),
                                                new MatchPair("select", "consultar"),
                                                new MatchPair("update", "actualizar"),
                                                new MatchPair("delete", "eliminar")),
                                "match");

                // OPCIÓN
                List<OptionEntity> options6 = List.of(
                                new OptionEntity("consultar", true, ""),
                                new OptionEntity("insertar", false, ""),
                                new OptionEntity("eliminar", false, ""),
                                new OptionEntity("crear", false, ""));

                ExerciseEntity ex6 = new ExerciseEntity(
                                "Select",
                                "Un estudiante ve la palabra 'select'. ¿Qué significa en español?",
                                options6);

                // ORDEN
                List<String> correctOrder7 = List.of(
                                "Delete",
                                "data");

                List<OptionEntity> scrambled7 = List.of(
                                new OptionEntity("data", false, "datos"),
                                new OptionEntity("Delete", false, "eliminar"));

                ExerciseEntity ex7 = new ExerciseEntity(
                                "eliminar datos",
                                "Ordena la frase en inglés para decir:",
                                scrambled7,
                                correctOrder7);

                // TRADUCCIÓN
                ExerciseEntity ex8 = new ExerciseEntity(
                                "Update data",
                                "Traduce la siguiente frase al español:",
                                "Actualizar datos",
                                "translate");

                // FILL
                ExerciseEntity ex9 = new ExerciseEntity(
                                "____ data",
                                "Completa la frase en inglés para decir 'consultar datos':",
                                "Select",
                                "fill");

                // OPCIÓN
                List<OptionEntity> options10 = List.of(
                                new OptionEntity("eliminar", true, ""),
                                new OptionEntity("crear", false, ""),
                                new OptionEntity("consultar", false, ""),
                                new OptionEntity("insertar", false, ""));

                ExerciseEntity ex10 = new ExerciseEntity(
                                "Delete",
                                "Un estudiante quiere entender la palabra 'delete'. ¿Qué significa?",
                                options10);

                // MATCH (OBJETOS)
                ExerciseEntity ex11 = new ExerciseEntity(
                                "Relación de vocabulario",
                                "Relaciona las palabras con su significado.",
                                List.of(
                                                new MatchPair("database", "base de datos"),
                                                new MatchPair("table", "tabla"),
                                                new MatchPair("data", "datos")),
                                "match");

                // OPCIÓN FINAL
                List<OptionEntity> options12 = List.of(
                                new OptionEntity("actualizar", true, ""),
                                new OptionEntity("consultar", false, ""),
                                new OptionEntity("insertar", false, ""),
                                new OptionEntity("crear", false, ""));

                ExerciseEntity ex12 = new ExerciseEntity(
                                "Update",
                                "Un desaarrollador ve la palabra 'update'. ¿Qué significa en español?",
                                options12);

                // LECCIÓN
                LessonEntity lesson6 = new LessonEntity(
                                "2-3",
                                "2",
                                "Vocabulario en inglés (MySQL)",
                                0,
                                List.of(ex1, ex2, ex3, ex4, ex5, ex6,
                                        ex7, ex8, ex9, ex10, ex11, ex12));
                lessons.add(lesson1);
                lessons.add(lesson2);
                lessons.add(lesson3);
                lessons.add(lesson4);
                lessons.add(lesson5);
                lessons.add(lesson6);
        }

        public List<LessonEntity> getAllLessons() {
                return lessons;
        }

        public List<LessonEntity> getLessonsByModule(String moduleId) {
                return lessons.stream()
                                .filter(l -> l.getModuleId().equals(moduleId))
                                .toList();
        }

        public LessonEntity getLessonById(String lessonId, User user) {

                boolean isGuest = (user == null);

                if (isGuest && !lessonId.equals("1")) {
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Debes registrarte");
                }

                return findLessonById(lessonId);
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

        public LessonEntity findLessonById(String lessonId) {
                return lessons.stream()
                                .filter(l -> l.getId().equals(lessonId))
                                .findFirst()
                                .orElse(null);
        }
}
