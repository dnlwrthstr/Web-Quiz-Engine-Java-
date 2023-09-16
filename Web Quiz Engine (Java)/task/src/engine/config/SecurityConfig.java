package engine.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .httpBasic(Customizer.withDefaults())     // Default Basic auth config
                .csrf(AbstractHttpConfigurer::disable) // for POST requests via Postman
                //.csrf(AbstractHttpConfigurer::disable).headers(cfg -> cfg.frameOptions().disable())
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers("/api/register").permitAll()
                        .antMatchers("/api/**").authenticated()
                        .anyRequest().permitAll()
                );
        return http.build();
    }
}
