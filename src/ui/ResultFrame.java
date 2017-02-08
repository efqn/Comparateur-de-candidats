package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Candidat.Candidat;
import Criteres.Critere;
import Recherche.Billet;
import Recherche.Demande;
import net.miginfocom.swing.MigLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.Color;

/**
 * 
 * Affichage de la fenetre de résulat d'une recherche
 *
 */

@SuppressWarnings({ "unused", "serial" })
public class ResultFrame extends TailleFenetre implements ActionListener,ItemListener {

	private JPanel container;
	private JPanel containerB;
	protected MenuHeader menu;
	
	private Billet r1;
	
	private JLabel phraseRecr;
	
		
	private JButton nvlRecherche;
	private RechercheCritere rechercherCand;
	
	private JButton accueil;
	private Accueil ChAccueil;
	
	private JButton valSelection;
	private ValidationSelection fenetreSelect;
	
	private JCheckBox check;
	private boolean itemChecked=false;
	
	protected HashMap<JCheckBox, ProfilCandidats> map;
	
	private Demande r;
	
	/**
	 * 
	 * @param r  Tous les résultats des candidats d'une recherche
	 */
	public ResultFrame( Demande r) {
		super();
		
		this.r=r;
			
		getContentPane().setLayout(new BorderLayout());
		
		// Menu 
		menu = new MenuHeader();
		menu.setLocation(0, 0);
		menu.setSize(844, 37);
		
		getContentPane().add(menu, BorderLayout.NORTH);
		
		container = new JPanel();
		container.setBackground(UIManager.getColor("Button.background"));
		
		container.setPreferredSize(new Dimension((int) d.getWidth()-25, 10*210+200));
		container.setLayout(null);

		// Création de l'arrayList de résultats de la recherche.
		ArrayList<Billet> rl = r.getResultats();
		
		// Affichage de chaque candidats
	    ProfilCandidats pc; 
	    int y=100;

		map = new HashMap<JCheckBox, ProfilCandidats>();
		
		for (Billet entry : rl) {
	    	pc= new ProfilCandidats(entry);
	    	pc.setBounds(50,y, 900, 160);
	    	container.add(pc);
	    	
	    	check  = new JCheckBox() ;
		    check.setBounds(10, y, 50, 70);
			container.add(check);
			map.put(check,pc);
			check.setVisible(true);
	    	
	    	y=y+200;
		}	

		
		
		// Création de la scroll barre
		JScrollPane jsp = new JScrollPane(container);
		jsp.getVerticalScrollBar().setUnitIncrement(16);
		getContentPane().add(jsp, BorderLayout.CENTER);
		
		
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setBackground(UIManager.getColor("Button.background"));
		container.setLayout(null);
		
	/*	// Jlabel selectionner
		JLabel selectionCand = new JLabel("Quel(s) candidat(s) voulez vous selectionner?");
		selectionCand.setForeground(new Color(50, 205, 50));
		selectionCand.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		selectionCand.setBounds(170, y, 491, 28);
		container.add(selectionCand);	*/
		
		// Bouton  valider selection
		valSelection = new JButton ("Valider Selection(s)");
		valSelection.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		valSelection.setBounds(250, y+30, 300, 50);
		valSelection.addActionListener(this);
		container.add(valSelection);
		
		// Bouton nouvelle recherche
		nvlRecherche = new JButton ("Nouvelle recherche");
		nvlRecherche.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		nvlRecherche.setBounds(402, y+140, 200, 50);
		nvlRecherche.addActionListener(this);
		container.add(nvlRecherche);

		// Bouton retour menu
		accueil = new JButton ("Retour Menu");
		accueil.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		accueil.setBounds(199, y+140, 200, 50); 
		accueil.addActionListener(this);
		container.add(accueil);

		// Phrase de début
		JLabel phraseRecr = new JLabel("Voici les 10 meilleurs candidats selon vos critères.");
		phraseRecr.setForeground(new Color(50, 205, 50));
		phraseRecr.setFont(new Font("Tw Cen MT", Font.BOLD, 25));
		phraseRecr.setBounds(149, 16, 530, 28);
		container.add(phraseRecr);	

		
		
		this.setVisible(true);

	        
	}
	
	/**
	 * Action sur les bouton
	 */
	  public void actionPerformed(ActionEvent e) {
		  Object source = e.getSource();
		  int i=0;
		  if(source ==valSelection){
			  for(Entry<JCheckBox, ProfilCandidats> entry : map.entrySet()) {
					JCheckBox cle = entry.getKey();
					if(cle.isSelected()){
						ProfilCandidats tmp= entry.getValue();
						Billet tmp2= tmp.getBillet();
						r.insertEntryIntoDatabase(tmp2.getID_crit());
						itemChecked=true;
					}
			  }
				if(itemChecked){
					fenetreSelect = new ValidationSelection();
					this.setVisible(false);
					this.dispose();
					/*ProfilCandidats valeur = entry.getValue();
				    System.out.println("JCHECKBOS:"+cle);
				    System.out.println("ProfilCAndidats:"+valeur);*/
				}
			  
		  }
			 
		  
		  if(source == nvlRecherche){
			  rechercherCand=new RechercheCritere();
			  this.setVisible(false);
			  this.dispose();
		  } 
		  if(source == accueil){
			  ChAccueil=new Accueil();	
			  this.setVisible(false);
			  this.dispose();
		  }
	  }


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	  
}