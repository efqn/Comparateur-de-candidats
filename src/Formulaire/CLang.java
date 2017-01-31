package Formulaire;

public class CLang {
	// ATTRIBUTS
		private String angNiv;
		private String espNiv;
		private String itaNiv;
		private String allNiv;
		private String chiNiv;
		
			// CONSTRUCTUEUR
		public CLang(String ang, String esp, String ita, String all, String chi)
		{
			angNiv = ang;
			espNiv = esp;
			itaNiv = ita;
			allNiv = all;
			chiNiv = chi;
		}
		
			// METHODE

		public String getAngNiv()
		{
			return angNiv;
		}
		
		public String getEspNiv()
		{
			return espNiv;
		}
		
		public String getItaNiv()
		{
			return itaNiv;
		}
		
		public String getallNiv()
		{
			return allNiv;
		}
		
		public String getChiNiv()
		{
			return chiNiv;
		}

}
