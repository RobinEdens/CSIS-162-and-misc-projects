import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Zach D. & Robin A.
 */
public class Voting {

	public static void main(String[] args) {
		int voteKey = 0;
		int districtNum = 0;
		District [] votingDistrict;
		Scanner userInput = new Scanner (System.in);
		
		System.out.println("Hello! If you are an authorized voting official, please enter "
				+ "a positive numeric key (4 or more digits) to end the voting process once finished");
		while (voteKey < 1000) {
			try {
				voteKey = userInput.nextInt();
				if (voteKey < 1000) {
					System.out.println("Please make sure your key is 4 (positive) digits or greater");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid, positive integer only!");
				userInput.nextLine();
			}
		}
		System.out.println("Thank you! Be sure to write down your key; it is required to end voting\nNext, tell me how many districts will be part of this voting cycle?");

		while (districtNum < 1) {
			try {
				districtNum = userInput.nextInt();
			} 
			catch (InputMismatchException e) {
				System.out.println("Please enter a valid, positive integer!");
				userInput.nextLine();
			}
		}
		votingDistrict = new District[districtNum];
		
		for (int i = 0; i < votingDistrict.length; i++) {
			int numCandidates = 0;
			System.out.printf("How many candidates are in district #%s?%n",i + 1);
			while (numCandidates < 1) {
				try {
					numCandidates = userInput.nextInt();
				} 
				catch (InputMismatchException e) {
					System.out.println("Please enter a valid, positive integer!");
					userInput.nextLine();
				}
			}
			String [] tempCandidates = new String[numCandidates];
			userInput.nextLine();
			for (int j = 0; j < numCandidates; j++) {
				System.out.println("Please enter candidate #" + (j+1) +"; first name, then last");
				tempCandidates[j] = userInput.nextLine();
			}
			votingDistrict[i] = new District(tempCandidates);
		}
		
		System.out.println("Thank you very much! Voting may now commense");
		int userVote = 0;
		int userDistrict = 0;
		while (userDistrict != voteKey) {
			userDistrict = 0;
			userVote = 0;
			System.out.println("Welcome! Please enter your voting district");
			while (userDistrict < 1 || userDistrict > districtNum) {
				try {
					userDistrict = userInput.nextInt();
					if (userDistrict == voteKey) {
						break;
					}
				} 
				catch (InputMismatchException e) {
					System.out.println("Please enter a valid, positive integer!");
					userInput.nextLine();
				}
			}
			if (userDistrict == voteKey) {
				System.out.println("Admin key entered. Ending voting process and tallying up votes.");
				break;
			}
			System.out.println("Thank you! Here are the candidates listed for your district:");
			votingDistrict[userDistrict - 1].displayCandidates();
			
			System.out.println("Which candidate would you like to vote for? Enter the number next to the candidate's name");
			while (userVote < 1 || userVote > votingDistrict[userDistrict - 1].candAmount()) {
				try {
					userVote = userInput.nextInt();
				} 
				catch (InputMismatchException e) {
					System.out.println("Please enter a valid, positive integer!");
					userInput.nextLine();
				}
			}
			votingDistrict[userDistrict -1].addVote(userVote);
			System.out.println("Thank you for voting!");
		}
		districtNum = 0;
		for (District j: votingDistrict) {
			districtNum++;
			System.out.printf("Results for district %s:%n%s%n", districtNum, j);
		}
	}
}
