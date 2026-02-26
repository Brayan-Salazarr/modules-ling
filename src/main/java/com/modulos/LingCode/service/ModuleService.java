package com.modulos.LingCode.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.modulos.LingCode.model.ModuleEntity;

@Service
public class ModuleService {

    private List<ModuleEntity> modules = new ArrayList<>();

    public ModuleService() {
        modules.add(new ModuleEntity(1L, "GitHub", false));
        modules.add(new ModuleEntity(2L, "MySQL", false));
        modules.add(new ModuleEntity(3L, "Java", false));
    }

    public List<ModuleEntity> getAllModules() {
        return modules;
    }

    public void completeModule(String id) {
        modules.stream()
                .filter(m -> m.getId().equals(id))
                .findFirst()
                .ifPresent(m -> m.setCompleted(true));
    }
}
