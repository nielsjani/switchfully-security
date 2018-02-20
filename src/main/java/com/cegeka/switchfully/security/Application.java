package com.cegeka.switchfully.security;

import com.cegeka.switchfully.security.spring.CommonConfig;
import com.cegeka.switchfully.security.spring.SecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import({CommonConfig.class, SecurityConfig.class})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
