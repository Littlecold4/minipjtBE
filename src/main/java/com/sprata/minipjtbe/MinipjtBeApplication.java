package com.sprata.minipjtbe;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MinipjtBeApplication {

<<<<<<< HEAD
    public static final String APPLICATION_LOCATIONS = "spring.config.location="
        + "classpath:/aws.yml"
            +",classpath:/application.properties";
=======
//    public static final String APPLICATION_LOCATIONS = "spring.config.location="
//            + "classpath:aws.yml";
>>>>>>> origin/HEAD

    public static void main(String[] args) {
        SpringApplication.run(MinipjtBeApplication.class, args);
//        new SpringApplicationBuilder(MinipjtBeApplication.class)
//                .properties(APPLICATION_LOCATIONS)
//                .run(args);
    }

}
