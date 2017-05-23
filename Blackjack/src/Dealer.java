
class Dealer {
	private static int money, cardValue;
	
	void resetMoney(){
		money = 100;
	}
	
	void updateBet(int bet){
		money -= bet;
	}
	
	
	
	int getMoney(){
		return money;
	}
	
	String deal(){
		String card;
		int random = (int)(Math.random() * 13 + 2);
		if(random>10){
			card = checkFace(random);
		} else {
			card = (Integer.toString(random));
		}
		
		return card;
	}
	
	String checkFace(int random){
		
		switch(random) {
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
		case 14: return "A";
		default: return "E";
		}
	}
	
	int checkValue(String card){
		
		switch(card){
		case "2": 
			cardValue = 2;
			return cardValue;
		case "3":
			cardValue = 3;
			return cardValue;
		case "4":
			cardValue = 4;
			return cardValue;
		case "5":
			cardValue = 5;
			return cardValue;
		case "6":
			cardValue = 6;
			return cardValue;
		case "7":
			cardValue = 7;
			return cardValue;
		case "8":
			cardValue = 8;
			return cardValue;
		case "9":
			cardValue = 9;
			return cardValue;
		case "10":
			cardValue = 10;
			return cardValue;
		case "J":
			cardValue = 10;
			return cardValue;
		case "Q":
			cardValue = 10;
			return cardValue;
		case "K":
			cardValue = 10;
			return cardValue;
		case "A":
			cardValue = 11;
			return cardValue;
		case "E":
			cardValue = 0;
			return cardValue;
		default:
			cardValue = 0;
			return cardValue;
		
		}
	}
	
	// Check if over
	boolean ifOver(int sum){
		if(sum > 21) {
			return true;
		} else {
			return false;
		}
	}
	
	// Check if dealer over
	boolean ifOverDealer(int sum){
		if(sum > 16) {
			return true;
		} else {
			return false;
		}
	}
	
	// Check win
	String checkWin(int bet, int playerSum, int dealerSum){
		int winnings = 0;
		
		if (playerSum == dealerSum && playerSum < 22){
			winnings = bet;
			money = money + winnings;
			return Announcer.push();
		} else if (playerSum == 21){
			winnings = bet*2;
			money = money + winnings;
			return Announcer.playerWin();
		} else if (playerSum < 22 && dealerSum > 21){
			winnings = bet*2;
			money = money + winnings;
			return Announcer.playerWin();
		} else if (playerSum > dealerSum && playerSum < 22){
			winnings = bet*2;
			money = money + winnings;
			return Announcer.playerWin();
		} else if (playerSum > 21){
			winnings = 0;
			money = money + winnings;
			return Announcer.dealerWin();
		} else if (playerSum < dealerSum && dealerSum < 22){
			winnings = 0;
			money = money + winnings;
			return Announcer.dealerWin();
		} else {
			return Announcer.error();
		}
	}
}