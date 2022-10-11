package org.example;

import java.sql.Time;
import java.util.*;

public class Snap extends CardGame {
    public Snap() {
        super();
    }

    Scanner numberOfPlayers = new Scanner(System.in);
    Scanner PlayerNames = new Scanner(System.in);
    Scanner drawCard = new Scanner(System.in);
    Scanner snap = new Scanner(System.in);

    Player snapPlayer1 = new Player("");
    Player snapPlayer2 = new Player("");

    Player currentPlayer = new Player("");

    public void initialiseGame(){
        shuffleDeck();
        System.out.println("Welcome to snap.");
        System.out.println("Rules of the game are: 1-...");
    }

    private int checkPlayers() {
        System.out.println("\nplease state how many players are playing by entering either 1 or 2:");
        int selection = numberOfPlayers.nextInt();
            while (selection != 1 && selection != 2) {
                System.err.println("Selection must be either 1 or 2");
                selection = numberOfPlayers.nextInt();
            }
        return selection;
    }

    private void addPlayer(){
        System.out.println("Please enter you player name...");
        snapPlayer1.setPlayerName(PlayerNames.nextLine());
    }

    private void add2Players(){
        System.out.println("Please enter you player 1's name...");
        snapPlayer1.setPlayerName(PlayerNames.nextLine());
        checkValidName(snapPlayer1.getPlayerName());

        System.out.println("\nPlease enter you player 2's name...");
        snapPlayer2.setPlayerName(PlayerNames.nextLine());
        checkValidName(snapPlayer2.getPlayerName());
    }

    private void checkValidName(String name){
        if (name.isBlank()){
            throw new IllegalArgumentException("Name must be a valid name");
        }
    }

    private void singlePlayerGame(){
        boolean isDeckEmpty = getDeckOfCards().isEmpty();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("you ran out of time");
                System.exit(0);
            }
        };

        while (!isDeckEmpty){
            System.out.println(snapPlayer1.getPlayerName() +" draw a card");
            String newCard = drawCard.nextLine();
            System.out.println(dealCard());

            int currentCard = getCurrentCard().getValue();
            int oldCard = getPreviousCard().getValue();

            if (currentCard == oldCard) {
                timer.schedule(task,3000);
                handleSnap();
                timer.cancel();
                break;
            }
        }
    }

    private void twoPlayerGame(){
        boolean isDeckEmpty = getDeckOfCards().isEmpty();
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("you ran out of time");
                System.exit(0);
            }
        };
        currentPlayer = snapPlayer1;
        while (!isDeckEmpty){
            switchPlayer();
            System.out.println("\n"+currentPlayer.getPlayerName() + " draw a card");
            String player1Card = drawCard.nextLine();
            System.out.println(dealCard());

            int currentCard = getCurrentCard().getValue();
            int oldCard = getPreviousCard().getValue();

                if (currentCard == oldCard) {
                    timer.schedule(task,3000);
                    handleMultiplayerSnap();
                    timer.cancel();
                    break;
                }

        }
    }



    private void handleSnap(){
        String win = snap.nextLine();
        if (win.equalsIgnoreCase("SNAP")){
            System.out.println("SNAP!! " + snapPlayer1.getPlayerName() +" You Won!!!");
        } else {
            System.out.println("Sorrry you lost");
        }
    }

    private void handleMultiplayerSnap(){
        String win = snap.nextLine();
        if (win.equalsIgnoreCase("SNAP")){
            System.out.println("SNAP!! " + currentPlayer.getPlayerName() +" You Won!!!");
        } else {
            System.out.println("Sorrry " + currentPlayer.getPlayerName() + " you lost");
            switchPlayer();
            System.out.println("\n" + currentPlayer.getPlayerName() +" You Won!!!");
        }
    }

    private void switchPlayer(){
        if (currentPlayer == snapPlayer1){
            currentPlayer = snapPlayer2;

        } else currentPlayer= snapPlayer1;
    }


    public void playGame(){
        if (checkPlayers() == 1){
            addPlayer();
            checkValidName(snapPlayer1.getPlayerName());
            System.out.println("\n" + snapPlayer1.getPlayerName() + " press enter to draw a card and start the game");
            String dealCard = drawCard.nextLine();
            System.out.println(dealCard());
            singlePlayerGame();
        } else {
            add2Players();
            System.out.println("\n" + snapPlayer1.getPlayerName() + " press enter to draw a card and start the game");
            String dealCard = drawCard.nextLine();
            System.out.println(dealCard());
            twoPlayerGame();
        }

    }

}



