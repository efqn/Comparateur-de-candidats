package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.AbstractListModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import Candidat.Candidat;
import Criteres.Age;
import Criteres.CDD;
import Criteres.CDI;
import Criteres.Critere;
import Criteres.ExperiencePro;
import Criteres.Filiere;
import Criteres.Interim;
import Criteres.Langue;
import Criteres.NiveauEtude;
import Criteres.PermisB;
import Criteres.Region;
import Criteres.Stage;
import Recherche.Billet;
import Recherche.Demande;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;
import javax.swing.JList;


/**
 * 
 * @author Utilisateur
 *  Affichage et création du formulaire pour le candidat. Permet au candidat
 *  d'ajouter son profil sur la base de données. 
 *  On vérifie directement ici que le formulaire est rempli correctement.
 *  C'est ici directement que le profil est ajouté à la base de données.
 */

@SuppressWarnings("unused")
public class FormulaireCand extends TailleFenetre implements ActionListener{  

	protected JPanel container;
	protected MenuHeader menu;
	  
	protected JTextField boiteNom;
	protected JLabel nom;
	protected String n;
	  
	protected JTextField boitePrenom;
	protected JLabel prenom;
	protected String p;
  
	protected JSpinner boiteAge;
	protected JLabel age;
	private Critere ag;
	private int value;
	  
	protected JComboBox boiteRegion;
	protected JLabel region;
	private Critere reg;
	private boolean boolReg;
	  
	protected JTextField boiteNumero;
	protected JLabel numero;
	protected String num;
	  
	protected JTextField boiteEmail;
	protected JLabel email;
	protected String em;
	  
	protected JLabel permis;
	protected ButtonGroup bgpermis;
	protected JRadioButton oui;
	protected JRadioButton non;
	private Critere perm;
	private boolean boolPerm;
	  
	protected JLabel typEmploi;
	protected ButtonGroup bgEmploi;
	protected JRadioButton stage;
	protected JRadioButton interim; 
	protected JRadioButton CDD;
	protected JRadioButton CDI;
	private Critere empl;
	  
	protected JComboBox boiteNivEtude;
	protected JLabel nivEtude;
	private Critere etu;
	  
	protected JComboBox boiteFiliere;
	protected JLabel filiere;
	private Critere fil;
	  
	protected JSpinner boiteExperience;
	protected JLabel experience;
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
	
	protected JTextPane ExpA;
	
	  
	protected JButton retour;
	protected JButton ajouter;
	
	protected Accueil retourAccueil;
	protected ValidationProfil ajoutProfil;
	
	protected JLayeredPane layeredPane;

	private JLabel lblVousNavezPas;
	
	private Demande demand;
	
/**************************** CONSTRUCTEUR *********************************/
	
