package org.ptvinh203.bcserver.service;

import lombok.RequiredArgsConstructor;
import org.ptvinh203.bcserver.entity.User;
import org.ptvinh203.bcserver.repository.UserRepository;
import org.ptvinh203.bcserver.util.model.ApiDataResponse;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public ApiDataResponse getUserByType(String id) throws Exception {
        if (id != null && !id.isBlank()) {
            var user = userRepository.findById(UUID.fromString(id))
                    .orElseThrow(() -> new Exception("User not found"));
            user.setPassword(null);
            return ApiDataResponse.successWithDataOnly(user);
        }
        return ApiDataResponse.successWithDataOnly(userRepository.findAll().stream().peek(user -> user.setPassword(null)).toList());
    }

    public ApiDataResponse createNewUser(User user) throws Exception {
        if (user == null) {
            throw new Exception("User is null");
        }

        // Check email is existed
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new Exception("Your email is already existed, please try another email");
        }

        user.setPassword(passwordEncoder.encode("123456"));
        user = userRepository.save(user);
        user.setPassword(null);
        return ApiDataResponse.successWithDataOnly(user);
    }

    public ApiDataResponse editUser(String id, User user) throws Exception {
        if (id == null || user == null) {
            throw new Exception("User id or user is null");
        }
        var existedUser = userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new Exception("User not found"));

        // Update user information
        if (user.getFirstName() != null) {
            existedUser.setFirstName(user.getFirstName());
        }
        if (user.getLastName() != null) {
            existedUser.setLastName(user.getLastName());
        }
        if (user.getPhoneNumber() != null) {
            existedUser.setPhoneNumber(user.getPhoneNumber());
        }
        if (user.getAddress() != null) {
            existedUser.setAddress(user.getAddress());
        }
        existedUser.setGender(user.isGender());
        if (user.getImage() != null) {
            existedUser.setImage(user.getImage());
        }

        user = userRepository.save(user);
        user.setPassword(null);
        return ApiDataResponse.successWithDataOnly(user);
    }

    public ApiDataResponse deleteUser(String id) throws Exception {
        if (id == null || id.isBlank()) {
            throw new Exception("User id is null");
        }

        var existedUser = userRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new Exception("User not found"));

        userRepository.delete(existedUser);
        return ApiDataResponse.successWithDataOnly("ok");
    }
}
