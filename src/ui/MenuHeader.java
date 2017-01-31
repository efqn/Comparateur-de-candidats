package ui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class MenuHeader extends JMenuBar{
	
	protected ConnexionAdmin admin;
	
	public MenuHeader(){
		JMenuBar jm = new JMenuBar();
		JMenu fm = new JMenu("Fichier");
		JMenu am = new JMenu("Aide");
		JMenuItem connexion = new JMenuItem("Connexion");
		connexion.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ConnexionAdmin loginDlg = new ConnexionAdmin(new JFrame());
                loginDlg.setVisible(true);
                // if login successfully
                if(loginDlg.isSucceeded()){
                   	
                }
			}
		});
		
		JMenuItem quitter = new JMenuItem("Quitter");
		quitter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		JMenuItem aprop = new JMenuItem("À propos");
		aprop.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JPanel jp = new JPanel();
				jp.setLayout(new BoxLayout(jp,BoxLayout.Y_AXIS));
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.CENTER;
				gbc.weighty = 1;
				jp.add(new JLabel	("Comparateur de Candidats - Projet POO 2016",JLabel.CENTER),gbc);
				jp.add(new JLabel	("Fabien Quang et Lucile Texier",JLabel.CENTER),gbc);
				jp.add(new JLabel	("Comparer des profils candidats à partir d'une demande, ces profils sont stockés dans une base de données",JLabel.CENTER),gbc);
				jp.add(new JLabel   ("Version 1.0 - Dernière édition le 06/02/2016",JLabel.CENTER),gbc);
				JOptionPane.showMessageDialog(aprop, jp, "À propos", JOptionPane.INFORMATION_MESSAGE);
				
				
			}
		});
		
		// Ajout des boutons dans les sous-menus
		fm.add(connexion);
		fm.add(quitter);
		am.add(aprop);
		
		// Ajout des menus
		jm.add(fm);
		jm.add(am);
		
		// Ajout de la barre de menu
		add(jm);
	}
}