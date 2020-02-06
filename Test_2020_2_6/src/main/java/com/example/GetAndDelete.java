package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class GetAndDelete {

    public void getAndDelete() {

        // create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = factory.getCurrentSession();
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the ID for the Student you wish to get? ");
        long studentId = kb.nextLong();
        System.out.println("Enter the ID for the Student you wish to Delete? ");
        long idNum = kb.nextLong();
        try {


            // now get a new session and start transaction
            session = factory.getCurrentSession();
            session.beginTransaction();


            // retrieve student based on the id: primary key
            System.out.println("\nGetting student with id: " + studentId);

            Student myStudent = session.get(Student.class, studentId);
            System.out.println("This is his name: " + myStudent.getName());
            // delete the student
            // System.out.println("Deleting student: " + myStudent);
            // session.delete(myStudent);

            // delete student id=2
            System.out.println("Deleting student id=" +idNum);

            session.createQuery("delete from Student where id="+idNum).executeUpdate();

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Student Deleted!");
        } finally {
            factory.close();
        }
    }
}
