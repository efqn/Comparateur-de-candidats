package Candidat ;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Candidat {
	private String nom ;
	private String prenom ;
	private String mail ;
	private String telephone ;
	private int id_candidat ;	
	
	public Candidat(String nom, String prenom, String mail, String tel, int id_candidat) {
		this.nom = nom ;
		this.prenom = prenom ;
		this.mail = mail ;
		this.telephone = tel ;
		this.id_candidat = id_candidat ;
	}
	
	/**
	 * 
	 * @param String s : Nom du fichier a creer
	 * @return File fic : Le fichier cree
	 * @throws FileNotFoundException
	 */
	public File createFile(String s) throws FileNotFoundException {
		FileWriter fw = null ;
		File fic = null ;
		String SL = System.getProperty("line.separator") ;	
		
		try {
			fic = new File(s) ;
			if( fic.exists() )
				System.out.println("Fichier trouve");
			else if( fic.createNewFile() )
				System.out.println("Le fichier '"+ nom + " "+ prenom +"' a ete cree avec succes dans\n'"+fic.getAbsolutePath() +"'") ;
			else throw new Exception() ;
			
			fw = new FileWriter(fic)	;														//ouverture du fichier pour ecriture
			fw.write("Nom:       "+ nom + SL +"Prenom:    "+ prenom + SL+"Email:     "+ mail + SL + "Telephone :   ") ;
		} catch(FileNotFoundException e) {
			e.printStackTrace() ;
			}
		 	catch(Exception e) {
		 		System.out.println("Erreur de creation de fichier") ;
		 	}
				finally {
					try{
						if( fw != null )
							fw.close() ;														//fermeture du fichier
					} catch (IOException e) {
						e.printStackTrace() ;
					}
				}
		return fic ;
	}
	
	/**
	 * Dans le cas classique d'utilisation, le bureau d'un user est dansle C:/ (sous windows)
	 * Les autres cas ne sont pas (encore) traites
	 * @param String s : Nom du dossier a creer
	 * @return File dir : Le dossier cree
	 */
	public File createDirectory(String s) {
		String desktop_path = System.getProperty("user.home") + "\\Desktop\\" ;
				System.out.println(desktop_path) ;
		File dir = new File(desktop_path+s) ;
		try {
			if( dir.exists() && dir.isDirectory() )
				System.out.println("Le dossier '"+s+"' existe deja") ;
			else if( dir.mkdir() )
					System.out.println("Le dossier '"+s+"' a ete cree avec succes dans\n'"+dir.getAbsolutePath()+"'" ) ;
			else throw new Exception() ;
		} catch(Exception e) {
			System.out.println("erreur de creation de repertoire") ;
		}
		return dir ;  
	}
	
	/**
	 * Il faudra gerer les personnes avec le meme nom :
	 * 	- si c'est effectivement la meme personne, ecraser le fichier (elle a pu ajouter de nouvelles choses)
	 * 	- sinon, on créera un 2e fichier (nom prenom 2?)
	 * 
	 * il faudra faire un hash avec les differents attributs des candidats pour les distinquer
	 * 
	 * essayer de creer des fonction "creer repertoire" et "creer fichier"
	 * @throws FileNotFoundException
	 */
	public void saveC() throws FileNotFoundException {
		File dir = null ;
		
		dir = createDirectory("Candidats a contacter") ;
		createFile(dir.getAbsolutePath()+"\\"+nom+" "+prenom+".txt") ;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "Candidat [nom=" + nom + ", prenom=" + prenom + ", mail=" + mail + ", telephone=" + telephone + "]";
	}

}
