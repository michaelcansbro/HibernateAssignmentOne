package com.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Insert {
    public void insert() {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        // create session
        Session session = factory.getCurrentSession();
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a name to add a student: ");
        String name = kb.nextLine();
        try {

                    Student tempStudent = new Student(name);
                    // start a transaction
                    session.beginTransaction();
                    // save the student object
                    session.save(tempStudent);
                    // commit transaction
                    session.getTransaction().commit();


        }
        finally {
            factory.close();
        }
    }
}