//package com.fedex.jr.gateway;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
////@Configuration
////@EnableWebFluxSecurity
//public class SecurityConfig {
////    @Bean
//    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
//        return http
//            .authorizeExchange(exchanges -> exchanges.pathMatchers("/swagger-ui/**",
//                        "/v3/api-docs/**",
//                        "/api/customers/createUser", "/api/customers/authenticate"
//                    ).permitAll()
//                    .anyExchange().authenticated()
//            )
//            .oauth2Login(withDefaults())
//            .csrf(ServerHttpSecurity.CsrfSpec::disable)
//            .oauth2ResourceServer(oauth2 -> oauth2
//                .jwt(withDefaults())
//            )
//            .cors(e -> e.configurationSource(corsSource())).build();
//    }
//
//
////    @Bean
//    public UrlBasedCorsConfigurationSource corsSource() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedOrigin("*");
//        corsConfig.addAllowedMethod("*");
//        corsConfig.addAllowedHeader("*");
//        corsConfig.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);
//
//        return source;
//    }
//
//}
