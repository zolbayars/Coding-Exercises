package com.zolbayar.cracking_the_oyster.object_oriented_design;

import java.util.ArrayList;

/*
    Purpose: 1. Design an object oriented data structure for a generic playing card game.
             2. Data structure for a blackjack game.

    Insight: 1. Ask yourself 6 Ws. Ask questions and clarify about the usages of the classes: A standard 52 card game, and a blackjack
             2. Describe the core classes: Suit, Deck, Card, Hand
             3. What are the relationships between those classes: Every card has a suit, a deck is consisted of cards, a hand is created from the deck, etc.
             4. Investigate actions: A hand should return its score, the should be able to shuffle its cards, etc.
 */
public class DeckOfCards {

    public enum Suit {
        HEART(0), SPADE(1), DIAMOND(2), CLUB(3);

        private int value;
        Suit(int value){
            this.value = value;
        }

        public int getValue(){
            return this.value;
        }
    }

    abstract class Card {
        private Suit suit;
        private int faceValue;
        private boolean available = true;

        public Card(Suit suit, int faceValue) {
            this.suit = suit;
            this.faceValue = faceValue;
        }

        public boolean isAvailable(){
            return available;
        }

        abstract int value();
        public Suit suit(){
            return this.suit;
        }

        public void markUnavailable(){
            this.available = false;
        }

        public void markAvailable(){
            this.available = true;
        }
    }

    class Deck <T extends Card> {
        private ArrayList<T> cards;

        // The index you've dealt
        private int currentIndex = 0;

        public Deck(ArrayList<T> cards) {
            this.cards = cards;
        }

        public void shuffle(){}

        public int remainingCards(){
            return cards.size() - currentIndex;
        }

        // Unnecessary to implement it.
        public T[] dealHand(int count){
            return null;
        }

        public T dealCard(){
            if(currentIndex < (cards.size() - 1)){
                return cards.get(currentIndex++);
            }else{
                return null;
            }
        }
    }

    class Hand <T extends Card> {
        private ArrayList<T> cards;

        public Hand(ArrayList<T> cards) {
            this.cards = cards;
        }

        public void addCard(T card){
            cards.add(card);
        }

        public int score(){
            int score = 0;
            for (T card : cards){
                score += card.value();
            }
            return score;
        }
    }


}