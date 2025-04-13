package com.salah.monapp.entity;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Course extends Event implements Serializable {
    private int professorId;
    private int classroomId;
    private Set<Integer> groupsIds;

    // Constructeurs
    public Course() {
        super();
        this.groupsIds = new HashSet<>();
    }

    public Course(int id, String title, int professorId, int classroomId, Set<Integer> groupsIds) {
        super(id, title);
        this.professorId = professorId;
        this.classroomId = classroomId;
        this.groupsIds = new HashSet<>(groupsIds);
    }

    // Accesseurs et mutateurs
    public int getProfessorId() {
        return professorId;
    }

    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public Set<Integer> getGroupsIds() {
        return new HashSet<>(groupsIds); // Retourne une copie pour l'encapsulation
    }

    public void setGroupsIds(Set<Integer> groupsIds) {
        this.groupsIds = new HashSet<>(groupsIds); // Copie défensive
    }

    // Méthodes pour gérer les groupes
    public void addGroupId(int id) {
        groupsIds.add(id);
    }

    public boolean isGroupIdPresent(int id) {
        return groupsIds.contains(id);
    }

    // Méthodes de comparaison
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Course course = (Course) obj;
        return professorId == course.professorId &&
                classroomId == course.classroomId &&
                groupsIds.equals(course.groupsIds);
    }
}