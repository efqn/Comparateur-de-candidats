package ui;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

//import Candidat.Candidats;
//import Score.ScoreFinal;
import net.miginfocom.swing.MigLayout;

public class ResultFrame extends TailleFenetre {

	private JPanel contentPane;
	private JPanel container;
	protected MenuHeader menu;
	
	/**
	 * 
	 * @param r  		tous les résultats des candidats d'une recherche
	 */
	public ResultFrame( Results r) {
		super();
		container = new JPanel();
		container.setBorder(new EmptyBorder(5, 5, 5, 5));
		container.setBackground(UIManager.getColor("Button.background"));
		contentPane.setLayout(new MigLayout("insets 5 5 5 5", "", ""));
		this.setContentPane(container);
		

		JScrollPane scrollpane = new JScrollPane(container);
	    getContentPane().add(scrollpane);
	    
	    TreeMap<Float, ArrayList<Candidats>> rl = r.getResults();
	    
	    int i= r.countResults();
	    for (Map.Entry<Float,ArrayList<Candidats>> entry : rl.entrySet()) {
	    	ArrayList<Candidats> alp = entry.getValue();
	        Float score = entry.getKey();
	        
	        for(Candidats cand : alp){
	        	container.add(new ProfilCandidats(score, cand, ((SearchFrame) parent).getIsAdmin(), ResultFrame.this), "cell 0 "+ i );
	        	i--;
	        }
	        
	    }
	    
		this.setVisible(true);

	        
	}
		
}