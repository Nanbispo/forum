package com.alura.forum.config

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
)  {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain? {
        http
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/topicos").permitAll()
            .anyRequest().authenticated()
            .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().formLogin().disable()
            .httpBasic()
        return http.build()
    }



    @Bean
    fun bCryptPasswordEncoder(): PasswordEncoder? {
        return BCryptPasswordEncoder()
    }

//    fun configure(auth : AuthenticationManagerBuilder?){
//        auth?.userDetailsService(userDetailsService)?.passwordEncoder(bCryptPasswordEncoder())
//    }

    @Bean
    fun configure(auth: AuthenticationManagerBuilder?): DaoAuthenticationProvider {
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(userDetailsService)
        authProvider.setPasswordEncoder(bCryptPasswordEncoder())
        return authProvider
    }
}