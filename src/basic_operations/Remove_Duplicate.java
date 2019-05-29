package basic_operations;

public class Remove_Duplicate {
	static Node head;

	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	void remove_duplicates_recursion(Node node) {
		if (node == null)
			return;
		remove_duplicates_recursion(node.next);
		if (node.next == null || node.data != node.next.data) {
			System.out.println(node.data);
		}
		return;
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
		Remove_Duplicate llist = new Remove_Duplicate();
		llist.push(20);
		llist.push(13);
		llist.push(13);
		llist.push(11);
		llist.push(11);
		llist.push(11);

		System.out.println("List before removal of duplicates");
		llist.printList();
		llist.remove_duplicates_recursion(head);
//		System.out.println("List after removal of elements");
//		llist.printList();
	}
}
