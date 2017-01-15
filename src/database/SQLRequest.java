package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SQLRequest {
	private String option;										//option pour les commandes SQL
	private Connection connexion = null ;
	private PreparedStatement preparedStatement = null ;
	private ResultSet result = null ;
	
	//Constructeur utilise lorsqu'on ignore complement les criteres forts
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
	
	public void selectRequest(String table) {
		try {
		   this.connect() ;
		   this.preparedStatement = this.connexion.prepareStatement("SELECT * FROM \""+ table +"\" "+ option +";") ;
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
	
	public void insertRequest(String table, String option) {
		try {
		   this.connect() ;
		   this.preparedStatement = this.connexion.prepareStatement("INSERT INTO \""+ table +"\" VALUES( "+ option +";") ;
		   this.result = preparedStatement.executeQuery() ;
	   } catch (Exception e) {
	      e.printStackTrace();
	   }
	}
	
	public void setInsertValuesCandidat(ArrayList<String> liste) {
		
	}
	
	public void setInsertValuesCritere(ArrayList<String> liste) {
		
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
