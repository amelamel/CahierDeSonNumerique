package com.example.cahierdeson;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ElevesBDD {

	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "cahierdeson";

	//nom des champs de la table eleves
	private static final String TABLE_ELEVES = "Eleves";
	private static final String COL_ID = "id_eleve";
	private static final int NUM_COL_ID = 0;
	private static final String COL_NOM = "nom";
	private static final int NUM_COL_NOM = 1;
	private static final String COL_PRENOM = "prenom";
	private static final int NUM_COL_PRENOM = 2;
	private static final String COL_SURNOM = "surnom";
	private static final int NUM_COL_SURNOM = 3;
	private static final String COL_PASS = "mot_de_passe";
	private static final int NUM_COL_PASS = 4;
	private static final String COL_CLASSE = "classe";
	private static final int NUM_COL_CLASSE = 5;
	private static final String COL_PHOTO_PROFIL = "lien_photo_profil ";
	private static final int NUM_COL_PHOTO_PROFIL = 6;
	
 
	private SQLiteDatabase bdd;
 
	private BDCahierDeSon maBaseSQLite;
 
	public ElevesBDD(Context context){
		//On cr�er la BDD et sa table
		maBaseSQLite = new BDCahierDeSon(context, NOM_BDD, null, VERSION_BDD);
	}
 
	public void open(){
		//on ouvre la BDD en �criture
		bdd = maBaseSQLite.getWritableDatabase();
	}
 
	public void close(){
		//on ferme l'acc�s � la BDD
		bdd.close();
	}
 
	public SQLiteDatabase getBDD(){
		return bdd;
	}
 
	public long insertEleve(Eleve eleve){
		
		//Cr�ation d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associ� � une cl� (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		//values.put(COL_ID, eleve.getId());
		values.put(COL_NOM, eleve.getNom());
		values.put(COL_PRENOM, eleve.getPrenom());
		values.put(COL_SURNOM, eleve.getSurnom());
		values.put(COL_CLASSE, eleve.getClasse());
		values.put(COL_PASS, eleve.getMotDePasse());
		values.put(COL_PHOTO_PROFIL, eleve.getLienImage());
		
		
		//on ins�re l'objet dans la BDD via le ContentValues
		Log.i("bdd cahierdeson","insertion r�ussie");
		return bdd.insert(TABLE_ELEVES, null, values);
		
	}
 
	public int updateEleves(int id, Eleve eleve){
		//La mise � jour d'un ELEVE dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simple pr�ciser quel ELEVE on doit mettre � jour gr�ce � l'ID
		ContentValues values = new ContentValues();
		//values.put(COL_ID, eleve.getId());
		values.put(COL_NOM, eleve.getNom());
		values.put(COL_PRENOM, eleve.getPrenom());
		values.put(COL_SURNOM, eleve.getSurnom());
		values.put(COL_CLASSE, eleve.getClasse());
		values.put(COL_PASS, eleve.getMotDePasse());
		values.put(COL_PHOTO_PROFIL, eleve.getLienImage());
		Log.i("update eleve","update ex�cut�");
		return bdd.update(TABLE_ELEVES, values, COL_ID + " = " +id, null);
		
		
			
	}
 
	public int removeEleveWithID(int id){
		//Suppression d'un eleve de la BDD gr�ce � l'ID
		Log.i("suppression","eleve dont l'id est"+ id);
		return bdd.delete(TABLE_ELEVES, COL_ID + " = " +id, null);
	}
 
	public Eleve getEleveWith(String COL,String value){
		//R�cup�re dans un Cursor les valeur correspondant � un eleve contenu dans la BDD (ici on s�lectionne l'eleve dont le nom de champs COL correspond � la valeur value)
		Cursor c = bdd.query(TABLE_ELEVES, new String[] {COL_ID, COL_NOM, COL_PRENOM, COL_SURNOM,COL_CLASSE,COL_PHOTO_PROFIL}, COL + " LIKE \"" + value +"\"", null, null, null, null);
		Log.i("afficher prenom","affichage ex�cut�");
		return cursorToEleve(c);
	}
 
	//Cette m�thode permet de convertir un cursor en un eleve
	private Eleve cursorToEleve(Cursor c){
		//si aucun �l�ment n'a �t� retourn� dans la requ�te, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier �l�ment
		c.moveToFirst();
		//On cr�� un eleve
		Eleve eleve = new Eleve();
		//on lui affecte toutes les infos gr�ce aux infos contenues dans le Cursor
		eleve.setId(c.getInt(NUM_COL_ID));
		eleve.setNom(c.getString(NUM_COL_NOM));
		eleve.setPrenom(c.getString(NUM_COL_PRENOM));
		eleve.setSurnom(c.getString(NUM_COL_SURNOM));
		eleve.setClasse(c.getString(NUM_COL_CLASSE));
		eleve.changeMotDePass(c.getString(NUM_COL_PASS));
		//eleve.setLienImage(c.getString(NUM_COL_PHOTO_PROFIL));
		//On ferme le cursor
		c.close();
 
		//On retourne l eleve
		return eleve;
	}
}
