import java.util.ArrayList;

public class Deck {
	public ArrayList<Card> deck;
	
	public Deck() {
		this.deck = generateDeck();
	}
	
	public ArrayList<Card> generateDeck() {
		ArrayList<Card> newDeck = new ArrayList<>();
		String[] suits = new String[]{"♦", "♣", "♠","♥"};
		String[] values = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
		
		for(int i = 0; i < suits.length; i++) {
			for(int j = 0; j < values.length; j++) {
				newDeck.add(new Card(suits[i], values[j], j + 1));
			}
		}
		return newDeck;
	}
	
	public void shuffleDeck() {
		for(int i = this.deck.size() - 1; i >= 0; i--) {
			int j = (int) Math.floor(Math.random() * (i + 1));
			
			Card temp = this.deck.get(i);
			this.deck.set(i, this.deck.get(j));
			this.deck.set(j, temp);
		}		
	}
	
	public Card draw() {
		return this.deck.remove(this.deck.size() - 1);
	}
	
}
