package com.modulos.LingCode.model;

import java.util.List;

public class LessonEntity {
    
    private String id;
    private String moduleId;
    private String title;
    private int xpReward;
    private boolean isPublished;
    private List<ExerciseEntity> exercises;

    public LessonEntity(String id, String moduleId, String title,
                        int xpReward, List<ExerciseEntity> exercises) {
        this.id = id;
        this.moduleId = moduleId;
        this.title = title;
        this.xpReward = xpReward;
        this.isPublished = true;
        this.exercises = exercises;
    }

    public String getId() { return id; }
    public String getModuleId() { return moduleId; }
    public String getTitle() { return title; }
    public int getXpReward() { return xpReward; }
    public boolean isPublished() { return isPublished; }
    public List<ExerciseEntity> getExercises() { return exercises; }
}
