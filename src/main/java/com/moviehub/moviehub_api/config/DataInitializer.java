package com.moviehub.moviehub_api.config;

import com.moviehub.moviehub_api.domain.entity.User;
import com.moviehub.moviehub_api.domain.enums.Role;
import com.moviehub.moviehub_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (userRepository.count() == 0) {
            User admin = User.builder()
                    .nome("Administrador")
                    .email("admin@moviehub.com")
                    .senha(passwordEncoder.encode("admin123"))
                    .role(Role.ADMIN)
                    .build();

            userRepository.save(admin);
        }
    }
}
