package com.mycompany.dvdstore;

import com.mycompany.dvdstore.controller.MovieController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args )
    {
        /* Lit le fichier xml et instancie toutes les classes qui y sont définies
         et les mettres en mémoire au travers de la variable context.
         Crétaion dynamique des objets par Spring ou IoC = Inversion of Control
        */
       // ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /* Charge le contexte à partir des configurations indiquées sur une classe */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println( " ************ ENREGISTRER LE FILM ***********" );
        MovieController movieController = context.getBean(MovieController.class);
        movieController.addUsingConsole();
    }
}
