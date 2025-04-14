package com.salah.monapp.entity;
import java.io.*;
import java.util.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class ContainerIdentifiant {
    private static List<Identifiant> identifiants = new ArrayList<>();
    private static final String FILE_PATH = "identifiants.json";

    public void addIdentifiant(Identifiant id) {
        identifiants.add(id);
    }

    public boolean checkAccess(String username, String password) {
        for (Identifiant id : identifiants) {
            if (id.getUsername().equalsIgnoreCase(username) && id.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void saveToFile() {
        try (Writer writer = new FileWriter(FILE_PATH)) {
            new Gson().toJson(identifiants, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadFromFile() {
        try (Reader reader = new FileReader(FILE_PATH)) {
            identifiants = new Gson().fromJson(reader, new TypeToken<List<Identifiant>>() {}.getType());
            if (identifiants == null) identifiants = new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Identifiant> getAll() {
        return identifiants;
    }
    public static void setAll(List<Identifiant> identifiants) {
        ContainerIdentifiant.identifiants = identifiants;
    }
}
