/**
 * Stack class assignment for week 11; manipulation of the built in Stack class
 * @author Robin A.
 */
import java.util.Stack;

public class StackClass {

	public static void checkEmpty(Stack<Object> a, Stack<Object> b) {
		System.out.println("Checing if stacks are empty:");
		System.out.println("#1: " + a.isEmpty());
		System.out.println("#2: " + b.isEmpty() + "\n");
	}
	
	public static void checkEmpty(Stack<Object> a) {
		System.out.println("Checing if stack is empty:");
		System.out.println(a.isEmpty() + "\n");
	}
	
	public static Boolean inList(int searchValue) {
		return (searchValue >= 0);
	}
	
	public static void main(String[] args) {
		Stack <Object> stack1 = new Stack<Object>();
		Stack <Object> stack2 = new Stack<Object>();
		
		checkEmpty(stack1, stack2);
		
		stack1.push("Robin");
		stack1.push((int)22);
		stack1.push("Purple");
		stack1.push((double)25.49);
		
		checkEmpty(stack1);
		
		System.out.printf("First item in list: %s%n%n", stack1.peek());
		System.out.printf("Is magenta in the stack?  %s%n", inList(stack1.search("Magenta")));
		System.out.printf("Is purple in the stack?  %s%n", inList(stack1.search("Purple")));

		System.out.println("\nMoving from stack #1 to stack #2:");
		
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
			System.out.println(stack2.peek());
		}
		System.out.println();
		checkEmpty(stack1, stack2);
		
		System.out.println("Printing values and emptying stack2:");
		while (!stack2.isEmpty()) {
			System.out.println(stack2.pop());
		}
		
		System.out.println();
		checkEmpty(stack2);
	}
}
