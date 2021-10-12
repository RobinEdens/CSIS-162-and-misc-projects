/**
 * @author Robin A.
 *
 */
import java.io.DataInputStream;

class QueueProgram {

    public static void main(String arg[]) {
        DataInputStream get = new DataInputStream(System.in);
        int choice;
        QueueLinkedList queue = new QueueLinkedList();
        queue.getdata();
        System.out.println("Queue\n\n");
        try {
            do {
                System.out.println("1.Enqueue\n2.Dequeue\n3.Peek\n4.Display\n5.Exit\n");
                System.out.println("Enter the Choice : ");
                choice = Integer.parseInt(get.readLine());
                switch (choice) {
                    case 1:
                        queue.enqueue();
                        break;
                    case 2:
                        queue.dequeue();
                        break;
                    case 3:
                    	queue.peek();
                    	break;
                    case 4:
                        queue.display();
                        break;
                }
            } while (choice != 5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}