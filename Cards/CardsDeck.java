package cards;

public class CardsDeck {

	public static void main(String[] args) {
		int[] deck=new int[52];
		String[] suits= {"Spades", "Hearts", "Diamonds", "Clubs"};
		String[] ranks= {"A","2","3","4","5","6","7","8","9","10","J","Q", "K"};
		for(int i=0;i<deck.length;i++) {
			deck[i]=i;
		}

		for(int i=0;i<52;i++) {
			String suit=suits[deck[i]/13];
			String rank=ranks[deck[i]%13];
			System.out.println(rank+" "+suit);
		}
	}
}
