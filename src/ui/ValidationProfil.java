package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ValidationProfil extends JFrame implements ActionListener {
	
	protected static Dimension d;
	private JPanel container;
	
	protected JLabel validation;
	protected JButton btnQuitter;
	protected JButton btnRetourMenu;
	protected Choix menu;

	public ValidationProfil(){
		// Cr�ation de la fen�tre du programme avec ses dimensions
		getContentPane().setLayout(new BorderLayout() );
		Toolkit tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();
		int w = 850;
		int h = 800;
		int x = (int)d.getWidth()/2 - w/2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x,200,w,300);
		d.setSize(new Dimension(w,h));
		setResizable(false);
		setTitle("Comparateur de candidats");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Utilisateur\\Desktop\\Projet Info4\\logo.gif"));
		
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setBackground(UIManager.getColor("Button.background"));
		container.setLayout(null);
		this.setContentPane(container);
		
		validation = new JLabel(" Votre Profil a bien �t� ajout� dans notre base de donn�es.");
		validation.setBounds(145, 54, 512, 24);
		validation.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		container.add(validation);
		
		btnRetourMenu = new JButton("Retour menu");
		btnRetourMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetourMenu.setBounds(196, 170, 138, 47);
		btnRetourMenu.addActionListener(this);
		container.add(btnRetourMenu);
		
		btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuitter.setBounds(476, 170, 108, 47);
		btnQuitter.addActionListener(this);
		container.add(btnQuitter);
		
		this.setVisible(true);
	}
	
/************************** METHODES ********************************/		
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btnRetourMenu){				  
			menu=new Choix();
			this.setVisible(false);
			this.dispose();
		} 
		if(source == btnQuitter){
			System.exit(0);  
		}	
	}	
}
