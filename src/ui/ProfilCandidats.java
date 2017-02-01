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
import net.miginfocom.swing.MigLayout;

public class ProfilCandidats extends JPanel {
	
	private Candidat cand;      
	private ImagePanel img_panel;
	
	private JLabel candNom;
	private JLabel candPrenom;
	private JLabel candEmail;
	private JLabel candNumero;
	
	private JButton deleteBouton;
	private JButton selectionBouton;


	/**
	 * 
	 * @param f   			Score
	 * @param c  			 Represente un candidat
	 * @param adminstatus  si on est en mode administrateur ou non
	 * @param parent
	 */
	public ProfilCandidats(Candidat c ){
		
		// Layout
		setLayout(new MigLayout("insets 10 10 10 10","[120px][400px][160px!]",""));
				
		// Border
		DecimalFormat PourcentFormat= new DecimalFormat("00.00");
	
		// Candidat
		cand =c;
		
	/*	// Photo Candidat
		img_panel = new ImagePanel(c.getImage());  // Ajouter image 
		add(img_panel, "cell 0 0 1 8, grow");
	*/	
		// Nom
		candNom = new JLabel(c.getNom());  
		candNom.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candNom, "cell 1 0, gapleft 20");
		
		// Prénom
		candPrenom = new JLabel(c.getPrenom());  
		candPrenom.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candPrenom, "cell 1 0, gapleft 20");
		
		// Email
		candEmail = new JLabel(c.getMail());
		candEmail.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candEmail, "cell 1 0, gapleft 20");
		
		// Numero de telephone
		candNumero = new JLabel(c.getTelephone()); // ??????????
		candNumero.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candNumero, "cell 1 0, gapleft 20");
				

		
		deleteBouton = new JButton("Supprimer"); 
		deleteBouton.setBorderPainted(false);
		add(deleteBouton, "cell 0 8, aligny top");
		//if(!adminstatus) deleteBouton.setEnabled(false);
		
		selectionBouton = new JButton("Selectionner");
		add(selectionBouton, "cell 0 9, aligny top, alignx center");
		selectionBouton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

		        }

		});
		
			
	}

}
