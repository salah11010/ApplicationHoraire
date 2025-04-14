package com.salah.monapp.Interface;
import com.salah.monapp.entity.ContainerIdentifiant;
import com.salah.monapp.entity.Identifiant;

import java.security.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SignIn extends JFrame {

    private JTextField userName;
    private JPasswordField passWorld;
    private JLabel lblusername, lblpassword;
    private JButton jbtnsignIn, jbtnsignUp;

    public SignIn() {
        JFrame frame = new JFrame("Sign In");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximiser la fenêtre
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Plein écran        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Marges
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Création des composants
        userName = new JTextField(15);
        passWorld = new JPasswordField(15);
        lblusername = new JLabel("Username:");
        lblpassword = new JLabel("Password:");
        jbtnsignIn = new JButton("Sign In");
        jbtnsignUp = new JButton("Sign Up");

        // Style des composants

        jbtnsignIn.setBackground(new Color(0, 120, 215));
        jbtnsignIn.setForeground(Color.WHITE);
        jbtnsignUp.setBackground(new Color(200, 200, 200));




        // Positionnement
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(lblusername, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        panel.add(userName, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panel.add(lblpassword, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        panel.add(passWorld, gbc);

        // Boutons centrés
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        buttonPanel.add(jbtnsignIn);
        buttonPanel.add(jbtnsignUp);

        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(buttonPanel, gbc);

        // Ajout de padding autour du panel principal
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        frame.add(panel);
        frame.setVisible(true);

        // Action sur bouton Sign In
        jbtnsignIn.addActionListener(j -> {
            String usernameInput = userName.getText();
            String passwordInput = new String(passWorld.getPassword());
            ContainerIdentifiant.loadFromFile();
            List<Identifiant> identifiants = ContainerIdentifiant.getAll();
            for(Identifiant identifiant : identifiants) {
                if(identifiant.verifier(usernameInput, passwordInput) == true) {
                    JOptionPane.showMessageDialog(null, "Accès réussi.");
                    return;
                };
            }
            JOptionPane.showMessageDialog(null, "vérifier tes informations.");
        });

        jbtnsignUp.addActionListener(j -> {
            JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(jbtnsignIn);
            currentFrame.dispose();
            new SignUp();
        });


    }
/*
    public static void checkInfo(String username, String password) {
        if ("admin".equalsIgnoreCase(username)) {
            if ("admin".equalsIgnoreCase(password)) {
                JOptionPane.showMessageDialog(null, "Accès réussi.");
            } else {
                JOptionPane.showMessageDialog(null, "Mot de passe incorrect.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nom d'utilisateur incorrect.");
        }
    }
*/

}