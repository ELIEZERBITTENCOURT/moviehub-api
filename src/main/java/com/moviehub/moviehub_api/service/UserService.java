package com.moviehub.moviehub_api.service;

import com.moviehub.moviehub_api.domain.entity.User;
import com.moviehub.moviehub_api.dto.user.UserCreateDTO;
import com.moviehub.moviehub_api.dto.user.UserResponseDTO;
import com.moviehub.moviehub_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponseDTO create(UserCreateDTO dto) {

        if (userRepository.existsByEmail(dto.email())) {
            throw new RuntimeException("Email já cadastrado");
        }

        User user = User.builder()
                .nome(dto.nome())
                .email(dto.email())
                .senha(passwordEncoder.encode(dto.senha()))
                .role(dto.role())
                .build();

        userRepository.save(user);

        return new UserResponseDTO(
                user.getId(),
                user.getNome(),
                user.getEmail(),
                user.getRole()
        );
    }
}
