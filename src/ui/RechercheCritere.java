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
import java.util.ArrayList;
import java.awt.event.AdjustmentEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Criteres.Critere;
import Criteres.ExperiencePro;
import Criteres.Filiere;
import Criteres.Langue;
import Criteres.NiveauEtude;
import Criteres.PermisB;
import Criteres.Region;
import Criteres.Age;
import Criteres.CDD;
import Criteres.CDI;
import Criteres.Interim;
import Criteres.Stage;
import Recherche.Billet;
import Recherche.Demande;
import database.Connect;

import javax.swing.ListSelectionModel;
import javax.swing.JTextPane;
import javax.swing.UIManager;


public class RechercheCritere extends TailleFenetre implements ActionListener {

	private JPanel container;
	protected MenuHeader menu;
		  
	private JComboBox boiteRegion;
	private JLabel region;
	private Critere reg;
	private boolean boolReg;
	  
	private JLabel permis;
	private ButtonGroup bgpermis;
	private JRadioButton oui;
	private JRadioButton non; 
	private JRadioButton indifferent; 
	private Critere perm;
	private boolean boolPerm;
	
	private JLabel age;
	private JSpinner boiteAgeMin;
	private JSpinner boiteAgeMax;
	private Critere Ag;
	private int value;
	  
	private JLabel typEmploi;
	private ButtonGroup bgEmploi;
	private JRadioButton stage;
	private JRadioButton interim; 
	private JRadioButton CDD;
	private JRadioButton CDI;
	private Critere empl;

	  
	private JComboBox boiteNivEtude;
	private JLabel nivEtude;
	private Critere etu;

	  
	private JComboBox boiteFiliere;
	private JLabel filiere;
	private Critere fil;

	  
	private JSpinner boiteExperience;
	private JSpinner spinner;
	private JLabel experience;
	private Critere exp;

	
	private JLabel languesPratique;
	private JList anglais;
	private JList allemand;
	private JList chinois;
	private JList espagnole;
	private JList italien;
	private String ang;
	private String all;
	private String chi;
	private String esp;
	private String ita;
	private boolean boolLang=false;

	private JTextPane ExpA;
	private JTextPane ExpB;
	private JTextPane ExpC;
	
	private JButton retour;
	private JButton chercher;
	
	private Choix retourAccueil;
	private ResultFrame rechercherCand;
	
	protected JLabel FormulaireFaux;
	
	private Demande demand;
	
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
		
		// Phrase du d�but
		JLabel label = new JLabel("Veuillez entrer vos crit�res de recherche.  ");
		label.setBounds(243, 53, 380, 24);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		container.add(label);
		  
		  
		//R�gion
		region = new JLabel("R�gion de r�sidence");
		region.setBounds(15, 117, 142, 20);
		container.add(region);
		boiteRegion = new JComboBox();
		boiteRegion.setBounds(176, 114, 281, 28);
		boiteRegion.setPreferredSize(new Dimension(320, 50));
		boiteRegion.addItem("Indiff�rent");
		boiteRegion.addItem("Alsace");		
		boiteRegion.addItem("Aquitaine");
		boiteRegion.addItem("Auvergne");
		boiteRegion.addItem("Basse Normandie");
		boiteRegion.addItem("Bourgogne");
		boiteRegion.addItem("Bretagne");
		boiteRegion.addItem("Centre");
		boiteRegion.addItem("Champagne-Ardenne");
		boiteRegion.addItem("Corse");
		boiteRegion.addItem("Franche-Comt�");
		boiteRegion.addItem("Haute Normandie");
		boiteRegion.addItem("Ile-de-France");
		boiteRegion.addItem("Languedoc-Roussillon");
		boiteRegion.addItem("Limousin");
		boiteRegion.addItem("Lorraine");
		boiteRegion.addItem("Midi-Pyr�n�es");
		boiteRegion.addItem("Nord-Pas-de-Calais");
		boiteRegion.addItem("Pays de la Loire");
		boiteRegion.addItem("Picardie");
		boiteRegion.addItem("Poitou-Charentes");
		boiteRegion.addItem("Provence-Alpes-C�te-d'Azur");
		boiteRegion.addItem("Rh�ne-Alpes");
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
		indifferent = new JRadioButton("indiff�rent");
		indifferent.setBounds(715, 112, 105, 29);
		indifferent.setSelected ( true );
		indifferent.addActionListener(this);
		bgpermis.add(indifferent);
		container.add(indifferent);

