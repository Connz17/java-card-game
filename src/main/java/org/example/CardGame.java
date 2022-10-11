package org.example;

import java.util.*;

import static org.example.Card.cardValues;
import static org.example.Card.suits;


public class CardGame {

    private ArrayList<Card> deckOfCards = new ArrayList<>();
    private static ArrayList<Card> oldCards = new ArrayList<>();
    private static ArrayList<Card> previousCard = new ArrayList<>();
    private static ArrayList<Card> currentCard = new ArrayList<>();


    public CardGame() {
        createDeck();

    }


    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public static ArrayList<Card> getOldCards() {
        return oldCards;
    }

    public static Card getCurrentCard() {
        return currentCard.get(currentCard.size()-1);
    }

    public static Card getPreviousCard() {
        return previousCard.get(previousCard.size()-2);
    }

    public ArrayList<Card> createDeck(){

        for (String suit: suits) {
            for (String i : cardValues.keySet()) {
                Card playingCard = new Card(suit, i, cardValues.get(i));
                deckOfCards.add(playingCard);
            }
        }

        return deckOfCards;
    }


    public Card dealCard(){
        oldCards.add(deckOfCards.get(0));
        previousCard.add(deckOfCards.get(0));
        currentCard.add(deckOfCards.get(0));
        return deckOfCards.remove(0);
    }

    public Card pastCard(){
        return previousCard.remove(0);
    }

    public ArrayList<Card>  sortDeckInNumberOrder(){
        Collections.sort(deckOfCards, new SortDeckInNumberOrder());
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckInIntoSuits(){
        Collections.sort(deckOfCards, new SortDeckInIntoSuits());
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck(){
        Collections.shuffle(deckOfCards);
        return deckOfCards;
    }

}
