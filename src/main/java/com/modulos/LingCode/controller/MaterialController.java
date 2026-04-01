package com.modulos.LingCode.controller;

import java.util.Map;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.modulos.LingCode.service.SupaBaseService;

@RestController
@RequestMapping("/api/material")
@CrossOrigin(origins = "http://localhost:4200")
public class MaterialController {

    private final SupaBaseService supaBaseService;

    public MaterialController(SupaBaseService supaBaseService) {
        this.supaBaseService = supaBaseService;
    }

    @GetMapping("/link/{*path}")
    public ResponseEntity<?> getDownloadLink(@PathVariable String path) {

        String signedUrl = supaBaseService.getSignedUrl(path);

        return ResponseEntity.ok(Map.of("downloadUrl", signedUrl));
    }
}