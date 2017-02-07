
import java.awt.EventQueue;
import java.util.ArrayList;

import Candidat.Candidat;
import Criteres.Age;
import Criteres.CDD;
import Criteres.Critere;
import Criteres.ExperiencePro;
import Criteres.Filiere;
import Criteres.Langue;
import Criteres.NiveauEtude;
import Criteres.PermisB;
import Criteres.Region;
import Recherche.Billet;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Candidat.initCandidats();
					Billet.initBillets();
					Accueil frame = new Accueil();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	


}
