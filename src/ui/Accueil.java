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


/**
 * 
 * @author Utilisateur
 *  Fenêtre d'accueil du comparateur de candidats
 */

@SuppressWarnings("unused")
public class Accueil extends TailleFenetre implements ActionListener {
	
	private JPanel container;
	private JLabel phraseDebut;
	
	private JButton ajoutProfil;
	private JButton rechercherCandidat;
	private JButton quitter;
	
	private FormulaireCand ajoutProf;
	private RechercheCritere rechercheCand;
	
	protected MenuHeader menu;
	
	/**
	 * Constructeur de la classe Accueil
	 */
	public Accueil(){
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
		phraseDebut.setForeground(new Color(0, 0, 0));
		phraseDebut.setFont(new Font("Tw Cen MT", Font.PLAIN, 30));
		phraseDebut.setBounds(127, 108, 588, 33);
		container.add(phraseDebut);
		
		// Bouton ajouter profil candidat
		ajoutProfil = new JButton("Ajouter mon profil candidat");
		ajoutProfil.setBackground(UIManager.getColor("activeCaption"));
		ajoutProfil.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		ajoutProfil.setBounds(51, 217, 348, 179);
		ajoutProfil.addActionListener(this);
		container.add(ajoutProfil);
		
		// Bouton rechercher candidats
		rechercherCandidat = new JButton("Rechercher des candidats");
		rechercherCandidat.setBackground(UIManager.getColor("activeCaption"));
		rechercherCandidat.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		rechercherCandidat.setBounds(442, 217, 348, 179);
		rechercherCandidat.addActionListener(this);
		container.add(rechercherCandidat);
		
		// Bouton quitter
		quitter = new JButton("Quitter");
		quitter.setBackground(UIManager.getColor("activeCaption"));
		quitter.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		quitter.setBounds(242, 445, 348, 179);
		quitter.addActionListener(this);
		container.add(quitter);
		
		
		this.setVisible(true);
	}
	
	/**
	 *  Action faites sur les boutons
	 */
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
