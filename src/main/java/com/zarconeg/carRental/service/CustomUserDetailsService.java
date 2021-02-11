package com.zarconeg.carRental.service;

import com.zarconeg.carRental.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService { // l'interfaccia mi consente di recuperare le info degli utenti
    @Autowired
    private UserService userService;


    @Override
    @Transactional(readOnly=true)
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        // https://www.boraji.com/spring-mvc-5-spring-security-5-hibernate-5-example
        User user = userService.getByUsername(ssoId);
        if (user==null){
            throw new UsernameNotFoundException("Utente non trovato");
        }
        else{
            // Creo un utente di Core security
            org.springframework.security.core.userdetails.User.UserBuilder builder;
            builder =  org.springframework.security.core.userdetails.User.withUsername(ssoId);
            builder.password(user.getPassword());
            builder.disabled(user.isDeleted());
            String[] authorities = user.getRuoli()
                    .stream().map(a -> a.getRuolo()).toArray(String[]::new);
            builder.authorities(authorities);
            return builder.build();
        }
    }
}
