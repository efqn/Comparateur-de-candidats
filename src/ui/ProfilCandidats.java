package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

import Candidat.Candidat;
import Criteres.Critere;
import Recherche.Billet;
import ui.ConnexionAdmin;
import net.miginfocom.swing.MigLayout;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import java.awt.Color;

/**
 * 
 *  Permet de créer une fiche candidat à afficher pour le résultat
 *  d'une recherche ou pour l'administrateur
 */

@SuppressWarnings("unused")
public class ProfilCandidats extends JPanel {
	 
	public static int count=1;
	
	private Candidat cand;      
	
	private JLabel candNom;
	private JLabel candN;
	
	private JLabel candPrenom;
	private JLabel candP;
	
	private JLabel candEmail;
	private JLabel candE;
	
	private JLabel candNumero;
	private JLabel candNum;
	
	private JLabel JLcritere;
	
	private JButton deleteBouton;
	private JButton selectionBouton;
	
	private ResultFrame rechercherCand;
	
	private Billet billet;



	/**
	 *  Création d'une fiche candidat
	 * @param c Représente un candidat
	 */
	public ProfilCandidats(Billet c){
		
		this.billet=c;
		
		// Layout
		setLayout(new MigLayout("insets 10 10 10 10", "[][][][][][][120px][195.00px][][160px!][]", "[][][][][][][16.00][][]"));
		
		// Border
		DecimalFormat PourcentFormat= new DecimalFormat("00.00");
	
				
		// Photo Candidat
		JLabel img_panel = new JLabel(new ImageIcon("C:/Users/Utilisateur/workspace/Comparateur/src/Image/Candidat.jpg"));  // Ajouter image 
		add(img_panel, "cell 6 0 1 4,grow");
		
		// Nom
		candNom = new JLabel("Nom:  ");
		candNom.setForeground(new Color(50, 205, 50));
		candN=new JLabel(c.getCandidat().getNom());  
		candNom.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		candN.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candNom, "cell 7 0,gapx 20");
		add(candN, "cell 7 0,gapx 20");
		
		// Prénom
		candPrenom = new JLabel("Prénom:  ");
		candPrenom.setForeground(new Color(50, 205, 50));
		candP= new JLabel(c.getCandidat().getPrenom());  
		candPrenom.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		candP.setFont(new Font("Lucida Grande", Font.BOLD, 18));	
		add(candPrenom, "cell 7 1,gapx 20");
		add(candP, "cell 7 1,gapx 20");
		
			
		// Numero de telephone
		candNumero = new JLabel("Numéro:  ");
		candNumero.setForeground(new Color(50, 205, 50));
		candNum=new JLabel(c.getCandidat().getTelephone());
		candNumero.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		candNum.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candNumero, "cell 7 2,gapx 20");
		add(candNum, "cell 7 2,gapx 20");

		
		// Email
		candEmail = new JLabel("Email:  ");
		candE = new JLabel(c.getCandidat().getMail());
		candEmail.setForeground(new Color(50, 205, 50));
		candEmail.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		candE.setFont(new Font("Lucida Grande", Font.BOLD, 18));		
		add(candEmail, "flowx,cell 7 3,gapx 20");
		add(candE, "flowx,cell 7 3,gapx 20");
		
		
		// Affichage Critères
		for(Critere critere : c.getCriteres()){
			JLcritere= new JLabel(critere.getContent());
			JLcritere.setFont(new Font("Lucida Grande", Font.BOLD, 10));
			add(JLcritere, "cell 3 6 6 4,grow");
		}				
	}



	public Billet getBillet() {
		return billet;
	}



	public void setBillet(Billet billet) {
		this.billet = billet;
	}
	
	


}
