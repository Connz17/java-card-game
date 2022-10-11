package org.example;

import java.util.Comparator;

public class SortDeckInNumberOrder implements Comparator<Card> {

    @Override
    public int compare(Card card1, Card card2) {
        return card1.getValue().compareTo(card2.getValue());
    }
}
