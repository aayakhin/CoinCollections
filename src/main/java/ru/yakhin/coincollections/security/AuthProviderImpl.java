package ru.yakhin.coincollections.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import ru.yakhin.coincollections.service.UsersDetailsService;

import java.util.Collection;
import java.util.Collections;

@Component
public class AuthProviderImpl implements AuthenticationProvider {


    private final UsersDetailsService usersDetailsService;
    @Autowired
    public AuthProviderImpl(UsersDetailsService usersDetailsService) {
        this.usersDetailsService = usersDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        UserDetails userDetails = usersDetailsService.loadUserByUsername(username);
        String password = authentication.getCredentials().toString();
        if (!password.equals(userDetails.getPassword()))
            throw new BadCredentialsException("Incorrect password");
        return new PreAuthenticatedAuthenticationToken(userDetails, password, Collections.emptyList());


    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}
