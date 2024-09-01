package sia.tacocloud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.*;
import sia.tacocloud.domain.repository.UserRepository;
import sia.tacocloud.domain.security.User;

import java.util.Set;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User ‘" + username + "’ not found");
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        Set<String> csrfAllowedMethods = Set.of("GET", "HEAD", "TRACE", "OPTIONS");
        CsrfTokenRepository csrfTokenRepository = new HttpSessionCsrfTokenRepository();
        return http.csrf(csrf -> csrf
//                        .requireCsrfProtectionMatcher(request ->
//                                !csrfAllowedMethods.contains(request.getMethod()))
                        .csrfTokenRepository(csrfTokenRepository)
//                        .csrfTokenRequestHandler(new XorCsrfTokenRequestAttributeHandler())
                        .sessionAuthenticationStrategy(
                                new CsrfAuthenticationStrategy(csrfTokenRepository)
                        ))
                .authorizeRequests()
                .requestMatchers("/design/**", "/orders/**").access("hasRole('USER')")
                .requestMatchers("/admin/**").access("hasRole('ADMIN')")
                .anyRequest().access("permitAll()")
                .and()
                .formLogin(formLogin -> {
                    formLogin
                            .loginPage("/login")
                            .defaultSuccessUrl("/design", true)
                            .permitAll();
                })
                .securityContext(securitycontext -> securitycontext
                        .requireExplicitSave(true))
                .build();

    }
}
