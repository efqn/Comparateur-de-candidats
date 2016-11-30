package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;

public class FormulaireCand extends JFrame {
  private JPanel container;
  
  private JTextField boiteNom;
  private JLabel nom;
  
  private JTextField boitePrenom;
  private JLabel prenom;
  
  private JTextField boiteNumero;
  private JLabel numero;
  
  private JTextField boiteEmail;
  private JLabel email;
  
  private JLabel typEmploi;
  private JRadioButton stage;
  private JRadioButton interim; 
  private JRadioButton CDD;
  private JRadioButton CDI;
  private ButtonGroup bgEmploi;
  
  private JComboBox boiteNivEtude;
  private JLabel nivEtude;
  
  private JComboBox boiteFiliere;
  private JLabel filiere;
  
  public FormulaireCand(){
	  
	  container = new JPanel();
	  // Fenetre du formulaire
	  this.setTitle("Formulaire profil candidat");
	  this.setSize(1000, 1000);
	  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  this.setLocationRelativeTo(null);
	  container.setBackground(Color.white);
	  container.setLayout(new BorderLayout());
	    
	  // Phrase du d�but
	  container.setLayout(new FlowLayout());
	  JLabel label = new JLabel("Veuillez remplir ce formulaire pour ajouter votre profil dans notre base de donn�es.");
	  label.setFont(new Font("Lucida Grande", Font.BOLD, 16));
	  container.add(label);
		
	  // Police du formulaire
	  Font police= new Font("Arial", Font.BOLD, 18);
		
	  // Cr�ation de la boite nom
	  boiteNom = new JTextField("Votre nom");
	  nom = new JLabel("Nom");
	  boiteNom.setFont(police);
	  boiteNom.setPreferredSize(new Dimension(180, 50));
	  boiteNom.setForeground(Color.GRAY);
	  nom.setFont(police);
	  nom.setForeground(Color.BLACK);
	  container.add(nom);
	  container.add(boiteNom);
	    
	  //Cr�ation de la boite pr�nom
	  boitePrenom = new JTextField("Votre pr�nom");
	  prenom = new JLabel("Pr�nom");
	  boitePrenom.setFont(police);
	  boitePrenom.setPreferredSize(new Dimension(180, 50));
	  boitePrenom.setForeground(Color.GRAY);
	    
	  prenom.setFont(police);
	  prenom.setForeground(Color.BLACK);
	    
	  container.add(prenom);
	  container.add(boitePrenom);
	    
	    
	  // Num�ro de t�l�phone
	  boiteNumero = new JTextField("Num�ro");
	  numero = new JLabel("Num�ro de telephone");
	  boiteNumero.setFont(police);
	  boiteNumero.setPreferredSize(new Dimension(180, 50));
	  boiteNumero.setForeground(Color.GRAY);
	    
	  numero.setFont(police);
	  numero.setForeground(Color.BLACK);    
	  container.add(numero);
	  container.add(boiteNumero);
	    /*try{
	    	  MaskFormatter tel = new MaskFormatter("## ## ## ## ##");
	    	  //Vous pouvez ensuite le passer � votre zone de texte
	    	  JFormattedTextField boiteNumero = new JFormattedTextField(tel);
	    	}catch(ParseException e){e.printStackTrace();}*/
	  
	  // Boite Email  
	  boiteEmail = new JTextField("Votre email");
	  email = new JLabel("Email");
	  boiteEmail.setFont(police);
	  boiteEmail.setPreferredSize(new Dimension(250, 50));
	  boiteEmail.setForeground(Color.GRAY);
	    
	  email.setFont(police);
	  email.setForeground(Color.BLACK);    
	  container.add(email);
	  container.add(boiteEmail);	
	  
	  //Type d'emploi
	  typEmploi = new JLabel("Type d'emploi");
	  stage = new JRadioButton("Stage");
	  interim = new JRadioButton("It�rim");
	  CDD = new JRadioButton("CDD");
	  CDI = new JRadioButton("CDI");
	  bgEmploi = new ButtonGroup();
	  
	  typEmploi.setFont(police);
	  stage.setFont(police);
	  interim.setFont(police);
	  CDD.setFont(police);
	  CDI.setFont(police);

	  stage.addActionListener(new StateListener());
	  interim.addActionListener(new StateListener());
	  CDD.addActionListener(new StateListener());
	  CDI.addActionListener(new StateListener());
	  
	  bgEmploi.add(stage);
	  bgEmploi.add(interim);
	  bgEmploi.add(CDD);
	  bgEmploi.add(CDI);
	  container.add(typEmploi);
	  container.add(stage);
	  container.add(interim);	
	  container.add(CDD);
	  container.add(CDI);
	  
	  //Niveau d'�tude
	  nivEtude = new JLabel("Niveau d'�tude");
	  boiteNivEtude = new JComboBox();
	  boiteNivEtude.setPreferredSize(new Dimension(300, 50));
	  boiteNivEtude.setFont(police);
	  nivEtude.setFont(police);
	  container.add(nivEtude);
	  boiteNivEtude.addItem("BEP/CAP");
	  boiteNivEtude.addItem("Employ�/Op�rateur/Bac");
	  boiteNivEtude.addItem("Technicien/Employ� bac+2");
	  boiteNivEtude.addItem("Ing�nieur/Cadre/Bac+5");
	  container.add(boiteNivEtude);
	  
	  //Fili�re / Domaine comp�tence
	  boiteFiliere = new JComboBox();
	  filiere = new JLabel("Domaine comp�tence");
	  boiteFiliere.setPreferredSize(new Dimension(420, 50));
	  boiteFiliere.setFont(police);
	  filiere.setFont(police);
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
	  container.add(filiere);
	  container.add(boiteFiliere);
	  
	    
	  this.setContentPane(container);
	  this.setVisible(true);
  }
  
  //Groupe bouton Type d'emploi
  class StateListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
	    	System.out.println("source : " + stage.getText() + " - �tat : " + stage.isSelected());
	        System.out.println("source : " + interim.getText() + " - �tat : " + interim.isSelected());
	        System.out.println("source : " + CDD.getText() + " - �tat : " + CDD.isSelected());
	        System.out.println("source : " + CDI.getText() + " - �tat : " + CDI.isSelected());
	    }
  }

}
