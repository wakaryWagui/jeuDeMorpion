package players;

import java.util.Scanner;
import games.Game;

public class Human implements Player{
	
	
	private String name; // nom du joeur clavier
	Scanner scanner;  // elle stocke un objet scanner qui permet de faire des lecture claviers
	
	//constructeur
	public Human(String name,Scanner scanner){
		
		this.name = name;
		this.scanner = scanner;
		
	} 
	
	
    // demande au joueur courant d'entrer un coup parmis les coups valides ( selon la situation du jeux passé en parametre ) // et retourne ce coup apres l'avoir validé
	@Override
	public int chooseMove(Game game){
		
		int coup;
		System.out.println("=> les coups valides sont = "+game.validMoves()); // affiche les coups valides
		
		do{
			System.out.print("=> veuillez donner un coup : ");
			coup = scanner.nextInt();
		} while(!game.isValid(coup)) ;// on redemande d'entrer le coup tantque celui ci n'est pas valide
		
		return coup;
	}
	
	// retourne le nom du joueur
	@Override 
	public String toString(){
		return this.name;
	}

	
}