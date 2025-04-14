package com.salah.monapp.Interface;

import com.salah.monapp.entity.ContainerIdentifiant;
import com.salah.monapp.entity.Identifiant;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SignUp extends JFrame {

    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton btnSignUp;

    public SignUp() {
        setTitle("Sign Up");
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // Plein écran
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Composants
        JLabel lblUsername = new JLabel("Username:");
        userNameField = new JTextField(15);

        JLabel lblPassword = new JLabel("Password:");
        passwordField = new JPasswordField(15);

        btnSignUp = new JButton("Sign Up");

        // Ajout des composants
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lblUsername, gbc);
        gbc.gridx = 1;
        panel.add(userNameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblPassword, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 2;
        panel.add(btnSignUp, gbc);

        add(panel);
        setVisible(true);

        // Action bouton
        btnSignUp.addActionListener(e -> {
            String username = userNameField.getText();
            String password = new String(passwordField.getPassword());
            Identifiant identifiant = new Identifiant(username, password);
            ContainerIdentifiant.loadFromFile();
            List<Identifiant> identifiants = ContainerIdentifiant.getAll();
            identifiants.add(identifiant);
            ContainerIdentifiant.setAll(identifiants);
            ContainerIdentifiant.saveToFile();
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnSignUp);
            currentFrame.dispose();
            JOptionPane.showMessageDialog(this, "Utilisateur inscrit : " + username);
            new SignIn();
        });
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
