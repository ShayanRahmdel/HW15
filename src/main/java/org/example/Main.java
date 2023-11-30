package org.example;

import entity.Lesson;
import entity.MidTerm;
import entity.Student;
import entity.Term;
import util.AppContext;
import util.MainMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static void main(String[] args) {
//

//        EntityManagerFactory entityManagerFactory =
//                Persistence.createEntityManagerFactory("default");
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();




        MainMenu mainMenu = new MainMenu();

        mainMenu.main();

//        Term term = new Term(2022, MidTerm.First);
//        System.out.println(AppContext.getMasterService().findUnitInTerm(3, term));


//            Student student = new Student(2);
//        System.out.println(AppContext.getReportCardService().getAvg(student));

    }

}