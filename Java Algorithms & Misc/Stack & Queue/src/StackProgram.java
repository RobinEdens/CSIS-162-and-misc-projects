/**
 * Program to check the source code of any Java file and make sure all delimiters are properly open/closed, for the Week 11 Stack assignment 
 * @author Robin A.
 */
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class StackProgram {
	Map <Character, Character> delimMap;
	final Character [] openDelim = {'{', '[', '(' };
	final Character [] closeDelim = {'}', ']', ')' };

	public StackProgram() {
		delimMap = new HashMap<Character,Character>();
		delimMap.put('}', '{');
		delimMap.put(']', '[');
		delimMap.put(')', '(');
	}
		
	public boolean contains (Character [] array, Character val) {
		for (Character j: array) {
			if (j == val) {
				return true;
			}
		}
		return false;
	}
	
	public void readFile(File file) throws IOException {
		Stack<Character> delimStack = new Stack<Character>();
		Scanner fileScanner = new Scanner(file);
		while (fileScanner.hasNextLine()) {
			String line = fileScanner.nextLine();
			StringReader lineParse = new StringReader(line);
			int c;
			while((c = lineParse.read()) != -1) {
				Character delimiter = (char)c;
				if (contains(openDelim, delimiter)) {
					delimStack.add(delimiter);
				} else if (contains(closeDelim, delimiter)) {
					try {
						if (delimMap.get(delimiter) != delimStack.pop()) {
							System.out.print("\nErrors found with nesting: exiting file\n");
							return;					
						}
					} catch (EmptyStackException e) {
						System.out.print("\nErrors found with nesting: exiting file\n");
						return;		
					}
				}
				System.out.print((char)c);
			}
			System.out.println();
		}
		fileScanner.close();
		System.out.println("Finished checking line: no errors found!");
	}
	
	public static void main(String[] args) {
		StackProgram main = new StackProgram();
		String [] javaFile = {
				"GrandWelcomeFinal.java",
				"FirstProgram.java",
				"FileReadNums.java",
				"FacePrinterSimple.java"
				};
		for (String fileName: javaFile) {
			try {
				System.out.printf("Checking %s for proper nesting:%n", fileName);
				main.readFile(new File(fileName));
				System.out.println();
			} catch (Exception ex) {
	            System.out.println(ex.getMessage());
			}
		}
	}
}
