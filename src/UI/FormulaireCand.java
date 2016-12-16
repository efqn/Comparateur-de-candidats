package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;

public class FormulaireCand extends JFrame implements ActionListener{  

	private JFrame frame;
	private JPanel container;
	  
	private JTextField boiteNom;
	private JLabel nom;
	  
	private JTextField boitePrenom;
	private JLabel prenom;
	  
	private JSpinner boiteAge;
	private JLabel age;
	  
	private JComboBox boiteRegion;
	private JLabel region;
	  
	private JTextField boiteNumero;
	private JLabel numero;
	  
	private JTextField boiteEmail;
	private JLabel email;
	  
	private JLabel permis;
	private ButtonGroup bgpermis;
	private JRadioButton oui;
	private JRadioButton non; 
	  
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
	
	private JLabel anglais;
	private ButtonGroup bganglais;
	private JLabel allemand;
	private ButtonGroup bgallemand;
	private JLabel espagnol;
	private ButtonGroup bgespagnol;
	private JLabel italien;
	private ButtonGroup bgitalien;
	private JLabel chinois;
	private ButtonGroup bgchinois;
	private JRadioButton NP;
	private JRadioButton A1;
	private JRadioButton A2; 
	private JRadioButton B1; 
	private JRadioButton B2;
	private JRadioButton C1; 
	private JRadioButton C2;
	
	private JTextPane ExpA;
	
	  
	private JButton retour;
	private JButton ajouter;
	
	private Choix retourAccueil;
	private JLabel lblLanguesPratiques;



	 
	public FormulaireCand(){		  
		// Fenetre du formulaire
		setTitle("Recherche");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 1000,1000);
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setBackground(Color.white);
		container.setLayout(null);
		  
		// Phrase du début
		JLabel label = new JLabel("Veuillez remplir ce formulaire pour ajouter votre profil dans notre base de données.");
		label.setBounds(118, 43, 729, 24);
		label.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		container.add(label);
		  
		// Création de la boite nom
		nom = new JLabel("Nom");
		nom.setBounds(118, 125, 41, 22);
		nom.setForeground(Color.BLACK);
		container.add(nom);
		boiteNom = new JTextField("Votre nom");
		boiteNom.setBounds(174, 122, 181, 28);
		boiteNom.setForeground(Color.GRAY);
		container.add(boiteNom);
		boiteNom.setColumns(25);
		
		  
		//Création de la boite prénom
		prenom = new JLabel("Prénom");
		prenom.setBounds(405, 125, 69, 22);
		prenom.setForeground(Color.BLACK);
		container.add(prenom);
		boitePrenom = new JTextField("Votre prénom");
		boitePrenom.setBounds(489, 122, 181, 28);
		boitePrenom.setPreferredSize(new Dimension(180, 50));
		boitePrenom.setForeground(Color.GRAY);
		container.add(boitePrenom);
		  
		// Age 
		age = new JLabel("Age");
		age.setBounds(751, 125, 35, 22);
		age.setForeground(Color.BLACK);
		container.add(age);
		boiteAge = new JSpinner();
		boiteAge.setBounds(801, 122, 46, 28);
		boiteAge.setModel(new SpinnerNumberModel(0, 0, 60, 1));
		boiteAge.setPreferredSize(new Dimension(50, 50));
		boiteAge.setForeground(Color.GRAY);
		container.add(boiteAge);
		
		  
		//Région
		region = new JLabel("Région de résidence");
		region.setBounds(12, 177, 181, 22);
		container.add(region);
		boiteRegion = new JComboBox();
		boiteRegion.setBounds(208, 174, 281, 28);
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
		numero.setBounds(558, 177, 190, 22);
		numero.setForeground(Color.BLACK);
		container.add(numero);
		boiteNumero = new JTextField("Numéro");
		boiteNumero.setBounds(761, 174, 181, 28);
		boiteNumero.setPreferredSize(new Dimension(180, 50));
		boiteNumero.setForeground(Color.GRAY);
		container.add(boiteNumero);		
		  		  		  
		// Boite Email
		email = new JLabel("Email");
		email.setBounds(140, 232, 49, 22);
		email.setForeground(Color.BLACK);
		container.add(email);
		boiteEmail = new JTextField("Votre email");
		boiteEmail.setBounds(204, 229, 270, 28);
		boiteEmail.setPreferredSize(new Dimension(250, 50));
		boiteEmail.setForeground(Color.GRAY);
		container.add(boiteEmail);
		  		  		  
