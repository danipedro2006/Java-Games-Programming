package cards;

public class Card {
//	String[] suits= {"Spades", "Hearts", "Diamonds", "Clubs"};
//	String[] ranks= {"A","2","3","4","5","6","7","8","9","10","J","Q", "K"};
	
	private int serial;
	private Suit suit;
	private Rank value;
	
	public Card(int i,Suit suit, Rank value) {
		this.serial=i;
		this.suit=suit;
		this.value=value;
	}

	@Override
	public String toString() {
		return "suit=" + suit + ", value=" + value + "]";
	};

}
