package com.salah.monapp.entity;
import java.util.Objects;

public abstract class Schedulable {
    protected int id;
    private static int currentId = 1;


    public Schedulable() {
        this.id = currentId++;
    }

    public Schedulable(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + " [id=" + id + "]";
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Schedulable that = (Schedulable) obj;
        return id == that.id;
    }

    // Méthode abstraite supplémentaire
    public abstract String tuple();
}