/*
 parte en el min 02:05:00
 */
package com.portfolio.mgb.Security;

import com.portfolio.mgb.Security.Service.UserDetailsImpl;
import com.portfolio.mgb.Security.jwt.JwtEntryPoint;
import com.portfolio.mgb.Security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class MainSecurity {
    @Autowired     
    UserDetailsImpl userDetailsImpl;     
    @Autowired     
    JwtEntryPoint jwtEntryPoint;     
    
    @Bean     
    public JwtTokenFilter jwtTokenFilter() {         
        return new JwtTokenFilter();     
    }     
    
    @Bean     
    public PasswordEncoder passwordEncoder() {         
        return new BCryptPasswordEncoder();     
    }     
    
    @Bean     
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {         
        return authenticationConfiguration.getAuthenticationManager();     
    }     
    
    @Bean     
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {         
        http.cors()
                .and()
                .csrf()
                .disable()                 
                .exceptionHandling()
                .authenticationEntryPoint(jwtEntryPoint).and()                 
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()                 
                .authorizeRequests()                 
                .antMatchers("").permitAll()                 
                .anyRequest()
                .authenticated();         
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);         
        return http.build();
    }
    } 