		bgpermis.add(non);
		container.add(non);	
		
		// Tranche d'�ge
		age = new JLabel("Tranche d'�ge");
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
		
		interim = new JRadioButton("Int�rim");
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
		  
		//Niveau d'�tude
		nivEtude = new JLabel("Niveau d'�tude");
		nivEtude.setBounds(235, 318, 104, 20);
		container.add(nivEtude);
		boiteNivEtude = new JComboBox();
		boiteNivEtude.setBounds(354, 314, 269, 28);
		boiteNivEtude.setPreferredSize(new Dimension(300, 50));
		boiteNivEtude.addItem("Employ�/Op�rateur/Bac");
		boiteNivEtude.addItem("Technicien/Employ� bac+2");
		boiteNivEtude.addItem("Licence/Bac+3");
		boiteNivEtude.addItem("Ing�nieur/Cadre/Bac+5");
		boiteNivEtude.addItem("Doctorant/Bac+7");
		container.add(boiteNivEtude);
		
		  
		//Fili�re / Domaine comp�tence
		filiere = new JLabel("Domaine comp�tence");
		filiere.setBounds(135, 383, 160, 22);
		container.add(filiere);
		boiteFiliere = new JComboBox();
		boiteFiliere.setBounds(312, 380, 375, 28);
		boiteFiliere.setPreferredSize(new Dimension(420, 50));
		boiteFiliere.addItem("Assistanat/Adm.ventes/Accueil");
		boiteFiliere.addItem("Bureau d'Etudes/R&D/BTP archi/conception");
		boiteFiliere.addItem("Commercial/Technico-Commercial");
		boiteFiliere.addItem("Compta/Gestion/Finance/Audit");
		boiteFiliere.addItem("Informatique - D�veloppement");
		boiteFiliere.addItem("Informatique - Syst�mes d'Information");
		boiteFiliere.addItem("Informatique - Syst�mes/R�seaux");
		boiteFiliere.addItem("Ing�nierie - Chimie/Pharmacie/Bio");
		boiteFiliere.addItem("Ing�nierie - Electro-tech./Automat");
		boiteFiliere.addItem("Juridique/Droit");
		boiteFiliere.addItem("Marketing/Communication/Graphisme");
		boiteFiliere.addItem("M�tiers de la Fonction Publique");
		boiteFiliere.addItem("Restauration/Tourisme/H�tellerie/Loisirs");
		container.add(boiteFiliere);
		
		  
		// Ann�e experience
		experience = new JLabel("Ann�e(s) d'exp�rience(s)");
		experience.setBounds(277, 444, 220, 22);
		experience.setForeground(Color.BLACK);
		container.add(experience);
		boiteExperience = new JSpinner();
		boiteExperience.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		boiteExperience.setBounds(512, 441, 49, 28);
		boiteExperience.setPreferredSize(new Dimension(50, 50));
		boiteExperience.setForeground(Color.GRAY);
		container.add(boiteExperience);
		 
		 
		// Langues pratiqu�
		languesPratique = new JLabel("Langue(s) pratiqu�e(s)");
		languesPratique.setBounds(354, 518, 160, 20);
		container.add(languesPratique);
		
		  // Anglais
		anglais = new JList();
		anglais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		anglais.setValueIsAdjusting(true);
		anglais.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		anglais.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indiff�rent", "Anglais A1", "Anglais A2", "Anglais B1", "Anglais B2", "Anglais C1", "Anglais C2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		anglais.setBounds(33, 564, 124, 158);
		container.add(anglais);
		
		allemand = new JList();
		allemand.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indiff�rent", "Allemand A1", "Allemand A2", "Allemand B1", "Allemand B2", "Allemand C1", "Allemand C2"};
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
		
		espagnole = new JList();
		espagnole.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indiff�rent", "Espagnol A1", "Espagnol A2", "Espagnol B1", "Espagnol B2", "Espagnol C1", "Espagnol C2"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		espagnole.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		espagnole.setValueIsAdjusting(true);
		espagnole.setToolTipText("");
		espagnole.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		espagnole.setBounds(367, 566, 124, 158);
		container.add(espagnole);
		
		italien = new JList();
		italien.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indiff�rent", "Italien A1", "Italien A2", "Italien B1", "Italien B2", "Italien C1", "Italien C2"};
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
		
