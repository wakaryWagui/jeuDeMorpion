package games;

import java.util.ArrayList;
import players.Player;


public class TicTacToeWithHints extends TicTacToe{
	
	// constructeur 
	public TicTacToeWithHints(Player p1 , Player p2){
		super(p1,p2);
	}
	// cette methode permet de donner les cases sur lesquelles l'adversaire pourrait gagner
	public ArrayList<Integer> hints(){
		
		ArrayList<Integer> hintList = new ArrayList <>(); 
		Player enemy ;
		Player p; // p permet de recuperer la valeur precedente de la case
		Integer hint = 0; // hint donne les coup qui permettent à  l'adversaire de gagner
		
		// il faut d'abord savoir  qui est l'adversaire  
		if ( getCurrentPlayer() == getPlayer1()) enemy = getPlayer2();
		else enemy = getPlayer1();
		
		for (int i=0; i<=2; i++) {
			for (int j=0; j<=2; j++) {
			    
				p = movesPlayed[i][j];
			    movesPlayed[i][j] = enemy ;
			    if ( p == null && getWinner() != null ) { // testet si l'adversaire peut jouer 
				    hintList.add(hint);                  // sur la case et peut gagner en jouant sur celle ci
				}
				movesPlayed[i][j] = p;
				hint++;
			}
		}
		
		return hintList;
	
	 
	}
	// retourner la situation courante du jeux
	@Override
	public String situationToString(){
		String chaine = "\n*** plateau courant (X pour "+getPlayer1().toString()+" et O pour "+getPlayer2().toString()+") ***\n";
		chaine += "!!! attention: les menaces sont = "+hints().toString();
		
	    chaine += "\n\n   0    1    2   ";
		chaine += System.lineSeparator();
		chaine += System.lineSeparator();
		
		for (int ligne=0;ligne<3;ligne++){
			chaine += ligne;
			for (int colonne=0;colonne<3;colonne++){
			if (getCase(ligne,colonne) == getPlayer1() ) chaine += "  X  "; 	
			else {if (getCase(ligne,colonne) == getPlayer2() ) chaine += "  O  ";
			      else chaine += "  *  ";}
	
			}
		    chaine += System.lineSeparator();
			chaine += System.lineSeparator();
			
		}
		 
	    return chaine;
	
	}
	
	
	
	
	    
	
	
	
}