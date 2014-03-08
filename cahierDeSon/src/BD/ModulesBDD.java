package BD;

import com.example.cahierdeson.Module;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ModulesBDD {
	
	//pas d'id c'est au to increment dans la bd
	//a determiner manipulation d'un module a travers la bd (comme ElevesBDD)
	
	
	private static final int VERSION_BDD = 1;
	private static final String NOM_BDD = "cahierdeson";

	//nom des champs de la table eleves
	private static final String TABLE_MODULES = "Modules";
	private static final String COL_ID = "id_module";
	private static final int NUM_COL_ID = 0;
	
	private static final String COL_GRAPHEME = "grepheme";
	private static final int NUM_COL_GRAPHEME =1; 
	
	private static final String COL_LIEN_IMAGE="lien_image";
	private static final int NUM_COL_LIEN_IMAGE=2;
	
	private static final String COL_LIEN_SON="lien_son";
	private static final int NUM_COL_LIEN_SON=3;
	
	private static final String COL_LIEN_VIDEO="lien_video";
	private static final int NUM_COL_LIEN_VIDEO=4;
	
	private static final String COL_DATE_CREATION="date_creation";
	private static final int NUM_COL_DATE_CREATION=5;
	

	private static final String COL_ELEVE = "id_eleve";
	private static final int NUM_COL_ELEVE = 6;
 
	private SQLiteDatabase bdd;
 
	private BDCahierDeSon maBaseSQLite;
 
	public ModulesBDD(Context context){
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
 
	public long insertModule(Module module){
		
		//Cr�ation d'un ContentValues (fonctionne comme une HashMap)
		ContentValues values = new ContentValues();
		//on lui ajoute une valeur associ� � une cl� (qui est le nom de la colonne dans laquelle on veut mettre la valeur)
		//values.put(COL_ID, eleve.getId());
		values.put(COL_GRAPHEME ,module.getGrapheme());
		values.put(COL_LIEN_IMAGE, module.getLienImage());
		values.put(COL_LIEN_SON, module.getLienSon());
		values.put(COL_LIEN_VIDEO, module.getLienVideo());
		values.put(COL_DATE_CREATION, module.getDateCreation());
		values.put(COL_ELEVE,module.getIdEleve());
		
		
		//on ins�re l'objet dans la BDD via le ContentValues
		
		if( bdd.insert(TABLE_MODULES, null, values)!=0)
			{Log.i("bdd cahierdeson","insertion module r�ussite"); return 1;}
		else return 0;
		    
		
	}
 
	public int updateEleves(int id, Module module){
		//La mise � jour d'un module dans la BDD fonctionne plus ou moins comme une insertion
		//il faut simple pr�ciser quel module on doit mettre � jour gr�ce � l'ID
		ContentValues values = new ContentValues();
		values.put(COL_GRAPHEME ,module.getGrapheme());
		values.put(COL_LIEN_IMAGE, module.getLienImage());
		values.put(COL_LIEN_SON, module.getLienSon());
		values.put(COL_LIEN_VIDEO, module.getLienVideo());
		values.put(COL_DATE_CREATION, module.getDateCreation());
		values.put(COL_ELEVE,module.getIdEleve());
		Log.i("update eleve","update ex�cut�");
		return bdd.update(TABLE_MODULES, values, COL_ID + " = " +id, null);
			
			
	}
 
	public int removeModuleWithID(int id){
		//Suppression d'un module de la BDD gr�ce � l'ID
		Log.i("suppression","module dont l'id est"+ id);
		return bdd.delete(TABLE_MODULES, COL_ID + " = " +id, null);
	}
 
	public Module getModuleWith(String COL,String value){
		//R�cup�re dans un Cursor les valeur correspondant � un module contenu dans la BDD (ici on s�lectionne le module  dont le nom de champs COL correspond � la valeur value)
		Cursor c = bdd.query(TABLE_MODULES, new String[] {COL_ID,COL_GRAPHEME,COL_LIEN_IMAGE,COL_LIEN_SON,COL_LIEN_VIDEO,COL_DATE_CREATION,COL_ELEVE}, COL + " LIKE \"" + value +"\"", null, null, null, null);
		Log.i("afficher prenom","affichage ex�cut�");
		return cursorToModule(c);
	}
 
	//Cette m�thode permet de convertir un cursor en un module
	private Module cursorToModule(Cursor c){
		//si aucun �l�ment n'a �t� retourn� dans la requ�te, on renvoie null
		if (c.getCount() == 0)
			return null;
 
		//Sinon on se place sur le premier �l�ment
		c.moveToFirst();
		//On cr�� un module
		 Module m= new Module();
		//on lui affecte toutes les infos gr�ce aux infos contenues dans le Cursor
		m.setID(c.getInt(NUM_COL_ID));
		m.setGrapheme(c.getString(NUM_COL_GRAPHEME));
		m.setLienImage(c.getString(NUM_COL_LIEN_IMAGE));
		m.setLienSon(c.getString(NUM_COL_LIEN_SON));
		m.setLienVideo(c.getString(NUM_COL_LIEN_VIDEO));
		m.setDateCreation(c.getString(NUM_COL_DATE_CREATION));
		m.setIdEleve(c.getInt(NUM_COL_ELEVE));

		//eleve.setLienImage(c.getString(NUM_COL_PHOTO_PROFIL));
		//On ferme le cursor
		c.close();
 
		//On retourne le livre
		return m;
	}
	

}