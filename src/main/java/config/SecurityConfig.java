package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author josue
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) 
            .httpBasic(basic -> basic.disable()) // Apaga la ventanita
            .formLogin(form -> form.disable())   // Apaga el formulario de Spring
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // 🟢 LA CLAVE: Agregamos "/error" para evitar la trampa del fantasma
                .requestMatchers("/api/users/**", "/api/users", "/error").permitAll() 
                .requestMatchers("/ws-invernadero/**").permitAll()
                .anyRequest().permitAll() 
            );
            
        return http.build();
    }
}
