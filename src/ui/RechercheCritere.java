package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;
import javax.swing.JSlider;
import javax.swing.JProgressBar;
import javax.swing.SpinnerNumberModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import java.awt.event.AdjustmentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.AdjustmentEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.UIManager;


public class RechercheCritere extends TailleFenetre implements ActionListener {

	private JPanel container;
	protected MenuHeader menu;
	
	private JLabel age;
	  
	private JComboBox boiteRegion;
	private JLabel region;
	  
	private JLabel permis;
	private ButtonGroup bgpermis;
	private JRadioButton oui;
	private JRadioButton non; 
	private JRadioButton indifferent; 
	
	private JSpinner boiteAgeMin;
	private JSpinner boiteAgeMax;
	private int value;
	  
	private JLabel typEmploi;
	private ButtonGroup bgEmploi;
	private JRadioButton stage;
	private JRadioButton interim; 
	private JRadioButton CDD;
	private JRadioButton CDI;
	  
	private JComboBox boiteNivEtude;
	private JLabel nivEtude;
	  
	private JComboBox boiteFiliere;
	private JLabel filiere;
	  
	private JSpinner boiteExperience;
	private JSpinner spinner;
	private JLabel experience;
	
	private JLabel languesPratique;
	private JTextPane ExpA;
	private JTextPane ExpB;
	private JTextPane ExpC;

	
	private JButton retour;
	private JButton chercher;
	
	private Choix retourAccueil;
	
