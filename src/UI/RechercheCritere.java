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
import java.awt.event.AdjustmentEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;


public class RechercheCritere extends JFrame implements ActionListener {
	private JFrame frame;
	private JPanel container;
	  
	private JSpinner boiteAge;
	private JLabel age;
	  
	private JComboBox boiteRegion;
	private JLabel region;
	  
	private JLabel permis;
	private ButtonGroup bgpermis;
	private JRadioButton oui;
	private JRadioButton non; 
	private JRadioButton indifferent; 
	
	private JLabel lblDe;
	private JLabel lblA;
	  
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
	private JLabel experience;
	
	private JLabel languesPratique;
	private JTextPane ExpA;
	private JTextPane ExpB;
	private JTextPane ExpC;

	
	private JButton retour;
	private JButton ajouter;
	
	private Choix retourAccueil;
	


	 
	public RechercheCritere(){		  
		// Fenetre du formulaire
		setTitle("Recherche de candidats");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 1000,1000);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setBackground(Color.white);
		container.setLayout(null);
		  
		// Phrase du début
		JLabel label = new JLabel("Veuillez rentrer vos critères de recherche.  ");
		label.setBounds(307, 47, 380, 24);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		container.add(label);
		  
		  
		//Région
		region = new JLabel("Région de résidence");
		region.setBounds(68, 123, 181, 22);
		container.add(region);
		boiteRegion = new JComboBox();
		boiteRegion.setBounds(229, 120, 281, 28);
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
		permis.setBounds(583, 121, 80, 22);		  		  		  
		container.add(permis);	
		bgpermis = new ButtonGroup ();
		oui = new JRadioButton("oui");
		oui.setBounds(668, 117, 59, 31);
		oui.setSelected ( true );
		oui.addActionListener(this);
		bgpermis.add(oui);
		container.add(oui);
		non = new JRadioButton("non");
		non.setBounds(732, 117, 65, 31);
		non.addActionListener(this);
		indifferent = new JRadioButton("indifférent");
		indifferent.setBounds(804, 118, 105, 29);
		indifferent.setSelected ( true );
		indifferent.addActionListener(this);
		bgpermis.add(indifferent);
		container.add(indifferent);

		bgpermis.add(non);
		container.add(non);	
		
