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
import javax.swing.UIManager;
import java.awt.Toolkit;

public class Choix extends TailleFenetre implements ActionListener {
	
	private JPanel container;
	private JLabel phraseDebut;
	
	private Label label_1;
	private Label label_2;
	
	private JButton ajoutProfil;
	private JButton rechercherCandidat;
	private JButton quitter;
	
	private FormulaireCand ajoutProf;
	private RechercheCritere rechercheCand;
	
	protected MenuHeader menu;
	
	public Choix(){
		// Création de la fenetre
		super();
		container = new JPanel();
		container.setBorder(new EmptyBorder(6, 6, 6, 6));
		container.setBackground(UIManager.getColor("Button.background"));
		container.setLayout(null);
		setContentPane(container);
		
		// Menu 
		menu = new MenuHeader();
		menu.setLocation(0, 0);
		menu.setSize(844, 37);
		container.add(menu);
		
		// Phrase du début
		phraseDebut = new JLabel("Bienvenue dans notre comparateur de candidats.");
		phraseDebut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		phraseDebut.setBounds(180, 63, 438, 25);
		container.add(phraseDebut);
		
		//Phrase vous pouvez... et OU
		label_1 = new Label("Vous pouvez...");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(336, 215, 111, 27);
		container.add(label_1);
		label_2 = new Label("ou");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(377, 329, 31, 27);
		container.add(label_2);
		
		// Bouton ajouter profil candidat
		ajoutProfil = new JButton("Ajouter mon profil candidat");
		ajoutProfil.setBackground(UIManager.getColor("activeCaption"));
		ajoutProfil.setFont(new Font("Tahoma", Font.BOLD, 14));
		ajoutProfil.setBounds(259, 258, 268, 50);
		ajoutProfil.addActionListener(this);
		container.add(ajoutProfil);
		
		// Bouton rechercher candidats
		rechercherCandidat = new JButton("Rechercher des candidats");
		rechercherCandidat.setBackground(UIManager.getColor("activeCaption"));
		rechercherCandidat.setFont(new Font("Tahoma", Font.BOLD, 14));
		rechercherCandidat.setBounds(259, 374, 268, 50);
		rechercherCandidat.addActionListener(this);
		container.add(rechercherCandidat);
		
		// Bouton quitter
		quitter = new JButton("Quitter");
		quitter.setBackground(UIManager.getColor("activeCaption"));
		quitter.setFont(new Font("Tahoma", Font.BOLD, 14));
		quitter.setBounds(259, 803, 268, 50);
		quitter.addActionListener(this);
		container.add(quitter);
		
		
		this.setVisible(true);
	}
	
	// Action des boutons
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
 
		if(source == quitter){
			System.exit(0);
		} 
		if(source == ajoutProfil){
			ajoutProf=new FormulaireCand();	
			this.setVisible(false);
			this.dispose();

		}
		
		if(source== rechercherCandidat ){
			rechercheCand=new RechercheCritere();
			this.setVisible(false);
			this.dispose();

		}
	}
}
