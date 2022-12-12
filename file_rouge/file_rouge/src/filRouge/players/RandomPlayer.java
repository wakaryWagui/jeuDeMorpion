package players;

import java.util.Random;
import games.Game;

public class RandomPlayer implements Player {
	
	
	// rand permet de stocker un objet random sur lequel on peut invoquer la methode
	// nextInt(n) qui retourne un entier tiré (pseudo-)uniformément dans l'intervalle [0,n[
	private Random rand;  
   
	// constructeur
	public RandomPlayer(Random rand){
		
		this.rand = rand;
	
	}
	
	// cette methode retourne renvoie l'indice d'un coup joué par joueur ( clavier ou bien automatiquement) 
	@Override
	public int chooseMove(Game game){
		
		System.out.println("=> les coups valides sont = "+game.validMoves()); // affiche les coups valides
		
		int coup ;
		
		// je recupere un coup aléatoire parmis les coups valides
		coup = rand.nextInt(game.validMoves().size());
		return game.validMoves().get(coup);
		
	}
	
	// cette methode retourne un entier generé par hashcode qui joue le role d'un identificateur pou le joueur aléatoire 
	@Override 
	public String toString(){
		return "Joueur aleatoire num " + this.hashCode();
	}
	



}