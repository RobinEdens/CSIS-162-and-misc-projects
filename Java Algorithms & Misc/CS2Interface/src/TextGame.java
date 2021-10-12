/**
 * Basic text-adventure game for use with Player interface
 * @author Robin A.
 */
import java.util.Scanner;

public class TextGame implements Player {
	public String facing = "north";
	public final String [] directions = {"north", "south", "east", "west"};
	public boolean makeMove;
	
	public TextGame() {
		makeMove = false;
	}
	
	/* (non-Javadoc)
	 * @see Player#planMove()
	 * Give player option to choose where to face, to move direction facing, and to quit game
	 */
	@Override
	public void planMove() {
		Scanner input = new Scanner(System.in);
		System.out.println("You find yourself in an abandoned field, miles upon miles of nothingness surrounds you. " 
				+ "What would you like to do? (type 'help' for list of commands)");
		makeMove = false;
		
		while (!makeMove) {
			String userSelection = "";
			System.out.println("What would you like to do?");
			userSelection = input.next();
			switch (userSelection) {
				case "face":
					String tempDir = "";
					boolean validDir = false;
					System.out.println("Which direction would you like to face?");
					tempDir = input.next();
					for (String j: directions) {
						if (tempDir.equals(j)) {
							setFacing(tempDir);
							validDir = true; 
							break;
						}
					}
					if (!validDir) {
						System.out.printf("You have entered an invalid direction. Currently facing %s.%n", isFacing());
					} else {
						System.out.printf("You are now facing %s.%n", isFacing());
					}
					break;
				case "help":
					System.out.println("List of commands:\n'face' - change facing direction"
							+ "\n'move' - move current facing direction"
							+ "\n'looking' - tell you current direction you are facing"
							+ "\n'help' - show commands" 
							+ "\n'quit' - exit the game");
					break;
				case "move":
					makeMove();
					makeMove = true;
					break;
				case "looking":
					System.out.printf("You are currently facing %s.%n", isFacing());
					break;
				case "quit":
					System.out.println("\nThank you very much for playing.");
					System.exit(0);
				default:
					System.out.println("You have entered an invalid command; type 'help' for list of commands");
					break;			
			}
		}
	}

	/* (non-Javadoc)
	 * @see Player#makeMove()
	 * Move direction currently facing; reset facing direction to default values
	 */
	@Override
	public void makeMove() {
		System.out.printf("Moving %s%n", isFacing());
		setFacing("north");
	}
	
	/**
	 * @return - return facing direction
	 */
	public String isFacing() {
		return facing;
	}
	
	/**
	 * @param facing - set facing direction
	 */
	public void setFacing(String facing) {
		this.facing = facing;
	}
	
	/**
	 * @param args
	 */
	public static void main (String[] args) {
		TextGame game = new TextGame();
		while (true) {
			game.planMove();
			System.out.println();
		}
	}
}
