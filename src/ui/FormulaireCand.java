package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JLayeredPane;

public class FormulaireCand extends TailleFenetre implements ActionListener{  

	protected JPanel container;
	protected MenuHeader menu;
	  
	protected JTextField boiteNom;
	protected JLabel nom;
	  
	protected JTextField boitePrenom;
	protected JLabel prenom;
	  
	protected JSpinner boiteAge;
	protected JLabel age;
	  
	protected JComboBox boiteRegion;
	protected JLabel region;
	  
	protected JTextField boiteNumero;
	protected JLabel numero;
	  
	protected JTextField boiteEmail;
	protected JLabel email;
	  
	protected JLabel permis;
	protected ButtonGroup bgpermis;
	protected JRadioButton oui;
	protected JRadioButton non; 
	  
	protected JLabel typEmploi;
	protected ButtonGroup bgEmploi;
	protected JRadioButton stage;
	protected JRadioButton interim; 
	protected JRadioButton CDD;
	protected JRadioButton CDI;
	  
	protected JComboBox boiteNivEtude;
	protected JLabel nivEtude;
	  
	protected JComboBox boiteFiliere;
	protected JLabel filiere;
	  
	protected JSpinner boiteExperience;
	protected JLabel experience;
	
	protected JLabel languesPratique;
	protected JLabel lblLanguesPratiques;

	protected JLabel anglais;
	protected ButtonGroup bganglais;
	protected JLabel allemand;
	protected ButtonGroup bgallemand;
	protected JLabel espagnol;
	protected ButtonGroup bgespagnol;
	protected JLabel italien;
	protected ButtonGroup bgitalien;
	protected JLabel chinois;
	protected ButtonGroup bgchinois;
	protected JRadioButton NP;
	protected JRadioButton A1;
	protected JRadioButton A2; 
	protected JRadioButton B1; 
	protected JRadioButton B2;
	protected JRadioButton C1; 
	protected JRadioButton C2;
	
	protected JTextPane ExpA;
	
	  
	protected JButton retour;
	protected JButton ajouter;
	
	protected Choix retourAccueil;
	protected ValidationProfil ajoutProfil;
	
	protected JLayeredPane layeredPane;

