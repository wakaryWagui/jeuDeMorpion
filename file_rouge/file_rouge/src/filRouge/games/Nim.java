package games;

import java.util.ArrayList;
import players.Player;

public class Nim extends AbstractGame {
	
	private int initialNbMatches;  // nombre d'allumettes initiale
	private int nbMatchesMaxRet;   // nombre maximale d'allumettes à retirer
	private int currentNbMatches;   // nombre d'allumettes courant ( restées )
	
	// constructeur
	public Nim(int initialNbMatches, int nbMatchesMaxRet,Player p1,Player p2){
		super(p1,p2);
		this.nbMatchesMaxRet = nbMatchesMaxRet;
		this.initialNbMatches = initialNbMatches;
		this.currentNbMatches = initialNbMatches;
		
		
	}
	
	// tirer des allumettes pour un coup joué
	@Override
	public void doExecute(int coup){
		currentNbMatches = currentNbMatches - coup;
	}
	
	// accesseurs 
	public int getInitialNbMatches (){return initialNbMatches;} 
	public int getCurrentNbMatches (){return currentNbMatches;}
	
	// cette methode donne une representation de la situation courante 
	@Override
	public String situationToString (){
		return "\n=> il reste "+getCurrentNbMatches()+" allumettes ";
	}		
	
	// cette methode verifier si un coup est valid
	@Override
	public boolean isValid (int coup) {
		return ( 0 < coup && coup <= nbMatchesMaxRet && coup <= currentNbMatches) ;
        		
	}
	
	//cette methode verifier si la partie est terminé
	@Override
	public boolean isOver (){
		return (getCurrentNbMatches() == 0);  
	}
	// cettte methode donne le joueur qui a gagné 
	@Override
	public Player getWinner (){
		if (isOver()) return getCurrentPlayer();
		else return null;
	}
	
	// retourne la liste de tous les coups valides
	@Override
	public ArrayList<Integer> validMoves(){
		ArrayList<Integer>  movesValid = new ArrayList<>();
		// on suppose des coups qui ne depassent pas le nombre max a retirer 
		// et pour chaque coups on verifier s'il est valide paraport au nombre courant d'allumettes
		for (int i=1; i <= this.nbMatchesMaxRet ; i++) {
			if (i <= this.currentNbMatches) movesValid.add(i); 
		}
		return movesValid;
		
	}
	
	// cette methode donne representation d'un coup joué
	@Override
	public String moveToString(int coup){
		return ">> vous avez enleve "+coup+" allumettes\n\n";
	}
	// cette methode permet de creer une copie de notre jeux 
	@Override
	public Game copy(){
		Game res1;
		Nim res2 = new Nim(this.initialNbMatches, this.nbMatchesMaxRet, this.p1,this.p2);
        res2.currentNbMatches = this.currentNbMatches;
        res2.currentPlayer = super.currentPlayer;
        res1 = res2;
		return res1;
		
	}

	
	
	
	
	
	
	
	
	
	
}