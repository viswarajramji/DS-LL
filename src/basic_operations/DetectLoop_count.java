package basic_operations;

public class DetectLoop_count {
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

	public int compute_cnt(Node index1, Node index2) {
		int cnt = 1;
		index2 = index2.next;
		while (index1 != index2) {
			cnt++;
			index2 = index2.next;
		}
		return cnt;
	}

	public void detect_loop() {
		Node index1 = head;
		Node index2 = head;
		while (index1 != null && index2 != null && index2.next != null) {
			index1 = index1.next;
			index2 = index2.next.next;
			if (index1 == index2) {
				System.out.println("loop detected");
				System.out.println("total Number of cnt :" + compute_cnt(index1, index2));
				return;
			}
		}
		System.out.println("loop Not detected");
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		DetectLoop_count llist = new DetectLoop_count();

		llist.push(20);
		llist.push(4);
		llist.push(15);
		llist.push(10);

		/* Create loop for testing */
		 llist.head.next.next.next.next = llist.head;

		llist.detect_loop();
	}
}
