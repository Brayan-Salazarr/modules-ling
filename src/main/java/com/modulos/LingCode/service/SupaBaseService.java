package com.modulos.LingCode.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.Map;

@Service
public class SupaBaseService {

    @Value("${supabase.url}")
    private String supabaseUrl;

    @Value("${supabase.service-key}")
    private String serviceRoleKey;

    @Value("${supabase.bucket}")
    private String bucketName;

    public String getSignedUrl(String filePath) {

        try {

            String endpoint = supabaseUrl + "/storage/v1/object/sign/" + bucketName + "/" + filePath;

            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(serviceRoleKey);

            Map<String, Object> body = Map.of("expiresIn", 300);
            HttpEntity<Map<String, Object>> request = new HttpEntity<>(body, headers);

            ResponseEntity<Map> response = restTemplate.postForEntity(endpoint, request, Map.class);

            Map<String, Object> responseBody = response.getBody();

            if (responseBody == null || !responseBody.containsKey("signedURL")) {
                throw new RuntimeException("No se pudo generar el link");
            }

            return (String) responseBody.get("signedURL");

        } catch (Exception e) {
            throw new RuntimeException("Error al generar link desde Supabase", e);
        }
    }
}