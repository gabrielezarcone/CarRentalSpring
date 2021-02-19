package com.zarconeg.carRental.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/** Questa classe crea un Servlet Filter chiamato springSecurityFilterChain  all WAR */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecuritu(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder()); // mi consente di criptare le password
    }

    @Override
    protected void configure(HttpSecurity http)throws Exception{
        http.authorizeRequests()
                .antMatchers( "/").permitAll()
                .antMatchers("/admin/**").access("hasRole('ADMIN')") // NB nel db deve essere salvato come ROLE_ADMIN
                .antMatchers("/**/eliminaAuto/**").access("hasRole('ADMIN')")
                .antMatchers("/customer/**").access("hasRole('ADMIN') or hasRole('CUSTOMER')")
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/Access_Denied");
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        // Bean che mi consente di criptare le password
        return new BCryptPasswordEncoder();
    }
}
