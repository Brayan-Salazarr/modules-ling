package com.modulos.LingCode.controller;

import org.springframework.web.bind.annotation.RestController;

import com.modulos.LingCode.model.ModuleEntity;
import com.modulos.LingCode.service.ModuleService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api/modules")
@CrossOrigin(origins = "http://localhost:4200")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping
    public List<ModuleEntity> getModules() {
        return moduleService.getAllModules();
    }

    
}
