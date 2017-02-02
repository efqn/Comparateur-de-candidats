
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Candidat.Candidat ;
import Criteres.*;
import Recherche.*;
import database.SQLRequest; 

public class Main {
	
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
	
	public static void main(String[]args) {
		System.out.println("main") ;
		ArrayList<Critere> crit = new ArrayList<>(8) ;
		boolean[]bool = {true, true, true, true, true, true} ;
		addC2(crit, 30, 50) ;
		Demande d = new Demande(crit, bool) ;
		d.retrieveData("Juridique/Droit", "CDI");
		System.out.println("salut sa va");
		System.out.println("taille all : "+d.getAll().size()) ;
	}
}
