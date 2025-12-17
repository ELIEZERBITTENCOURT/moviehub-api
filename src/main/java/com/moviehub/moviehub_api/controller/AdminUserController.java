package com.moviehub.moviehub_api.controller;

import com.moviehub.moviehub_api.dto.user.UserCreateDTO;
import com.moviehub.moviehub_api.dto.user.UserResponseDTO;
import com.moviehub.moviehub_api.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/users")
@RequiredArgsConstructor
public class AdminUserController {

    private final UserService userService;

    @PostMapping
    public UserResponseDTO create(@RequestBody @Valid UserCreateDTO dto) {
        return userService.create(dto);
    }
}
