package main.com.salah.monapp.Interface;

import javax.swing.*;
import java.awt.*;

public class MainInterface {
    public MainInterface() {
        // Configuration fenêtre
        JFrame frame = new JFrame("Application Horaire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Barre menu (inchangée)
        JPanel menuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        String[] boutonsMenu = {"Session", "Fichier", "Supprimer", "Importer", "Exporter Horaire"};
        for (String texte : boutonsMenu) {
            JButton btn = new JButton(texte);
            btn.setFont(new Font("Arial", Font.PLAIN, 11));
            menuPanel.add(btn);
        }
        frame.add(menuPanel, BorderLayout.NORTH);


        // 3. Panels principaux (variables explicites)
        // Panel Professeurs
        JPanel professorsPanel = new JPanel(new BorderLayout());
        professorsPanel.setBackground(Color.white);
        professorsPanel.setBorder(BorderFactory.createTitledBorder("Professeurs"));
        professorsPanel.add(new JScrollPane(new JList<>(new String[]{"Prof1", "Prof2"})), BorderLayout.CENTER);

        JTextArea profDisplayArea = new JTextArea();
        profDisplayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(profDisplayArea);
        professorsPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        formPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel nomLabel = new JLabel("Nom:");
        JTextField nomField = new JTextField();
        JLabel prenomLabel = new JLabel("Prénom:");
        JTextField prenomField = new JTextField();

        JButton ajouterBtn = new JButton("Ajouter");
        JButton supprimerBtn = new JButton("Supprimer");

        formPanel.add(nomLabel);
        formPanel.add(prenomLabel);
        formPanel.add(nomField);
        formPanel.add(prenomField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        buttonPanel.add(ajouterBtn);
        buttonPanel.add(supprimerBtn);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(formPanel, BorderLayout.CENTER);
        southPanel.add(buttonPanel, BorderLayout.SOUTH);
        professorsPanel.add(southPanel, BorderLayout.SOUTH);










        JPanel groupsPanel = new JPanel(new BorderLayout());
        groupsPanel.setBackground(Color.white);
        groupsPanel.setBorder(BorderFactory.createTitledBorder("Groupes"));


        JTextArea groupDisplayArea = new JTextArea();
        groupDisplayArea.setEditable(false);
        JScrollPane groupScrollPane = new JScrollPane(groupDisplayArea);
        groupsPanel.add(groupScrollPane, BorderLayout.CENTER);


        JPanel groupFormPanel = new JPanel(new BorderLayout(5, 5));
        groupFormPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));


        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel numLabel = new JLabel("Numéro:");
        JTextField numField = new JTextField(40); // Largeur de 15 colonnes
        inputPanel.add(numLabel);
        inputPanel.add(numField);

        JPanel groupButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton ajouterGroupeBtn = new JButton("Ajouter");
        JButton supprimerGroupeBtn = new JButton("Supprimer");
        groupButtonPanel.add(ajouterGroupeBtn);
        groupButtonPanel.add(supprimerGroupeBtn);


        groupFormPanel.add(inputPanel, BorderLayout.CENTER);
        groupFormPanel.add(groupButtonPanel, BorderLayout.SOUTH);
        groupsPanel.add(groupFormPanel, BorderLayout.SOUTH);







// Panel Locaux
        JPanel roomsPanel = new JPanel(new BorderLayout());
        roomsPanel.setBackground(Color.white);
        roomsPanel.setBorder(BorderFactory.createTitledBorder("Locaux"));

// Zone d'affichage des locaux
        JTextArea roomDisplayArea = new JTextArea();
        roomDisplayArea.setEditable(false);
        JScrollPane roomScrollPane = new JScrollPane(roomDisplayArea);
        roomsPanel.add(roomScrollPane, BorderLayout.CENTER);

// Panel de formulaire
        JPanel roomFormPanel = new JPanel(new BorderLayout(5, 5));
        roomFormPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

// Champ unique pour le nom du local
        JPanel roomInputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel roomLabel = new JLabel("Nom du local:");
        JTextField roomField = new JTextField(40);
        roomInputPanel.add(roomLabel);
        roomInputPanel.add(roomField);

// Boutons
        JPanel roomButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        JButton ajouterLocalBtn = new JButton("Ajouter");
        JButton supprimerLocalBtn = new JButton("Supprimer");
        roomButtonPanel.add(ajouterLocalBtn);
        roomButtonPanel.add(supprimerLocalBtn);

// Assemblage
        roomFormPanel.add(roomInputPanel, BorderLayout.CENTER);
        roomFormPanel.add(roomButtonPanel, BorderLayout.SOUTH);

        roomsPanel.add(roomFormPanel, BorderLayout.SOUTH);

        // 4. Conteneur principal
        JPanel mainContainer = new JPanel(new GridLayout(1, 3));
        mainContainer.setPreferredSize(new Dimension(screenSize.width, screenSize.height/2));
        mainContainer.add(professorsPanel);
        mainContainer.add(groupsPanel);
        mainContainer.add(roomsPanel);

        // 5. Panel du bas
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(new JLabel("Espace calendrier"));

        // 6. Organisation finale
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.add(mainContainer, BorderLayout.NORTH);
        wrapper.add(bottomPanel, BorderLayout.CENTER);

        frame.add(wrapper);
        frame.setVisible(true);
    }
}