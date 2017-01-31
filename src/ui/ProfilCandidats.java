package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.border.TitledBorder;

import Candidat.Candidat;
import net.miginfocom.swing.MigLayout;

public class ProfilCandidats extends TailleFenetre {
	
	private Candidat cand;       // ???? ou sont les Get.....
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
	public ProfilCandidats( Float f, Candidat c, boolean adminstatus,JDialog parent  ){
		
		// Layout
		setLayout(new MigLayout("insets 10 10 10 10","[120px][400px][160px!]",""));
				
		// Border
		DecimalFormat PourcentFormat= new DecimalFormat("00.00");
		setBorder(new TitledBorder("<html><b>"+PourcentFormat.format(f)+" %</b></html>"));
	
		// Candidat
		cand =c;
		
		// Photo Candidat
		img_panel = new ImagePanel(c.getImage());  // Ajouter image 
		add(img_panel, "cell 0 0 1 8, grow");
		
		// Nom
		candNom = new JLabel(c.getName());  // ??????????
		candNom.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candNom, "cell 1 0, gapleft 20");
		
		// Prénom
		candPrenom = new JLabel(c.getName());    // ??????????
		candPrenom.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candPrenom, "cell 1 0, gapleft 20");
		
		// Email
		candEmail = new JLabel(c.getName()); // ??????????
		candEmail.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candEmail, "cell 1 0, gapleft 20");
		
		// Numero de telephone
		candNumero = new JLabel(c.getName()); // ??????????
		candNumero.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		add(candNumero, "cell 1 0, gapleft 20");
				
		// Separators
		JSeparator separator = new JSeparator();
		separator.setPreferredSize(new Dimension(530, 15));
		add(separator, "cell 1 2 2 1, gapleft 20");
		
		deleteBouton = new JButton("Supprimer"); 
		deleteBouton.setBorderPainted(false);
		add(deleteBouton, "cell 0 8, aligny top");
		if(!adminstatus) deleteBouton.setEnabled(false);
		
		selectionBouton = new JButton("Selectionner");
		add(selectionBouton, "cell 0 9, aligny top, alignx center");
		selectionBouton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

		        }

		});
		
			
	}


}