	private JLabel lblVousNavezPas;
	
/**************************** CONSTRUCTEUR *********************************/
	
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
		label.setBounds(66, 43, 729, 24);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 18));
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
		boiteRegion.addItem("Pays de la Loire");
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
		boiteNivEtude.addItem("Technicien/Employé bac+2");
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
		languesPratique.setBounds(329, 552, 160, 20);
		container.add(languesPratique);
		anglais = new JLabel("Anglais:");
		anglais.setBounds(51, 614, 80, 22);		  		  		  
		container.add(anglais);	
		bganglais = new ButtonGroup ();
		NP = new JRadioButton("Non pratiqué");
		NP.setBounds(140, 613, 125, 24);
		NP.setSelected ( true );
		NP.addActionListener(this);
		bganglais.add(NP);
		container.add(NP);
		A1 = new JRadioButton("A1");
		A1.setBounds(295, 614, 53, 29);
		A1.addActionListener(this);
		bganglais.add(A1);
		container.add(A1);
		A2 = new JRadioButton("A2");
		A2.setBounds(374, 614, 53, 29);
		A2.addActionListener(this);
		bganglais.add(A2);
		container.add(A2);
		B1 = new JRadioButton("B1");
		B1.setBounds(450, 614, 51, 29);
		B1.addActionListener(this);
		bganglais.add(B1);
		container.add(B1);
		B2 = new JRadioButton("B2");
		B2.setBounds(528, 614, 51, 29);
		B2.addActionListener(this);
		bganglais.add(B2);
		container.add(B2);
		bganglais.add(A2);
		container.add(A2);
		C1 = new JRadioButton("C1");
		C1.setBounds(601, 614, 51, 29);
		C1.addActionListener(this);
		bganglais.add(C1);
		container.add(C1);
		C2 = new JRadioButton("C2");
		C2.setBounds(674, 614, 51, 29);
		C2.addActionListener(this);
		bganglais.add(C2);
		container.add(C2);
				
				
		allemand = new JLabel("Allemand:");
		allemand.setBounds(39, 649, 80, 22);		  		  		  
		container.add(allemand);	
		bgallemand = new ButtonGroup ();
		NP = new JRadioButton("Non pratiqué");
		NP.setBounds(140, 648, 125, 24);
		NP.setSelected ( true );
		NP.addActionListener(this);
		bgallemand.add(NP);
		container.add(NP);
		A1 = new JRadioButton("A1");
		A1.setBounds(295, 649, 53, 29);
		A1.addActionListener(this);
		bgallemand.add(A1);
		container.add(A1);
		A2 = new JRadioButton("A2");
		A2.setBounds(374, 649, 53, 29);
		A2.addActionListener(this);
		bganglais.add(A2);
		container.add(A2);
		B1 = new JRadioButton("B1");
		B1.setBounds(450, 649, 51, 29);
		B1.addActionListener(this);
		bgallemand.add(B1);
		container.add(B1);
		B2 = new JRadioButton("B2");
		B2.setBounds(528, 649, 51, 29);
		B2.addActionListener(this);
		bgallemand.add(B2);
		container.add(B2);
		bgallemand.add(A2);
		container.add(A2);
		C1 = new JRadioButton("C1");
		C1.setBounds(599, 649, 51, 29);
		C1.addActionListener(this);
		bgallemand.add(C1);
		container.add(C1);
		C2 = new JRadioButton("C2");
		C2.setBounds(674, 649, 51, 29);
		C2.addActionListener(this);
		bgallemand.add(C2);
		container.add(C2);
				
				
		espagnol = new JLabel("Espagnol:");
		espagnol.setBounds(39, 687, 80, 22);		  		  		  
		container.add(espagnol);	
		bgespagnol = new ButtonGroup ();
		NP = new JRadioButton("Non pratiqué");
		NP.setBounds(140, 686, 125, 24);
		NP.setSelected ( true );
		NP.addActionListener(this);
		bgespagnol.add(NP);
		container.add(NP);
		A1 = new JRadioButton("A1");
		A1.setBounds(295, 687, 53, 29);
		A1.addActionListener(this);
		bgespagnol.add(A1);
		container.add(A1);
		A2 = new JRadioButton("A2");
		A2.setBounds(374, 687, 53, 29);
		A2.addActionListener(this);
		bganglais.add(A2);
		container.add(A2);
		B1 = new JRadioButton("B1");
		B1.setBounds(450, 687, 51, 29);
		B1.addActionListener(this);
		bgespagnol.add(B1);
		container.add(B1);
		B2 = new JRadioButton("B2");
		B2.setBounds(528, 687, 51, 29);
		B2.addActionListener(this);
		bgespagnol.add(B2);
		container.add(B2);
		bgespagnol.add(A2);
		container.add(A2);
		C1 = new JRadioButton("C1");
		C1.setBounds(599, 687, 51, 29);
		C1.addActionListener(this);
		bgespagnol.add(C1);
		container.add(C1);
		C2 = new JRadioButton("C2");
		C2.setBounds(674, 687, 51, 29);
		C2.addActionListener(this);
		bgespagnol.add(C2);
		container.add(C2);
				
		italien = new JLabel("Italien:");
		italien.setBounds(51, 727, 50, 20);		  		  		  
		container.add(italien);	
		bgitalien = new ButtonGroup ();
		NP = new JRadioButton("Non pratiqué");
		NP.setBounds(140, 725, 125, 24);
		NP.setSelected ( true );
		NP.addActionListener(this);
		bgitalien.add(NP);
		container.add(NP);
		A1 = new JRadioButton("A1");
		A1.setBounds(295, 725, 53, 29);
		A1.addActionListener(this);
		bgitalien.add(A1);
		container.add(A1);
		A2 = new JRadioButton("A2");
		A2.setBounds(374, 725, 53, 29);
		A2.addActionListener(this);
		bgitalien.add(A2);
		container.add(A2);
		B1 = new JRadioButton("B1");
		B1.setBounds(450, 725, 51, 29);
		B1.addActionListener(this);
		bgitalien.add(B1);
		container.add(B1);
		B2 = new JRadioButton("B2");
		B2.setBounds(528, 725, 51, 29);
		B2.addActionListener(this);
		bgitalien.add(B2);
		container.add(B2);
		bgitalien.add(A2);
		container.add(A2);
		C1 = new JRadioButton("C1");
		C1.setBounds(599, 725, 51, 29);
		C1.addActionListener(this);
		bgitalien.add(C1);
		container.add(C1);
		C2 = new JRadioButton("C2");
		C2.setBounds(674, 725, 51, 29);
		C2.addActionListener(this);
		bgitalien.add(C2);
		container.add(C2);
				
		chinois = new JLabel("Chinois:");
		chinois.setBounds(51, 765, 58, 20);		  		  		  
		container.add(chinois);	
		bgchinois = new ButtonGroup ();
		NP = new JRadioButton("Non pratiqué");
		NP.setBounds(140, 763, 125, 24);
		NP.setSelected ( true );
		NP.addActionListener(this);
		bgchinois.add(NP);
		container.add(NP);
		A1 = new JRadioButton("A1");
		A1.setBounds(295, 763, 80, 22);
		A1.addActionListener(this);
		bgchinois.add(A1);
		container.add(A1);
		A2 = new JRadioButton("A2");
		A2.setBounds(374, 762, 53, 29);
		A2.addActionListener(this);
		bgchinois.add(A2);
		container.add(A2);
		B1 = new JRadioButton("B1");
		B1.setBounds(450, 762, 51, 29);
		B1.addActionListener(this);
		bgchinois.add(B1);
		container.add(B1);
		B2 = new JRadioButton("B2");
		B2.setBounds(527, 762, 51, 29);
		B2.addActionListener(this);
		bgchinois.add(B2);
		container.add(B2);
		bgchinois.add(A2);
		container.add(A2);
		C1 = new JRadioButton("C1");
		C1.setBounds(599, 761, 51, 29);
		C1.addActionListener(this);
		bgchinois.add(C1);
		container.add(C1);
		C2 = new JRadioButton("C2");
		C2.setBounds(674, 763, 51, 29);
		C2.addActionListener(this);
		bgchinois.add(C2);
		container.add(C2);
		
		  
		// Bouton ajouter
		ajouter = new JButton ("Ajouter mon profil");
		ajouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		ajouter.setBounds(216, 891, 191, 31);
		ajouter.addActionListener(this);
		container.add(ajouter);
			
		  		  
		//Bouton retour
		retour = new JButton ("Retour");
		retour.setFont(new Font("Tahoma", Font.BOLD, 14));
		retour.setBounds(506, 891, 91, 31);
		retour.addActionListener(this);
		container.add(retour);
		 
		
		// Aide pour la compétence langue 
		JLabel Aide = new JLabel("*Aide choix niveau(x) de langue(s)");
		Aide.setFont(new Font("Tahoma", Font.ITALIC, 16));
		Aide.setForeground(Color.BLUE);
		Aide.setBounds(286, 834, 255, 20);
		container.add(Aide);
		
		// Panel pour afficher l'erreur de formulaire
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(65, 70, 734, 45);
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
	// Vérifie si le numero est bon
	public boolean VerificationNumero(){
		if((boiteNumero.getText().matches("[0-9]*" )) && (boiteNumero.getText().length()==10)){
			numero.setForeground(Color.BLACK);	
			return false;
		}
		else{
			numero.setForeground(Color.RED);
			return true;
		}	
	}
	
	// Vérifie si l'email est du type: moi@coucou.com
	public boolean VerificationEmail(){
		if(boiteEmail.getText().matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$")){
			email.setForeground(Color.BLACK);	
			return false;
		}
		else{
			email.setForeground(Color.RED);
			return true;
		}	
	}
			
	
	// Vérifie si tous les champs du formulaire sont remplis
	public boolean VerificationTextFiled(){
		if(boiteNom.getText().isEmpty() || boitePrenom.getText().isEmpty() || VerificationNumero() || VerificationEmail()){
				lblVousNavezPas = new JLabel("Vous n'avez pas rempli tout le formulaire. Veuillez remplir le(s) champ(s) en rouge.");
				lblVousNavezPas.setForeground(Color.RED);
				lblVousNavezPas.setBounds(80, 10, 590, 20);
				lblVousNavezPas.setFont(new Font("Lucida Grande", Font.BOLD, 15));
				layeredPane.add(lblVousNavezPas);
				
				if(boiteNom.getText().isEmpty()){
					nom.setForeground(Color.RED);
				}
				else{
					nom.setForeground(Color.BLACK);}
					
				if(boitePrenom.getText().isEmpty()){
					prenom.setForeground(Color.RED);
				}
				else{
					prenom.setForeground(Color.BLACK);}
				
				return false;
		}
		else{
			nom.setForeground(Color.BLACK);
			prenom.setForeground(Color.BLACK);
			layeredPane.remove(lblVousNavezPas);
			layeredPane.repaint();
			return true;
		}	
	}
	
	
	// Vérification finale
	public boolean Verification(){
		if(VerificationNumero() && VerificationEmail() && VerificationTextFiled())
			return false;
		else
			return true;
	}
	
	
	
	 // Action des boutons
	@Override
	  public void actionPerformed(ActionEvent e) {
		  Object source = e.getSource();
		  if(source == ajouter){
			  if(!Verification()){
				  ajoutProfil=new ValidationProfil();
				  this.setVisible(false);
				  this.dispose();
			  }
		  } 
		  if(source == retour){
			  retourAccueil=new Choix();	
			  this.setVisible(false);
			  this.dispose();
		  }	
	  }
	
	
	
}