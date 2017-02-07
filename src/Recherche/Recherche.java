package Recherche;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Candidat.Candidat;
import Criteres.*;
import database.SQLRequest;


public class Recherche {

	private ArrayList<Billet> allResults = new ArrayList<>() ;
	private ArrayList<Billet> subResults = new ArrayList<>() ;
	
	/**
	 * Contient toutes les entrees de la base de donnees
	 */
	public Recherche() {
		SQLRequest request = new SQLRequest();
		ResultSet resultat ;
		
	    //on cree les objets correspondants
	    ArrayList<Critere> critere ;
	    CritereFort fili;
	    CritereFort type_c;
	    Age age ;
	    PermisB permis;
	    Region region;
	    NiveauEtude nivEt;
	    ExperiencePro expp;
	    Langue lang;
	    Candidat cand ;
	    Billet billet ;
	    String langue;

		 try {	 
			 request.selectRequest("Critere");
			 resultat = request.getResult();
			  
			 while(resultat.next()) { 
			   critere = new ArrayList<>();
			   cand = Candidat.getAllCandidats().get(resultat.getInt("ID_candidat")) ;
			   fili = new Filiere(resultat.getString("Filiere"));
			   switch(resultat.getString("Type_contrat")) {
			   		case "CDD" : type_c = new CDD(true) ;
			   					break ;
			   					
			   		case "CDI" : type_c = new CDI(true) ;
			   					break ;
			   					
			   		case "Interim" : type_c = new Interim(true) ;
			   						break ;
			   		
			   		case "Stage"	: type_c = new Interim(true) ;
			   						break ;
			   						
			   		default	: type_c = new CritereFort(resultat.getString("Type_contrat")) ;
 			   }
			   //type_c = new CritereFort(resultat.getString("Type_contrat"));
			   age = new Age(resultat.getInt("Age"));
			   if (resultat.getString("PermisB").equals("Oui") )
					permis = new PermisB(true);
				else
					permis = new PermisB(false) ;
				region = new Region(resultat.getString("Region"));
				nivEt = new NiveauEtude(resultat.getInt("NiveauEtude")) ;
				expp = new ExperiencePro(resultat.getInt("ExperiencePro"));
				
				ArrayList<String> listlangue = new ArrayList<>();
				langue = resultat.getString("Langue") ;
				if( !langue.equals("") ) {															//il se peut que le champ "langue" soit vide
					   int nb = 0 ;
					   langue = langue.replaceAll(" ", "");
					   String tmp = langue ;
					   nb = langue.length() - langue.replace(",", "").length() ;					//nombre d'occurences de la virgule : on aura nb+1 valeurs a recuperer
					   
					   for(int i=0; i<nb; i++) {
							tmp = langue.substring(0, langue.indexOf(",")) ;						//Format langue : (langue+ "+" + niveau)
							langue = langue.substring(langue.indexOf(",")+1) ;
							listlangue.add(tmp) ;
						}
					   tmp = langue.substring(0) ;													//on enleve le dernier espace (le traitement de la derniere valeur est specifique)
					   listlangue.add(tmp) ;
				}
				lang = new Langue(listlangue);
				
				critere.add(fili);
				critere.add(type_c);
				critere.add(age);
				critere.add(permis);
				critere.add(region);
				critere.add(nivEt);
				critere.add(expp);
				critere.add(lang);
			    billet = new Billet(resultat.getInt("ID_crit"), cand, critere) ;
			    this.allResults.add(billet);
		   }
		} 
		catch(SQLException e) {
			e.printStackTrace() ;
			System.out.println("ko");
		}
		finally {
			request.closeConnection() ;
		}
	}
	
	/**
	 * Recupere une sous collection avec des objets qui ont le meme contenu que le critere passee en parametre
	 * @param critere	: Critere pour lequel les elements de la collection devront avoir la meme contenu
	 */
	public void searchFilter(Critere critere) {
		this.subResults.removeAll(subResults) ;										//reset
		Class<?> classe = critere.getClass() ;
		for(Billet b : this.allResults) {
			for(Critere c : b.getCriteres()) {
				if( classe.isInstance(c) ) {
					if( critere.getContent().equals(c.getContent())) {
						subResults.add(b) ;
						//System.out.println("Oui isInstance de"+classe.getClass());
						//System.out.println("INSERTION");
					}
				}
			}
		}
	}

	public ArrayList<Billet> getAllResults() {
		return allResults;
	}

	public void setAllResults(ArrayList<Billet> allResults) {
		this.allResults = allResults;
	}

	public ArrayList<Billet> getSubResults() {
		return subResults;
	}

	public void setSubResults(ArrayList<Billet> subResults) {
		this.subResults = subResults;
	}
	
}
