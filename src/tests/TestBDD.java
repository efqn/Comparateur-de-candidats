package tests;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Candidat.Candidat;
import Criteres.Age;
import Criteres.Critere;
import Criteres.CritereFort;
import Criteres.ExperiencePro;
import Criteres.Filiere;
import Criteres.Langue;
import Criteres.NiveauEtude;
import Criteres.PermisB;
import Criteres.Region;
import Recherche.Billet;
import database.SQLRequest;

public class TestBDD {
	
	public static void main(String[]args) {
///////////////////////////////////////////////////////////////////////
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
			 while ( resultat.next() ) {
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
