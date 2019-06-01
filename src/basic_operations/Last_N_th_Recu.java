package basic_operations;

public class Last_N_th_Recu {
	static Node head;
	static int i = 0;

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

	void find_reverse_values(Node temp, int index) {

		if (temp == null) {
			return;
		}
		find_reverse_values(temp.next, index);
		if (index == ++i) {
			System.out.println(temp.data);
		}
		return;

	}

	public static void main(String args[]) {
		Last_N_th_Recu llist = new Last_N_th_Recu();
		llist.push(20);
		llist.push(15);
		llist.push(12);
		llist.push(11);
		llist.push(11);
		llist.push(11);
		System.out.println("List before removal of duplicates");
		llist.printList();
		llist.find_reverse_values(head,5);
	}
}
