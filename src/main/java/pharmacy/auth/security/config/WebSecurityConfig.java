package pharmacy.auth.security.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;
import pharmacy.auth.security.filters.JwtAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception{
        http
            .csrf( crsf -> crsf.disable())
            // .authorizeHttpRequests( (authorize) -> authorize.requestMatchers("/api/auth/test").permitAll() )
            .authorizeHttpRequests((authorize) -> authorize
                // .requestMatchers("/api/auth/login").permitAll()
                .requestMatchers("/api/auth/login").permitAll()

                .anyRequest()
                .authenticated())
            
            .sessionManagement( session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS) )
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            ;        
        return http.build();
    }

    // public static void main(String[] args) {
    //     // Tu código principal va aquí
    //     System.out.println("Pass de Carloss123: " + new BCryptPasswordEncoder().encode("Mafer123"));
    // }

    
    
}
