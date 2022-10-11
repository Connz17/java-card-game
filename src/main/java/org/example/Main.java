package org.example;
import org.example.Card;
import org.example.CardGame;

public class Main {
    public static void main(String[] args) {
        Snap snap = new Snap();
        snap.initialiseGame();
        snap.playGame();
    }
}