package Modeles;

public abstract class Utilisateur {
	private int id_utilisateur;
	protected String nom;
	protected String prenom;
	protected String mot_de_pass; //on modifira le type si le mot de passe doit �tre chiffr� ou crypt�
	
	public Utilisateur(String nom,String prenom,String pass){
		this.nom=nom;
		this.prenom=prenom;
		this.mot_de_pass=pass;
	}
	
	public Utilisateur(String prenom){
		this.prenom=prenom;
	}
	
	public Utilisateur(){}

	
	//a completer
	
	/*************************************************getters**************************************************/
	public int getId(){
		return this.id_utilisateur;
		}
	public String getNom(){
		return this.nom;
	}
	
	public String getPrenom(){
		return this.prenom;
	}
	
	//on verra par la suite si on chiffre le mot de passe 
	public String getMotDePasse(){
		return this.mot_de_pass;
		
	}
	
	
	/***************************************************setters*******************************************************/
	
	public void changeMotDePass(String mp){
		this.mot_de_pass=mp;
		
		//a completer
	}
	
	
	public void setId(int id){
		this.id_utilisateur=id;
	}
	public void setNom(String nom){
		this.nom=nom;
	}
	
	public void setPrenom(String prenom){
		this.prenom=prenom;
	}
	
}
