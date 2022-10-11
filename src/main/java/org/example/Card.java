package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Card implements Comparable<Card>{

    String suit;
    String name;
    Integer value;

    public Card(String suit, String name, Integer value) {
        this.suit = suit;
        this.name = name;
        this.value = value;
    }


    final static Map<String, Character> suitUnicode = new HashMap<>(){{
        put("heart", '\u2764');
        put("club", '\u2663');
        put("diamond", '\u2666');
        put("spade", '\u2660');
    }};

    public static String[] suits = {"heart", "club", "diamond", "spade"};



    static Map<String, Integer> cardValues = new HashMap<>(){{
        put("Ace", 14);
        put("King", 13);
        put("Queen", 12);
        put("Jack", 11);
        put("10", 10);
        put("9", 9);
        put("8", 8);
        put("7", 7);
        put("6", 6);
        put("5", 5);
        put("4", 4);
        put("3", 3);
        put("2", 2);
    }};

    public String getSuit() {
        return suit;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.name + suitUnicode.get(this.suit) + "\n";
    }


    @Override
    public int compareTo(Card other) {
        return this.value - other.value;
    }
}
