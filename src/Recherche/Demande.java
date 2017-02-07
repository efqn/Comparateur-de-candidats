package Recherche;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

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
import database.SQLRequest;

public class Demande {
	private ArrayList<Critere> recherche = new ArrayList<>(8) ;						//criteres de recherche
	private ArrayList<Billet> resultats = new ArrayList<>(10) ;						//les 10 meilleurs resultats (initialement vide)
	private ArrayList<Billet> all = new ArrayList<>() ;								//selection de la base de donnees
	private boolean[] flags ;														//flags permettant d'ignorer ou non les criteres correspondants a une case
	
	private static HashMap<Integer, Integer> allRetenus = new HashMap<>() ;			//liste de toutes les entrees de la table "Retenus" dans la base de donnees
	
	/**
	 * 
	 * @param criteres : Criteres de references
	 * 					---> dans l'ordre : Filiere, type de contrat, Age, PermisB, Region, NiveauEtude, ExperiencePro, Langue
	 * @param flags    : Criteres Faibles a prendre en compte
	 * 					---> dans l'ordre : Age, PermisB, Region, NiveauEtude, ExperiencePro, Langue
	 */
	public Demande(ArrayList<Critere> criteres, boolean[]flags) {
			this.recherche.addAll(criteres) ;
			this.flags = new boolean[this.recherche.size()-2] ;							// les -2 correspond aux criteres forts, qui ne sont pas pris en compte ici
			for(int i=0; i<this.flags.length; i++)
				this.flags[i] = flags[i] ;
	}
	
///////////////////////   METHODE STATIQUE   /////////////////////////////////
	public static void initRetenus() {
		SQLRequest request= new SQLRequest();
		try {
			request.selectRequest("Retenus") ;
			ResultSet resultat = request.getResult();
		
			while( resultat.next() ){
				 allRetenus.put(resultat.getInt("id_cand"), resultat.getInt("id_crit")) ;
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
////////////////////////////////////////////////////////////////////
	/**
	 * Recupere les entrees de la base de donnee pour lesquelles les champs specifies en parametres correspondent
	 * @param filiere		: nom de la filiere pour laquelle la colonne "Filiere" de la base doit correspondre
	 * @param typeContrat	: type de contrat pour lequel la colonne "Type_contrat" de la base doit correspondre
	 */
	public void retrieveData(String filiere, String typeContrat) {
		//On recupere les elements dans la base de donnees correspondant deux colonnes filiere et typeContrat
		SQLRequest request = new SQLRequest();
		request.setSelectOption("Filiere", "Type_contrat", filiere, typeContrat);
		
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
			  ResultSet resultat = request.getResult();
				
			 while(resultat.next()) {
			   critere = new ArrayList<>();
			   //cand = this.allCandidats.get(resultat.getInt("ID_candidat")) ;
			   cand = Candidat.getAllCandidats().get(resultat.getInt("ID_candidat")) ;
			   System.out.println("\nID_cand = "+resultat.getInt("ID_candidat")+"\n");
			   fili = new Filiere(resultat.getString("Filiere"));
			   type_c = new CritereFort(resultat.getString("Type_contrat"));
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
			    billet = new Billet( resultat.getInt("ID_crit"),cand, critere) ;
			    this.all.add(billet);
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
	 * Cette fonction selectionne les 10 meilleurs resultats de la selection de la base de donnee
	 * Le nombre de resultats est limite a 10
	 */
	public void rechercheResultats() {
		ArrayList<Billet> tmp = this.all ;
		Billet min ;	
		Iterator<Billet> iter = tmp.iterator() ;
		
		// remplir 'resultats' avec les 10 premiers trouves
		Billet current ;
		for(int i=0; i<10; i++) {
			if( iter.hasNext() ) {
				current = (Billet)iter.next() ;
				current.getScore(this.recherche, this.flags) ;
				this.resultats.add(current) ;
			}
		}
		
		/* 
		 * Parcourir le reste des candidats 
		 * et les mettre dans 'resultats' si ils sont meilleurs que le min courant dans 'resultats'
		*/
		min = Collections.min(this.resultats) ;
		while(iter.hasNext()) {
			current = (Billet)iter.next() ;
			System.out.println("Score = "+current.getScore(recherche, flags)) ;
			if( min.getThisScore() < current.getThisScore()) {
				this.resultats.remove(min) ;
				this.resultats.add(current) ;
				min = Collections.min(this.resultats) ;
			}
		}
		
		//Tri des resultats dans l'ordre decroissant
		Collections.sort(this.resultats) ;
		Collections.reverse(this.resultats) ;
		System.out.println("Score min : "+Collections.min(this.resultats).getThisScore()) ;
	}
	
	/**
	 * Insere le billet reference par id_critere dans la "Retenus" de la base de donnees.
	 * Un controle est effectue avant insertion pour verifier si le billet n'est pas deja dans la table.
	 * @param id_critere : id du billet a inserer dans la table
	 */
	public void insertEntryIntoDatabase(int id_critere) {
		
		if ( !allRetenus.containsValue(id_critere) ) {
			SQLRequest request = new SQLRequest() ;
			Billet tmp = Billet.getAllBillets().get(id_critere) ;
			System.out.println(tmp);
			ArrayList<Critere> criteres = new ArrayList<>() ;
			Candidat candidat = tmp.getCandidat() ;
			int id_crit = tmp.getID_crit() ;
			int id_candidat = candidat.getId_candidat() ;
			
			//Recupere les criteres dans une ArrayList pour etre au bon format d'insertion
			for(Critere c : tmp.getCriteres())
				criteres.add(c) ;
			
			try {	 
				request.setInsertOption(id_candidat, id_crit) ;
				request.insertRequest("Retenus") ;
				allRetenus.put(id_candidat, id_crit) ;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				request.closeConnection() ;
			}
		}
		else
			System.out.println("Entree pour la valeur "+id_critere+" deja presente dans la table Retenus");
	}
	
	
	/**
	 * Supprime le billet reference par id_critere de la table "Retenus" de la base de donnee
	 * @param id_critere : id du billet a supprimer de la table
	 */
	public void deleteEntryFromDatabase(int id_critere) {
		
		if ( allRetenus.containsValue(id_critere) ) {
			SQLRequest request = new SQLRequest() ;
			Billet tmp = Billet.getAllBillets().get(id_critere) ;
			int id_candidat = tmp.getCandidat().getId_candidat() ;
			try {	 
				request.deleteRequest("Retenus", "id_crit", id_critere) ;
				allRetenus.remove(id_candidat, id_critere) ;
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				request.closeConnection() ;
			}
		}
		else
			System.out.println("Entree deja inexistante dans la table Retenus");
	}
	
	public ArrayList<Critere> getRecherche() {
		return recherche;
	}

	public void setRecherche(ArrayList<Critere> recherche) {
		this.recherche = recherche;
	}

	public ArrayList<Billet> getResultats() {
		return resultats;
	}

	public void setResultats(ArrayList<Billet> resultats) {
		this.resultats = resultats;
	}
	
	public ArrayList<Billet> getAll() {
		return all;
	}

	public void setAll(ArrayList<Billet> all) {
		this.all = all;
	}
	
	public boolean[] getFlags() {
		return flags;
	}

	public void setFlags(boolean[] flags) {
		this.flags = flags;
	}

	public String toString() {
		String result = "" ;
		Billet current ;
		Iterator<Billet> iter = this.resultats.iterator() ;
		while(iter.hasNext()) {
			//result = result + iter.next() ++ "\n";
			current = (Billet)iter.next();
			result = result + current + current.getThisScore() + "\n" ;
		}
		return result ;
	}
	
}
