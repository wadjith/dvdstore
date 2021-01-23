package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan(basePackages = {"com.mycompany.dvdstore.service","com.mycompany.dvdstore.repository.file"})
@PropertySource("classpath:application.properties")
public class App 
{
    public static void main( String[] args )
    {
        /* Charge le contexte à partir des configurations indiquées sur une classe */
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        System.out.println( " ************ ENREGISTRER LE FILM ***********" );
        MovieController movieController = context.getBean(MovieController.class);
        movieController.addUsingConsole();
    }

    @Bean
    public MovieController getMovieController() {
        return new MovieController();
    }
}