		// Tranche d'âge
		age = new JLabel("Tranche d'âge");
		age.setBounds(329, 197, 99, 20);
		age.setForeground(Color.BLACK);
		container.add(age);
		boiteAge = new JSpinner();
		boiteAge.setModel(new SpinnerNumberModel(16, 16, 60, 1));
		boiteAge.setBounds(509, 193, 46, 28);
		boiteAge.setPreferredSize(new Dimension(50, 50));
		boiteAge.setForeground(Color.GRAY);
		container.add(boiteAge);
		
		
		lblDe = new JLabel("De");
		lblDe.setBounds(475, 197, 19, 20);
		container.add(lblDe);
		lblA = new JLabel("à");
		lblA.setBounds(570, 197, 8, 20);
		container.add(lblA);
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(16, 16, 60, 1));
		spinner.setPreferredSize(new Dimension(50, 50));
		spinner.setForeground(Color.GRAY);
		spinner.setBounds(593, 194, 46, 28);
		container.add(spinner);
		  
		  		  
		//Type d'emploi
		typEmploi = new JLabel("Type d'emploi");
		typEmploi.setBounds(252, 272, 124, 22); 		  
		container.add(typEmploi);
		bgEmploi = new ButtonGroup ();
		stage = new JRadioButton("Stage");
		stage.setBounds(391, 268, 83, 31);
		stage.setSelected ( true );
		stage.addActionListener(this);
		bgEmploi.add(stage);
		container.add(stage);
		
		interim = new JRadioButton("Intérim");
		interim.setBounds(481, 268, 95, 31);
		interim.setSelected ( true );
		interim.addActionListener(this);
		bgEmploi.add(interim);
		container.add(interim);	
		
		CDD = new JRadioButton("CDD");
		CDD.setBounds(583, 268, 71, 31);
		CDD.setSelected ( true );
		CDD.addActionListener(this);
		bgEmploi.add(CDD);
		container.add(CDD);
		
		CDI = new JRadioButton("CDI");
		CDI.setBounds(661, 268, 63, 31);
		CDI.setSelected ( true );
		CDI.addActionListener(this);
		bgEmploi.add(CDI);
		container.add(CDI);
		  
		//Niveau d'étude
		nivEtude = new JLabel("Niveau d'étude");
		nivEtude.setBounds(303, 349, 104, 20);
		container.add(nivEtude);
		boiteNivEtude = new JComboBox();
		boiteNivEtude.setBounds(422, 345, 269, 28);
		boiteNivEtude.setPreferredSize(new Dimension(300, 50));
		boiteNivEtude.addItem("BEP/CAP");
		boiteNivEtude.addItem("Employé/Opérateur/Bac");
		boiteNivEtude.addItem("Technicien/Employé bac+2");
		boiteNivEtude.addItem("Ingénieur/Cadre/Bac+5");
		container.add(boiteNivEtude);
		
		  
		//Filière / Domaine compétence
		filiere = new JLabel("Domaine compétence");
		filiere.setBounds(203, 414, 160, 22);
		container.add(filiere);
		boiteFiliere = new JComboBox();
		boiteFiliere.setBounds(380, 411, 375, 28);
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
		experience.setBounds(345, 475, 220, 22);
		experience.setForeground(Color.BLACK);
		container.add(experience);
		boiteExperience = new JSpinner();
		boiteExperience.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		boiteExperience.setBounds(580, 472, 49, 28);
		boiteExperience.setPreferredSize(new Dimension(50, 50));
		boiteExperience.setForeground(Color.GRAY);
		container.add(boiteExperience);
		 
		 
		// Langues pratiqué
		languesPratique = new JLabel("Langue(s) pratiquée(s)");
		languesPratique.setBounds(422, 549, 160, 20);
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
		anglais.setBounds(79, 595, 124, 158);
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
		allemand.setBounds(252, 595, 124, 158);
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
		Espagnole.setBounds(435, 597, 124, 158);
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
		italien.setBounds(631, 597, 124, 158);
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
		chinois.setBounds(823, 597, 124, 158);
		container.add(chinois);
		
		ExpA = new JTextPane();
		ExpA.setFont(new Font("Tahoma", Font.ITALIC, 14));
		ExpA.setText("A1 : Peut comprendre et utiliser des expressions familières.\n A2 : Peut comprendre des phrases isolées et des expressions fréquemment utilisées.");
		ExpA.setBounds(15, 769, 262, 97);
		container.add(ExpA);
		
		ExpB = new JTextPane();
		ExpB.setFont(new Font("Tahoma", Font.ITALIC, 14));
		ExpB.setText("B1 : Peut comprendre les points essentiels quand un langage clair et standard est utilisé.\n B2 : Peut comprendre le contenu essentiel de sujets dans un texte complexe, y compris une discussion technique. Peut communiquer avec un degré de spontanéité et d'aisance.");
		ExpB.setBounds(307, 769, 312, 113);
		container.add(ExpB);
		
		ExpC = new JTextPane();
		ExpC.setFont(new Font("Tahoma", Font.ITALIC, 14));
		ExpC.setText("C1 : Peut comprendre une grande gamme de textes longs et exigeants. Peut s'exprimer spontanément et couramment.\nC2 : Peut comprendre sans effort pratiquement tout ce qu'il/elle lit ou entend. Peut s'exprimer spontanément, très couramment et de façon précise.");
		ExpC.setBounds(641, 771, 338, 126);
		container.add(ExpC);
		
		 
		// Bouton ajouter
		ajouter = new JButton ("rechercher");
		ajouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		ajouter.setBounds(283, 913, 191, 31);
		ajouter.addActionListener(this);
		container.add(ajouter);
			
		  		  
		//Bouton retour
		retour = new JButton ("Retour");
		retour.setFont(new Font("Tahoma", Font.BOLD, 14));
		retour.setBounds(572, 913, 91, 31);
		retour.addActionListener(this);
		container.add(retour);
				
		
		this.setContentPane(container);
		this.setVisible(true);
	  }
	  
	
	  // Action des boutons
	  public void actionPerformed(ActionEvent e) {
		  Object source = e.getSource();
		  if(source == ajouter){
		  } 
		  if(source == retour){
			  retourAccueil=new Choix();	
			  this.setVisible(false);
			  this.dispose();
		  }
	  }
	  
	  
}
	
