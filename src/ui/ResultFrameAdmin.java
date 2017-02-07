package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Recherche.Billet;
import Recherche.Demande;
import Recherche.Recherche;

/**
 * 
 * Création de la fenetre administrateur qui affiche tous les candidats 
 * de la base de données. Avec possibilité de les supprimer.
 */
@SuppressWarnings({ "unused", "serial" })
public class ResultFrameAdmin extends TailleFenetre implements ActionListener {

	private JPanel container;
	private JPanel containerB;
	protected MenuHeader menu;
	
	private JLabel phraseAdmin;
	
	private JButton nvlRecherche;
	private RechercheCritere rechercherCand;
	
	private JButton deconnexion;
	private Accueil ChAccueil;
	
	private JButton valSelection;
	private ValidationSuppression fenetreSelect;
	
	private JCheckBox check;
	private boolean itemChecked=false;
	
	protected HashMap<JCheckBox, ProfilCandidats> map;
	
	/**
	 * Affichage des candidats de la base de donées
	 */
	public ResultFrameAdmin() {
		
		super();
		
		getContentPane().setLayout(new BorderLayout());
		
		// Menu 
		menu = new MenuHeader();
		menu.setLocation(0, 0);
		menu.setSize(844, 37);
		
		getContentPane().add(menu, BorderLayout.NORTH);
		
		container = new JPanel();
		container.setBackground(UIManager.getColor("Button.background"));
		
		// Création du billet avec tous les candidats
		Recherche recherche= new Recherche();
		int taille=recherche.getAllResults().size();
				
		container.setPreferredSize(new Dimension((int) d.getWidth()-25, taille*201-500));
		container.setLayout(null);	
		
		map = new HashMap<JCheckBox, ProfilCandidats>();
		
		// Affichage de tous les candidats
	    ProfilCandidats pc;	    
	    int y=100;
		for (Billet entry : recherche.getAllResults()) {
	    	pc= new ProfilCandidats(entry);
	    	pc.setBounds(40,y, 900, 160);
	    	container.add(pc);
	    	
	    	check  = new JCheckBox() ;
		    check.setBounds(10, y, 50, 70);
			container.add(check);
			map.put(check,pc);
			check.setVisible(true);
	    	
	    	y=y+200;	    	
		}
		
		// Création de la Scroll barre
		JScrollPane jsp = new JScrollPane(container);
		jsp.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(jsp, BorderLayout.CENTER);
				
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setBackground(UIManager.getColor("Button.background"));
		container.setLayout(null);
		
		
		// Bouton supprimer
		valSelection = new JButton ("Valider la suppression");
		valSelection.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		valSelection.setBounds(250, y, 350, 50);
		valSelection.addActionListener(this);
		container.add(valSelection);
		
		
		// Création un bouton de déconnexion
		deconnexion = new JButton ("Deconnexion");
		deconnexion.setFont(new Font("Tahoma", Font.BOLD, 14));
		deconnexion.setBounds(320, y+100, 200, 50); 
		deconnexion.addActionListener(this);
		container.add(deconnexion);

		// Phrase de début
		JLabel phraseAdmin = new JLabel("Voici tous les candidats de la base de données.");
		phraseAdmin.setForeground(new Color(50, 205, 50));
		phraseAdmin.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		phraseAdmin.setBounds(149, 16, 600, 28);
		container.add(phraseAdmin);				
		
		this.setVisible(true);	        
	}
	
	/**
	 * Action sur les boutons
	 */
	  public void actionPerformed(ActionEvent e) {
		  Object source = e.getSource();
		  
		  int i=0;
		  if(source ==valSelection){
			  for(Entry<JCheckBox, ProfilCandidats> entry : map.entrySet()) {
					JCheckBox cle = entry.getKey();
					if(cle.isSelected()){
						itemChecked=true;
					}
			  }
				if(itemChecked){
					fenetreSelect = new ValidationSuppression();
					this.setVisible(false);
					this.dispose();
					/*ProfilCandidats valeur = entry.getValue();
				    System.out.println("ProfilCAndidats:"+valeur);*/
				}
			  
		  }
		  
		  if(source == deconnexion){
			  ConnexionAdmin.setSucceeded(false);
			  ChAccueil=new Accueil();
			  this.setVisible(false);
			  this.dispose();
		  } 

	  }
}
