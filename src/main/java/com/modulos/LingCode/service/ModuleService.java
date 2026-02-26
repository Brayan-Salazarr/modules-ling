package com.modulos.LingCode.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.modulos.LingCode.model.ModuleEntity;

@Service
public class ModuleService {

    private List<ModuleEntity> modules = new ArrayList<>();

    public ModuleService() {
        modules.add(new ModuleEntity("1", "GitHub"));
        modules.add(new ModuleEntity("2", "MySQL"));
        modules.add(new ModuleEntity("3", "Java"));
    }

    public List<ModuleEntity> getAllModules() {
        return modules;
    }
}
