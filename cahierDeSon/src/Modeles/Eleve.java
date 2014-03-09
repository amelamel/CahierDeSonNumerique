package Modeles;


public class Eleve extends Utilisateur{

	private String surnom;
	private String lienImage;
	private String classe;
	

	public Eleve(){super();}
	
	public Eleve(String prenom){
		super(prenom);
	}
	
	public Eleve(String nom, String prenom, String pass,String surnom,String classe) {
		super(nom, prenom, pass);
		this.surnom=surnom;
		this.classe=classe;
		// TODO Auto-generated constructor stub
	}
	
	public String getSurnom(){
		return this.surnom;
	}
	public String getLienImage(){
		return this.lienImage;
	}
	
	public String getClasse(){
		return this.classe;
	}
	public void setSurnom(String surnom){
		this.surnom=surnom;
	}

	public void setLienImage(String lien){
		this.lienImage=lien;
	}
	
	public void setClasse(String classe){
		this.classe=classe;
	}
}
