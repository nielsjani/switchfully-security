package com.cegeka.switchfully.security.spring;

import com.cegeka.switchfully.security.spring.feature.Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.ldap.core.AuthenticatedLdapEntryContextMapper;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.ldap.query.LdapQueryBuilder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.ldap.SpringSecurityLdapTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;

import static com.google.common.collect.Lists.newArrayList;

@Component
public class ArmyAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private Environment environment;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SpringSecurityLdapTemplate ldapTemplate = getLdapTemplate();
        return ldapTemplate.authenticate(LdapQueryBuilder.query().filter("uid=euler"), "password", mapToArmyAuthentication(authentication, ldapTemplate));
    }

    private AuthenticatedLdapEntryContextMapper<ArmyAuthentication> mapToArmyAuthentication(Authentication authentication, SpringSecurityLdapTemplate ldapTemplate) {
        return (ctx, ldapEntryIdentification) -> new ArmyAuthentication(authentication.getPrincipal().toString(), authentication.getCredentials().toString(), Feature.getFeaturesForRoles(newArrayList(getRolesForUser(ldapTemplate))));
    }

    private SpringSecurityLdapTemplate getLdapTemplate() {
        LdapContextSource contextSource = new LdapContextSource();
        contextSource.setUrl(environment.getProperty("ldap.url"));
        contextSource.setBase(environment.getProperty("ldap.base"));
        contextSource.setUserDn(environment.getProperty("ldap.userdn"));
        contextSource.setPassword(environment.getProperty("ldap.password"));
        contextSource.afterPropertiesSet();
        return new SpringSecurityLdapTemplate(contextSource);
    }

    private Set<String> getRolesForUser(SpringSecurityLdapTemplate ldapTemplate) {
        return ldapTemplate.searchForSingleAttributeValues("", "(uniqueMember={0})", new String[]{"uid=riemann,dc=example,dc=com", "riemann"}, "cn");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
