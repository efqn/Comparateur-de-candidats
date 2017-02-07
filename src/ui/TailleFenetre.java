package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 * 
 * Fenetre qui sert à l'UI
 *
 */

@SuppressWarnings({ "unused", "serial" })
public class TailleFenetre extends JFrame {
	
	protected static Dimension d;
	
	public TailleFenetre(){
		// Création de la fenêtre du programme avec ses dimensions
		setLayout(new BorderLayout());
		Toolkit tk = Toolkit.getDefaultToolkit();
		d = tk.getScreenSize();
		int w = 850;
		int h = 800;
		int x = (int)d.getWidth()/2 - w/2;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x,10,w,1000);
		d.setSize(new Dimension(w,h));
		setResizable(false);
		setTitle("Comparateur de candidats");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Utilisateur\\Desktop\\Projet Info4\\logo.gif"));		
	}
}
