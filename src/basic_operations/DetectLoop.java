package basic_operations;

public class DetectLoop {
	Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void push(int new_data) {

		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	public void detect_loop() {
		Node index1 = head;
		Node index2 = head;
		while (index1 != null && index2 != null && index2.next != null) {
			index1=index1.next;
			index2=index2.next.next;
			if(index1==index2) {
				System.out.println("loop detected");
				return;
			}
		}
		System.out.println("loop Not detected");
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		DetectLoop llist = new DetectLoop();

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
	//	llist.head.next.next.next.next = llist.head;

		llist.detect_loop();
	}
}
