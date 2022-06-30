import java.util.ArrayList;
import java.util.HashMap;

public class HelperFunction {
	
	public static int[] generateNumberArr(ArrayList<Card> playerHand) {
		int[] intArr = new int[playerHand.size()];
		for(int i = 0; i < playerHand.size(); i++) {
			intArr[i] = playerHand.get(i).intValue;
		}
		return intArr;
	}
	
	public static HashMap<Integer, Integer> generateHashMap(int[] cardPower, int[] numberArr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < cardPower.length; i++) {
			map.put(cardPower[i], 0);
		}
		
		for(int i = 0; i < numberArr.length; i++) {
			map.replace(numberArr[i], map.get(numberArr[i]) + 1);
		}
		
		return map;
	}
}
