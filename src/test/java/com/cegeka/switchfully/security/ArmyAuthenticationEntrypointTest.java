package com.cegeka.switchfully.security;

import com.cegeka.switchfully.security.spring.ArmyAuthenticationEntrypoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ArmyAuthenticationEntrypointTest {

    @InjectMocks
    private ArmyAuthenticationEntrypoint entrypoint;

    @Test
    public void commence_shouldSetUnauthorisedStatusAndHeader() throws IOException, ServletException {

        HttpServletRequest request = new MockHttpServletRequest();
        HttpServletResponse response = new MockHttpServletResponse();

        entrypoint.commence(request, response, null);

        assertThat(response.getHeader("WWW-Authenticate")).isEqualTo("Basic realm=ARMYRealm");
        assertThat(response.getStatus()).isEqualTo(401);
    }
}