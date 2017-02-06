package tests;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

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
import Recherche.Demande;

public class TestScore {
	
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
	
	public static void addC2(ArrayList<Critere> criteres, int i, int i2) {
		criteres.add(new Filiere("Info")) ;
		criteres.add(new CDD(true)) ;
		criteres.add(new Age(i, i2)) ;
		criteres.add(new PermisB(false)) ;
		criteres.add(new Region("aze")) ;
		criteres.add(new NiveauEtude(7)) ;
		criteres.add(new ExperiencePro(5)) ;
		ArrayList<String> langues = new ArrayList<>() ;
		langues.add("Anglais+3") ;
		langues.add("Espagnol+3") ;
		langues.add("Italien+3") ;
		langues.add("Allemand+3") ;
		langues.add("Russe+3") ;
		criteres.add(new Langue(langues)) ;
	}
	
	public static void addC3(ArrayList<Critere> criteres, int i) {
		criteres.add(new Filiere("Info")) ;
		criteres.add(new CDD(true)) ;
		criteres.add(new Age(i)) ;
		criteres.add(new PermisB(false)) ;
		criteres.add(new Region("aze")) ;
		criteres.add(new NiveauEtude(7)) ;
		criteres.add(new ExperiencePro(5)) ;
		ArrayList<String> langues = new ArrayList<>() ;
		langues.add("Anglais+3") ;
		langues.add("Espagnol+3") ;
		langues.add("Italiano+3") ;
		langues.add("Allemand+3") ;
		langues.add("Russe+3") ;
		criteres.add(new Langue(langues)) ;
	}
	
	public static void main(String[]args) throws FileNotFoundException {
		ArrayList<Critere> criteres = new ArrayList<>(8) ;
		ArrayList<Critere> criteres2 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres3 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres4 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres5 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres6 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres7 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres8 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres9 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres10 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres11 = new ArrayList<>(8) ;
		ArrayList<Critere> criteres12 = new ArrayList<>(8) ;
		
		/*criteres.add(new Filiere("Info")) ;
		criteres.add(new CDD(true)) ;
		criteres.add(new Age("25")) ;
		criteres.add(new PermisB(true)) ;
		criteres.add(new Region("BDR")) ;
		criteres.add(new NiveauEtude("BDR")) ;
		criteres.add(new ExperiencePro(3)) ;
		criteres.add(new Langue("Anglais")) ;*/
		addC(criteres, 25) ;
		addC(criteres2, 12) ;
		addC(criteres3, 22) ;
		addC(criteres4, 21) ;
		addC(criteres5, 54) ;
		addC(criteres6, 85) ;
		addC(criteres7, 28) ;
		addC(criteres8, 29) ;
		addC(criteres9, 30) ;
		addC(criteres10, 10) ;
		addC(criteres11, 40) ;
		addC3(criteres12, 25) ;
		
		
		Candidat c = new Candidat("John","Smith","azerty@gmail.com", "07xxxxxxxx", 1) ;
		c.saveC();
		
		ArrayList<Billet> barray = new ArrayList<>() ;
		Billet b = new Billet(1,c, criteres) ;
		Billet b2 = new Billet(2,c, criteres2) ;
		Billet b3 = new Billet(3,c, criteres3) ;
		Billet b4 = new Billet(4,c, criteres4) ;
		Billet b5 = new Billet(5,c, criteres5) ;
		Billet b6 = new Billet(6,c, criteres6) ;
		Billet b7 = new Billet(7,c, criteres7) ;
		Billet b8 = new Billet(8,c, criteres8) ;
		Billet b9 = new Billet(9,c, criteres9) ;
		Billet b10 = new Billet(10,c, criteres10) ;
		Billet b11 = new Billet(11,c, criteres11) ;
		Billet b12 = new Billet(12,c, criteres12) ;
		//System.out.println(b) ;
		barray.add(b) ;
		barray.add(b2) ;
		barray.add(b3) ;
		barray.add(b4) ;
		barray.add(b5) ;
		barray.add(b6) ;
		barray.add(b7) ;
		barray.add(b8) ;
		barray.add(b9) ;
		barray.add(b10) ;
		barray.add(b11) ;
		barray.add(b12) ;
		
		boolean[] flags = {true, true, true, true, true, true} ;
			
		System.out.println("\nResultat recherche + score") ;
		ArrayList<Critere> critest = new ArrayList<>(8) ;
		addC2(critest, 23, 26) ;
		Demande d = new Demande(critest, flags) ;
		d.setAll(barray);
		d.rechercheResultats() ;
		System.out.println(d) ;
		
/////////////////////		TESTS SCORE		//////////////////////////	
		System.out.println("\ntest score intervalle") ;
		Age age = new Age(23) ;
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
		
		System.out.println("\ntest score simple pond2") ;
		ExperiencePro exp = new ExperiencePro(0) ;
		System.out.println(exp.getScore(true, 7)) ;
		
		System.out.println("\ntest score mult") ;
		ArrayList<String> langues = new ArrayList<>() ;
		langues.add("Anglais+2") ;
		langues.add("Espagnol+2") ;
		/*ArrayList<String> ref = new ArrayList<>() ;
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
		ref.add("azt") ;*/
		HashMap<String, Integer> ref = new HashMap<>() ;
		ref.put("Anglais", 2) ;
		ref.put("Russe", 2) ;
		ref.put("Suedois", 2) ;
		ref.put("Portugais", 2) ;
		ref.put("Polonais", 2) ;
		ref.put("Coreen", 2) ;
		
		Langue langue = new Langue(langues) ;
		System.out.println(langue.getScore(true, ref)) ;
		System.out.println(ref);
		System.out.println("Critere recherches :\n"+ critest) ;
		System.out.println("Contenu billet :\n" + b2.getCriteres()) ;
		System.out.println("Score billet 1 :" + b2.getScore(critest, flags)) ;

	}

}
