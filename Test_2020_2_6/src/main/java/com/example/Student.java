package com.example;
import org.hibernate.*;
import javax.persistence.*;
@Entity
@Table(name="student")
public class Student {
    private long id;
    private String name;

    public Student() {
    }
    public Student(String name){
        this.name = name;
        //this.major = major;
        //this.school = school;
    }
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(generator = "increment")
    public long getId(){
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    @Column(name="name")
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    /* @Column(name="major")
     public String getMajor(){
         return major;
     }
     public void setMajor(String major){
         this.major = major;
     }
     @Column(name="school")
     public String getSchool(){
         return school;
     }
     public void setSchool(String school){
         this.school = school;
     }
     */
    public String toString() {
        return "Student [studentId=" + id + ", studentName="
                + name;
    }
}
