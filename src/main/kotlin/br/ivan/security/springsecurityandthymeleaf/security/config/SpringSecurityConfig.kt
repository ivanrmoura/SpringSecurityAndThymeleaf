package br.ivan.security.springsecurityandthymeleaf.security.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.util.matcher.AntPathRequestMatcher

@Configuration
class SpringSecurityConfig {
    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()


    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {

        http.csrf { it.disable() }
            .authorizeHttpRequests { authorization ->
                authorization
                    .requestMatchers("/home").authenticated()
                    .requestMatchers("/api/v1/user/delete").hasRole("ADMINISTRATOR")
                    .anyRequest().permitAll()

            }
            .formLogin { form ->
                form.loginPage("/login")
                    .loginProcessingUrl("/login")
                    .defaultSuccessUrl("/home")
                    .permitAll()
            }

            .logout { logout ->
                logout.logoutRequestMatcher(AntPathRequestMatcher("/logout"))
                    .permitAll()
            }

        return http.build()

    }


    @Bean
    fun authenticationManager(configuration: AuthenticationConfiguration) : AuthenticationManager {
        return configuration.authenticationManager

    }

}