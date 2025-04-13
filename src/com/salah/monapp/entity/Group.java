package com.salah.monapp.entity;
import java.io.*;
import java.util.Objects;

public class Group extends Schedulable implements Serializable {
    private String name;


    public Group() {
        super();
        this.name = " ";
        System.out.println("---Group: constructeur par defaut---");
    }

    public Group(int id, String name) {
        super(id);
        this.name = name;
        System.out.println("---Group: constructeur d'initialisation---");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Group group = (Group) obj;
        return Objects.equals(name, group.name);
    }


    @Override
    public String tuple() {
        return getId() + ";" + name;
    }
}