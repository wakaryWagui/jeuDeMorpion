package plays;

import games.Game;

public class Orchestrator {
	
	private Game game; // stocke un jeux
	
	// constructeur
	public Orchestrator(Game game){
		
		this.game = game;
		
	}
	
	// cette methode permet de gerer ou bien jouer une partie apres l'avoir invoqué sur objet orchestrator 
	public void play(){
		
		System.out.println("\n******** la partie commence ********");
		
		while(!game.isOver()){
			System.out.println(game.situationToString()); // situation courant du jeux
		    System.out.println("=> le coup est pour "+game.getCurrentPlayer().toString()); // afficher joueur courant
			int coup = game.getCurrentPlayer().chooseMove(game);
			game.execute(coup); // executer un coup
			System.out.println(game.moveToString(coup)); // afficher le coup joué
		}
		
		System.out.println("\n*** c'est fini *** \n*** resultat finale ***");
		System.out.println(game.situationToString()); // situation finale
		
		// afficher le gagnant
		if (game.getWinner() == null) System.out.println("***** match nul*****"); 
		else System.out.println("le gagnant est : "+game.getWinner().toString()); 
		
	  
		
		
	}
	
	
	
	
	
	
	
	
	
}