package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import Candidat.Candidat;
import Criteres.Age;
import Criteres.CDD;
import Criteres.Critere;
import Criteres.CritereFort;
import Criteres.ExperiencePro;
import Criteres.Filiere;
import Criteres.Langue;
import Criteres.NiveauEtude;
import Criteres.PermisB;
import Criteres.Region;
import Recherche.Billet;
import Recherche.Demande;
import database.SQLRequest;

public class TestBDD {
	
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
	
	public static void main(String[]args) {
///////////////////////////////////////////////////////////////////////
/////////////////////		TESTS BDD		//////////////////////////	
		
		// TEST DE RECUPERATION DU CONTENU DE LA BASE
		
		Candidat.initCandidats() ;
		Billet.initBillets();
		/*System.out.println("////////////////////////////    TESTS BDD    //////////////////////////////////");
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
	    
	    //recuperer toute la base
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
	    String langues;

		 try {
			 while(resultat.next() && resultat_cand.next() ) {
			   crita = new ArrayList<>();
			   cand = new Candidat(resultat_cand.getString("Nom"), resultat_cand.getString("Prenom"), resultat_cand.getString("Mail"), resultat_cand.getString("Telephone"),  resultat_cand.getInt("ID_candidat"));
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
				langues = resultat.getString("Langue") ;
				if( !langues.equals("") ) {
					   int nb = 0 ;
					   langues = langues.replaceAll(" ", "");
					   String tmp = langues ;
					   nb = langues.length() - langues.replace(",", "").length() ;					//nombre d'occurences de la virgule
					   
					   for(int i=0; i<nb; i++) {
							tmp = langues.substring(0, langues.indexOf(",")) ;						//Format langue : (langue+ espace + niveau)
							langues = langues.substring(langues.indexOf(",")+1) ;
							azaza.add(tmp) ;
						}
					   tmp = langues.substring(0) ;											//on enleve le dernier espace
					   azaza.add(tmp) ;
				}
				lagg = new Langue(azaza);
				
				crita.add(fili);
				crita.add(type_c);
				crita.add(aa);
				crita.add(perm);
				crita.add(regi);
				crita.add(nivEt);
				crita.add(expp);
				crita.add(lagg);
			    bill = new Billet(resultat.getInt("ID_crit"), cand, crita) ;
			    resb.add(bill);
			    System.out.println("\n\n");
		   }
			 
		   System.out.println("Taille resb : "+ resb.size() ) ;
		   int score ;
		   ArrayList<Critere> crit = new ArrayList<>(8) ;
		   boolean[]bool = {true, true, true, true, true, true} ;
		   addC2(crit, 30, 50) ;
		   for(Billet b : resb) {
			   score = b.getScore(crit, bool) ;
			   System.out.println(b) ;
		   }*/
		  // System.out.println(resb) ;
		  /* Iterator<Billet> it = resb.iterator() ;
		   it.next();
		   System.out.println(it.next()) ;*/
		   
		  /* String s = "Anglais+1, Francais+1, Espagnol+1, mognon+88";
		   String tmp = s ;
		   int nb = 0 ;
		   ArrayList<String>test = new ArrayList<>() ;
		   
		   s = s.replaceAll(" ", "") ;										//exit les espaces
		   nb = s.length() - s.replace(",", "").length() ;					//nombre d'occurences de la virgule
		   System.out.println("nb :"+nb);
		   
		   for(int i=0; i<nb; i++) {
				System.out.println("s : "+s);
				tmp = s.substring(0, s.indexOf(",")) ;						//Format langue : (langue+ espace + niveau)
				s = s.substring(s.indexOf(",")+1) ;
				test.add(tmp) ;
			}
		   System.out.println("\nFin boucle\n");
		   tmp = s.substring(0) ;											//on enleve le dernier espace
		   System.out.println(tmp);
		   test.add(tmp) ;
		   System.out.println(test);*/
		   
		   // juste pour afficher ce qui ce recupere
			 /*while ( resultat.next() ) {
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
		    }
		
		} catch(SQLExceptionException e) {
			e.printStackTrace() ;
			System.out.println("ko");
		}
		finally{
			request.closeConnection() ;
			request_cand.closeConnection();
		}*/
		
		//TEST D'OPERATION SUR LA BASE
		
		ArrayList<Critere> crit = new ArrayList<>(8) ;
		boolean[]bool = {true, true, true, true, true, true} ;
		addC2(crit, 30, 50) ;
		Demande d = new Demande(crit, bool) ;
		d.retrieveData("Juridique/Droit", "Stage");
		System.out.println("salut sa va");
		System.out.println("taille all : "+d.getAll().size()) ;
		for( Billet b : d.getAll() ) {
			System.out.println(b) ;
			System.out.println("Candidat ID :"+b.getCandidat().getId_candidat());
		}
		
		System.out.println("test formatage langue ");
		ArrayList<String> yo = new ArrayList<>() ;
		yo.add("Anglais+3") ;
		yo.add("Espagnol+3") ;
		yo.add("Italien+3") ;
		yo.add("Allemand+3") ;
		yo.add("Russe+3") ;
		Langue lang = new Langue(yo) ;
		System.out.println(lang.convertLangueToBDDFormat()+"/");
		
		System.out.println("\n\n TEST INSERT\n\n");
		//Candidat cadi = new Candidat("YOHOHO", "YOOOOOOOORRRR", "123456789", "aze@aze.aze",Candidat.getUnusedId()) ;
		Candidat cadi = new Candidat("YOHOHO", "YOOOOOOOORRRR", "123456789", "aze@aze.aze",804) ;
		ArrayList<Critere> crit2 = new ArrayList<>() ;
		addC3(crit2, 50) ;
		//Billet bambi = new Billet(Billet.getUnusedId(), cadi, crit2) ;
		Billet bambi = new Billet(801, cadi, crit2) ;
		SQLRequest request = new SQLRequest() ;
		SQLRequest request2 = new SQLRequest() ;
		try {
			//request.setInsertOption(cadi) ;
			//request2.setInsertOption(id, filiere, typeContrat, age, permis, region, lvlEtu, exp, langue);
			//request.insertRequest("Candidat");
			//request2.deleteRequest("Candidat", "ID_candidat", 801);
			//bambi.insertEntryIntoDatabase();
			bambi.deleteEntryFromDatabase();
		}
		catch(Exception e) {
			System.out.println("MARCHE PAS");
		}
		finally {
			//request.closeConnection();
			//request2.closeConnection();
		}
	}
///////////////////////////////////////////////////////////////////////////////	
}

