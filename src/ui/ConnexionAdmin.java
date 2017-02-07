package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Criteres.Critere;
import Recherche.Billet;
import Recherche.Demande;
import Recherche.Recherche;
import ui.Login;
import ui.ConnexionAdmin;

/**
 * 
 * @author Utilisateur
 *  Fenêtre de connexion de l'administrateur, vérification si le bon
 *  mot de passe et le bon utilisateur est rentré. Ceux ci sont stockés
 *  dans la classe Login dans la package UI
 */

@SuppressWarnings("unused")
public class ConnexionAdmin extends JDialog {
 
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private static boolean succeeded=false;
    private ResultFrameAdmin candidatBD;
 
    /**
     * Constructeur de la fenetre Connexion administrateur
     * @param parent fenetre parente de la fenetre connexion administrateur
     */
    public ConnexionAdmin(Frame parent) {
        super(parent, "Connexion", true);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints cs = new GridBagConstraints();
 
        cs.fill = GridBagConstraints.HORIZONTAL;
 
        lbUsername = new JLabel("Nom d'utilisateur: ");
        cs.gridx = 0;
        cs.gridy = 0;
        cs.gridwidth = 1;
        panel.add(lbUsername, cs);
 
        tfUsername = new JTextField(20);
        cs.gridx = 1;
        cs.gridy = 0;
        cs.gridwidth = 2;
        panel.add(tfUsername, cs);
 
        lbPassword = new JLabel("Mot de passe: ");
        cs.gridx = 0;
        cs.gridy = 1;
        cs.gridwidth = 1;
        panel.add(lbPassword, cs);
 
        pfPassword = new JPasswordField(20);
        cs.gridx = 1;
        cs.gridy = 1;
        cs.gridwidth = 2;
        panel.add(pfPassword, cs);
        panel.setBorder(new LineBorder(Color.GRAY));

        
        btnLogin = new JButton("Valider");
        btnLogin.addActionListener(new ActionListener() {
        	 
            public void actionPerformed(ActionEvent e) {
                if (Login.admin_authenticate(getUsername(), getPassword())) {
                	setSucceeded(true);
                    candidatBD = new ResultFrameAdmin();
                    //dispose();
                    parent.dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(ConnexionAdmin.this,
                            "Nom d'utilisateur ou mot de passe incorrect",
                            "Connexion échouée",
                            JOptionPane.ERROR_MESSAGE);
                    // reset username et le password
                    tfUsername.setText("");
                    pfPassword.setText("");
                    setSucceeded(false);
 
                }
            }
        });
       
        btnCancel = new JButton("Annuler");
        btnCancel.addActionListener(new ActionListener() {
 
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);
 
        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);
 
        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }
 
 /******************** Méthodes ***********************************/
    
 
    public String getUsername() {
        return tfUsername.getText().trim();
    }
 
    public String getPassword() {
        return new String(pfPassword.getPassword());
    }
 
    public static boolean isSucceeded() {
        return succeeded;
    }
    
    public static void setSucceeded(boolean succ){
    	succeeded=succ;
    }
}
