package org.ptvinh203.bcserver.controller;

import lombok.RequiredArgsConstructor;
import org.ptvinh203.bcserver.service.AuthService;
import org.ptvinh203.bcserver.util.model.ApiDataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<ApiDataResponse> login(@RequestBody Map<String, Object> body) {
        String email = null;
        String password = null;
        try {
            email = (String) body.get("email");
            password = (String) body.get("password");
            if (email == null || email.isBlank() || password == null || password.isBlank()) {
                throw new Exception("Email or password is missing");
            }
            return ResponseEntity.ok(service.login(email, password));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiDataResponse.error(e.getMessage()));
        }
    }
}
