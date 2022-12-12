package players;

import games.Game;

public interface Player {
	
	//cette méthode aura pour fonction de « demander » au joueur quel coup il souhaite jouer dans la situation de jeu //représentée par son argument, puis de renvoyer l'indice de ce coup
	public int chooseMove(Game game);
	
	
	
	
	
}