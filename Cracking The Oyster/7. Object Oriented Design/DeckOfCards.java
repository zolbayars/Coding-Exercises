/*
    Purpose: 1. Design an object oriented data structure for a generic playing card game.
             2. Data strcuture for a blackjack game.

    Insight: 1. Ask yourself 6 Ws. Ask questions and clarify about the usages of the classes: A standart 52 card game, and a blackjack
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


}