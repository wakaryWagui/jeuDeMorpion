package games;

import java.util.ArrayList;
import players.Player;

public interface Game {
	
	
	public void execute(int coup);	// cette methode permet d'executer un coup + changer le joueur courant
	public Player getCurrentPlayer(); // cette methode permet de donner le joueur courant
	public ArrayList<Integer> validMoves();  // lister les coups valide
	public boolean isValid(int coup);  // verifier si un coup est valid 
	public String situationToString();  // representer la situation du jeux
	public String moveToString(int coup);  // representer un coup joué 
	public boolean isOver();  // determiner si la partie est terminée
	public Player getWinner();  // donner le joueur qui a gagné
	public Game copy(); // cette methode permet de creer une copie de notre jeux
	
	// cette methode permet d'executer un coup
	public void doExecute(int coup);
	

	
	
	
	
	
	
	
	
	
}