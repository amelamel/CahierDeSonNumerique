================================
1#	Telechager et Installer Github
===============================

	lien windows http://windows.github.com/
	
================================================
2#	Cr�e un compte sur github 
================================================

	1# aller sur https://www.github.com
	2# cr�e un compte 
	
===================================
3#  le projet 
===================================

	voici le lien du depot du projet: https://github.com/SupGalileeGroupe4/CahierDeSonNumerique
	il comporte 4 branche, chacun de nous travaillera sur une branche
	on �vitera de travailler sur le m�me fichier afin de faciliter la gestion 
	des confusions

==============================	
4#	Forker le projet 
==============================

	connecter vous sur votre compte Github
	Pour cr�er un fork, allez sur le projet que vous voulez forker, donc notre projet https://github.com/SupGalileeGroupe4/CahierDeSonNumerique
	et dans le menu du haut cliquez sur le bouton Fork :
	
	vous aurais le projet dans votre compte github
	
===============================
5# Utiliser le projet forker 
================================
	
	Mise en place de la version locale
	Il suffit d�exploiter le fork comme un d�pot normal. Tout d�abord, cl�nez le
	Taper les commande suivante:
	votre_nom_utilisateur: est votre login qui vous permet de vous connect� sur github
	
	git clone git@github.com:votre_nom_utilisateur/CahierDeSonNumerique.git
	cd CahierDeSonNumerique
	
	=======
	
	Ajoutez un alias nomm� upstream vers le d�p�t original (que vous avez fork� "projet original"),
	Ceci permettra de r�cup�rer ses �volutions et aussi de proposer votre tache ou partie r�aliser la dessus.
	Taper la commande suivante:
	
	git remote add upstream https://github.com/SupGalileeGroupe4/CahierDeSonNumerique.git
	
	===============
	
	Mise � jour de votre d�p�t distant depuis le d�p�t d�origine du projet
	Il suffit de faire un fetch sur l�alias du d�p�t d�origine :
	Commande:
	
	git fetch upstream
	
	Mise � jour de votre dep�t local avec votre dep�t distant
	Commande :
			git remote add mondepotdistant git@github.com:/login/CahierDeSonNumerique.git
			git pull  mondepotdistant master
			
			(remote permet de cr�er des alias avec des projets distant)
	
	Vous aurez maintenant acc�s aux autre branches du d�pots Original du projet r�alis� par les autres membres du projet.
	
===========================================
6#	R�aliser votre t�che sur une branche
===========================================

	Tout d�abord, cr�ez une branche d�di�e et passez dessus :
	Commande:

	git branch <le_nom_explicite_de_ma_branche_ou_nom_de_la_tache>
	git checkout <le_nom_explicite_de_ma_branche_ou_nom_de_la_tache>
	
	============================================
	
	Vous travailler sur un fichier ou 2 fichiers ou plus ....
	
	pour un fichier: r�p�ter la commande 1 et 2 � chaque fois que vous voulez soumettre une modification
	***************
					Vous avez fait des modifications sur un fichier
					Ajouter le fichier a votre branche afin que git puisse le suivre
					1#Commande:
								git add <nom_du_fichier>
								
					 
					vous voulez que git tienne compte de cette modification dans votre depot LOCAL.
					2#Commande:
								git commit -m 'message decrivant la modification' 
								
	Sinon si vous aviez modifier plusieurs fichiers unitile de r�pter la commande 1 et 2 pr�c�dente  utiliser la commande suivante
	*******************
	Commande:
				git commit -a -m �message decrivant la modification�
				
	
	vous voulez que git tienne compte de cette modification dans votre depot DISTANT sur le serveur web de github.
	Commande:		
				git push origin <le_nom_explicite_de_ma_branche_ou_nom_de_la_tache>
	

=================================================================
7#	Integartion de votre t�che au Projet
=================================================================

	Pour soumettre votre tache ou mission r�alis� d�p�t d�origine, 
	il faut faire une pull request. Pour ceci, allez sur la page de votre fork sur github 
	et commencez par s�lectionner la branche sur laquelle vous avez travailler.
	Puis cliquez sur le bouton Pull request :
	Vous acc�dez � un formulaire avec plusieurs parties :
	En dessous il y a 3 onglets. Le premier est � remplir avec un titre pour votre pull request 
	et une description de ce que vous avez fait. Le second liste les commits que vous proposez 
	et le 3�me affiche les modifications sur les fichiers.
	 
	exemple:
	Titre: donner le titre de votre t�che 
	Write: D�crire en quelque mots les traveaux r�alis�s sur cette t�che
	
	Une fois tout renseign� et surtout v�rifi�, vous pouvez cliquer sur le bouton Send pull request.
	
	

	***********************************************************************************************
		Apr�s un test par un autre membre de l'�quipe votre t�che r�aliser sera int�gr� au projet
	***********************************************************************************************
	Commande:
				git checkout master
				git merge <le_nom_explicite_de_ma_branche_ou_nom_de_la_tache>

	
	
		
	
