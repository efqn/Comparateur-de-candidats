package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ValidationSuppression extends JFrame implements ActionListener {
	
	protected static Dimension d;
	private JPanel container;
	
	protected JLabel validation;
	protected JButton btnQuitter;
	protected JButton btnRetourMenu;
	protected ResultFrameAdmin menu;

	public ValidationSuppression(){
		// Création de la fenêtre du programme avec ses dimensions
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
		
		validation = new JLabel(" Vos profils selectionnés ont bien été supprimés dans notre base de données.");
		validation.setBackground(new Color(50, 205, 50));
		validation.setBounds(83, 76, 681, 24);
		validation.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		container.add(validation);
		
		btnRetourMenu = new JButton("Ok");
		btnRetourMenu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnRetourMenu.setBounds(332, 172, 138, 47);
		btnRetourMenu.addActionListener(this);
		container.add(btnRetourMenu);
		
		this.setVisible(true);
	}
	
/************************** METHODES ********************************/		
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btnRetourMenu){				  
			//menu=new ResultFrameAdmin();
			this.setVisible(false);
			this.dispose();
		} 
		if(source == btnQuitter){
			System.exit(0);  
		}	
	}	
}