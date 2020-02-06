package com.example;
import com.example.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

import org.hibernate.Query;



public class Display {

    public void display() {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();

        try {


            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();




            Query query = session.createQuery("from Student");

            List<Student> list = query.list();
            for(int i =0;i<list.size();i++) {
               System.out.println(list.get(i) + " ");
            }

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Students Displayed!");
        } finally {
            factory.close();
        }
    }
}