		//Permis
		permis = new JLabel("Permis B");
		permis.setBounds(581, 235, 80, 22);		  		  		  
		container.add(permis);	
		bgpermis = new ButtonGroup ();
		oui = new JRadioButton("oui");
		oui.setBounds(666, 231, 59, 31);
		oui.setSelected ( true );
		oui.addActionListener(this);
		bgpermis.add(oui);
		container.add(oui);
		non = new JRadioButton("non");
		non.setBounds(730, 231, 65, 31);
		non.addActionListener(this);
		bgpermis.add(non);
		container.add(non);	
		  
		  		  
		//Type d'emploi
		typEmploi = new JLabel("Type d'emploi");
		typEmploi.setBounds(254, 289, 124, 22); 		  
		container.add(typEmploi);
		bgEmploi = new ButtonGroup ();
		stage = new JRadioButton("Stage");
		stage.setBounds(393, 285, 83, 31);
		stage.setSelected ( true );
		stage.addActionListener(this);
		bgEmploi.add(stage);
		container.add(stage);
		
		interim = new JRadioButton("Intérim");
		interim.setBounds(483, 285, 95, 31);
		interim.setSelected ( true );
		interim.addActionListener(this);
		bgEmploi.add(interim);
		container.add(interim);	
		
		CDD = new JRadioButton("CDD");
		CDD.setBounds(585, 285, 71, 31);
		CDD.setSelected ( true );
		CDD.addActionListener(this);
		bgEmploi.add(CDD);
		container.add(CDD);
		
		CDI = new JRadioButton("CDI");
		CDI.setBounds(663, 285, 63, 31);
		CDI.setSelected ( true );
		CDI.addActionListener(this);
		bgEmploi.add(CDI);
		container.add(CDI);
		  
