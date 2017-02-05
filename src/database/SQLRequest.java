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
	
	// A UTILISER POUR CLOTURER LES CONNEXIONS
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
	
	//Pour prendre en compte un seul critere fort
	public void setSelectOption(String colonne, String arg) {
		this.option = "WHERE (\"" + colonne+ "\" = '"+ arg + "')";
	}
	
	//Pour prendre en compte 2 criteres forts
	public void setSelectOption(String colonne1, String colonne2, String arg1, String arg2) {
		this.option = "WHERE (\"" + colonne1+ "\" = '"+ arg1 + "' AND \"" + colonne2+ "\" = '"+ arg2 + "')";
	}
	
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
	
	//pour candidat
	public void setInsertOption(Candidat candidat) {
		this.option = candidat.getId_candidat()+",'"+candidat.getNom()+"','"+candidat.getPrenom()+"','"+candidat.getTelephone()+"','"+candidat.getMail()+"'" ;
	}
	
	//pour critere
	public void setInsertOption(int id, String filiere, String typeContrat, int age, String permis, String region, int lvlEtu, int exp, String langue, int id_candidat) {
		this.option = id+",'"+filiere+"','"+typeContrat+"','"+age+"','"+permis+"','"+region+"','"+lvlEtu+"','"+exp+"','"+langue+"','"+id_candidat+"'";
	}
	
	//pour la table des candidats retenus
	public void setInsertOption(int idCandidat, int idCritere) {
		this.option = idCandidat+","+idCritere ;
	}
	
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
