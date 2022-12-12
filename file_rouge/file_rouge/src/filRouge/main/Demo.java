package main;

import java.util.Random;
import java.util.Scanner;
import plays.Orchestrator;
import players.Player;
import players.Human;
import players.RandomPlayer;
import players.NegamaxPlayer;
import games.TicTacToe;
import games.TicTacToeWithHints;
import games.Nim;

public class Demo{

	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] argvs) {



		System.out.println("Bienvenue sur notre interface des jeux!!!");

		Integer Entrer=null;

		do{
           if(Entrer != null) {
    	        System.out.println("Votre choix n'est pas valide");
            }
           System.out.print("Choisissez entrez Nim et Morpion(sans indices) et Morpion(avec indices) (0/1/2) !!! :");
           Entrer = scanner.nextInt();

		}while(Entrer != 0 && Entrer !=1 && Entrer !=2);


	    if(Entrer == 0){
    	    presentation("Nim");
    	    Player joueur1 = joueur1("premier");
    	    Player joueur2 = joueur2("second");
            int tailleInitTas;
            System.out.print("Entrez la taille initial du Tas:");
            tailleInitTas = scanner.nextInt();
            int nbreMaxiAllumettes;
            System.out.print("Entrez le nombre maximal d'allumettes qu'un utilisateur peut retirer:");
            nbreMaxiAllumettes = scanner.nextInt();

            Nim nim = new Nim(tailleInitTas,nbreMaxiAllumettes,joueur1,joueur2);
            Orchestrator orchestrator = new Orchestrator(nim);

            orchestrator.play();

        }

        if(Entrer == 1){
    	    presentation("Morpion(sans indices)");
    	    Player joueur1 = joueur1("premier");
    	    Player joueur2 = joueur2("second");

            TicTacToe ticTacToe = new TicTacToe(joueur1,joueur2);
            Orchestrator orchestrator = new Orchestrator(ticTacToe);
            orchestrator.play();

		}

        if(Entrer == 2){
    	    presentation("Morpion(avec indices)");
    	    Player joueur1 = joueur1("premier");
    	    Player joueur2 = joueur2("second");

            TicTacToeWithHints ticTacToeWithHints = new TicTacToeWithHints(joueur1,joueur2);
            Orchestrator orchestrator = new Orchestrator(ticTacToeWithHints);
            orchestrator.play();


        }




        scanner.close();




	}

    public static String saisirJoueur(String chaine) {
	  String EntrerCaractere=null;
	  do{
		  if(EntrerCaractere!=null) {
			  System.out.println("Votre saisi n'est pas valide!");
		    }
		  System.out.print("Saisissez le type de votre "+chaine+" joueur (H/A/N) :");
    	  EntrerCaractere=scanner.next();
        }while(!EntrerCaractere.equalsIgnoreCase("H") && !EntrerCaractere.equalsIgnoreCase("A")
        		&& !EntrerCaractere.equalsIgnoreCase("N"));
	  return EntrerCaractere;
    }

	public static Player joueur1(String chaine) {
	  String EntrerCaractere = saisirJoueur(chaine);
	  Player joueur1 = null;
	  if (EntrerCaractere.equalsIgnoreCase("H")) {
    	   joueur1=joueurHumain(chaine);
        }
      if (EntrerCaractere.equalsIgnoreCase("A")) {
    	   joueur1=joueurRandom();
        }
      if (EntrerCaractere.equalsIgnoreCase("N")) {
    	   joueur1=joueurNegamax();
        }

      return joueur1;
    }

	public static Player joueur2(String chaine) {
	  String EntrerCaractere=saisirJoueur(chaine);
	  Player joueur2 = null;
	  if (EntrerCaractere.equalsIgnoreCase("H")) {
    	   joueur2=joueurHumain(chaine);
        }
      if (EntrerCaractere.equalsIgnoreCase("A")) {
    	   joueur2=joueurRandom();
        }
      if (EntrerCaractere.equalsIgnoreCase("N")) {
    	   joueur2=joueurNegamax();
        }

      return joueur2;
    }

	public static Player joueurHumain(String chaine){
        String name;
        System.out.print("Entrer le nom du "+ chaine +" joueur:");
        name = scanner.next();
        Player player = new Human(name,scanner);
        return player;
    }

	public static Player joueurRandom(){
	  	Random random = new Random(123);
	    System.out.println("Votre adversaire est un joueur aleatoire");
	    Player player=new RandomPlayer(random);
	    return player;
	}

	public static Player joueurNegamax(){
	    System.out.println("Votre adversaire est un joueur Negamax(algorithme)");
	    Player player=new NegamaxPlayer();
	    return player;
	}

	public static void presentation(String jeu) {

		System.out.println("Vous avez choisi le Jeu de "+jeu+" !!!\n");

	    System.out.println("Nous proposons un jeu de "+jeu+" a 2 joueurs\n"
	        + "Plusieurs possibilites s'offrent a vous\n"
	        + "Vous pouvez choisir de jouer entre :\n"
	        + "humain contre humain(Si vous etes deux)\n"
	        + "humain contre joueur aleatoire et vice versa\n"
	        + "humain contre Negamax(algorithme) et vice versa\n"
	        + "joueur aleatoire contre Negamax et vice versa\n"
	      	+ "joueur aleatoire contre lui meme\n"
	      	+ "Negamax contre lui meme.\n ");


        System.out.println("Pour faire votre choix :\n"
	    	+ "Ecrire (H) pour humain\n"
	    	+ "Ecrire (A) pour joueur aleatoire\n"
	    	+ "Ecrire (N) pour Negamax(algorithme)\n");

    }




}
