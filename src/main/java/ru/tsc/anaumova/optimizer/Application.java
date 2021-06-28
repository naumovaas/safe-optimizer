package ru.tsc.anaumova.optimizer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tsc.anaumova.optimizer.component.Bootstrap;
import ru.tsc.anaumova.optimizer.config.AppConfig;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        Bootstrap bootstrap = context.getBean("bootstrap", Bootstrap.class);
//        System.out.println(bootstrap.start());
//        ((AnnotationConfigApplicationContext) context).close();

        SpringApplication.run(Application.class, args);
    }

}
