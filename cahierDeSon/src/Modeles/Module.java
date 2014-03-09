package Modeles;

public class Module {
	
	private int id_module;
	//private String word_module;
	private String grapheme;
	private String lien_image;
	//private String lien_image_word;
	//private String lien_image_borel;
	private String lien_son;
	private String lien_video;
	private String date_creation;
	private int id_eleve;
	
	public Module(){}
	
	public Module( int id_module, String grapheme, String lien_image,String lien_son,String lien_video,String date_creation,int id_eleve)
	{
		this.id_module=id_module;
		//this.word_module=word_module;
		this.grapheme=grapheme;
		this.lien_image=lien_image;
		this.lien_son=lien_son;
		this.lien_video=lien_video;
		this.date_creation=date_creation;
		this.id_eleve=id_eleve;
		/*this.lien_image_borel)lien_image_borel;*/
	}

	
	/****************************************getters**********************************************/
	
	public int getID(){return this.id_module;}
	
	//public String getWord(){return this.word_module;}
	
	public String getGrapheme(){return this.grapheme;}
	
	public String getLienImage(){ return this.lien_image;}
	
	public String getLienSon(){return this.lien_son;}
	
	public String getLienVideo(){return this.lien_video;}
	
	public String getDateCreation(){return this.date_creation;}
	
	public int getIdEleve(){return this.id_eleve;}
	/*public String getLienImageBorel(){return this.lien_image_borel}
	 * 
	 * public String getLienImageWord(){return this.lein_image_word;}*/
	
	/****************************************setters*********************************************/

	public void setGrapheme(String g){this.grapheme=g;} 	
   public void setID(int id){this.id_module=id;}
   
  // public void setWord(String world){ this.word_module=world;}
   
   public void setLienImage(String lien){ this.lien_image=lien;}
   
   public void setLienSon(String lien){ this.lien_son=lien;}
   
   public void setLienVideo(String lien){ this.lien_video=lien;}
   
   public void setDateCreation(String date){ this.date_creation=date;}
   
   public void setIdEleve(int id){ this.id_eleve=id;}
   
   /*public void setLienImageBorel(String lien){this.lien_image_borel=lien;}
    * 
    * public void setLienImageWord(String lien){this.lien_image_word=lien;}*/

}