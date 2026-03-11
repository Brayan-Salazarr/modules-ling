package com.modulos.LingCode.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.modulos.LingCode.model.ModuleEntity;

@Service
public class ModuleService {

    private List<ModuleEntity> modules = new ArrayList<>();

    public ModuleService() {

        modules.add(new ModuleEntity(
                "1",
                "GitHub",
                "GitHub",
                "Learn version control with GitHub",
                "Aprende control de versiones con GitHub",
                "Version control basics",
                "https://res.cloudinary.com/ddvjgyi3f/image/upload/v1763696348/Group_25_fnpomn.png",
                "github-icon",
                "development",
                "beginner",
                10,
                2,
                500,
                1,
                false,
                true,
                true,
                Arrays.asList("git", "github", "version-control"),
                50,
                List.of()
        ));

        modules.add(new ModuleEntity(
                "2",
                "MySQL",
                "MySQL",
                "Master relational databases",
                "Domina bases de datos relacionales",
                "SQL fundamentals",
                "https://res.cloudinary.com/ddvjgyi3f/image/upload/v1763695172/mysql-removebg-preview-removebg-preview_2_hc65ln.png",
                "database-icon",
                "database",
                "intermediate",
                15,
                2,
                800,
                2,
                false,
                true,
                false,
                Arrays.asList("sql", "mysql", "database"),
                0,
                List.of("1")
        ));
    }

    public List<ModuleEntity> getAllModules() {
        return modules;
    }

    
}
