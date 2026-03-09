package com.example.gestion_tienda.config;


import com.example.gestion_tienda.auth.LoginRequest;
import com.example.gestion_tienda.exception.BusinessRuleException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;


    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {

        if (request.username().equals("admin") &&
                request.password().equals("1234")) {

            String token = jwtService.generateToken(request.username());
            return Map.of("token", token);
        }

        throw new BusinessRuleException("Credenciales inválidas");
    }
}
