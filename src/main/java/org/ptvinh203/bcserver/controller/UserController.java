package org.ptvinh203.bcserver.controller;

import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.ptvinh203.bcserver.entity.User;
import org.ptvinh203.bcserver.service.UserService;
import org.ptvinh203.bcserver.util.model.ApiDataResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/get-all-users")
    public ResponseEntity<ApiDataResponse> getAllUsers(@Nullable @RequestParam("id") String id) {
        try {
            return ResponseEntity.ok(userService.getUserByType(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiDataResponse.error(e.getMessage()));
        }
    }

    @PostMapping("/create-new-user")
    public ResponseEntity<ApiDataResponse> createNewUser(@RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.createNewUser(user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiDataResponse.error(e.getMessage()));
        }
    }

    @PutMapping("/edit-user")
    public ResponseEntity<ApiDataResponse> editUser(@Nullable @RequestParam("id") String id, @RequestBody User user) {
        try {
            return ResponseEntity.ok(userService.editUser(id, user));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiDataResponse.error(e.getMessage()));
        }
    }

    @DeleteMapping("/edit-user")
    public ResponseEntity<ApiDataResponse> deleteUser(@Nullable @RequestParam("id") String id) {
        try {
            return ResponseEntity.ok(userService.deleteUser(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ApiDataResponse.error(e.getMessage()));
        }
    }
}
