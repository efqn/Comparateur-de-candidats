
import java.io.FileNotFoundException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Candidat.Candidat ;
import Criteres.*;
import Recherche.*;
import database.SQLRequest; 

public class Main {
	
	public static void addC(ArrayList<Critere> criteres, int i) {
		criteres.add(new Filiere("Info")) ;
		criteres.add(new CDD(true)) ;
		criteres.add(new Age(i)) ;
		criteres.add(new PermisB(true)) ;
		criteres.add(new Region("BDR")) ;
		criteres.add(new NiveauEtude(2)) ;
		criteres.add(new ExperiencePro(1)) ;
		ArrayList<String> langues = new ArrayList<>() ;
		langues.add("Anglais") ;
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
		langues.add("Anglais") ;
		langues.add("Espagnol") ;
		langues.add("Italiano piano") ;
		langues.add("Allemand") ;
		langues.add("Russe") ;
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
		langues.add("Anglais") ;
		langues.add("Espagnol") ;
		langues.add("Italiano piano") ;
		langues.add("Allemand") ;
		langues.add("Russe") ;
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
		
		
		Candidat c = new Candidat("John","Smith","azerty@gmail.com", "07xxxxxxxx") ;
		c.saveC();
		
		ArrayList<Billet> barray = new ArrayList<>() ;
		Billet b = new Billet(c, criteres) ;
		Billet b2 = new Billet(c, criteres2) ;
		Billet b3 = new Billet(c, criteres3) ;
		Billet b4 = new Billet(c, criteres4) ;
		Billet b5 = new Billet(c, criteres5) ;
		Billet b6 = new Billet(c, criteres6) ;
		Billet b7 = new Billet(c, criteres7) ;
		Billet b8 = new Billet(c, criteres8) ;
		Billet b9 = new Billet(c, criteres9) ;
		Billet b10 = new Billet(c, criteres10) ;
		Billet b11 = new Billet(c, criteres11) ;
		Billet b12 = new Billet(c, criteres12) ;
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
		d.rechercheResultats(barray) ;
		System.out.println(d) ;
/////////////////////		TESTS SCORE		//////////////////////////	
		/*System.out.println("\ntest score intervalle") ;
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
		System.out.println(ref);*/
		/*System.out.println("Critere recherches :\n"+ critest) ;
		System.out.println("Contenu billet :\n" + b2.getCriteres()) ;
		System.out.println("Score billet 1 :" + b2.getScore(critest, flags)) ;*/
///////////////////////////////////////////////////////////////////////////////	
/////////////////////		TESTS BDD		//////////////////////////	
		
		System.out.println("////////////////////////////    TESTS BDD    //////////////////////////////////");
		SQLRequest request = new SQLRequest();
		SQLRequest request_cand = new SQLRequest();
		request.selectRequest("Critere");
		ResultSet resultat = request.getResult();
		request_cand.selectRequest("Candidat") ;
		ResultSet resultat_cand = request_cand.getResult();
	    int idCrit;
	    String filiere;
	    String t_cont;
	    int age;
	    String permis;
	    String reg;
	    int lvlE;
	    int exp;
	    String lang;  
	    
	    ArrayList<Billet> resb = new ArrayList<>();
	    ArrayList<Critere> crita ;
	    CritereFort fili;
	    CritereFort type_c;
	    Age aa ;
	    PermisB perm;
	    Region regi;
	    NiveauEtude nivEt;
	    ExperiencePro expp;
	    Langue lagg;
	    Candidat cand ;
	    Billet bill ;
		try {
		   while(resultat.next() && resultat_cand.next() ) {
			   crita = new ArrayList<>();
			   cand = new Candidat(resultat_cand.getString("Nom"), resultat_cand.getString("Prenom"), resultat_cand.getString("Telephone"), resultat_cand.getString("Mail"));
			   fili = new Filiere(resultat.getString("Filiere"));
			   type_c = new CritereFort(resultat.getString("Type_contrat"));
			   aa = new Age(resultat.getInt("Age"));
			   if (resultat.getString("PermisB").equals("Oui") )
					perm = new PermisB(true);
				else
					perm = new PermisB(false) ;
				regi = new Region(resultat.getString("Region"));
				nivEt = new NiveauEtude(resultat.getInt("NiveauEtude")) ;
				expp = new ExperiencePro(resultat.getInt("ExperiencePro"));
				ArrayList<String> azaza = new ArrayList<>();
				azaza.add(resultat.getString("Langue")) ;
				lagg = new Langue(azaza);
				crita.add(fili);
				crita.add(type_c);
				crita.add(aa);
				crita.add(perm);
				crita.add(regi);
				crita.add(nivEt);
				crita.add(expp);
				crita.add(lagg);
			    bill = new Billet(cand, crita) ;
			    resb.add(bill);
		   }
		   
		   System.out.println("Taille resb : "+ resb.size() );
			/* while ( resultat.next() ) {
			    idCrit = resultat.getInt( "ID_crit" );
			    filiere = resultat.getString( "Filiere" );
			    t_cont = resultat.getString( "Type_contrat" );
			    age = resultat.getInt( "Age" );
			    permis = resultat.getString( "PermisB" );
			    reg = resultat.getString( "Region" );
			    lvlE = resultat.getInt( "NiveauEtude" );
			    exp = resultat.getInt( "ExperiencePro" );
			    lang = resultat.getString( "Langue" );
			    System.out.println(idCrit+". Filiere: "+filiere+", Type_contrat : "+t_cont+", Age : "+age+", Permis : "+permis
			    		   +", Region : "+reg+", NiveauEtude : "+lvlE+", ExperiencePro : "+exp+", Langues : "+lang);
		    }*/
		    
		} catch(SQLException e) {
			e.printStackTrace() ;
			System.out.println("ko");
		}
		finally{
			request.closeConnection() ;
			request_cand.closeConnection();
		}
///////////////////////////////////////////////////////////////////////////////	
		
	}
}