	protected JLabel FormulaireFaux;
	
/********************** CONSTRUCTEUR ************************************/

	 
	public RechercheCritere(){		  
		// Fenetre du formulaire
		super();
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setBackground(UIManager.getColor("Button.background"));
		container.setLayout(null);
		this.setContentPane(container);
		
		// Menu 
		menu = new MenuHeader();
		menu.setLocation(0, 0);
		menu.setSize(844, 37);
		container.add(menu);
		
		// Phrase du début
		JLabel label = new JLabel("Veuillez entrer vos critères de recherche.  ");
		label.setBounds(243, 53, 380, 24);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		container.add(label);
		  
		  
		//Région
		region = new JLabel("Région de résidence");
		region.setBounds(15, 117, 142, 20);
		container.add(region);
		boiteRegion = new JComboBox();
		boiteRegion.setBounds(176, 114, 281, 28);
		boiteRegion.setPreferredSize(new Dimension(320, 50));
		boiteRegion.addItem("Indifférent");
		boiteRegion.addItem("Alsace");
		
		boiteRegion.addItem("Aquitaine");
		boiteRegion.addItem("Auvergne");
		boiteRegion.addItem("Basse Normandie");
		boiteRegion.addItem("Bourgogne");
		boiteRegion.addItem("Bretagne");
		boiteRegion.addItem("Centre");
		boiteRegion.addItem("Champagne-Ardenne");
		boiteRegion.addItem("Corse");
		boiteRegion.addItem("Franche-Comté");
		boiteRegion.addItem("Haute Normandie");
		boiteRegion.addItem("Ile-de-France");
		boiteRegion.addItem("Languedoc-Roussillon");
		boiteRegion.addItem("Limousin");
		boiteRegion.addItem("Lorraine");
		boiteRegion.addItem("Midi-Pyrénées");
		boiteRegion.addItem("Nord-Pas-de-Calais");
		boiteRegion.addItem("Pays de la Loiret");
		boiteRegion.addItem("Picardie");
		boiteRegion.addItem("Poitou-Charentes");
		boiteRegion.addItem("Provence-Alpes-Côte-d'Azur");
		boiteRegion.addItem("Rhône-Alpes");
		container.add(boiteRegion);
		  		  		  
		//Permis
		permis = new JLabel("Permis B");
		permis.setBounds(494, 115, 80, 22);		  		  		  
		container.add(permis);	
		bgpermis = new ButtonGroup ();
		oui = new JRadioButton("oui");
		oui.setBounds(579, 111, 59, 31);
		oui.setSelected ( true );
		oui.addActionListener(this);
		bgpermis.add(oui);
		container.add(oui);
		non = new JRadioButton("non");
		non.setBounds(643, 111, 65, 31);
		non.addActionListener(this);
		indifferent = new JRadioButton("indifférent");
		indifferent.setBounds(715, 112, 105, 29);
		indifferent.setSelected ( true );
		indifferent.addActionListener(this);
		bgpermis.add(indifferent);
		container.add(indifferent);

		bgpermis.add(non);
		container.add(non);	
		
		// Tranche d'âge
		age = new JLabel("Tranche d'âge");
		age.setBounds(261, 166, 99, 20);
		age.setForeground(Color.BLACK);
		container.add(age);
		  
		  		  
		//Type d'emploi
		typEmploi = new JLabel("Type d'emploi");
		typEmploi.setBounds(184, 241, 124, 22); 		  
		container.add(typEmploi);
		bgEmploi = new ButtonGroup ();
		stage = new JRadioButton("Stage");
		stage.setBounds(323, 237, 83, 31);
		stage.setSelected ( true );
		stage.addActionListener(this);
		bgEmploi.add(stage);
		container.add(stage);
		
		interim = new JRadioButton("Intérim");
		interim.setBounds(413, 237, 95, 31);
		interim.setSelected ( true );
		interim.addActionListener(this);
		bgEmploi.add(interim);
		container.add(interim);	
		
		CDD = new JRadioButton("CDD");
		CDD.setBounds(515, 237, 71, 31);
		CDD.setSelected ( true );
		CDD.addActionListener(this);
		bgEmploi.add(CDD);
		container.add(CDD);
		
		CDI = new JRadioButton("CDI");
		CDI.setBounds(593, 237, 63, 31);
		CDI.setSelected ( true );
		CDI.addActionListener(this);
		bgEmploi.add(CDI);
		container.add(CDI);
		  
		//Niveau d'étude
		nivEtude = new JLabel("Niveau d'étude");
		nivEtude.setBounds(235, 318, 104, 20);
		container.add(nivEtude);
		boiteNivEtude = new JComboBox();
		boiteNivEtude.setBounds(354, 314, 269, 28);
		boiteNivEtude.setPreferredSize(new Dimension(300, 50));
		boiteNivEtude.addItem("BEP/CAP");
		boiteNivEtude.addItem("Employé/Opérateur/Bac");
		boiteNivEtude.addItem("Technicien/Employé bac+2");
		boiteNivEtude.addItem("Ingénieur/Cadre/Bac+5");
		container.add(boiteNivEtude);
		
		  
		//Filière / Domaine compétence
		filiere = new JLabel("Domaine compétence");
		filiere.setBounds(135, 383, 160, 22);
		container.add(filiere);
		boiteFiliere = new JComboBox();
		boiteFiliere.setBounds(312, 380, 375, 28);
		boiteFiliere.setPreferredSize(new Dimension(420, 50));
		boiteFiliere.addItem("Assistanat/Adm.ventes/Accueil");
		boiteFiliere.addItem("Bureau d'Etudes/R&D/BTP archi/conception");
		boiteFiliere.addItem("Commercial/Technico-Commercial");
		boiteFiliere.addItem("Compta/Gestion/Finance/Audit");
		boiteFiliere.addItem("Informatique - Développement");
		boiteFiliere.addItem("Informatique - Systèmes d'Information");
		boiteFiliere.addItem("Informatique - Systèmes/Réseaux");
		boiteFiliere.addItem("Ingénierie - Chimie/Pharmacie/Bio");
		boiteFiliere.addItem("Ingénierie - Electro-tech./Automat");
		boiteFiliere.addItem("Juridique/Droit");
		boiteFiliere.addItem("Marketing/Communication/Graphisme");
		boiteFiliere.addItem("Métiers de la Fonction Publique");
		boiteFiliere.addItem("Restauration/Tourisme/Hôtellerie/Loisirs");
		container.add(boiteFiliere);
		
		  
		// Année experience
		experience = new JLabel("Année(s) d'expérience(s)");
		experience.setBounds(277, 444, 220, 22);
		experience.setForeground(Color.BLACK);
		container.add(experience);
		boiteExperience = new JSpinner();
		boiteExperience.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		boiteExperience.setBounds(512, 441, 49, 28);
		boiteExperience.setPreferredSize(new Dimension(50, 50));
		boiteExperience.setForeground(Color.GRAY);
		container.add(boiteExperience);
		 
		 
		// Langues pratiqué
		languesPratique = new JLabel("Langue(s) pratiquée(s)");
		languesPratique.setBounds(354, 518, 160, 20);
		container.add(languesPratique);
		
		  // Anglais
		JList anglais = new JList();
		anglais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		anglais.setValueIsAdjusting(true);
		anglais.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		anglais.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indifférent", "Anglais A1", "Anglais A2", "Anglais B1", "Anglais B2", "Anglais C1", "Anglais C2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		anglais.setBounds(33, 564, 124, 158);
		container.add(anglais);
		
		JList allemand = new JList();
		allemand.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indifférent", "Allemand A1", "Allemand A2", "Allemand B1", "Allemand B2", "Allemand C1", "Allemand C2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		allemand.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		allemand.setValueIsAdjusting(true);
		allemand.setToolTipText("");
		allemand.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		allemand.setBounds(197, 564, 124, 158);
		container.add(allemand);
		
		JList Espagnole = new JList();
		Espagnole.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indifférent", "Espagnol A1", "Espagnol A2", "Espagnol B1", "Espagnol B2", "Espagnol C1", "Espagnol C2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		Espagnole.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		Espagnole.setValueIsAdjusting(true);
		Espagnole.setToolTipText("");
		Espagnole.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		Espagnole.setBounds(367, 566, 124, 158);
		container.add(Espagnole);
		
		JList italien = new JList();
		italien.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indifférent", "Italien A1", "Italien A2", "Italien B1", "Italien B2", "Italien C1", "Italien C2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		italien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		italien.setValueIsAdjusting(true);
		italien.setToolTipText("");
		italien.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		italien.setBounds(539, 566, 124, 158);
		container.add(italien);
		
		JList chinois= new JList();
		chinois.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indifférent", "Chinois A1", "Chinois A2", "Chinois B1", "Chinois B2", "Chinois C1", "Chinois C2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		chinois.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chinois.setValueIsAdjusting(true);
		chinois.setToolTipText("");
		chinois.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		chinois.setBounds(702, 564, 124, 158);
		container.add(chinois);
		
		// Aide pour la compétence langue 
				JLabel Aide = new JLabel("*Aide choix niveau(x) de langue(s)");
				Aide.setFont(new Font("Tahoma", Font.ITALIC, 16));
				Aide.setForeground(Color.BLUE);
				Aide.setBounds(286, 834, 255, 20);
				container.add(Aide);
					
				// Affiche l'aide
				Aide.addMouseListener(new MouseListener() {
				     
			        public void mouseClicked(MouseEvent e){}
			 

			        public void mousePressed(MouseEvent e){}

			        
			        public void mouseReleased(MouseEvent e){}
			 

			       public void mouseEntered(MouseEvent e){
			        	ExpA = new JTextPane();
			    		ExpA.setFont(new Font("Tahoma", Font.ITALIC, 16));
			    		ExpA.setText("A1 : Peut comprendre et utiliser des expressions familières.\n "
			    				+ "A2 : Peut comprendre des phrases isolées et des expressions fréquemment utilisées.\n "
			    				+ "B1 : Peut comprendre les points essentiels quand un langage clair et standard est utilisé.\n "
			    				+ "B2 : Peut comprendre le contenu essentiel de sujets dans un texte complexe, y compris une discussion technique. Peut communiquer avec un degré de spontanéité et d'aisance.\n"
			    				+ "C1 : Peut comprendre une grande gamme de textes longs et exigeants. Peut s'exprimer spontanément et couramment.\n"
			    				+ "C2 : Peut comprendre sans effort pratiquement tout ce qu'il/elle lit ou entend. Peut s'exprimer spontanément, très couramment et de façon précise.");
			    		ExpA.setBounds(15, 369, 262, 497);
			    		container.add(ExpA);
			        }
			 

			        public void mouseExited(MouseEvent e)
			        {
			        	container.remove(ExpA);
			        	container.repaint();
			        }
			 
			    });
		
		 
		// Bouton ajouter
		chercher = new JButton ("Rechercher");
		chercher.setFont(new Font("Tahoma", Font.BOLD, 14));
		chercher.setBounds(283, 913, 123, 31);
		chercher.addActionListener(this);
		container.add(chercher);
			
		  		  
		//Bouton retour
		retour = new JButton ("Retour");
		retour.setFont(new Font("Tahoma", Font.BOLD, 14));
		retour.setBounds(450, 913, 91, 31);
		retour.addActionListener(this);
		container.add(retour);
		
		boiteAgeMin = new JSpinner();
		boiteAgeMin.setModel(new SpinnerNumberModel(18, 18, 60, 1));
		boiteAgeMin.setPreferredSize(new Dimension(50, 50));
		boiteAgeMin.setForeground(Color.GRAY);
		boiteAgeMin.setBounds(388, 163, 49, 28);
		value = ((Integer)boiteAgeMin.getValue());  
		container.add(boiteAgeMin);
		

		
		JLabel AgeA = new JLabel("à");
		AgeA.setForeground(Color.BLACK);
		AgeA.setBounds(469, 166, 8, 20);
		container.add(AgeA);
		
		boiteAgeMax = new JSpinner();
		boiteAgeMax.setModel(new SpinnerNumberModel(value, value, 61, 1));
		boiteAgeMax.setPreferredSize(new Dimension(50, 50));
		boiteAgeMax.setForeground(Color.GRAY);
		boiteAgeMax.setBounds(504, 163, 49, 28);
		container.add(boiteAgeMax);
		
		
		this.setVisible(true);
		
	  }
	  
/************************* METHODES	***************************************/
	
	  // Action des boutons
	  public void actionPerformed(ActionEvent e) {
		  Object source = e.getSource();
		  if(source == chercher){
		  } 
		  if(source == retour){
			  retourAccueil=new Choix();	
			  this.setVisible(false);
			  this.dispose();
		  }
	  }
	  
	  ArrayList<Critere> crit = new ArrayList<>();
	  //recup langue formulaire
	  ArrayList<String> tmp = new ArrayList<>();
	  //3 langues
	  value = chose;
	  tmp.add(value);
	  value2 = chose;
	  tmp.add(value2);
	  value3 = chose;
	  tmp.add(value3);
	  
	  Langue langue = new Langue(tmp);
	  crit.add(Langue);
	  

	  Demande demand = new Demande(arraylist, new boolean ={true,true,true,true,true,true});

}
	
