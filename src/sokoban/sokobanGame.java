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
		System.out.println("Press any key to enter game");
		move= s.next();
		int positionOfB=positionOfB(move, board);
		 printBoard(board);
		while (!isGameOver(positionOfB) && !isWinner(positionOfB)) {
			System.out.println("**********************");
			System.out.println("Make a move");
			 move = s.next();
			 int moving=makingMove(move);
			 int positionOfU=positionOfU(move, board);
			  positionOfB=positionOfB(move, board);
			
	System.out.println("**********************");
			 printBoard(board);
			
				
			
			}if (isGameOver(positionOfB)) {
				System.out.println("**********************");
				System.out.println("Game Over");
			}else if (isWinner(positionOfB)) {
				System.out.println("**********************");
				System.out.println("You won");
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

	public static boolean isGameOver(int positionOfB) {
		if (positionOfB==0) {
			return true;
		}else if (positionOfB==1) {
			return true;
		}else if (positionOfB==2) {
			return true;
		}else if (positionOfB==3) {
			return true;
		}else if (positionOfB==4) {
			return true;
		}else if (positionOfB==5) {
			return true;
		}else if (positionOfB==10) {
			return true;
		}else if (positionOfB==15) {
			return true;
		}else if (positionOfB==20) {
			return true;
		}return false;
	}

	public static boolean isWinner(int positionOfB) {
		if (positionOfB==24) {
				return true;
		}
		return false;
	}

			
	
	
	public static boolean isValidMove(String[] board,  String move) {
	
		for (int i = 0; i < board.length; i++) {
			if (move.equals("a")&&!board[5].equals("U") &&!board[10].equals("U") 
				&&!board[15].equals("U")&&!board[20].equals("U")){
				return true;
			} else if (move.equals("s") ) {
				return true;
				
			} else if (move.equals("d") &&!board[4].equals("U") &&!board[9].equals("U") 
					&&!board[14].equals("U")&&!board[19].equals("U")) {
				return true;
			} else if (move.equals("w") ) {
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
				if (positionOfU>=0&&positionOfU<25&& !board[positionOfU].equals("X")&&!board[positionOfU].equals("B")) {
				board[positionOfU]="U";
				board[i]=" ";
				return positionOfU;
				}else {
					positionOfU=positionOfU-moving;
					return positionOfU;
				}
			}
		}return positionOfU=100;
		
	}
	public static int positionOfB(String move, String [] board) {
		int positionOfB;
		
		int moving = makingMove(move);
		for (int i=0;i<board.length;i++) {
			
			if (board[i].equals("B")&&board[i-moving].equals("U")&&!isBValid(board, move)) {
				positionOfB=i+moving;
				if(positionOfB>=0&&positionOfB<25&& !board[positionOfB].equals("X")
						&&!board[positionOfB].equals("U")) {
				board[positionOfB]="B";
				board[positionOfB-moving]="U";
				board[positionOfB-moving-moving]=" ";
				return positionOfB;}
		
				
				
			
				}
			}return positionOfB=100;
			}	
	public static boolean isBValid(String[]board, String move) {
	
if(move.equals("a")||move.equals("s")||move.equals("w")) {
		return false;
		
			
		}else if (move.equals("d")) {
			if (board[9].equals("B") &&board[8].equals("U")) {
			return true;
			}else if (board[14].equals("B")&&board[13].equals("U")) {
				return true;
			}else if (board[19].equals("B")&&board[18].equals("U")) {
				return true;
		}return false;
		}
return true;
			
		
	}
}
