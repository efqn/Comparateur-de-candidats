package tests;

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
import Recherche.Recherche;

public class TestRecherche {
	
	public static void addC(ArrayList<Critere> criteres, int i) {
		criteres.add(new Filiere("Info")) ;
		criteres.add(new CDD(true)) ;
		criteres.add(new Age(i)) ;
		criteres.add(new PermisB(true)) ;
		criteres.add(new Region("BDR")) ;
		criteres.add(new NiveauEtude(2)) ;
		criteres.add(new ExperiencePro(1)) ;
		ArrayList<String> langues = new ArrayList<>() ;
		langues.add("Anglais+3") ;
		criteres.add(new Langue(langues)) ;
	}
	
	public static void main(String[]args) {
		Recherche search = new Recherche() ;
		Candidat cand = new Candidat("yoyo","pilipilu","01238606","a@a.a", 2);
		ArrayList<Critere> crit = new ArrayList<>() ;
		addC(crit, 25) ;
		Billet billet = new Billet(1, cand, crit) ;

		/*for( Billet b : search.getSubResults() ) {
			System.out.println(b) ;
		}*/
		Region region = new Region("ririri") ;
		search.searchFilter(new CDD(true));
		System.out.println("\nTaille result: "+search.getSubResults().size());
		
		Age age = new Age(25) ;
		Class<?> classe = region.getClass() ;
		Critere critere = new NiveauEtude(5) ;
		Critere exp = new ExperiencePro(1) ;
		classe = exp.getClass() ;
		System.out.println(classe);
		int i = 2 ;
		if(classe.isInstance(crit))
			System.out.println("Instance ok");
		else
			System.out.println("caca");
		
		/*System.out.println("test boucle");
		for(Critere c : billet.getCriteres()) {
			System.out.println("\nClasse : "+c.getClass());
			if(classe.isInstance(c)) {
				//System.out.println("Oui isInstance de"+classe.getClass());
				if( exp.getContent().equals(c.getContent()) )
					System.out.println("Valeur egales");
				else
					System.out.println("Valeurs differentes");
			}
			else
				System.out.println("N'est pas instance");
		}*/
	}
}