	/**
	 * Créer l'affichage du formualaire candidat.
	 */
	public FormulaireCand(){		  
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
		JLabel label = new JLabel("Veuillez remplir ce formulaire pour ajouter votre profil dans notre base de données.");
		label.setForeground(new Color(50, 205, 50));
		label.setBounds(28, 44, 801, 28);
		label.setFont(new Font("Tw Cen MT", Font.BOLD, 23));
		container.add(label);
		  
		// Création de la boite nom
		nom = new JLabel("Nom");
		nom.setBounds(66, 123, 41, 22);
		nom.setForeground(Color.BLACK);
		container.add(nom);
		boiteNom = new JTextField();
		boiteNom.setBounds(122, 120, 181, 28);
		boiteNom.setForeground(Color.GRAY);
		container.add(boiteNom);
		boiteNom.setColumns(25);
		
		  
		//Création de la boite prénom
		prenom = new JLabel("Prénom");
		prenom.setBounds(353, 123, 69, 22);
		prenom.setForeground(Color.BLACK);
		container.add(prenom);
		boitePrenom = new JTextField();
		boitePrenom.setBounds(437, 120, 181, 28);
		boitePrenom.setPreferredSize(new Dimension(180, 50));
		boitePrenom.setForeground(Color.GRAY);
		container.add(boitePrenom);
		  
		// Age 
		age = new JLabel("Age");
		age.setBounds(699, 123, 35, 22);
		age.setForeground(Color.BLACK);
		container.add(age);
		boiteAge = new JSpinner();
		boiteAge.setBounds(749, 120, 46, 28);
		boiteAge.setModel(new SpinnerNumberModel(18, 18, 60, 1));
		boiteAge.setPreferredSize(new Dimension(50, 50));
		boiteAge.setForeground(Color.GRAY);
		container.add(boiteAge);
		
		  
		//Région
		region = new JLabel("Région de résidence");
		region.setBounds(12, 177, 142, 20);
		container.add(region);
		boiteRegion = new JComboBox();
		boiteRegion.setBounds(174, 173, 281, 28);
		boiteRegion.setPreferredSize(new Dimension(320, 50));
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
		
		  
		  
		// Numéro de téléphone
		numero = new JLabel("Numéro de telephone");
		numero.setBounds(517, 177, 153, 20);
		numero.setForeground(Color.BLACK);
		container.add(numero);
		boiteNumero = new JTextField();
		boiteNumero.setBounds(691, 173, 138, 28);
		boiteNumero.setPreferredSize(new Dimension(180, 50));
		boiteNumero.setForeground(Color.GRAY);
		container.add(boiteNumero);
		  		  		  
		// Boite Email
		email = new JLabel("Email");
		email.setBounds(86, 232, 49, 22);
		email.setForeground(Color.BLACK);
		container.add(email);
		boiteEmail = new JTextField();
		boiteEmail.setBounds(150, 229, 270, 28);
		boiteEmail.setPreferredSize(new Dimension(250, 50));
		boiteEmail.setForeground(Color.GRAY);
		container.add(boiteEmail);
		  		  		  
		//Permis
		permis = new JLabel("Permis B");
		permis.setBounds(527, 235, 80, 22);		  		  		  
		container.add(permis);	
		bgpermis = new ButtonGroup ();
		oui = new JRadioButton("oui");
		oui.setBounds(612, 231, 59, 31);
		oui.setSelected ( true );
		oui.addActionListener(this);
		bgpermis.add(oui);
		container.add(oui);
		non = new JRadioButton("non");
		non.setBounds(676, 231, 65, 31);
		non.addActionListener(this);
		bgpermis.add(non);
		container.add(non);	
		  
		  		  
		//Type d'emploi
		typEmploi = new JLabel("Type d'emploi");
		typEmploi.setBounds(190, 289, 124, 22); 		  
		container.add(typEmploi);
		bgEmploi = new ButtonGroup ();
		stage = new JRadioButton("Stage");
		stage.setBounds(329, 285, 83, 31);
		stage.setSelected ( true );
		stage.addActionListener(this);
		bgEmploi.add(stage);
		container.add(stage);
		
		interim = new JRadioButton("Intérim");
		interim.setBounds(419, 285, 95, 31);
		interim.setSelected ( true );
		interim.addActionListener(this);
		bgEmploi.add(interim);
		container.add(interim);	
		
		CDD = new JRadioButton("CDD");
		CDD.setBounds(521, 285, 71, 31);
		CDD.setSelected ( true );
		CDD.addActionListener(this);
		bgEmploi.add(CDD);
		container.add(CDD);
		
		CDI = new JRadioButton("CDI");
		CDI.setBounds(599, 285, 63, 31);
		CDI.setSelected ( true );
		CDI.addActionListener(this);
		bgEmploi.add(CDI);
		container.add(CDI);
		  
		//Niveau d'étude
		nivEtude = new JLabel("Niveau d'étude");
		nivEtude.setBounds(216, 348, 131, 22);
		container.add(nivEtude);
		boiteNivEtude = new JComboBox();
		boiteNivEtude.setBounds(358, 345, 269, 28);
		boiteNivEtude.setPreferredSize(new Dimension(300, 50));
		boiteNivEtude.addItem("Employé/Opérateur/Bac");
		boiteNivEtude.addItem("Technicien/Bac+2");
		boiteNivEtude.addItem("Licence/Bac+3");
		boiteNivEtude.addItem("Ingénieur/Cadre/Bac+5");
		boiteNivEtude.addItem("Doctorant/Bac+7");
		container.add(boiteNivEtude);
		
		  
		//Filière / Domaine compétence
		filiere = new JLabel("Domaine compétence");
		filiere.setBounds(110, 414, 192, 22);
		container.add(filiere);
		boiteFiliere = new JComboBox();
		boiteFiliere.setBounds(316, 411, 375, 28);
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
		experience.setBounds(281, 475, 220, 22);
		experience.setForeground(Color.BLACK);
		container.add(experience);
		boiteExperience = new JSpinner();
		boiteExperience.setBounds(516, 472, 49, 28);
		boiteExperience.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		boiteExperience.setPreferredSize(new Dimension(50, 50));
		boiteExperience.setForeground(Color.GRAY);
		container.add(boiteExperience);
		
		
		// Langues pratiqué
				languesPratique = new JLabel("Langue(s) pratiquée(s)");
				languesPratique.setBounds(354, 541, 160, 20);
				container.add(languesPratique);
				
				  // Anglais
				anglais = new JList();
				anglais.setValueIsAdjusting(true);
				anglais.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				anglais.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				anglais.setModel(new AbstractListModel() {
					String[] values = new String[] {"Non pratiqué", "Anglais A1", "Anglais A2", "Anglais B1", "Anglais B2", "Anglais C1", "Anglais C2"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				anglais.setSelectedIndex(0);
				anglais.setBounds(33, 587, 124, 158);
				container.add(anglais);
				
				// Allemand
				allemand = new JList();
				allemand.setModel(new AbstractListModel() {
					String[] values = new String[] {"Non pratiqué", "Allemand A1", "Allemand A2", "Allemand B1", "Allemand B2", "Allemand C1", "Allemand C2"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				allemand.setSelectedIndex(0);
				allemand.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				allemand.setValueIsAdjusting(true);
				allemand.setToolTipText("");
				allemand.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				allemand.setBounds(197, 587, 124, 158);
				container.add(allemand);
				
				
				// Espagnole
				espagnole = new JList();
				espagnole.setModel(new AbstractListModel() {
					String[] values = new String[] {"Non pratiqué", "Espagnol A1", "Espagnol A2", "Espagnol B1", "Espagnol B2", "Espagnol C1", "Espagnol C2"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				espagnole.setSelectedIndex(0);
				espagnole.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				espagnole.setValueIsAdjusting(true);
				espagnole.setToolTipText("");
				espagnole.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				espagnole.setBounds(367, 589, 124, 158);
				container.add(espagnole);
				
				// Italien
				italien = new JList();
				italien.setModel(new AbstractListModel() {
					String[] values = new String[] {"Non pratiqué", "Italien A1", "Italien A2", "Italien B1", "Italien B2", "Italien C1", "Italien C2"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				italien.setSelectedIndex(0);
				italien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				italien.setValueIsAdjusting(true);
				italien.setToolTipText("");
				italien.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				italien.setBounds(539, 589, 124, 158);
				container.add(italien);
				
				
				// Chinois
				chinois= new JList();
				chinois.setModel(new AbstractListModel() {
					String[] values = new String[] {"Non pratiqué", "Chinois A1", "Chinois A2", "Chinois B1", "Chinois B2", "Chinois C1", "Chinois C2"};
					public int getSize() {
						return values.length;
					}
					public Object getElementAt(int index) {
						return values[index];
					}
				});
				chinois.setSelectedIndex(0);
				chinois.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				chinois.setValueIsAdjusting(true);
				chinois.setToolTipText("");
				chinois.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
				chinois.setBounds(699, 587, 124, 158);
				container.add(chinois);
		
		  
		// Bouton ajouter
		ajouter = new JButton ("Ajouter mon profil");
		ajouter.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		ajouter.setBounds(168, 877, 217, 45);
		ajouter.addActionListener(this);
		container.add(ajouter);
			
		  		  
		//Bouton retour
		retour = new JButton ("Retour");
		retour.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		retour.setBounds(469, 877, 118, 45);
		retour.addActionListener(this);
		container.add(retour);
		 
		
		// Aide pour la compétence langue 
		JLabel Aide = new JLabel("*Aide choix niveau(x) de langue(s)");
		Aide.setFont(new Font("Tahoma", Font.ITALIC, 16));
		Aide.setForeground(new Color(50, 205, 50));
		Aide.setBounds(281, 798, 255, 20);
		container.add(Aide);
		
		// Panel pour afficher l'erreur de formulaire
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(66, 71, 734, 45);
		container.add(layeredPane);
		
		
		
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
		
		
		this.setVisible(true);
	  }
	
	
/************************** METHODES ********************************/		
	
		/**
		 *  Action sur les boutons
		 */
		  public void actionPerformed(ActionEvent e) {
			  Object source = e.getSource();
			  if(source == ajouter){
				  if(Verification()){  // si le formulaire est bon on le récupère et on ajoute le profil.
					  RecupererFormulaire();
					  ajoutProfil=new ValidationProfil();
					  this.setVisible(false);
					  this.dispose();
				  }
			  } 
			  if(source == retour){
				  retourAccueil=new Accueil();	
				  this.setVisible(false);
				  this.dispose();
			  }	
		  }	
	
	
	
	
	/**
	 * Vérifie que le champ numéro est bien rempli c'est à dire avec 10 string de chiffres
	 * @return boolean
	 */
	public boolean VerificationNumero(){
		if((boiteNumero.getText().matches("[0-9]*" )) && (boiteNumero.getText().length()==10)){
			numero.setForeground(Color.BLACK);	
			return true;
		}
		numero.setForeground(Color.RED);
		return false;
	}
	
	
	/**
	 * Vérifie si le champ Email est bien rempli avec la forme moi@coucou.com
	 * @return boolean
	 */
	public boolean VerificationEmail(){
		if(boiteEmail.getText().matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$")){
			email.setForeground(Color.BLACK);	
			return true;
		}
		email.setForeground(Color.RED);
		return false;
	}
			
	
	/**
	 * Vérifie que le champ prénom n'est pas vide
	 * @return boolean
	 */
	public boolean VerificationTextFiledPrenom(){					
		if(boitePrenom.getText().isEmpty()){
			prenom.setForeground(Color.RED);
			return false;
		}
		else{
			prenom.setForeground(Color.BLACK);
			return true;
		}				
	}
	
	/**
	 * Vérifie que le champ nom n'est pas vide
	 * @return boolean
	 */
	public boolean VerificationTextFiledNom(){	
		if(boiteNom.getText().isEmpty()){
			nom.setForeground(Color.RED);
			return false;
		}
		else{
			nom.setForeground(Color.BLACK);
			return true;
		}							
	}

	/**
	 * Affiche la phrase d'erreur si tous les champs ne sont pas bien remplis
	 * @return boolean
	 */
	public boolean AffichagePhrase(){
		if(!VerificationTextFiledNom() || !VerificationTextFiledPrenom() || !VerificationNumero() || !VerificationEmail()){
			lblVousNavezPas = new JLabel("Vous n'avez pas rempli tout le formulaire. Veuillez remplir le(s) champ(s) en rouge.");
			lblVousNavezPas.setForeground(Color.RED);
			lblVousNavezPas.setBounds(80, 10, 590, 20);
			lblVousNavezPas.setFont(new Font("Lucida Grande", Font.BOLD, 15));
			layeredPane.add(lblVousNavezPas);
			return false;
		}
		else if(VerificationTextFiledNom() && VerificationTextFiledPrenom() && VerificationNumero() && VerificationEmail()){
			nom.setForeground(Color.BLACK);
			prenom.setForeground(Color.BLACK);
			layeredPane.remove(lblVousNavezPas);
			layeredPane.repaint();
			return true;
		}
		return false;
	}

	
	/**
	 * Vérification final qui reprend toute les vérification au dessus.
	 * @return boolean
	 */
	public boolean Verification(){	
		VerificationNumero();
		VerificationEmail();
		VerificationTextFiledNom();
		VerificationTextFiledPrenom();
		
		if(AffichagePhrase())
			return true;
		else
			return false;
	}
	
	
	
	
	
	public void RecupererFormulaire(){
		  
		  // Region
		reg= new Region((String) boiteRegion.getSelectedItem());
		boolReg = true;
		  
		  // Permis
		  if (oui.isSelected()){
			  perm= new PermisB(true); 
		  }
		  else if (non.isSelected()){
			  perm= new PermisB(false); 
		  }

		 
		  // Borne Age
		  ag= new Age ((Integer)boiteAge.getValue());
		  
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
		  
		  // Niveau d'étude
		  if((String) boiteNivEtude.getSelectedItem()== "Employé/Opérateur/Bac"){
			  etu= new NiveauEtude(0);  
		  }
		  if((String) boiteNivEtude.getSelectedItem()== "Technicien/Employé bac+2"){
			  etu= new NiveauEtude(2);  
		  }
		  if((String) boiteNivEtude.getSelectedItem()== "Licence/Bac+3"){
			  etu= new NiveauEtude(3);  
		  }
		  if((String) boiteNivEtude.getSelectedItem()== "Ingénieur/Cadre/Bac+5"){
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
		  crit.add(ag);
		  crit.add(perm);
		  crit.add(reg);
		  crit.add(etu);
		  crit.add(exp);
		  
		  //recuperer les langues 
		  ArrayList<String> tmp = new ArrayList<>();
		  	  
		  if((String)anglais.getSelectedValue()!="Non pratiqué"){
			  if((String)anglais.getSelectedValue()=="Anglais A1"){
				  ang= "Anglais+1";
			  }
			  if((String)anglais.getSelectedValue()=="Anglais A2"){
				  ang= "Anglais+2";
			  }			  
			  if((String)anglais.getSelectedValue()=="Anglais B1"){
				  ang= "Anglais+3";
			  }		  
			  if((String)anglais.getSelectedValue()=="Anglais B2"){
				  ang= "Anglais+4";
			  }
			  if((String)anglais.getSelectedValue()=="Anglais C1"){
				  ang= "Anglais+5";
			  }
			  if((String)anglais.getSelectedValue()=="Anglais C2"){
				  ang= "Anglais+6";
			  }
			  boolLang=true;
			  tmp.add(ang);
		  }
		  
		  if((String)espagnole.getSelectedValue()!="Non pratiqué"){
			  if((String)espagnole.getSelectedValue()=="Espagnol A1"){
				  esp= "Espagnol+1";
			  }
			  if((String)espagnole.getSelectedValue()=="Espagnol A2"){
				  esp= "Espagnol+2";
			  }			  
			  if((String)espagnole.getSelectedValue()=="Espagnol B1"){
				  esp= "Espagnol+3";
			  }		  
			  if((String)espagnole.getSelectedValue()=="Espagnol B2"){
				  esp= "Espagnol+4";
			  }
			  if((String)espagnole.getSelectedValue()=="Espagnol C1"){
				  esp= "Espagnol+5";
			  }
			  if((String)espagnole.getSelectedValue()=="Espagnol C2"){
				  esp= "Espagnol+6";
			  }
			  boolLang=true;
			  tmp.add(esp);
		  }
		  
		  if((String)allemand.getSelectedValue()!="Non pratiqué"){
			  if((String)allemand.getSelectedValue()=="Allemand A1"){
				  all= "Allemand+1";
			  }
			  if((String)allemand.getSelectedValue()=="Allemand A2"){
				  all= "Allemand+2";
			  }			  
			  if((String)allemand.getSelectedValue()=="Allemand B1"){
				  all= "Allemand+3";
			  }		  
			  if((String)allemand.getSelectedValue()=="Allemand B2"){
				  all= "Allemand+4";
			  }
			  if((String)allemand.getSelectedValue()=="Allemand C1"){
				  all= "Allemand+5";
			  }
			  if((String)allemand.getSelectedValue()=="Allemand C2"){
				  all= "Allemand+6";
			  }
			  boolLang=true;
			  tmp.add(all);
		  }

		  if((String)chinois.getSelectedValue()!="Non pratiqué"){
			  if((String)chinois.getSelectedValue()=="Chinois A1"){
				  chi= "Chinois+1";
			  }
			  if((String)chinois.getSelectedValue()=="Chinois A2"){
				  chi= "Chinois+2";
			  }			  
			  if((String)chinois.getSelectedValue()=="Chinois B1"){
				  chi= "Chinois+3";
			  }		  
			  if((String)chinois.getSelectedValue()=="Chinois B2"){
				  chi= "Chinois+4";
			  }
			  if((String)chinois.getSelectedValue()=="Chinois C1"){
				  chi= "Chinois+5";
			  }
			  if((String)chinois.getSelectedValue()=="Chinois C2"){
				  chi= "Chinois+6";
			  }
			  boolLang=true;
			  tmp.add(chi);
		  }
		  
		  if((String)italien.getSelectedValue()!="Non pratiqué"){
			  if((String)italien.getSelectedValue()=="Italien A1"){
				  ita= "Italien+1";
			  }
			  if((String)italien.getSelectedValue()=="Italien A2"){
				  ita= "Italien+2";
			  }			  
			  if((String)italien.getSelectedValue()=="Italien B1"){
				  ita= "Italien+3";
			  }		  
			  if((String)italien.getSelectedValue()=="Italien B2"){
				  ita= "Italien+4";
			  }
			  if((String)italien.getSelectedValue()=="Italien C1"){
				  ita= "Italien+5";
			  }
			  if((String)italien.getSelectedValue()=="Italien C2"){
				  ita= "Italien+6";
			  }
			  boolLang=true;
			  tmp.add(ita);
		  }
		  Langue langue = new Langue(tmp);
		  crit.add(langue);
		  
		  // Récuparation du nom, prenom, mail et telephone
		  n= boiteNom.getText();;  
          p=boitePrenom.getText();
          em=boiteEmail.getText();
          num= boiteNumero.getText();

          Candidat candidat= new Candidat(n, p, em, num,Candidat.getUnusedId());
          Billet billet = new Billet(Billet.getUnusedId(), candidat, crit) ;
          billet.insertEntryIntoDatabase() ;
	  }
	
	
	
}