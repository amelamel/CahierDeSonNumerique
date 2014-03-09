package com.example.cahierdeson;

import BD.*;
import Modeles.Module;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    
    //le main activity teste la base de donn�es
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        
        /****************************decommenter si vous voulez tester la table el�ve et cr�er la base de donn�es ***************/
        //Cr�ation d'une instance de ma classe EleveBDD
        /*ElevesBDD elevesbdd = new ElevesBDD(this);
     
        //Cr�ation d'un eleve String nom, String prenom, String pass,String surnom,String classe) 
        Eleve eleve = new Eleve( "amel","krouma","h%jj","ammoula","cm1");
        
        //On ouvre la base de donn�es pour �crire dedans
        elevesbdd.open();
        //On ins�re l'eleve que l'on vient de cr�er
        elevesbdd.insertEleve(eleve);
 
        //Pour v�rifier que l'on a bien cr�� notre eleve dans la BDD
        //on extrait le livre de la BDD gr�ce au prenom de l'eve par exemple que l'on a cr�� pr�c�demment
        Eleve eleveFromBdd = elevesbdd.getEleveWith("prenom","krouma");
        //Si un eleve est retourn� (donc si l'eleve � bien �t� ajout� � la BDD)
        if(eleveFromBdd != null){
        	//On affiche les infos de l'eleve dans un Toast
        	Toast.makeText(this, eleveFromBdd.toString(), Toast.LENGTH_LONG).show();
        	//On modifie le nom du l eleve
        	eleveFromBdd.setPrenom("moussa");
        	//Puis on met � jour la BDD
            elevesbdd.updateEleves(eleveFromBdd.getId(),eleveFromBdd);
        }
 
        //On extrait l'eleve de la BDD gr�ce au nouveau prenom
        eleveFromBdd = elevesbdd.getEleveWith("prenom","moussa");
        //S'il existe un livre poss�dant ce titre dans la BDD
        if(eleveFromBdd != null){
	        //On affiche les nouvelle info de l'eleve pour v�rifier que son prenom  a bien �t� mis � jour
	        Toast.makeText(this, eleveFromBdd.toString(), Toast.LENGTH_LONG).show();
	        //on supprime l'eleve de la BDD gr�ce � son ID
	        elevesbdd.removeEleveWithID(eleveFromBdd.getId());
        }
 
        //On essait d'extraire de nouveau l'eleve de la BDD toujours gr�ce � son nouveau prenom
        eleveFromBdd = elevesbdd.getEleveWith("prenom","moussa");
        //Si aucun livre n'est retourn�
        if(eleveFromBdd == null){
        	//On affiche un message indiquant que l'eleve n'existe pas dans la BDD
        	Toast.makeText(this, "Cet �l�ve n'existe pas dans la BDD", Toast.LENGTH_LONG).show();
        }
        //Si l'eleve existe (mais normalement il ne devrait pas)
        else{
        	//on affiche un message indiquant que le livre existe dans la BDD
        	Toast.makeText(this, "Cet �l�ve existe dans la BDD", Toast.LENGTH_LONG).show();
        }
 
        elevesbdd.close();*/
        
      //Cr�ation d'une instance de ma classe ModuleBDD
        ModulesBDD modulebdd = new ModulesBDD(this);
        modulebdd.open();
        //Cr�ation d'un module et l'ins�rer dans la bd
      //  Module module =new Module( 0,"A", "image/a.png","son/a.mp3","video/A.mp4","05/05/2012",1);
        Module module =new Module( 0,"B", "image/b.png","son/b.mp3","video/b.mp4","05/05/2012",2);
        modulebdd.insertModule(module);
        modulebdd.close();
        
        
    }
        
        /********************************************/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
