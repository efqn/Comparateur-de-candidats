package ui;

public class Login {

	public static boolean admin_authenticate(String username, String password){
		if(username.equals("admin") && password.equals("admin")) return true;
		return false;
	}
}
