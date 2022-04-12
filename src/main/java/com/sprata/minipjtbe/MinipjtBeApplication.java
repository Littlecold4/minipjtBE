package com.sprata.minipjtbe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MinipjtBeApplication {

//    public static final String APPLICATION_LOCATIONS = "spring.config.location="
//            + "classpath:aws.yml";

    public static void main(String[] args) {
        SpringApplication.run(MinipjtBeApplication.class, args);
//        new SpringApplicationBuilder(MinipjtBeApplication.class)
//                .properties(APPLICATION_LOCATIONS)
//                .run(args);
    }

}
