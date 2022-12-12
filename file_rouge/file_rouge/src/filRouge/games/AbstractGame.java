package games;

import java.util.ArrayList;
import players.Player;

public abstract class AbstractGame implements Game {
	
	protected Player p1;  // pour stocker le 1 er joueur 
	protected Player p2;  // pour stocker le 2 eme joueur 
	protected Player currentPlayer; // pour stocker le joueur courant
	
	
	// constructeur 
	public AbstractGame(Player p1 , Player p2) {
		this.p1 = p1;
		this.p2 = p2;
		this.currentPlayer = p1;
	}
	
	// accesseur pour p1 et p2
	public Player getPlayer1(){
		return this.p1;
	}
	public Player getPlayer2(){
		return this.p2;
	}
	
	
	// cette methode permet d'executer un coup + changer le joueur courant
	@Override
	public void execute(int coup){
		doExecute(coup);
		if (this.currentPlayer == p1) this.currentPlayer = p2;
        else this.currentPlayer = p1;
		
	}
	// cette methode permet de donner le joueur courant
	@Override
	public Player getCurrentPlayer(){
		return this.currentPlayer;
	}
	
	





}