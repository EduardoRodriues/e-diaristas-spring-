package br.com.treinaweb.e_diarista.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.treinaweb.e_diarista.core.enums.TipoUsuario;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${br.com.treinaweb.e_diarista.rememberMe.key}")
    private String rememberKey;

    @Value("${br.com.treinaweb.e_diarista.rememberMe.validitySeconds}")
    private int rememberValiditySecs;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/admin/**").hasAuthority(TipoUsuario.ADMIN.toString())
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/admin/login")
                .usernameParameter("email")
                .passwordParameter("senha")
                .defaultSuccessUrl("/admin/servicos")
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout", "GET"))
                .logoutSuccessUrl("/admin/login")
                .permitAll()
                .and()
            .rememberMe()
                .rememberMeParameter("lembrar-me")
                .tokenValiditySeconds(rememberValiditySecs)
                .key(rememberKey);

        return http.build();
    }

    @Bean
    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder);
        return authenticationManagerBuilder.build();
    }

    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
            .requestMatchers("/webjars/**")
            .requestMatchers("/img/**");
    }
}
