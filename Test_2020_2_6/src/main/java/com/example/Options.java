package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Scanner;

public class Options {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        System.out.println("Options: ");
        System.out.println("I: Insert");
        System.out.println("D: Display");
        System.out.println("GD: Get and Delete");
        System.out.println("Q: Quit");
        String input= kb.nextLine();
        while(!(input.equals("Q"))){
            if(input.equals("I")){
                Insert I = new Insert();
                I.insert();

            }
            if(input.equals("D")){
                Display D = new Display();
                D.display();

            }
            if(input.equals("GD")){
                GetAndDelete GD = new GetAndDelete();
                GD.getAndDelete();

            }
            System.out.println("Options: ");
            System.out.println("I: Insert");
            System.out.println("D: Display");
            System.out.println("GD: Get and Delete");
            System.out.println("Q: Quit");
            input= kb.nextLine();
        }
    }
}
