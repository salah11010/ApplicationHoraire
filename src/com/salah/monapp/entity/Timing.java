package com.salah.monapp.entity;
import java.io.*;
import java.util.Objects;

public class Timing implements Serializable {
    // Constantes pour les jours
    public static final String MONDAY = "Lundi";
    public static final String TUESDAY = "Mardi";
    public static final String WEDNESDAY = "Mercredi";
    public static final String THURSDAY = "Jeudi";
    public static final String FRIDAY = "Vendredi";
    public static final String SATURDAY = "Samedi";
    public static final String SUNDAY = "Dimanche";
    public static final String[] DAYS = {MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};

    private String day;
    private Time start;
    private Time duration;

    // Constructeurs
    public Timing() {
        this.day = "---";
        this.start = new Time();
        this.duration = new Time();
    }

    public Timing(String day, Time start, Time duration) {
        setDay(day);
        setStart(new Time(start)); // Copie défensive
        setDuration(new Time(duration)); // Copie défensive
    }


    // Getters
    public String getDay() {
        return day;
    }

    public Time getStart() {
        return new Time(start);
    }

    public Time getDuration() {
        return new Time(duration);
    }


    public void setDay(String day) {
        for (String validDay : DAYS) {
            if (validDay.equals(day)) {
                this.day = day;
                return;
            }
        }
        throw new IllegalArgumentException("Jour invalide: " + day);
    }

    public void setStart(Time start) {
        this.start = new Time(start);
    }

    public void setDuration(Time duration) {
        this.duration = new Time(duration);
    }


    public void display() {
        System.out.println("Jour : " + day);
        System.out.println("Début : " + start);
        System.out.println("Durée : " + duration);
    }

    @Override
    public String toString() {
        return day + ";" + start + ";" + duration;
    }


    public boolean intersect(Timing other) {
        if (!day.equals(other.day)) {
            return false;
        }

        Time thisEnd = start.add(duration);
        Time otherEnd = other.start.add(other.duration);

        // Vérifie si this commence après other se termine
        if (start.compareTo(otherEnd) > 0) {
            return false;
        }

        // Vérifie si this se termine avant other commence
        if (thisEnd.compareTo(other.start) < 0) {
            return false;
        }

        return true;
    }

    // Méthodes equals et hashCode
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Timing timing = (Timing) obj;
        return Objects.equals(day, timing.day) &&
                Objects.equals(start, timing.start) &&
                Objects.equals(duration, timing.duration);
    }