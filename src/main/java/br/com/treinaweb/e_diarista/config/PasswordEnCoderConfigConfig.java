package br.com.treinaweb.e_diarista.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class PasswordEnCoderConfigConfig {
    
    @Bean
    public PasswordEncoder passwordEnCoder() {
        return new BCryptPasswordEncoder();
    }
}
