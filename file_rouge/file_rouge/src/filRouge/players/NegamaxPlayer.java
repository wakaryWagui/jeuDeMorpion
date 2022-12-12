package players;

import games.Game;

public class NegamaxPlayer implements Player {
	
	//constructeur
	public NegamaxPlayer(){} 
	
	// elle prend un jeux pour une situation courante s et elle verifier pour chaque coup valide le score minimum 
    // qu'on peut avoir à la fin de la partie et puis elle retourne une valeur qui represente le meilleur 
    // score ou bien le score minimum du meilleur coup 	
	public int evaluate(Game game){
		
		// le gagant est le joueur courant
		if (game.getWinner() == game.getCurrentPlayer()) {return +1;} 
		// le perdant est le joueur courant
		if (game.getWinner() != null && game.getWinner() != game.getCurrentPlayer()) {return -1;} 
		// match null
		if (game.isOver() == true && game.getWinner() == null ) {return 0;}
		// situation non terminale
		Integer res = null; int v; 
		
		for(Integer coup : game.validMoves()){
			
			Game gamecp = game.copy(); // creation d'une copie
			gamecp.execute(coup); // execution d'un coup sur la copie
			v = -evaluate(gamecp);
			
			if (res == null || v > res ) {res = v;}
			
		}
		
		return res.intValue(); // on retourne le score minimum à la fin pour le meilleur coup
		
		
		
		
	}
	
	// cette methode reçoit comme parametre un jeux dans une situation courante
	// et elle retourne le meilleur coup à jouer dans cette situation
	@Override
	public int chooseMove(Game game){
		
		Integer bestVal = null;
		Integer bestCoup = null;
		int v;
		
		for(Integer coup : game.validMoves()){
			
			Game gamecp = game.copy(); // creation d'une copie
			gamecp.execute(coup); // execution d'un coup sur la copie
			v = -evaluate(gamecp);
			if (bestVal == null || v > bestVal ) {
				bestVal = v;
				bestCoup = coup;
				
			}
			
			
		}
		
		return bestCoup.intValue(); // on retourne le meilleur coup dans la situation courante
	
		
		
	}
	// cette methode retourne un entier generé par hashcode qui joue le role d'un identificateur pou le joueur
	@Override 
	public String toString(){
		return "NegaMax num " + this.hashCode();
	}

	
	
} 