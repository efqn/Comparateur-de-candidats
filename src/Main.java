
import java.io.FileNotFoundException;
import java.util.ArrayList;

import Candidat.Candidat ;
import Criteres.*;
import Recherche.*; 

public class Main {
	
	public static void addC(ArrayList<Critere> criteres, int i) {
		criteres.add(new Filiere("Info")) ;
		criteres.add(new CDD(true)) ;
		criteres.add(new Age(String.valueOf(i))) ;
		criteres.add(new PermisB(true)) ;
		criteres.add(new Region("BDR")) ;
		criteres.add(new NiveauEtude("Master")) ;
		criteres.add(new ExperiencePro(3)) ;
		criteres.add(new Langue("Anglais")) ;
	}
	
	public static void main(String[]args) throws FileNotFoundException {
		
		
		ArrayList<Critere> criteres = new ArrayList<>(10) ;
		ArrayList<Critere> criteres2 = new ArrayList<>(10) ;
		ArrayList<Critere> criteres3 = new ArrayList<>(10) ;
		
		/*criteres.add(new Filiere("Info")) ;
		criteres.add(new CDD(true)) ;
		criteres.add(new Age("25")) ;
		criteres.add(new PermisB(true)) ;
		criteres.add(new Region("BDR")) ;
		criteres.add(new NiveauEtude("BDR")) ;
		criteres.add(new ExperiencePro(3)) ;
		criteres.add(new Langue("Anglais")) ;*/
		addC(criteres, 25) ;
		addC(criteres2, 26) ;
		addC(criteres3, 27) ;
		
		Candidat c = new Candidat("John","Smith","azerty@gmail.com", "07xxxxxxxx") ;
		c.saveC();
		
		ArrayList<Billet> barray = new ArrayList<>() ;
		Billet b = new Billet(c, criteres) ;
		Billet b2 = new Billet(c, criteres2) ;
		Billet b3 = new Billet(c, criteres3) ;
		System.out.println(b) ;
		barray.add(b) ;
		barray.add(b2) ;
		barray.add(b3) ;
		
		System.out.println("\nResultat recherche") ;
		Demande d = new Demande(criteres) ;
		d.rechercheResultats(barray) ;
		System.out.println(d) ;
		
		System.out.println("\ntest score intervalle") ;
		Age age = new Age("23") ;
		System.out.println(age.getScore(25, 30));
		
		System.out.println("\ntest score simple") ;
		Region PACA = new Region("PACA") ;
		System.out.println(PACA.getScore("PACA")) ;
	}
}
