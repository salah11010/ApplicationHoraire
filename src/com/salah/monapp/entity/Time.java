package com.salah.monapp.entity;
import java.io.*;
import java.util.Objects;

public class Time implements Serializable, Comparable<Time> {
    private int hour;
    private int minute;

    // Constructeurs
    public Time() {
        this(0, 0);
    }

    public Time(int h, int m) {
        setHour(h);
        setMinute(m);
    }

    public Time(int minutes) {
        this(minutes / 60, minutes % 60);
    }


    // Getters
    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    // Setters avec validation
    public void setHour(int h) {
        if (h < 0 || h > 24)
            throw new IllegalArgumentException("Heure invalide (0-24)");
        hour = h;
    }

    public void setMinute(int m) {
        if (m < 0 || m > 59)
            throw new IllegalArgumentException("Minute invalide (0-59)");
        minute = m;
    }

    // Affichage
    public void display() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return String.format("%02dh%02d", hour, minute);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Time time = (Time) obj;
        return hour == time.hour && minute == time.minute;
    }

    public Time decrement() {
        return this.subtract(30);
    }

    // Méthodes utilitaires
    private int toMinutes() {
        return hour * 60 + minute;
    }
}