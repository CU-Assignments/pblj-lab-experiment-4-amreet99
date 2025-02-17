Experiment 4.2: Card Collection System


  
import java.util.*;

class CardCollectionSystem {
    private Map<String, HashSet<String>> cardMap;

    public CardCollectionSystem() {
        cardMap = new HashMap<>();
    }

    public void addCard(String suit, String rank) {
        cardMap.putIfAbsent(suit, new HashSet<>());
        if (!cardMap.get(suit).add(rank)) {
            System.out.println("Error: Card \"" + rank + " of " + suit + "\" already exists.");
        } else {
            System.out.println("Card added: " + rank + " of " + suit);
        }
    }

    public void findCardsBySuit(String suit) {
        if (cardMap.containsKey(suit) && !cardMap.get(suit).isEmpty()) {
            System.out.println("Cards of " + suit + ": " + cardMap.get(suit));
        } else {
            System.out.println("No cards found for " + suit + ".");
        }
    }

    public void displayAllCards() {
        if (cardMap.isEmpty()) {
            System.out.println("No cards found.");
            return;
        }
        for (String suit : cardMap.keySet()) {
            for (String rank : cardMap.get(suit)) {
                System.out.println(rank + " of " + suit);
            }
        }
    }

    public void removeCard(String suit, String rank) {
        if (cardMap.containsKey(suit) && cardMap.get(suit).remove(rank)) {
            System.out.println("Card removed: " + rank + " of " + suit);
            if (cardMap.get(suit).isEmpty()) {
                cardMap.remove(suit);
            }
        } else {
            System.out.println("Card \"" + rank + " of " + suit + "\" not found.");
        }
    }

    public static void main(String[] args) {
        CardCollectionSystem system = new CardCollectionSystem();

        system.displayAllCards();

        system.addCard("Spades", "Ace"); 
        system.addCard("Hearts", "King");
        system.addCard("Diamonds", "10");
        system.addCard("Clubs", "5");

        system.findCardsBySuit("Hearts");
        system.findCardsBySuit("Diamonds"); 

        system.displayAllCards();

        system.addCard("Hearts", "King");

        system.removeCard("Diamonds", "10");
        system.displayAllCards();
    }
}



Test Cases

Test Case 1: No Cards Initially
Input:
Display All Cards
Expected Output:
No cards found.

Test Case 2: Adding Cards
Input:
Add Card: Ace of Spades
Add Card: King of Hearts
Add Card: 10 of Diamonds
Add Card: 5 of Clubs
Expected Output:
Card added: Ace of Spades
Card added: King of Hearts
Card added: 10 of Diamonds
Card added: 5 of Clubs

Test Case 3: Finding Cards by Suit
Input:
Find All Cards of Suit: Hearts
Expected Output:
King of Hearts

Test Case 4: Searching Suit with No Cards
Input:
Find All Cards of Suit: Diamonds
(If no Diamonds were added)
Expected Output:
No cards found for Diamonds.

Test Case 5: Displaying All Cards
Input:
Display All Cards
Expected Output:
Ace of Spades
King of Hearts
10 of Diamonds
5 of Clubs

Test Case 6: Preventing Duplicate Cards
Input:
Add Card: King of Hearts
Expected Output:
Error: Card "King of Hearts" already exists.

Test Case 7: Removing a Card
Input:
Remove Card: 10 of Diamonds
Expected Output:
Card removed: 10 of Diamonds
