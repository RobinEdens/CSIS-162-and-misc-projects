/**
 * Queue program using the Java LinkedList class 
 * @author Robin A.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
public class QueueLinkedList {
	BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
	Node list = new Node();
    int i, noOfItems, item;

    void getdata() {
        try {
            System.out.println("Enter the Limit :");
            noOfItems = Integer.parseInt(is.readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void enqueue() {
        try {
            if (list.getSize() < noOfItems) {
                System.out.println("Enter Queue Element :");
                item = Integer.parseInt(is.readLine());
                list.add(item);

            } else {
                System.out.println("Queue Is Full");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void dequeue() {
        if (list.getSize() != 0) {
            System.out.println("Deleted Item :" + list.pop());

        } else {
            System.out.println("Queue IS Empty");
        }
    }
    
    void peek() {
    	if (list.getSize() == 0) {
    		System.out.println("Nothing to peek at: queue is empty!");
    	} else {
    		System.out.printf("Next item in queue: %s%n", list.peek());
    	}
    }

    void display() {
        if (list.getSize() == 0) {
            System.out.println("Queue IS Empty");
        } else {
        	System.out.println(list.toString());
        }
    }
}

class Node {
	Node next, head, tail;
	int value;
	
	public Node (int value) {
		this(value, null);
	}
	
	public Node (int value, Node next) {
		this.value = value;
		this.next = next;
	}
	
	public Node() {
		head = null;
		tail = null;
	}
	
	public void add (int value) {
		if (head == null) {
			head = new Node(value);
			tail = head;
		} else {
			tail.next = new Node(value);
			tail = tail.next;
		}
	}
	
	public int pop () {
		int nodeVal = head.value;
		head = head.next;
		return nodeVal;		
	}
	
	public int peek() {
		return head.value;
	}
	
	public int getSize() {
		int size = 0;
		if (head != null) {
			size = 1;
			Node n = head;
			while (n.next != null) {
				size++;
				n = n.next;
			}
		}
		return size;		
	}
	
	public String toString() {
		Node n = head;
		String values = " " + head.value +"\n";
		while (n.next != null) {
			values = values.concat(" " + n.next.value + "\n");
			n = n.next;
		}
		return values;
	}
}

