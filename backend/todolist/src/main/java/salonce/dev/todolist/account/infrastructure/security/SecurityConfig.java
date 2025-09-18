package salonce.dev.todolist.account.infrastructure.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
public class SecurityConfig {

    private final CustomOidcSuccessHandler customOidcSuccessHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
                .csrf(csrf -> csrf.disable())
                .oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("http://localhost:8080/home").successHandler(customOidcSuccessHandler))
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
                .build();
    }
}
