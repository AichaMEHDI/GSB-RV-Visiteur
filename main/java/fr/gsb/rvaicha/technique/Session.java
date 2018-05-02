package fr.gsb.rvaicha.technique;

import fr.gsb.rvaicha.entites.Visiteur;
import fr.gsb.rvaicha.modeles.*;

public class Session {

	private static Session session = null ;
	private Visiteur leVisiteur ;
	
	private Session(Visiteur leVisiteur){
		super() ;
		this.leVisiteur = leVisiteur ;
	}
	
	public static boolean ouvrir(String matricule, String mdp){
		Visiteur visiteur = ModeleGsb.getInstance().seConnecter(matricule, mdp) ;
		if( visiteur != null ){
			System.out.println( "Session Ok" ) ;
			Session.session = new Session( visiteur ) ;
			return true ;
		}
		else {
			System.out.println( "Session Pas Ok" ) ;
			return false ;
		}
	}
	
	public static Session getSession(){
		return Session.session ;
	}
	
	public static void fermer(){
		Session.session = null ;
	}
	
	public Visiteur getLeVisiteur(){
		return this.leVisiteur ;
	}
}
