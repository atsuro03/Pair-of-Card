import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		Table table = new Table(2, "Pair of Cards");
		ArrayList<ArrayList<Card>> playerCards =  Dealer.startGame(table);
		Dealer.printTableInformation(playerCards, table);
		System.out.println(Dealer.winnerPairOfCards(playerCards));
		
	}
}
