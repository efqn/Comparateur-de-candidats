package ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import Candidat.Candidat;
import Criteres.Critere;
import Recherche.Billet;
import Recherche.Demande;

import net.miginfocom.swing.MigLayout;

public class ResultFrame extends TailleFenetre {

	private JPanel contentPane;
	private JPanel container;
	protected MenuHeader menu;
	
	/**
	 * 
	 * @param r  		tous les résultats des candidats d'une recherche
	 */
	public ResultFrame( Demande r) {
		super();
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setBackground(UIManager.getColor("Button.background"));
		container.setLayout(new MigLayout("insets 5 5 5 5", "", ""));
		//container.setLayout(null);
		this.setContentPane(container);
		
		// Menu 
		menu = new MenuHeader();
		menu.setLocation(0, 0);
		menu.setSize(844, 37);
		container.add(menu);
		

		//JScrollPane scrollpane = new JScrollPane(container);
	    //this.getContentPane().add(scrollpane);
		ArrayList<Critere> cand = new ArrayList<Critere>();
		Iterator<Critere> it = cand.iterator();
	    
		Candidat c=null;
		
	    int i=10;
	    while(it.hasNext()){
	    	container.add(new ProfilCandidats(c), "cell 0 "+i);
	    	
	    	//container.add(new ProfilCandidats(cand, ((ConnexionAdmin) parent).isSucceeded(), ResultFrame.this), "cell 0 "+i);

	    	i --;
	    }
	        
		this.setVisible(true);

	        
	}
		
}