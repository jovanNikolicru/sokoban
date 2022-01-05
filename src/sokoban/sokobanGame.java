package sokoban;

import java.util.Scanner;

public class sokobanGame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String[] board = {  "U", " ", " ", " ", " ", 
							" ", "B", "X", " ", " ",
							" ", " ", "X", " ", " ", 
							" ", " ", " ", " ", " ",
							" ", " ", " ", " ", "E"};

		String move ;
		
		
		 printBoard(board);
		while (!isGameOver(board) || isWinner(board)) {
			for (int i = 0; i < board.length; i++) {
			System.out.println("Make a move");
			 move = s.next();
			 int moving=makingMove(move);
			 int positionOfU=positionOfU(move, board);
			 System.out.println(positionOfU);System.out.println(moving);
			 if(isInField(moving, positionOfU, move)) {
					printBoard(board);
					 }else {
						 System.out.println("Invalid move");
						 printBoard(board);
					 }
			
				
			}	
			}
	}
	public static void printBoard(String[] board) {

		for (int i = 0; i < board.length; i++) {
			System.out.print(board[i] + " | ");
			if ((i + 1) % 5 == 0) {
				System.out.println();

			} 
		}
	}

	public static boolean isGameOver(String[] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[4].equals("B") && board[20].equals("B") && board[0].equals("B")) {
				return true;
			}
		}
		return false;
	}

	public static boolean isWinner(String[] board) {
		for (int i = 0; i < board.length; i++) {
			if (board[24].equals("B")) {
				return true;
			}
		}
		return false;
	}

			
	public static boolean isInField( int moving, int positionOfU,String move) {
		if (move.equals("a")||move.equals("w")) {
			return positionOfU+moving>=0;
		}else if(move.equals("d")||move.equals("s")) {
			return positionOfU+moving<25;
		}else {
			return false;
		}
	}
	
	public static boolean isValidMove(String[] board,  String move) {
		int moving=makingMove(move);
		for (int i = 0; i < board.length; i++) {
			if (move.equals("a") && i-moving >= 0 && i+moving < board.length) {
				return true;
			} else if (move.equals("s") && i-moving >= 0 && i+moving < board.length) {
				return true;
			} else if (move.equals("d") && i-moving>= 0 && i+moving < board.length) {
				return true;
			} else if (move.equals("w") && i-moving >= 0 && i+moving < board.length) {
				return true;
			}

		}
		return false;
	}


	public static int makingMove(String move) {
		int moving ;
		if (move.equals("a")) {
			moving =  - 1;
			return moving;
		} else if (move.equals("d")) {
			moving = + 1;
			return moving;
		} else if (move.equals("s")) {
			moving =  + 5;
			return moving;
		} else if (move.equals("w")) {
			moving =  - 5;
			return moving;
		}else {
			return moving=0;
		}
		
	}
	public static int positionOfU(String move, String [] board) {
		int positionOfU;
		
		int moving = makingMove(move);
		for (int i=0;i<board.length;i++) {
			if (board[i].equals("U")&&isValidMove(board, move)) {
				positionOfU=i;
				
				positionOfU=positionOfU+moving;
				board[positionOfU]="U";
				board[i]=" ";
				return positionOfU;
				
			}
		}return positionOfU=100;
	}
}

