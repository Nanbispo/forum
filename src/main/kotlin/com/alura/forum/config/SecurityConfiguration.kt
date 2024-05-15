package com.alura.forum.config


import org.springframework.cglib.core.Customizer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfiguration(
    private val userDetailsService: UserDetailsService
) {


    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() }
            .authorizeHttpRequests {
                it.requestMatchers("/topicos").permitAll()
                it.anyRequest().authenticated()
            }
            .sessionManagement {
                it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            }

        return http.build()
    }

//    @Bean
//    fun securityfilterChain(http: HttpSecurity): SecurityFilterChain? {
//        http.invoke {
//            csrf { disable() }
//            authorizeRequests {
//                authorize("/topicos", hasAuthority("LEITURA_ESCRITA"))
//                authorize(anyRequest, authenticated)
//            }
//            sessionManagement {
//                sessionCreationPolicy = SessionCreationPolicy.STATELESS
//            }
//            headers { frameOptions { disable() } }
//            httpBasic { }
//        }
//        return http.build()
//    }


    @Bean
    fun bCryptPasswordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }


    @Bean
    fun configure(auth: AuthenticationManagerBuilder?): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService)
        authProvider.setPasswordEncoder(bCryptPasswordEncoder())
        return authProvider
    }
}