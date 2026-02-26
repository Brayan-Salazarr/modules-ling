package com.modulos.LingCode.model;

public class ModuleEntity {
    
    private String id;
    private String title;
    private boolean is_published;
    private String category;
    private String difficulty_level;
    private int total_lessons;
    private int total_xp;
    private int display_order;

    public ModuleEntity(String id, String title) {
        this.id = id;
        this.title = title;
        this.is_published = true;
        this.category = "programming";
        this.difficulty_level = "beginner";
        this.total_lessons = 10;
        this.total_xp = 100;
        this.display_order = Integer.parseInt(id);
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIs_published() { return is_published; }
    public String getCategory() { return category; }
    public String getDifficulty_level() { return difficulty_level; }
    public int getTotal_lessons() { return total_lessons; }
    public int getTotal_xp() { return total_xp; }
    public int getDisplay_order() { return display_order; }
}
