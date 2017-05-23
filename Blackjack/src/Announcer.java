
public class Announcer {
	
	static String newGame(){
		return "New game started.";
	}
	
	static String betAmount(int bet){
		return "You bet " + bet + "€.";
	}
	
	static String dealFirstCards(){
		return "Dealer deals cards.";
	}
	
	static String dealMoreCards(){
		return "Dealer deals more cards.";
	}
	
	static String playerStand(){
		return "You decide to stand. Dealer thinks.";
	}
	
	static String playerDouble(){
		return "You decide to double.";
	}
	
	static String playerOver(){
		return "Your sum is over 21.";
	}
	
	static String playerWin(){
		return "You win!!";
	}
	
	static String dealerWin(){
		return "You lose!!";
	}
	
	static String push(){
		return "It's a push!";
	}
	
	static String error(){
		return "error";
	}
}
