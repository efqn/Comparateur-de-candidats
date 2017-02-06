package Recherche;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Candidat.Candidat;
import Criteres.*;
import Score.ScoreFinal;
import database.SQLRequest;

public class Billet implements ScoreFinal, Comparable<Billet> {
	private Candidat candidat ;
	private ArrayList<Critere> criteres = new ArrayList<>(8) ;
	private int id_crit ;
	private int score = 0;
	
	private static HashMap<Integer, Billet> allBillets = new HashMap<>() ;					//liste de toutes les entrees de la table critere
	
	
	public Billet(int id, Candidat candidat, ArrayList<Critere> criteres) {
		this.candidat = candidat ;
		this.criteres.addAll(criteres) ;
		this.id_crit = id ;
	}
	
//////////////////////////METHODES STATIQUES /////////////////////////////////////
	
	//retourne le 1er id de libre a partir de 1
	public static int getUnusedId() {
		int result = 1 ;
		boolean done = false ;
		
		while( !done ) {
			if( allBillets.containsKey(result)) {
				result++;
			}
			else
				done = true ;
		}
		
		return result ;
	}
	
	public static HashMap<Integer, Billet> getAllBillets() {
		return allBillets ;
	}
	
	//A utiliser au lancement du programme pour avoir une vision de l'etat de la base de donnees
	public static void initBillets() {
		//On recupere les elements dans la base de donnees
		SQLRequest request = new SQLRequest();
		
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
			   //System.out.println("\nID_cand = "+resultat.getInt("ID_candidat")+"\n");
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
			    allBillets.put(billet.getID_crit(), billet) ;
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
	
///////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 * @param criteres 	: Criteres a comparer avec la collection
	 * @param flags		: tableau de boolean pour savoir si il faut prendre en compte le critere concerne

	 * @return	Score final
	 */
	public int getScore(ArrayList<Critere> criteres, boolean[] flags) {
		Iterator<Critere> iter = this.criteres.iterator() ;
		Iterator<Critere> iter2 = criteres.iterator() ;
		this.score = 0 ;															//si on veut recompter pour une autre demande
		
		//Les 2 premiers champs d'une arraylist de criteres seront des criteres forts. Ils ne sont pas utilises pour le calcul
		for(int i=0; i<2; i++)
			iter.next() ;
		for(int i=0; i<2; i++)
			iter2.next() ;
		
		CritereFaible current ;														//critere du billet
		CritereFaible current2 ;													//critere de reference
		int i = 0 ;
		while( iter.hasNext() && iter2.hasNext() ) {
			current = (CritereFaible)iter.next() ;
			current2 = (CritereFaible)iter2.next();
			/*System.out.println("\n\nCalcul score :");
			System.out.println("Reference : " + current2) ;
			System.out.println("current : "+ current) ;
			System.out.println("Score current : "+ current.getScore(current2, flags[i]));*/
			this.score = this.score + current.getScore(current2, flags[i++]) ;
		}
		
		return this.score ;
	}
	
	/**
	 * Insere le billet dans la base de donnees
	 */
	public void insertEntryIntoDatabase() {
		SQLRequest request = new SQLRequest() ;
		this.candidat.insertCandidatIntoDatabase() ;
		try {
			 String filiere = criteres.get(0).getContent() ;
			 String typeContrat = criteres.get(1).getContent() ;
			 int age = Integer.parseInt(criteres.get(2).getContent()) ;
			 String permis = criteres.get(3).getContent() ;
			 String region = criteres.get(4).getContent() ;
			 int lvlEtu = Integer.parseInt(criteres.get(5).getContent()) ;
			 int exp = Integer.parseInt(criteres.get(6).getContent()) ;
			 String langue = criteres.get(7).getContent() ;
			 
			request.setInsertOption(this.id_crit, filiere, typeContrat, age, permis, region, lvlEtu, exp, langue, this.candidat.getId_candidat());
			System.out.println("\n"+this.candidat.getId_candidat());
			request.insertRequest("Critere") ;
			allBillets.put(this.id_crit, this) ;
		}
		catch(Exception e) {
			e.printStackTrace() ;
		}
		finally {
			request.closeConnection();
		}
	}
	
	/**
	 * Supprime le billet de la base de donnees
	 */
	public void deleteEntryFromDatabase() {
		SQLRequest request = new SQLRequest() ;
		try {
			request.deleteRequest("Critere", "ID_crit", this.id_crit);
			this.candidat.deleteCandidatFromDatabase() ;
			allBillets.remove(this.id_crit) ;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			request.closeConnection();
		}
	}
	
	public void afficher() {
		System.out.println("");
	}
	
	/**
	 * Fonction get classique mais le nom getScore et deja utilise pour le calcul du score
	 * @return le score du billet
	 */
	public int getThisScore() {
		return this.score ;
	}
	
	public Candidat getCandidat() {
		return candidat;
	}

	public void setCandidat(Candidat candidat) {
		this.candidat = candidat;
	}
	
	/// a voir 
	public ArrayList<Critere> getCriteres() {
		return criteres;
	}

	public void setCriteres(ArrayList<Critere> criteres) {
		this.criteres = criteres;
	}

	public int getID_crit() {
		return this.id_crit;
	}

	public void setID_crit(int id_crit) {
		this.id_crit = id_crit;
	}

	@Override
	public String toString() {
		return "Billet [candidat=" + candidat + ", criteres=" + criteres + "]";
	}

///////	Methodes a implementer pour les interfaces meres	////////////////
	@Override
	public int getScore(boolean flag, HashMap<String, Integer> reference) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore(boolean flag, String s) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore(boolean flag, int i) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore(boolean flag, int borneInf, int borneSup) {
		// TODO Auto-generated method stub
		return 0;
	}
/////////////////////////////////////////////////////////////////////////

	@Override
	public int compareTo(Billet b) {
		if( this.score < b.getThisScore() )
			return -1 ;
		else if ( this.score == b.getThisScore() )
			return 0 ;
		else
			return 1 ;
			
	}
}
