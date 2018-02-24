package com.cegeka.switchfully.security.spring;

import com.cegeka.switchfully.security.spring.feature.Feature;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class ArmyAuthentication implements Authentication {

    private String username;
    private String credentials;
    private List<SimpleGrantedAuthority> roles = newArrayList();
    private boolean isAuthenticated = true;

    public ArmyAuthentication(String username, String credentials, List<Feature> roles) {
        this.username = username;
        this.roles = roles.stream()
                .map(feature -> new SimpleGrantedAuthority(feature.name()))
                .collect(Collectors.toList());
        this.credentials = credentials;
    }

    //AKA Roles
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    //AKA Username
    @Override
    public Object getPrincipal() {
        return username;
    }

    //AKA Password
    @Override
    public Object getCredentials() {
        return credentials;
    }

    //Always true in our case.
    @Override
    public boolean isAuthenticated() {
        return isAuthenticated;
    }

    //Not used
    @Override
    public Object getDetails() {
        return "";
    }

    //Not used
    @Override
    public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
        this.isAuthenticated = isAuthenticated;
    }

    //Can not be null (or Spring will throw an exception)
    @Override
    public String getName() {
        return username;
    }
}