		//Niveau d'étude
		nivEtude = new JLabel("Niveau d'étude");
		nivEtude.setBounds(280, 348, 131, 22);
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
		filiere.setBounds(174, 414, 192, 22);
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
		boiteExperience.setBounds(580, 472, 49, 28);
		boiteExperience.setModel(new SpinnerNumberModel(0, 0, 40, 1));
		boiteExperience.setPreferredSize(new Dimension(50, 50));
		boiteExperience.setForeground(Color.GRAY);
		container.add(boiteExperience);
		
		
		// Langues pratiqué
				languesPratique = new JLabel("Langue(s) pratiquée(s)");
				languesPratique.setBounds(418, 553, 160, 20);
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
				A1.setBounds(295, 614, 80, 22);
				A1.addActionListener(this);
				bganglais.add(A1);
				container.add(A1);
				A2 = new JRadioButton("A2");
				A2.setBounds(404, 614, 80, 22);
				A2.addActionListener(this);
				bganglais.add(A2);
				container.add(A2);
				B1 = new JRadioButton("B1");
				B1.setBounds(517, 614, 80, 22);
				B1.addActionListener(this);
				bganglais.add(B1);
				container.add(B1);
				B2 = new JRadioButton("B2");
				B2.setBounds(631, 614, 80, 22);
				B2.addActionListener(this);
				bganglais.add(B2);
				container.add(B2);
				bganglais.add(A2);
				container.add(A2);
				C1 = new JRadioButton("C1");
				C1.setBounds(741, 614, 80, 22);
				C1.addActionListener(this);
				bganglais.add(C1);
				container.add(C1);
				C2 = new JRadioButton("C2");
				C2.setBounds(853, 614, 80, 22);
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
				A1.setBounds(295, 649, 80, 22);
				A1.addActionListener(this);
				bgallemand.add(A1);
				container.add(A1);
				A2 = new JRadioButton("A2");
				A2.setBounds(404, 649, 80, 22);
				A2.addActionListener(this);
				bganglais.add(A2);
				container.add(A2);
				B1 = new JRadioButton("B1");
				B1.setBounds(517, 649, 80, 22);
				B1.addActionListener(this);
				bgallemand.add(B1);
				container.add(B1);
				B2 = new JRadioButton("B2");
				B2.setBounds(631, 649, 80, 22);
				B2.addActionListener(this);
				bgallemand.add(B2);
				container.add(B2);
				bgallemand.add(A2);
				container.add(A2);
				C1 = new JRadioButton("C1");
				C1.setBounds(739, 649, 80, 22);
				C1.addActionListener(this);
				bgallemand.add(C1);
				container.add(C1);
				C2 = new JRadioButton("C2");
				C2.setBounds(853, 649, 80, 22);
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
				A1.setBounds(295, 687, 80, 22);
				A1.addActionListener(this);
				bgespagnol.add(A1);
				container.add(A1);
				A2 = new JRadioButton("A2");
				A2.setBounds(404, 687, 80, 22);
				A2.addActionListener(this);
				bganglais.add(A2);
				container.add(A2);
				B1 = new JRadioButton("B1");
				B1.setBounds(517, 687, 80, 22);
				B1.addActionListener(this);
				bgespagnol.add(B1);
				container.add(B1);
				B2 = new JRadioButton("B2");
				B2.setBounds(631, 687, 80, 22);
				B2.addActionListener(this);
				bgespagnol.add(B2);
				container.add(B2);
				bgespagnol.add(A2);
				container.add(A2);
				C1 = new JRadioButton("C1");
				C1.setBounds(739, 687, 80, 22);
				C1.addActionListener(this);
				bgespagnol.add(C1);
				container.add(C1);
				C2 = new JRadioButton("C2");
				C2.setBounds(853, 687, 80, 22);
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
				A1.setBounds(295, 725, 80, 22);
				A1.addActionListener(this);
				bgitalien.add(A1);
				container.add(A1);
				A2 = new JRadioButton("A2");
				A2.setBounds(404, 725, 80, 22);
				A2.addActionListener(this);
				bgitalien.add(A2);
				container.add(A2);
				B1 = new JRadioButton("B1");
				B1.setBounds(517, 725, 80, 22);
				B1.addActionListener(this);
				bgitalien.add(B1);
				container.add(B1);
				B2 = new JRadioButton("B2");
				B2.setBounds(631, 725, 80, 22);
				B2.addActionListener(this);
				bgitalien.add(B2);
				container.add(B2);
				bgitalien.add(A2);
				container.add(A2);
				C1 = new JRadioButton("C1");
				C1.setBounds(739, 725, 80, 22);
				C1.addActionListener(this);
				bgitalien.add(C1);
				container.add(C1);
				C2 = new JRadioButton("C2");
				C2.setBounds(853, 725, 80, 22);
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
				A2.setBounds(404, 763, 80, 22);
				A2.addActionListener(this);
				bgchinois.add(A2);
				container.add(A2);
				B1 = new JRadioButton("B1");
				B1.setBounds(517, 763, 80, 22);
				B1.addActionListener(this);
				bgchinois.add(B1);
				container.add(B1);
				B2 = new JRadioButton("B2");
				B2.setBounds(631, 763, 80, 22);
				B2.addActionListener(this);
				bgchinois.add(B2);
				container.add(B2);
				bgchinois.add(A2);
				container.add(A2);
				C1 = new JRadioButton("C1");
				C1.setBounds(739, 763, 80, 22);
				C1.addActionListener(this);
				bgchinois.add(C1);
				container.add(C1);
				C2 = new JRadioButton("C2");
				C2.setBounds(853, 763, 80, 22);
				C2.addActionListener(this);
				bgchinois.add(C2);
				container.add(C2);
		
		  
		// Bouton ajouter
		ajouter = new JButton ("Ajouter mon profil");
		ajouter.setFont(new Font("Tahoma", Font.BOLD, 14));
		ajouter.setBounds(280, 891, 191, 31);
		ajouter.addActionListener(this);

		container.add(ajouter);
			
		  		  
		//Bouton retour
		retour = new JButton ("Retour");
		retour.setFont(new Font("Tahoma", Font.BOLD, 14));
		retour.setBounds(570, 891, 91, 31);
		retour.addActionListener(this);
		container.add(retour);
		 
		
		// Aide pour la compétence langue 
		JLabel Aide = new JLabel("*Aide choix niveau(x) de langue(s)");
		Aide.setFont(new Font("Tahoma", Font.ITALIC, 16));
		Aide.setForeground(Color.BLUE);
		Aide.setBounds(350, 834, 247, 20);
		container.add(Aide);
		
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
		
		
		this.setContentPane(container);
		this.setVisible(true);
	  }
	
	  
	
	  // Action des boutons
	@Override
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