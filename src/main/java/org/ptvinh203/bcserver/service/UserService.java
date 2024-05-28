package org.ptvinh203.bcserver.service;

import lombok.RequiredArgsConstructor;
import org.ptvinh203.bcserver.repository.UserRepository;
import org.ptvinh203.bcserver.util.model.ApiDataResponse;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;

    public ApiDataResponse getUserByType(String id) throws Exception {
        if (id != null && !id.isBlank()) {
            return ApiDataResponse.successWithDataOnly(userRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new Exception("User not found"))
            );
        }
        return ApiDataResponse.successWithDataOnly(userRepository.findAll());
    }
}