		chinois= new JList();
		chinois.setModel(new AbstractListModel() {
			String[] values = new String[] {"Indiff�rent", "Chinois A1", "Chinois A2", "Chinois B1", "Chinois B2", "Chinois C1", "Chinois C2"};
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
		
		// Aide pour la comp�tence langue 
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
			    		ExpA.setText("A1 : Peut comprendre et utiliser des expressions famili�res.\n "
			    				+ "A2 : Peut comprendre des phrases isol�es et des expressions fr�quemment utilis�es.\n "
			    				+ "B1 : Peut comprendre les points essentiels quand un langage clair et standard est utilis�.\n "
			    				+ "B2 : Peut comprendre le contenu essentiel de sujets dans un texte complexe, y compris une discussion technique. Peut communiquer avec un degr� de spontan�it� et d'aisance.\n"
			    				+ "C1 : Peut comprendre une grande gamme de textes longs et exigeants. Peut s'exprimer spontan�ment et couramment.\n"
			    				+ "C2 : Peut comprendre sans effort pratiquement tout ce qu'il/elle lit ou entend. Peut s'exprimer spontan�ment, tr�s couramment et de fa�on pr�cise.");
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
		

		
		JLabel AgeA = new JLabel("�");
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
	
			// Lancement de la comparaison globale :
		  
		  //Connect database = Connect.getInstance();

		  //Billet newresults = newsearch.findInDB(database.getDB());

		  if(source == chercher){
			   RecupererFormulaire(); 		  
			  	  
			  rechercherCand=new ResultFrame(demand); // il faut metre ce qu'on a r�cup�rer de la base de donn�e
			  this.setVisible(false);
			  this.dispose();
		  } 
		  if(source == retour){
			  retourAccueil=new Choix();	
			  this.setVisible(false);
			  this.dispose();
		  }
	  }
	  
	  
	  public void RecupererFormulaire(){
		  
		  // Region
		  if (((String) boiteRegion.getSelectedItem()) == "Indiff�rent"){
			  boolReg = false;
		  }
		  else{
			  reg= new Region((String) boiteRegion.getSelectedItem());
			  boolReg = true;
		  }
		  
		  // Permis
		  if (oui.isSelected()){
			  perm= new PermisB(true); 
		  }
		  else if (non.isSelected()){
			  perm= new PermisB(false); 
		  }
		  else if (indifferent.isSelected()){
			  boolPerm=false;
		  }
		 
		  // Borne Age
		  if((Integer)boiteAgeMin.getValue()<= (Integer)boiteAgeMax.getValue()){
			  Ag= new Age (((Integer)boiteAgeMin.getValue()),((Integer)boiteAgeMax.getValue()));
		  }
		  else
			  Ag= new Age (((Integer)boiteAgeMax.getValue()),((Integer)boiteAgeMin.getValue()));

		  // Emploi
		  if (stage.isSelected()){
			  empl = new Stage(true);		  
		  }
		  else if (CDD.isSelected()){
			  empl = new CDD(true);
		  }
		  else if (CDI.isSelected()){
			  empl = new CDI(true);
		  }
		  else if (interim.isSelected()){
			  empl = new Interim(true);
		  }
		  
		  // Niveau d'�tude
		  if((String) boiteNivEtude.getSelectedItem()== "Employ�/Op�rateur/Bac"){
			  etu= new NiveauEtude(0);  
		  }
		  if((String) boiteNivEtude.getSelectedItem()== "Technicien/Employ� bac+2"){
			  etu= new NiveauEtude(2);  
		  }
		  if((String) boiteNivEtude.getSelectedItem()== "Licence/Bac+3"){
			  etu= new NiveauEtude(3);  
		  }
		  if((String) boiteNivEtude.getSelectedItem()== "Ing�nieur/Cadre/Bac+5"){
			  etu= new NiveauEtude(5);  
		  }
		  if((String) boiteNivEtude.getSelectedItem()== "Doctorant/Bac+7"){
			  etu= new NiveauEtude(7);  
		  }
		  
		  fil= new Filiere((String) boiteFiliere.getSelectedItem());
		  exp = new ExperiencePro((Integer)boiteExperience.getValue());
		 
		  
		  ArrayList<Critere> crit = new ArrayList<>();
		  crit.add(fil);
		  crit.add(empl);
		  crit.add(Ag);
		  crit.add(perm);
		  crit.add(reg);
		  crit.add(etu);
		  crit.add(exp);
		  
		  //recuperer les langues 
		  ArrayList<String> tmp = new ArrayList<>();
		  	  
		  if((String)anglais.getSelectedValue()!="Indiff�rent"){
			  if((String)anglais.getSelectedValue()=="Anglais A1"){
				  ang= "Anglais 1";
			  }
			  if((String)anglais.getSelectedValue()=="Anglais A2"){
				  ang= "Anglais 2";
			  }			  
			  if((String)anglais.getSelectedValue()=="Anglais B1"){
				  ang= "Anglais 3";
			  }		  
			  if((String)anglais.getSelectedValue()=="Anglais B2"){
				  ang= "Anglais 4";
			  }
			  if((String)anglais.getSelectedValue()=="Anglais C1"){
				  ang= "Anglais 5";
			  }
			  if((String)anglais.getSelectedValue()=="Anglais C2"){
				  ang= "Anglais 6";
			  }
			  boolLang=true;
			  tmp.add(ang);
		  }
		  
		  if((String)espagnole.getSelectedValue()!="Indiff�rent"){
			  if((String)espagnole.getSelectedValue()=="Espagnol A1"){
				  esp= "Espagnol 1";
			  }
			  if((String)espagnole.getSelectedValue()=="Espagnol A2"){
				  esp= "Espagnol 2";
			  }			  
			  if((String)espagnole.getSelectedValue()=="Espagnol B1"){
				  esp= "Espagnol 3";
			  }		  
			  if((String)espagnole.getSelectedValue()=="Espagnol B2"){
				  esp= "Espagnol 4";
			  }
			  if((String)espagnole.getSelectedValue()=="Espagnol C1"){
				  esp= "Espagnol 5";
			  }
			  if((String)espagnole.getSelectedValue()=="Espagnol C2"){
				  esp= "Espagnol 6";
			  }
			  boolLang=true;
			  tmp.add(esp);
		  }
		  
		  if((String)allemand.getSelectedValue()!="Indiff�rent"){
			  if((String)allemand.getSelectedValue()=="Allemand A1"){
				  all= "Allemand 1";
			  }
			  if((String)allemand.getSelectedValue()=="Allemand A2"){
				  all= "Allemand 2";
			  }			  
			  if((String)allemand.getSelectedValue()=="Allemand B1"){
				  all= "Allemand 3";
			  }		  
			  if((String)allemand.getSelectedValue()=="Allemand B2"){
				  all= "Allemand 4";
			  }
			  if((String)allemand.getSelectedValue()=="Allemand C1"){
				  all= "Allemand 5";
			  }
			  if((String)allemand.getSelectedValue()=="Allemand C2"){
				  all= "Allemand 6";
			  }
			  boolLang=true;
			  tmp.add(all);
		  }

		  if((String)chinois.getSelectedValue()!="Indiff�rent"){
			  if((String)chinois.getSelectedValue()=="Chinois A1"){
				  chi= "Chinois 1";
			  }
			  if((String)chinois.getSelectedValue()=="Chinois A2"){
				  chi= "Chinois 2";
			  }			  
			  if((String)chinois.getSelectedValue()=="Chinois B1"){
				  chi= "Chinois 3";
			  }		  
			  if((String)chinois.getSelectedValue()=="Chinois B2"){
				  chi= "Chinois 4";
			  }
			  if((String)chinois.getSelectedValue()=="Chinois C1"){
				  chi= "Chinois 5";
			  }
			  if((String)chinois.getSelectedValue()=="Chinois C2"){
				  chi= "Chinois 6";
			  }
			  boolLang=true;
			  tmp.add(chi);
		  }
		  
		  if((String)italien.getSelectedValue()!="Indiff�rent"){
			  if((String)italien.getSelectedValue()=="Italien A1"){
				  ita= "Italien 1";
			  }
			  if((String)italien.getSelectedValue()=="Italien A2"){
				  ita= "Italien 2";
			  }			  
			  if((String)italien.getSelectedValue()=="Italien B1"){
				  ita= "Italien 3";
			  }		  
			  if((String)italien.getSelectedValue()=="Italien B2"){
				  ita= "Italien 4";
			  }
			  if((String)italien.getSelectedValue()=="Italien C1"){
				  ita= "Italien 5";
			  }
			  if((String)italien.getSelectedValue()=="Italien C2"){
				  ita= "Italien 6";
			  }
			  boolLang=true;
			  tmp.add(ita);
		  }
		  Langue langue = new Langue(tmp);
		  crit.add(langue);
		  
		  boolean [] bb={true,boolPerm,boolReg,true,true,boolLang} ;
		  demand = new Demande(crit, bb);

	  }
	  

}
	
