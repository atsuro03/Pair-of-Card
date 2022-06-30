
public class Card{
	public String suits;
	public String value;
	public int intValue;
	
	public Card(String suits, String value,  int intValue) {
		this.suits = suits;
		this.value = value;
		this.intValue = intValue;
	}
	
	public String getCard() {
		return this.suits + this.value + "(" + this.intValue + ")";
	}
}
