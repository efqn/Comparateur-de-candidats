package Formulaire;


public class RecupFormualire {
	
	private CAge age;
	private CExp experience;
	
	private CNom nom;
	private CPrenom prenom;
	private CTel telephone;
	private CEmail email;
	private CPermis permis;
	private CRegion region;
	
	private CDomComp domaineComp;
	private CEmploi emploi;
	private CNivEtude niveauEtude;
	private CLang langue;
	
	// CONSTRUCTUEUR
	public RecupFormualire(){
		
	}
	
	/**
	 * 
	 * @param ag : 
	 * @param exp
	 * @param n
	 * @param p
	 * @param tel
	 * @param em
	 * @param perm
	 * @param reg
	 * @param comp
	 * @param emp
	 * @param nEtude
	 * @param lang
	 */
	public RecupFormualire(CAge ag, CExp exp, CNom n, CPrenom p, CTel tel, CEmail em, CPermis perm, CRegion reg, CDomComp comp, CEmploi emp, CNivEtude nEtude, CLang lang)
	{
		age= ag;
		experience= exp;
		nom= n;
		prenom= p;
		telephone= tel;
		email= em;
		permis= perm;
		region= reg;
		domaineComp= comp;
		emploi= emp;
		niveauEtude= nEtude;
		langue= lang;
	}
	
	// METHODES
		public String getNom()
		{
			return nom.getField();
		}
		
		public String getPrenom()
		{
			return prenom.getField();
		}
		
		public String getTelephone()
		{
			return telephone.getField();
		}
		
		public String getEmail()
		{
			return email.getField();
		}
		
		/**
		 * Fonction retournant l'âge du candidat.
		 * @return age.getAge() : int, l'âge du candidat.
		 */
		public Integer getCandAge()
		{
			return (age ==null)? null:age.getAge();
		}
		
		/**
		 * Fonction retournant l'experience du candidat.
		 * @return experience.getExp(): int, l'experience du candidat.
		 */
		public Integer getCandExp()
		{
			return (experience ==null)? null:experience.getExp();
		}
		

}
