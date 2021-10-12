/**
 * @author Robin A.
 *
 */
import java.util.Scanner;
public class Chess implements Player {
	public final char [] width = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
	
	// comparison with charAt was causing issues, since it was comparing unicode values of 1-8 to literal values; quick workaround
	public final char [] height = {'1', '2', '3', '4', '5', '6', '7', '8'};
	public final String [] pieces = {"king", "queen", "rook", "bishop", "knight", "pawn"};
	
	String move = "a1";
	String playerPiece = "pawn";
	
	/* (non-Javadoc)
	 * @see Player#planMove()
	 * Allow player to select chess piece, select coordinate to move to, and make move
	 */
	@Override
	public void planMove() {
		Scanner input = new Scanner (System.in);
		boolean validMove = false;
		
		System.out.println("Please select which piece you would like to move");
		while (!validMove) {
			playerPiece = input.nextLine();
			for (String j: pieces) {
				if (playerPiece.toLowerCase().equals(j)) {
					validMove = true;
				} 
			}
			if (!validMove) {
				System.out.println("Please select a valid chess piece to move");
			}
		}
		
		validMove = false;
		System.out.println("Where would you like to move this piece?");
		while (!validMove) {
			move = input.next();
			validMove = checkMove(move);
		}
		System.out.println("Move set\n");
		
	}

	/* (non-Javadoc)
	 * @see Player#makeMove()
	 * Print current move position; reset piece and coordinates to defaults
	 */
	@Override
	public void makeMove() {
		System.out.printf("White move: %s to %s%n", playerPiece, move);
		move = "a1";
		playerPiece = "pawn";
	}
	
	/**
	 * Check to make sure a valid move was entered
	 * @param userMove
	 * @return
	 */
	private boolean checkMove (String userMove) {
		boolean isChar = false;
		for (char j: width) {
			if (userMove.charAt(0) == j) {
				isChar = true;
				break;
			}
		}
		if (!isChar) {
			System.out.println("Invalid move. Please try again");
			return false;
		}
		
		for (char j: height) {
			if (userMove.charAt(1) == j) {
				return true;
			}
		}
		System.out.println("Invalid move. Please try again");
		return false;
	}
	
	/**
	 * @param args
	 */
	public static void main (String [] args ) {
		Chess game = new Chess();
		Scanner input = new Scanner (System.in);
		System.out.println("Welcome to chess! Type 'help' for commands");
		while (true) {
			String selection = input.nextLine();
			switch(selection) {
				case "select space":
					game.planMove();
					break;
				case "move":
					game.makeMove();
					break;
				case "help":
					System.out.println("List of commands:\n'select space' - choose which piece to move and where"
							+ "\n'move' - move selected piece to selected coordinate"
							+ "\n'quit' - exit program");
					break;
				case "quit":
					System.out.println("\nThank you very much for playing.");
					System.exit(0);
				default:
					System.out.println("Please enter a valid command! (type 'help' for commands)");
					break;
			}
		}
	}
}
