package com.cegeka.switchfully.security.external.authentication;

import org.springframework.stereotype.Service;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

@Service
public class FakeAuthenticationService {

    private List<ExternalAuthenticaton> externalAuthenticatons = newArrayList(
            ExternalAuthenticaton.externalAuthenticaton().withUsername("CRIMI").withPassword("NAL").withRoles(newArrayList("PRIVATE")),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("MOB").withPassword("BOSS").withRoles(newArrayList("PRIVATE")),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("ZWANETTA").withPassword("WORST").withRoles(newArrayList("CIVILIAN")),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("JMILLER").withPassword("THANKS").withRoles(newArrayList("PRIVATE")),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("UNCLE").withPassword("SAM").withRoles(newArrayList("HUMAN_RELATIONSHIPS")),
            ExternalAuthenticaton.externalAuthenticaton().withUsername("GENNY").withPassword("RALLY").withRoles(newArrayList("GENERAL"))
    );

    public ExternalAuthenticaton getUser(String username, String password) {
        return externalAuthenticatons.stream()
                .filter(externalAuthenticaton -> externalAuthenticaton.getUsername().equals(username))
                .filter(externalAuthenticaton -> externalAuthenticaton.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
