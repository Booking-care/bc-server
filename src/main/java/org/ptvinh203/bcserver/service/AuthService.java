package org.ptvinh203.bcserver.service;

import lombok.RequiredArgsConstructor;
import org.ptvinh203.bcserver.repository.UserRepository;
import org.ptvinh203.bcserver.util.model.ApiDataResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiDataResponse login(String email, String password) throws Exception {
        var user = userRepository.findByEmail(email)
                .orElseThrow(() -> new Exception("Your Email is not exist in our system. Plz try other email"));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new Exception("Your password is incorrect. Plz try again");
        }
        var response = Map.of(
                "email", user.getEmail(),
                "roleId", user.getRole().getId()
        );
        return ApiDataResponse.successWithDataOnly(response);
    }
}
