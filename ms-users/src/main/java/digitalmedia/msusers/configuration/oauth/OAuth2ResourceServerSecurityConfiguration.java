package digitalmedia.msusers.configuration.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAuth2ResourceServerSecurityConfiguration {

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .oauth2ResourceServer()
                .jwt()
                .jwtAuthenticationConverter((Converter<Jwt, ? extends AbstractAuthenticationToken>) new KeycloakJwtAuthenticationConverter());
        http.authorizeHttpRequests().anyRequest().permitAll();
        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withJwkSetUri("http://localhost:8082/realms/DigitalMedia/protocol/openid-connect/certs").build();
    }
}
