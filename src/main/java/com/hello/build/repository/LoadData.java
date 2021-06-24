package com.hello.build.repository;

import com.hello.build.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class LoadData {

    @Bean
    CommandLineRunner initial(UserRepository userRepository) {
        return args -> {
            log.info(
                    "Preparando insert User" + userRepository.save(
                            User.builder().name("Daniel").apellido("Achury").build()
                    )
            );

            log.info(
                    "Preparando insert User" + userRepository.save(
                            User.builder().name("Susana").apellido("Mejía").build()
                    )
            );

            log.info(
                    "Preparando insert User" + userRepository.save(
                            User.builder().name("Hello").apellido("Build").build()
                    )
            );

        };
    }
}
