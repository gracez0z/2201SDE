package org.ascending.training;

import org.ascending.training.service.JWTService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;

@SpringBootApplication(scanBasePackages = {"org.ascending.training"})
@ServletComponentScan(basePackages = {"org.ascending.training.filter"})
public class ApplicationBootstrap extends SpringBootServletInitializer {
    public static void main(String[] args) {
//        SpringApplication.run(ApplicationBootstrap.class, args);

        ApplicationContext app = SpringApplication.run(ApplicationBootstrap.class, args);

        // Within the Application contenxt, we can get the bean JWTService.
//        JWTService jwtService = app.getBean(JWTService.class);
//        System.out.println(jwtService.test());
    }
}

//public class ApplicationBootstrap {
//    public static void main(String[] args) {
//        SpringApplication.run(ApplicationBootstrap.class, args);
//    }
//}