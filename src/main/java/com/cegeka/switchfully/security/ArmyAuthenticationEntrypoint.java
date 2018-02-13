package com.cegeka.switchfully.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//This entrypoint is only used when the authentication didn't succeed (eg: an unknown username/password combination).
@Component
public class ArmyAuthenticationEntrypoint extends BasicAuthenticationEntryPoint {

    public ArmyAuthenticationEntrypoint() {
        setRealmName("ARMYRealm");
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException, ServletException {
        response.addHeader("WWW-Authenticate", "Basic realm=" +getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
