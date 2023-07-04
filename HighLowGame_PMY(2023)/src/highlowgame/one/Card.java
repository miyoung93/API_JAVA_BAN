package highlowgame.one;

public class Card {

	int card1 = 0;
	int card2 = 0;

	public void card1() {
		this.card1 = (int) (Math.random() * 9 + 1);
	}

	public void card2() {
		this.card2 = (int) (Math.random() * 9 + 1);
		
		// 두장의 카드 값이 겹치지 않게
		while (card1 == card2) {
			this.card2 = (int) (Math.random() * 9 + 1);
		}
	}

}
