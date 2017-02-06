package tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


//classe test
public class TestConnectBDD {

		public static void main(String[] args) {      
			Connection connexion = null ;
			PreparedStatement preparedStatement = null ;
			ResultSet resultat = null ;
			
			try {
			   Class.forName("org.postgresql.Driver");
			   System.out.println("Driver O.K.");
	
			   String url = "jdbc:postgresql://localhost:5432/Projet_4A";
			   String user = "postgres";
			   String passwd = "!azerty33AZERTY";
	
			   connexion = DriverManager.getConnection(url, user, passwd);
			   System.out.println("Connexion effective !");    
			   
			   String option = "WHERE (\"Type_contrat\"= 'CDI') ";
			   
			   //Critere
			   preparedStatement = connexion.prepareStatement("SELECT * FROM \"Critere\""+ option +";");

			   //Candidat
			   // preparedStatement = connexion.prepareStatement("SELECT * FROM \"Candidat\""+ option +";");
			   /* Execution d'une requete de lecture */
			   resultat = preparedStatement.executeQuery();
			   
			   /*int idCand;
			   String nom;
			   String prenom;
			   String tel;
			   String mail;
			   while ( resultat.next() ) {
			       idCand = resultat.getInt( "ID_candidat" );
			       nom = resultat.getString( "Nom" );
			       prenom = resultat.getString( "Prenom" );
			       tel = resultat.getString( "Telephone" );
			       mail = resultat.getString( "Mail" );
			       System.out.println(idCand+". Nom: "+nom+", Prenom : "+prenom+", Telephone : "+tel+", Mail : "+mail);
		        }*/
			   
			   int idCrit;
			   String filiere;
			   String t_cont;
			   int age;
			   String permis;
			   String reg;
			   int lvlE;
			   int exp;
			   String lang;
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
		       
		        
		   } catch (Exception e) {
		      e.printStackTrace();
		   } 
		   finally {
			   if (resultat != null) {
				   try {
					   resultat.close() ;
					   System.out.println("Fermeture du ResultSet");
				   } catch(SQLException ignore) {
					   //on ignore les erreurs pour la fermeture, de toutes facons on ferme la connexion
				   }
			   }
			   
			   if (preparedStatement != null) {
				   try {
					   preparedStatement.close() ;
					   System.out.println("Fermeture du PreparedStatement");
				   } catch(SQLException ignore) {
					   //on ignore les erreurs pour la fermeture, de toutes facons on ferme la connexion
				   }
			   }
			   
			   if (connexion != null) {
				   try {
					   connexion.close() ;
					   System.out.println("Fermeture de la connexion");
				   } catch(SQLException ignore) {
					   //on ignore les erreurs pour la fermeture, de toutes facons on ferme la connexion
				   }
			   }
		   }
		}
}
