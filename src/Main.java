
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
		criteres.add(new NiveauEtude(5)) ;
		criteres.add(new ExperiencePro(3)) ;
		ArrayList<String> langues = new ArrayList<>() ;
		langues.add("Anglais") ;
		langues.add("Espagnol") ;
		criteres.add(new Langue(langues)) ;
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
		System.out.println(age.getScore(true, 25, 30));
		
		System.out.println("\ntest score simple1") ;
		Region PACA = new Region("PACA") ;
		System.out.println(PACA.getScore(true, "PACA")) ;
		
		System.out.println("\ntest score simple2") ;
		PermisB pB = new PermisB(false) ;
		System.out.println(PACA.getScore(true, "")) ;
		
		System.out.println("\ntest score simple pond") ;
		NiveauEtude lvlE = new NiveauEtude(0) ;
		System.out.println(lvlE.getScore(true, 7)) ;
		
		System.out.println("\ntest score mult") ;
		ArrayList<String> langues = new ArrayList<>() ;
		langues.add("Anglais") ;
		langues.add("Espagnol") ;
		ArrayList<String> ref = new ArrayList<>() ;
		ref.add("Anglais") ;
		ref.add("caca") ;
		ref.add("caccaa") ;
		ref.add("caccaaa") ;
		ref.add("cacfaa") ;
		ref.add("cacga") ;
		ref.add("chsa") ;
		ref.add("aza") ;
		ref.add("azz") ;
		ref.add("aze") ;
		ref.add("azr") ;
		ref.add("azt") ;
		
		Langue langue = new Langue(langues) ;
		System.out.println(langue.getScore(true, ref)) ;
		System.out.println(ref);
		
	}
}
