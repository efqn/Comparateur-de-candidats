package UI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Choix extends JFrame {
	
	private JPanel pan = new JPanel ();
	private JButton bouton1 = new JButton (" Rechercher des candidats ");
	private JButton bouton2 = new JButton (" Ajoutez mon profil candidat ");
	
	public Choix(){
		this.setTitle (" Accueil comparateur candidats ");
		this.setSize (600 , 300);
		this.setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		this.setLocationRelativeTo ( null );
		
		// Ajout du texte
		pan.setLayout(new FlowLayout());
		JLabel label = new JLabel("Bienvenue dans notre comparateur de candidats. Vous souhaitez...");
		label.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		pan.add(label);

		// Ajout boutons
		pan.add( bouton1 );
		this.setContentPane (pan);
		
		pan.add( bouton2 );
		this.setContentPane (pan);
	}

}
