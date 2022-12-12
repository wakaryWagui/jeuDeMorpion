package games;

import java.util.ArrayList;
import players.Player;

public class TicTacToe extends AbstractGame {
	
	protected Player[][] movesPlayed;
	
	// constructeur 
	public TicTacToe (Player p1 , Player p2 ) {
		super(p1,p2);
		movesPlayed = new Player[3][3];
    }
    // cette methode permet d'executer un coup
    @Override
	public void doExecute(int coup){
		
		this.movesPlayed[coup/3][coup%3] = getCurrentPlayer();
		
	}
	
	
	
    // cette methode permet l'acces à une case du tableau
	public Player getCase(int ligne,int colonne){
		return movesPlayed[ligne][colonne];
	}
	

    //indique si le coup est valide
	@Override
	public boolean isValid(int coup){
		if ( coup >= 0 && coup <= 8 && this.movesPlayed[coup/3][coup%3] == null ) return true;
		return false;
	}
	// retourne la liste de tous les coups valides
	@Override
	public ArrayList<Integer> validMoves(){
		ArrayList<Integer>  movesValid = new ArrayList<>();
		for(int coup=0;coup<9;coup++){
			if (isValid(coup)) movesValid.add(coup);
		}
		return movesValid;
	}
	// cette methode permet de verifier si le joueur passé en parametre a gagné 
	public boolean wins(Player p,int row,int column,int deltaRow,int deltaColumn){
		return ((this.movesPlayed[row][column] == p) && (this.movesPlayed[row+deltaRow][column+deltaColumn] == p)
			&&(this.movesPlayed[row+2*deltaRow][column+2*deltaColumn] == p) );
	}
	// cette methode permet de retourner le joueur qui a gagné
	@Override
	public Player getWinner(){
	    int i=0;
		while( i<3 ){
			// verifier l'allignement parraport aux lignes pour les deux joueurs
			if(wins(getPlayer1(),i,0,0,1)) return getPlayer1();		
		    if(wins(getPlayer2(),i,0,0,1)) return getPlayer2();
			// verifier l'allignement parraport aux colonnes pour les deux joueurs
			if(wins(getPlayer1(),0,i,1,0)) return getPlayer1() ;         
			if(wins(getPlayer2(),0,i,1,0)) return getPlayer2();
			i++;
		}
		// verifier les diagonales pour les deux joueurs
	    if(wins(getPlayer1(),2,2,-1,-1)) return getPlayer1();	
		if(wins(getPlayer1(),0,2,1,-1)) return getPlayer1();
		if(wins(getPlayer2(),2,2,-1,-1)) return getPlayer2();	
		if(wins(getPlayer2(),0,2,1,-1)) return getPlayer2();
	    return null;
	}
	//cette methode permet de verifier si la partie est terminé
	@Override
	public boolean isOver(){
		
		// s'il y a un alignement pour l'un des deux joueur 
		//ou bien on trouve pas des coups valides cela veut dire que la partie est terminé
		// sinon la partie n'est pas encore terminé
		if ((getWinner() == getPlayer1()) || (getWinner() == getPlayer2()) || (validMoves().size() == 0 )) return true ;
		return false;
	}
	
	// cette methode donne une representation de la situation courante
	@Override
	public String situationToString(){
		String chaine = "\n*** plateau courant (X pour "+getPlayer1().toString()+" et O pour "+getPlayer2().toString()+") ***\n\n";
		
	    chaine += "   0    1    2   ";
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
	
	
	// cette methode donne representation d'un coup joué
	@Override
	public String moveToString(int coup){
		return ">> coup joue pour la case : ("+coup/3+","+coup%3+")\n";
	}
	// cette methode permet de creer une copie de notre jeux
	@Override
	public Game copy(){
		Game res1;
		TicTacToe res2 = new TicTacToe(this.p1,this.p2);
        res2.currentPlayer = super.currentPlayer;
		
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				res2.movesPlayed[i][j] = this.movesPlayed[i][j];
			}
		}
		
		res1 = res2;

        return res1;
		
	}







}












