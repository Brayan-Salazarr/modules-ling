package com.modulos.LingCode.model;

import java.util.List;

public class ModuleEntity {

    private String id;
    private String title;
    private String title_es;
    private String description;
    private String description_es;
    private String short_description;
    private String thumbnail_url;
    private String icon_name;
    private String category;
    private String difficulty_level;
    private Integer estimated_hours;
    private int total_lessons;
    private int total_xp;
    private int display_order;
    private boolean is_premium;
    private boolean is_published;
    private boolean is_featured;
    private List<String> tags;
    private List<String> prerequisiteModuleIds;

    public ModuleEntity(String id,
            String title,
            String title_es,
            String description,
            String description_es,
            String short_description,
            String thumbnail_url,
            String icon_name,
            String category,
            String difficulty_level,
            Integer estimated_hours,
            int total_lessons,
            int total_xp,
            int display_order,
            boolean is_premium,
            boolean is_published,
            boolean is_featured,
            List<String> tags,
            List<String> prerequisiteModuleIds) {
        this.id = id;
        this.title = title;
        this.title_es = title_es;
        this.description = description;
        this.description_es = description_es;
        this.short_description = short_description;
        this.thumbnail_url = thumbnail_url;
        this.icon_name = icon_name;
        this.category = category;
        this.difficulty_level = difficulty_level;
        this.estimated_hours = estimated_hours;
        this.total_lessons = total_lessons;
        this.total_xp = total_xp;
        this.display_order = display_order;
        this.is_premium = is_premium;
        this.is_published = is_published;
        this.is_featured = is_featured;
        this.tags = tags;
        this.prerequisiteModuleIds = prerequisiteModuleIds;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getTitle_es() { return title_es; }
    public String getDescription() { return description; }
    public String getDescription_es() { return description_es; }
    public String getShort_description() { return short_description; }
    public String getThumbnail_url() { return thumbnail_url; }
    public String getIcon_name() { return icon_name; }
    public String getCategory() { return category; }
    public String getDifficulty_level() { return difficulty_level; }
    public Integer getEstimated_hours() { return estimated_hours; }
    public int getTotal_lessons() { return total_lessons; }
    public int getTotal_xp() { return total_xp; }
    public int getDisplay_order() { return display_order; }
    public boolean isIs_premium() { return is_premium; }
    public boolean isIs_published() { return is_published; }
    public boolean isIs_featured() { return is_featured; }
    public List<String> getTags() { return tags; }
    public List<String> getPrerequisiteModuleIds() { return prerequisiteModuleIds; }
}
