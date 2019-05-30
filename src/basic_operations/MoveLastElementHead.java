package basic_operations;

public class MoveLastElementHead {
	static Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	public void move_head_element() {
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}

		Node tail = temp.next;
		tail.next = head;
		temp.next = null;
		head = tail;

	}

	public void push(int new_data) {
		Node new_node = new Node(new_data);
		new_node.next = head;
		head = new_node;
	}

	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		MoveLastElementHead llist = new MoveLastElementHead();
		llist.push(20);
		llist.push(13);
		llist.push(13);
		llist.push(11);
		llist.push(11);
		llist.push(11);
		llist.printList();
		llist.move_head_element();
		llist.printList();
		

	}
}
