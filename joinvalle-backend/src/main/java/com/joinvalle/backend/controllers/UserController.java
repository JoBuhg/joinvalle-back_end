package com.joinvalle.backend.controllers;

import com.joinvalle.backend.dtos.ChangePasswordRequestDTO;
import com.joinvalle.backend.dtos.UpdateUserRequestDTO;
import com.joinvalle.backend.dtos.UserResponseDTO;
import com.joinvalle.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService userService;

    @GetMapping("/profile")
    public ResponseEntity<UserResponseDTO> getCurrentUser() {
        return ResponseEntity.ok(userService.getCurrentUser());
    }

    @PutMapping("/profile")
    public ResponseEntity<UserResponseDTO> updateUser(@RequestBody UpdateUserRequestDTO request) {
        return ResponseEntity.ok(userService.updateUser(request));
    }

    @PutMapping("/password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequestDTO request) {
        userService.changePassword(request);
        return ResponseEntity.ok("Senha alterada com sucesso");
    }
} 