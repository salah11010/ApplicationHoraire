package com.salah.monapp.entity;
import java.util.Objects;

public class Classroom extends Schedulable {
    private String name;
    private int seatingCapacity;

    // 1. Constructeurs
    public Classroom() {
        super();
        this.name = " ";
        this.seatingCapacity = 0;
    }

    public Classroom(int id, String name, int seatingCapacity) {
        super(id);
        this.name = name;
        this.seatingCapacity = seatingCapacity;
    }

    // 2. Accesseurs (getters/setters)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    // 3. Méthode toString()
    @Override
    public String toString() {
        return "Classroom [id=" + getId() +
                ", name=" + name +
                ", seatingCapacity=" + seatingCapacity + "]";
    }

    // 4. Méthode equals()
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Classroom other = (Classroom) obj;
        return seatingCapacity == other.seatingCapacity &&
                Objects.equals(name, other.name);
    }
    // 6. Méthode tuple() (héritée de Schedulable)
    @Override
    public String tuple() {
        return getId() + ";" + name + ";" + seatingCapacity;
    }
}