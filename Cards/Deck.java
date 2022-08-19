package cards;

import java.util.ArrayList;

public class Deck {
	
	public static ArrayList<Card> deck=new ArrayList<>();
	
	
	public Deck() {
		for(int i=0;i<52;i++) {
			//deck.add(new Card(i));
			deck.add(new Card(i,Suit.values()[i/13], Rank.values()[i%13]));
		}
	}
	public static void showDeck(ArrayList<Card> deck){
		for(int i=0;i<deck.size();i++) {
			System.out.println(deck.get(i));
		}
	}
	public static void main(String[] args) {
		Deck d=new Deck();
		
		showDeck(deck);
		//Card card1=new Card(0,"Spades", "A");
		//System.out.println(card1);
		deck.remove(0);
		System.out.println("----------");
		showDeck(deck);
	}
}
