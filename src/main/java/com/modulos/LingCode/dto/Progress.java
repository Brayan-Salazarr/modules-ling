package com.modulos.LingCode.dto;

import java.time.LocalDateTime;

public class Progress {

    private String moduleId;
    private String moduleName;
    private int progress;
    private LocalDateTime updatedAt;

    public String getModuleId(){
        return moduleId;
    }

    public String getModuleName(){
        return moduleName;
    }

    public int getProgress(){
        return progress;
    }

    public LocalDateTime getUpdatedAt(){
        return updatedAt;
    }

    public void setModuleId( String moduleId){
        this.moduleId = moduleId;
    }

    public void setModuleName( String moduleName){
        this.moduleName = moduleName;
    }

    public void setProgress( int progress){
        this.progress = progress;
    }

    public void setUpdatedAt(LocalDateTime updatedAt){
        this.updatedAt = updatedAt;
    }
}
