package ui;

/**
 * 
 * Utilisateur et mot de passe pour la connexion
 *
 */
public class Login {

	/**
	 * Vérifie que l'utilisateur a rentré le bon utilisateur et mot de passe
	 * @param username
	 * @param password
	 * @return boolean
	 */
	public static boolean admin_authenticate(String username, String password){
		if(username.equals("admin") && password.equals("admin")) return true;
		return false;
	}
}
