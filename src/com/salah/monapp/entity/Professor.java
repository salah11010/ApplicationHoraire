package com.salah.monapp.entity;
import java.io.*;
import java.util.Objects;

public class Professor extends Schedulable implements Serializable {
    private String lastName;
    private String firstName;


    public Professor() {
        super();
        this.lastName = "nom";
        this.firstName = "prenom";
        System.out.println("---Professor: constructeur par defaut---");
    }

    public Professor(int id, String lastName, String firstName) {
        super(id);
        this.lastName = lastName;
        this.firstName = firstName;
        System.out.println("---Professor: constructeur d'initialisation---");
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Override
    public String toString() {
        return lastName + " " + firstName;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Professor professor = (Professor) obj;
        return Objects.equals(lastName, professor.lastName) &&
                Objects.equals(firstName, professor.firstName);
    }
}