import java.util.ArrayList;
import java.util.HashMap;

public class Dealer {
	
	public static ArrayList<ArrayList<Card>> startGame(Table table) {
		Deck deck = new Deck();
		ArrayList<ArrayList<Card>> playerCards = new ArrayList<>();
		
		for(int i = 0; i < table.amountOfPlayers; i++) {
			ArrayList<Card> playerHand = new ArrayList<>();
			for(int j = 0; j < initialMode(table); j++) {
				deck.shuffleDeck();
				Card card = deck.draw();
				playerHand.add(card);
			}
			playerCards.add(playerHand);
		}
		
		return playerCards;
	}
	
	public static int initialMode(Table table) {
		if(table.gameMode == "Pair of Cards") return 5;
		else return 0;
	}
	
	public static void printTableInformation(ArrayList<ArrayList<Card>> playerCards, Table table) {
		System.out.println("Amount of players: " + table.amountOfPlayers);
		System.out.println("Game mode: " + table.gameMode);
		
		for(int i = 0; i < playerCards.size(); i++) {
			System.out.println("Player" + (i+1) + " hand is:");
			for(int j = 0; j < playerCards.get(i).size(); j++) {
				System.out.println(playerCards.get(i).get(j).getCard());
			}
			System.out.println();
		} 
	}
	
	public static String winnerPairOfCards(ArrayList<ArrayList<Card>> playerCards) {
		//カードの強い順
		int[] cardPower = new int[]{1, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
		
		//番号のみの配列を生成
		int[] numbers1 = HelperFunction.generateNumberArr(playerCards.get(0));
		int[] numbers2 = HelperFunction.generateNumberArr(playerCards.get(1));

		//プレイヤーの手札をハッシュマップに格納
		HashMap<Integer, Integer> playerHand1 = HelperFunction.generateHashMap(cardPower, numbers1);
		HashMap<Integer, Integer> playerHand2 = HelperFunction.generateHashMap(cardPower, numbers2);
		
		//勝敗結果
		String winner = "Draw";
		
		//同じカードの枚数を記録
		int pairOfCards = 0;

		for(int i = 0; i < cardPower.length; i++) {
			if(playerHand1.get(cardPower[i]) < playerHand2.get(cardPower[i])) {
				if(playerHand2.get(cardPower[i]) > pairOfCards) {
					pairOfCards = playerHand2.get(cardPower[i]);
					winner = "Player2";
				}
			} else if(playerHand1.get(cardPower[i]) > playerHand2.get(cardPower[i])) {
				if(playerHand1.get(cardPower[i]) > pairOfCards) {
					pairOfCards = playerHand1.get(cardPower[i]);
					winner = "Player1";
				}
			}
		}
		System.out.println("The winner of this game is");
		return winner;
	}
	
	
	
	
}
