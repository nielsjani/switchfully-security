package com.cegeka.switchfully.security.spring;

import com.cegeka.switchfully.security.external.authentication.ExternalAuthenticaton;
import com.cegeka.switchfully.security.external.authentication.FakeAuthenticationService;
import com.cegeka.switchfully.security.spring.feature.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class ArmyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private FakeAuthenticationService fakeAuthenticationService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ExternalAuthenticaton user = fakeAuthenticationService.getUser(authentication.getPrincipal().toString(), authentication.getCredentials().toString());
        if(user != null){
            return new ArmyAuthentication(user.getUsername(), user.getPassword(), Feature.getFeaturesForRoles(user.getRoles()));
        }
        throw new BadCredentialsException("BAD BAD NOT GOOD");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
