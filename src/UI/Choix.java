package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class Choix extends JFrame implements ActionListener {
	
	private JPanel container;
	private JLabel phraseDebut;
	
	private Label label_1;
	private Label label_2;
	
	private JButton ajoutProfil;
	private JButton rechercherCandidat;
	private JButton quitter;
	
	private FormulaireCand ajoutProf;
	private RechercheCritere rechercheCand;
	
	public Choix(){
		setTitle (" Accueil");
		setSize (500 , 500);
		setResizable(false);
		setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE );
		
		container = new JPanel();
		container.setBorder(new EmptyBorder(6, 6, 6, 6));
		container.setBackground(Color.white);
		container.setLayout(null);
		setContentPane(container);
		
		// Phrase du début
		phraseDebut = new JLabel("Bienvenue dans notre comparateur de candidats.");
		phraseDebut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phraseDebut.setBounds(30, 26, 438, 25);
		container.add(phraseDebut);
		
		//Phrase vous pouvez... et OU
		label_1 = new Label("Vous pouvez...");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(191, 84, 111, 27);
		container.add(label_1);
		label_2 = new Label("ou");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(224, 198, 31, 27);
		container.add(label_2);
		
		// Bouton ajouter profil candidat
		ajoutProfil = new JButton("Ajouter mon profil candidat");
		ajoutProfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		ajoutProfil.setBounds(106, 127, 268, 50);
		ajoutProfil.addActionListener(this);
		container.add(ajoutProfil);
		
		// Bouton rechercher candidats
		rechercherCandidat = new JButton("Rechercher des candidats");
		rechercherCandidat.setFont(new Font("Tahoma", Font.BOLD, 14));
		rechercherCandidat.setBounds(106, 243, 268, 50);
		rechercherCandidat.addActionListener(this);
		container.add(rechercherCandidat);
		
		// Bouton quitter
		quitter = new JButton("Quitter");
		quitter.setFont(new Font("Tahoma", Font.BOLD, 14));
		quitter.setBounds(106, 374, 268, 50);
		quitter.addActionListener(this);
		container.add(quitter);
		
		
		this.setVisible(true);
	}
	
	// Action des boutons
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
 
		if(source == quitter){
			this.setVisible(false);
			this.dispose();
		} 
		if(source == ajoutProfil){
			ajoutProf=new FormulaireCand();	
			this.setVisible(false);
			this.dispose();
		}
		
		else if(source== rechercherCandidat ){
			rechercheCand=new RechercheCritere();	
			this.setVisible(false);
			this.dispose();
		}
	}
	
}
