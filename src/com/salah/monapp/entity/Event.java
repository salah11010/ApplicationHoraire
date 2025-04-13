package com.salah.monapp.entity;
import java.io.*;
import java.util.Objects;

public class Event implements Serializable {
    protected int code;
    protected String title;
    protected Timing timing;
    protected static int currentCode = 1;

    // Constructeurs
    public Event() {
        this(0, "---");
    }

    public Event(int code, String title) {
        setCode(code);
        setTitle(title);
        this.timing = null;
    }

    public Event(Event other) {
        this(other.code, other.title);
        if (other.timing != null) {
            this.timing = new Timing(other.timing);
        }
    }

    // Accesseurs et mutateurs
    public void setCode(int code) {
        if (code >= 1) {
            this.code = code;
        }
    }

    public void setTitle(String title) {
        this.title = (title != null) ? title : "---";
    }

    public void setTiming(Timing timing) {
        this.timing = (timing != null) ? new Timing(timing) : null;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public Timing getTiming() {
        if (timing == null) {
            throw new IllegalStateException("Evénement non planifié");
        }
        return new Timing(timing); // Copie défensive
    }

    // Affichage
    public void display() {
        System.out.println("Event (" + code + ") : " + title);
        if (timing != null) {
            timing.display();
        } else {
            System.out.println("Timing non planifié");
        }
    }

    // Conversion en chaîne
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(code).append(";").append(title).append(";");
        sb.append((timing != null) ? timing.toString() : "Timing non planifié");
        return sb.toString();
    }

    // Égalité
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Event event = (Event) obj;
        return code == event.code &&
                Objects.equals(title, event.title) &&
                Objects.equals(timing, event.timing);
    }
}