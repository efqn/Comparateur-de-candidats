package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Candidat.Candidat;

public class SQLRequest {
	private String option;										//option pour les commandes SQL
	private Connection connexion = null ;
	private PreparedStatement preparedStatement = null ;
	private ResultSet result = null ;

	public SQLRequest() {
		this.option = "";
	}
	
	/**
	 * Etablit une connexion avec la base de donnee locale.
	 * Fonctionne pour une base de donnee PostgreSQL.
	 * Pour etablir une connexion avec une base de donnee situee autre part, il faut changer :
	 * 			- le driver selon le type de base de donnee
	 * 			- le login et le mot de passe en fonction de la base
	 */
	public void connect() {
		try {
		   Class.forName("org.postgresql.Driver");
		   System.out.println("Driver O.K.");

		   String url = "jdbc:postgresql://localhost:5432/Projet_4A";
		   String user = "postgres";
		   String passwd = "!azerty33AZERTY";

		  this.connexion = DriverManager.getConnection(url, user, passwd);
		   System.out.println("Connexion effective !\n\n");    
	   } catch (Exception e) {
	      e.printStackTrace();
	      System.out.println("Erreur de connexion a la base de donnees");
	   } 
	}
	
	
	/**
	 * IMPORTANT
	 * A UTILISER POUR CLOTURER LES CONNEXIONS
	 * 
	 */
	public void closeConnection() {
		if (this.result != null) {
			try {
				this.result.close() ;
				System.out.println("\n\nFermeture du ResultSet");
			} catch(SQLException ignore) {
				//on ignore les erreurs pour la fermeture, de toutes facons on ferme la connexion
			}
		}
		   
		if (this.preparedStatement != null) {
			try {
				this.preparedStatement.close() ;
				System.out.println("Fermeture du PreparedStatement");
			} catch(SQLException ignore) {
				//on ignore les erreurs pour la fermeture, de toutes facons on ferme la connexion
			}
		}
		
		if (this.connexion != null) {
			try {
				this.connexion.close() ;
				System.out.println("Fermeture de la connexion");
			} catch(SQLException ignore) {
				//on ignore les erreurs pour la fermeture, de toutes facons on ferme la connexion
			}
		}
	}
	
	
	/**
	 * 
	 * Effectue une selection dans la table specifiee en parametre. 
	 * Option est defini par les setSelectOption si il y a besoin d'affiner le retour de la base
	 * 
	 * @param table 		: table dans laquelle la requete de selection doit etre faite
	 * @throws SQLException
	 */
	public void selectRequest(String table) throws SQLException {
		try {
		   this.connect() ;
		   this.preparedStatement = this.connexion.prepareStatement("SELECT * FROM \""+ table +"\" "+ option +";") ;
		   System.out.println("OK ON SELECT");
		   System.out.println("\n\n\nSELECT * FROM \""+ table +"\" "+ option +";\n\n\n");
		   this.result = preparedStatement.executeQuery() ;
	   } catch (Exception e) {
	      e.printStackTrace();
	   }
	}
	
	
	/**
	 * On utilise cette fonction si on veut juste prendre en compte un seul critere fort (dans le cadre de l'application)
	 * On lui preferera la version a 2 criteres forts qui affine mieux la recherche
	 * 
	 * @param colonne	: Colonne dans la table de la base de donnee sur laquelle il faut donner des precisions
	 * @param arg		: Valeur pour la colonne sur laquelle on veut des precisions
	 */
	public void setSelectOption(String colonne, String arg) {
		this.option = "WHERE (\"" + colonne+ "\" = '"+ arg + "')";
	}
	
	
	/**
	 * Version a 2 criteres forts de setSelectOption
	 * 
	 * @param colonne1	: 1ere colonne dans la table de la base de donnee sur laquelle il faut donner des precisions
	 * @param colonne2	: 2eme colonne dans la table de la base de donnee sur laquelle il faut donner des precisions
	 * @param arg1		: Valeur pour la 1ere colonne
	 * @param arg2		: Valeur pour la 2eme colonne
	 */
	public void setSelectOption(String colonne1, String colonne2, String arg1, String arg2) {
		this.option = "WHERE (\"" + colonne1+ "\" = '"+ arg1 + "' AND \"" + colonne2+ "\" = '"+ arg2 + "')";
	}
	
	
	/**
	 * Effectue une requete d'insertion dans la table specifiee en parametre
	 * @param table			: table dans laquelle effectuer l'insertion
	 * @throws SQLException
	 */
	public void insertRequest(String table) throws SQLException {
		try {
		   this.connect() ;
		   this.preparedStatement = this.connexion.prepareStatement("INSERT INTO \""+ table +"\" VALUES( "+ option +");") ;
		   System.out.println("\n\nINSERT INTO \""+ table +"\" VALUES( "+ option +");");
		   preparedStatement.executeUpdate() ;
	   } catch (Exception e) {
	      e.printStackTrace();
	   }
	}
	
	
	/**
	 * Definit les valeurs a inserer dans la base de donnees pour la table Candidat
	 * @param candidat : le candidat a inserer
	 */
	public void setInsertOption(Candidat candidat) {
		this.option = candidat.getId_candidat()+",'"+candidat.getNom()+"','"+candidat.getPrenom()+"','"+candidat.getTelephone()+"','"+candidat.getMail()+"'" ;
	}
	
	
	/**
	 * Definit les valeurs a inserer dans la base de donnees pour la table Critere.
	 * Les parametres suivants correspondent aux champs a inserer dans la base
	 * @param id
	 * @param filiere
	 * @param typeContrat
	 * @param age
	 * @param permis
	 * @param region
	 * @param lvlEtu
	 * @param exp
	 * @param langue
	 * @param id_candidat
	 */
	public void setInsertOption(int id, String filiere, String typeContrat, int age, String permis, String region, int lvlEtu, int exp, String langue, int id_candidat) {
		this.option = id+",'"+filiere+"','"+typeContrat+"','"+age+"','"+permis+"','"+region+"','"+lvlEtu+"','"+exp+"','"+langue+"','"+id_candidat+"'";
	}
	
	
	/**
	 * Definit les valeurs a rentrer dans la base de donnees pour la table Retenus
	 * @param idCandidat	: id du candidat
	 * @param idCritere		: id du critere
	 */
	public void setInsertOption(int idCandidat, int idCritere) {
		this.option = idCandidat+","+idCritere ;
	}
	
	
	/**
	 * Effectue une requete de suppression dans la base de donnees
	 * @param table			: table dans laquelle il faut supprimer
	 * @param idname		: nom de la colonne contenant les id
	 * @param id			: id de l'entree a supprimer
	 * @throws SQLException
	 */
	public void deleteRequest(String table, String idname, int id) throws SQLException {
		try {
			   this.connect() ;
			   this.preparedStatement = this.connexion.prepareStatement("DELETE FROM \""+ table +"\" WHERE( \""+idname+"\" = "+ id +");") ;
			   preparedStatement.executeUpdate() ;
		   } catch (Exception e) {
		      e.printStackTrace();
		   }
	}
	
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}
}
