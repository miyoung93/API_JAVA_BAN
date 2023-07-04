package highlowgame.one;

import java.util.Scanner;

public class HighLowGame {

	Scanner sc = new Scanner(System.in);

	String user = "";

	//게임 시작
	public void gameStart(Card card) {
		System.out.println("그럼 오늘은 \"하이&로\"로 대결하자!");

		timeDelay(2);
		
		System.out.println("그럼 시작한다~!");

		timeDelay(2);

		System.out.println("1부터 9까지의 카드 2장을 뽑을거야!");
		
		timeDelay(2);

		System.out.println("먼저 카드를 1장 뽑고...");

		card.card1();
		
		timeDelay(3);

		// 1번 카드 이미지
		System.out.println("첫 번째 카드");
		System.out.println("┌───┐");
		System.out.println("│ " + card.card1 + " │");
		System.out.println("└───┘");

		System.out.println("첫 번째 카드는 [" + card.card1 + "]이구나...!");

		timeDelay(2);

		System.out.println("자, 이어서 1장 더 뽑을게~");

		card.card2();
		
		timeDelay(3);

		System.out.println("좋아, 뽑았어!");

		// 2번 카드 이미지
		System.out.println("두 번째 카드");
		System.out.println("┌───┐");
		System.out.println("│ " + "?" + " │");
		System.out.println("└───┘");

		timeDelay(2);

		System.out.println("그럼 이 카드의 숫자는 [" + card.card1 + "]보다 클까, 아니면 작을까...?");

		timeDelay(1);

		System.out.println("한번 맞혀봐~");
		
		System.out.println("1번 카드\t2번카드");
	    System.out.println("┌───┐\t┌───┐");
	    System.out.println("│ "+ card.card1 +" │\t│ "+ "?" +" │");
	    System.out.println("└───┘\t└───┘");
	}

	
	// 게임 진행 유무 선택
	public void choiceGame(Card card) {
		while (true) {
			try {
				System.out.println("혹시 괜찮다면 게임하면서 놀지 않을래?");
			    
			    timeDelay(1);
			    
				System.out.println("\"할래!\"는 Y를 입력해주세요.\n\"지금은 됐어\"는 N을 입력해주세요. ");
				user = sc.nextLine();

				if (user.equalsIgnoreCase("Y")) {
					gameStart(card);
					choiceAnswer(card);
					break;
				} else if (user.equalsIgnoreCase("N")) {
					System.out.println("그래 그럼 다음에 다시 하자. 안녕!");
					break;
				} else {
					System.out.println("Y와 N중 하나만 입력해줘!");
				}
			} catch (Exception e) {
				System.out.println("Y와 N중 하나만 입력해 주세요.");
				sc.nextLine();
			}
		}
	}

	
	// 정답 맞추기
	public void choiceAnswer(Card card) {
		while (true) {
			try {
				System.out.println("\"크다!\"는 1을 입력해주세요.\n\"작다!\"는 2를 입력해주세요. ");
				user = sc.nextLine();

				if (user.equals("1")) {
					System.out.println("\"크다!\"를 선택했어~");
					
					openAnswer();
					
					if(card.card1 < card.card2) {
						userWin(card);
					} else if(card.card1 > card.card2) {
						userLose(card);
					}
					break;
					
				} else if (user.equals("2")) {
					System.out.println("\"작다!\"를 선택했어~");
					
					openAnswer();
					
					if(card.card1 > card.card2) {
						userWin(card);
					} else if(card.card1 < card.card2) {
						userLose(card);
					}
					break;
					
				} else {
					System.out.println("1과 2중 하나만 입력해줘!");
				}
			} catch (Exception e) {
				System.out.println("숫자 1과 2중 하나만 입력해 주세요.");
				sc.nextLine();
			}
		}
		
	}
	
	
	// 정답 공개
	public void openAnswer() {
		timeDelay(1);
		
		System.out.println("자~아, 과연 정답은...?");

		timeDelay(3);
	}

	
	// 정답일 때
	public void userWin(Card card) {
		System.out.println("두 번째 카드");
		System.out.println("┌───┐");
		System.out.println("│ " + card.card2 + " │");
		System.out.println("└───┘");

		System.out.print("[" + card.card2 + "]! ");

		timeDelay(1);

		System.out.println("정답이야~");

		timeDelay(1);

		System.out.println("축하해~!");
	}

	
	// 오답일 때
	public void userLose(Card card) {
		System.out.println("두 번째 카드");
		System.out.println("┌───┐");
		System.out.println("│ " + card.card2 + " │");
		System.out.println("└───┘");

		System.out.println("[" + card.card2 + "] 카드였습니다~! ");

		timeDelay(1);

		System.out.println("아쉽지만 오답이야~");

		timeDelay(2);

		System.out.println("아쉽게 됐지만 그래도 난 같이 놀아서 즐거웠어~\n포기하지 말고 다음에 또 해보자");
	}

	
	//시간 지연
		public void timeDelay(int time) {
			try {
				Thread.sleep(time*1000);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	
	
	
}
