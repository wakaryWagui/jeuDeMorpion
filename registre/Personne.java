package registre;

public class Personne {
	protected String nom;
	protected String prenom;
	protected int numeroSecurite;
	protected int telPortable;
	protected int telephone;
	protected String adress;
	protected String ville;
	protected int codePostal;
	public Personne() {}
	
	public Personne(String n,String p,int ns,int telP,int tel,String ad,String v,int code) {
		nom=n;
		prenom=p;
		numeroSecurite=ns;
		telPortable=telP;
		telephone=tel;
		adress=ad;
		ville=v;
		codePostal=code;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public int getSecu() {
		return numeroSecurite;
	}
	public int getPortable() {
		return telPortable;
	}
	public String getAdresse() {
		return adress;
	}
	public String getVille() {
		return ville;
	}
	public int getCodePostal() {
		return codePostal;
	}
	
	public boolean contacter(Personne p,boolean cont) {
		if(cont==true) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public boolean accepter(Personne p,boolean acc) {
		if(acc==true) {
			return true;
		}else {
			return false;
		}	
	}
	
	public boolean injection(Personne p,boolean b) {
		if(b==true) {
			return true;
		}else {
			return false;
		}
	}
		
	
	public String toString() {
		return "M/Mme : "+nom+" "+prenom+"\n Adresse : "+adress+" "+codePostal+" "+ville+"\n Numero de securité social :"+numeroSecurite+"\n";
	}
	
	boolean b;
	public void propose(Personne pers,String vaccin) {
		if(pers.contacter(pers,b)==false) {
			System.out.println(pers.toString()+" n' a pas été contacté. ");
		}else if(pers.contacter(pers,b)==true && pers.accepter(pers, b)==false) {
			System.out.println(pers.toString()+" a été contacté mais n'a pas accepter de se faire vacciner !");
		}else if(pers.accepter(pers,b)==true) {
			System.out.println(pers.toString()+" a été contacter et a accepté de se faire vacciner !");
			if(pers.injection(pers,b)==false) {
				System.out.println("1ere injection ");
			}else {
				System.out.println("2eme injection ");
			}
			if(vaccin.equals("suretcertin")) {
				System.out.println("Type de vaccin suretcertin ");
			}else if(vaccin.equals("presksu")) {
				System.out.println("Type de vaccin presksu ");
			}else if (vaccin.equals("Fotvoir")) {
				System.out.println("Type de vaccin Fotvoir ");
			}
		}
	}


}
